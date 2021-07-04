package fr.epita.socra.converter.entitymodel;

import fr.epita.socra.converter.Converter;
import fr.epita.socra.data.model.MissionModel;
import fr.epita.socra.domain.entity.MissionEntity;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MissionEntityToMissionModel implements Converter<MissionEntity, MissionModel> {
    @Override
    public MissionModel convertNotNull(MissionEntity from) {
        var res = new MissionModel();
        res.setLocation(from.location());
        res.setDescription(from.description());
        res.setContext(from.context());
        res.setJob(from.job());
        res.setDuration(from.duration());
        res.setPrice(from.price());
        res.setRemote(from.remote());
        res.setBeginning(from.beginning());
        return res;
    }
}
