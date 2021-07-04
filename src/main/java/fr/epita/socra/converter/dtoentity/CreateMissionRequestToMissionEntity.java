package fr.epita.socra.converter.dtoentity;

import fr.epita.socra.converter.Converter;
import fr.epita.socra.domain.entity.MissionEntity;
import fr.epita.socra.presentation.missiondto.CreateMissionRequest;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CreateMissionRequestToMissionEntity implements Converter<CreateMissionRequest, MissionEntity> {
    @Override
    public MissionEntity convertNotNull(CreateMissionRequest from) {
        return new MissionEntity(
                -1,
                from.getLocation(),
                from.getDuration(),
                from.getPrice(),
                from.getRemote(),
                from.getBeginning(),
                from.getJob(),
                from.getContext(),
                from.getDescription()
        );
    }
}
