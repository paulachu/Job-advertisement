package fr.epita.socra.converter.dtoentity;

import fr.epita.socra.converter.Converter;
import fr.epita.socra.domain.entity.MissionEntity;
import fr.epita.socra.presentation.missiondto.UpdateMissionRequest;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UpdateMissionRequestToMissionEntity implements Converter<UpdateMissionRequest, MissionEntity> {
    @Override
    public MissionEntity convertNotNull(UpdateMissionRequest from) {
        return null;
    }
}
