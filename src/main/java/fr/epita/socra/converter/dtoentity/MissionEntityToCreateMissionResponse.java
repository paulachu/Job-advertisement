package fr.epita.socra.converter.dtoentity;

import fr.epita.socra.converter.Converter;
import fr.epita.socra.domain.entity.MissionEntity;
import fr.epita.socra.presentation.missiondto.CreateMissionResponse;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MissionEntityToCreateMissionResponse implements Converter<MissionEntity, CreateMissionResponse> {
    @Override
    public CreateMissionResponse convertNotNull(MissionEntity from) {
        return new CreateMissionResponse(
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
