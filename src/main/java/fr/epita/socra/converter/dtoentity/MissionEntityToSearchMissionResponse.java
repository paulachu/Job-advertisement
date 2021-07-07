package fr.epita.socra.converter.dtoentity;

import fr.epita.socra.converter.Converter;
import fr.epita.socra.domain.entity.MissionEntity;
import fr.epita.socra.presentation.missiondto.SearchMissionResponse;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MissionEntityToSearchMissionResponse  implements Converter<MissionEntity, SearchMissionResponse> {
    @Override
    public SearchMissionResponse convertNotNull(MissionEntity from) {
        return new SearchMissionResponse(
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
