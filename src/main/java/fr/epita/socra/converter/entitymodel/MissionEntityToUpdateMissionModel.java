package fr.epita.socra.converter.entitymodel;

import fr.epita.socra.converter.Converter;
import fr.epita.socra.converter.ConverterUpdate;
import fr.epita.socra.data.model.MissionModel;
import fr.epita.socra.domain.entity.MissionEntity;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MissionEntityToUpdateMissionModel implements ConverterUpdate<MissionEntity, MissionModel> {
    @Override
    public MissionModel convertNotNull(MissionEntity from, MissionModel to) {
        to.setLocation(from.location());
        to.setDuration(from.duration());
        to.setPrice(from.price());
        to.setRemote(from.remote());
        to.setBeginning(from.beginning());
        to.setJob(from.job());
        to.setContext(from.context());
        to.setDescription(from.description());
        return to;
    }
}
