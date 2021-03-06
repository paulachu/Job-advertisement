package fr.epita.socra.converter.dtoentity;

import fr.epita.socra.converter.Converter;
import fr.epita.socra.domain.entity.MissionEntity;
import fr.epita.socra.presentation.missiondto.FindOneMissionResponse;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MissionEntityToFindOneMissionResponse implements Converter<MissionEntity, FindOneMissionResponse> {

    @Override
    public FindOneMissionResponse convertNotNull(MissionEntity from) {
        return new FindOneMissionResponse(
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
