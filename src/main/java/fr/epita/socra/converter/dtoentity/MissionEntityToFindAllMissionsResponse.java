package fr.epita.socra.converter.dtoentity;

import fr.epita.socra.converter.Converter;
import fr.epita.socra.domain.entity.MissionEntity;
import fr.epita.socra.presentation.missiondto.FindAllMissionsResponse;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MissionEntityToFindAllMissionsResponse implements Converter<MissionEntity, FindAllMissionsResponse> {
    @Override
    public FindAllMissionsResponse convertNotNull(MissionEntity from) {
        return null;
    }
}
