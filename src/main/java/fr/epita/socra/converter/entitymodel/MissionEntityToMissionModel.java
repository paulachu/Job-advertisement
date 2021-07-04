package fr.epita.socra.converter.entitymodel;

import fr.epita.socra.converter.Converter;
import fr.epita.socra.data.model.MissionModel;
import fr.epita.socra.domain.entity.MissionEntity;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MissionEntityToMissionModel implements Converter<MissionEntity, MissionModel> {
    @Override
    public MissionModel convertNotNull(MissionEntity from) {
        return null;
    }
}