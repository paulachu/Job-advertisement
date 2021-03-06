package fr.epita.socra.converter.dtoentity;

import fr.epita.socra.converter.Converter;
import fr.epita.socra.domain.entity.MissionEntity;
import fr.epita.socra.presentation.missiondto.UpdateMissionResponse;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MissionEntityToUpdateMissionResponse implements Converter<MissionEntity, UpdateMissionResponse> {
    @Override
    public UpdateMissionResponse convertNotNull(MissionEntity from) {
        return new UpdateMissionResponse(
                from.id(),
                from.location(),
                from.duration(),
                from.price(),
                from.remote(),
                from.beginning(),
                from.job(),
                from.context(),
                from.description()
        );
    }
}
