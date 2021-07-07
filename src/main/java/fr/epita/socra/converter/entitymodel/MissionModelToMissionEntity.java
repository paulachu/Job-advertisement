package fr.epita.socra.converter.entitymodel;

import fr.epita.socra.converter.Converter;
import fr.epita.socra.data.model.MissionModel;
import fr.epita.socra.domain.entity.MissionEntity;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MissionModelToMissionEntity implements Converter<MissionModel, MissionEntity> {
    @Override
    public MissionEntity convertNotNull(MissionModel from) {
        return new MissionEntity(
                from.getId(),
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
