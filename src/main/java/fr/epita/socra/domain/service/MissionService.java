package fr.epita.socra.domain.service;

import fr.epita.socra.converter.Converter;
import fr.epita.socra.converter.ConverterUpdate;
import fr.epita.socra.data.model.MissionModel;
import fr.epita.socra.domain.entity.MissionEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

@ApplicationScoped
public class MissionService implements MissionServiceInterface {
    @Inject
    PanacheRepositoryBase<MissionModel, Long> missionRepository;
    @Inject
    Converter<MissionModel, MissionEntity> missionModelToMissionEntityConverter;
    @Inject
    Converter<MissionEntity, MissionModel> missionEntityToMissionEntityModelConverter;
    @Inject
    ConverterUpdate<MissionEntity, MissionModel> converterUpdateMissionEntityToMissionModel;

    public MissionService()
    {
    }

    public List<MissionEntity> findAllMission() {
        var missionModelList = missionRepository.listAll().stream()
                                .sorted((m1, m2) -> (int) (m1.getId() - m2.getId())).collect(Collectors.toList());
        return missionModelToMissionEntityConverter.convertList(missionModelList);
    }

    @Override
    public MissionEntity findOneMission(long missionId)
    {
        return missionModelToMissionEntityConverter.convert(missionRepository.findById(missionId));
    }

    @Override
    public List<MissionEntity> searchMission(String search) {
        var missionModelList = missionRepository.listAll();

        var keywords = search.split(" ");

        Map<MissionModel, Float> missionScoreMap = new HashMap<>();

        for (var item : missionModelList) {
            var occurrenceFoundWords = 0;
            var nbFoundWords = 0;
            for (var keyword : keywords) {
                var tmp = occurrenceFoundWords;
                occurrenceFoundWords += item.getJob().toLowerCase(Locale.ROOT).split(keyword.toLowerCase(Locale.ROOT), -1).length - 1;
                occurrenceFoundWords += item.getContext().toLowerCase(Locale.ROOT).split(keyword.toLowerCase(Locale.ROOT), -1).length - 1;
                occurrenceFoundWords += item.getDescription().toLowerCase(Locale.ROOT).split(keyword.toLowerCase(Locale.ROOT), -1).length - 1;
                if (occurrenceFoundWords > tmp) {
                    nbFoundWords += 1;
                }
            }

            if (occurrenceFoundWords == 0) {
                continue;
            }

            var totalNbKeywords = keywords.length;
            missionScoreMap.put(item, nbFoundWords * occurrenceFoundWords - totalNbKeywords * 0.5f * occurrenceFoundWords);
        }

        var sortedMissionEntityList = missionScoreMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .map(entry -> missionModelToMissionEntityConverter.convert(entry.getKey()))
                .collect(Collectors.toList());

        Collections.reverse(sortedMissionEntityList);

        return sortedMissionEntityList;
    }

    @Transactional
    @Override
    public MissionEntity createMission(MissionEntity mission) {
        if (mission.remote() > 1.0f || mission.remote() < 0.0f)
        {
            return null;
        }
        MissionModel missionModel = missionEntityToMissionEntityModelConverter.convert(mission);
        missionRepository.persist(missionModel);
        if (missionModel == null)
        {
            return null;
        }
        return missionModelToMissionEntityConverter.convert(missionModel);
    }

    @Transactional
    @Override
    public MissionEntity updateMission(MissionEntity mission) {
        MissionModel missionFound = missionRepository.findById(mission.id());
        if (missionFound == null)
        {
            return null;
        }
        missionFound = converterUpdateMissionEntityToMissionModel.convert(mission, missionFound);
        missionRepository.persist(missionFound);
        return missionModelToMissionEntityConverter.convert(missionFound);
    }
}
