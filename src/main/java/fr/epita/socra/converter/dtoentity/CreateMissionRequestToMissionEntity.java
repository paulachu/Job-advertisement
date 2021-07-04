package fr.epita.socra.converter.dtoentity;

import fr.epita.socra.converter.Converter;
import fr.epita.socra.domain.entity.MissionEntity;
import fr.epita.socra.presentation.missiondto.CreateMissionRequest;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CreateMissionRequestToMissionEntity implements Converter<CreateMissionRequest, MissionEntity> {
    @Override
    public MissionEntity convertNotNull(CreateMissionRequest from) {
        return null;
    }
}
