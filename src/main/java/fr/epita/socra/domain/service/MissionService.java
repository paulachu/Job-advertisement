package fr.epita.socra.domain.service;

import fr.epita.socra.converter.Converter;
import fr.epita.socra.data.model.MissionModel;
import fr.epita.socra.domain.entity.MissionEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class MissionService implements MissionServiceInterface {
    @Inject
    PanacheRepositoryBase<MissionModel, Long> missionRepository;
    @Inject
    Converter<MissionModel, MissionEntity> missionModelToMissionEntityConverter;
    @Inject
    Converter<MissionEntity, MissionModel> missionEntityToMissionEntityModelConverter;

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
        return missionModelToMissionEntityConverter.convertNotNull(missionRepository.findById(missionId));
    }

    @Override
    public List<MissionEntity> searchMission(String search) {
        return null;
    }

    @Override
    public MissionEntity createMission(MissionEntity mission) {
        return null;
    }

    @Override
    public MissionEntity updateMission(MissionEntity mission) {
        return null;
    }
}
