package fr.epita.socra.converter.dtoentity;

import fr.epita.socra.converter.Converter;
import fr.epita.socra.domain.entity.MissionEntity;
import fr.epita.socra.presentation.missiondto.UpdateMissionRequest;

import javax.enterprise.context.ApplicationScoped;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@ApplicationScoped
public class UpdateMissionRequestToMissionEntity implements Converter<UpdateMissionRequest, MissionEntity> {
    @Override
    public MissionEntity convertNotNull(UpdateMissionRequest from) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date beginning = null;
        try {
            beginning = formatter.parse(from.getBeginning());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new MissionEntity(
                from.getId(),
                from.getLocation(),
                from.getDuration(),
                from.getPrice(),
                from.getRemote(),
                beginning,
                from.getJob(),
                from.getContext(),
                from.getDescription()
        );
    }
}
