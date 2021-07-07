package fr.epita.socra.converter.dtoentity;

import fr.epita.socra.converter.Converter;
import fr.epita.socra.domain.entity.MissionEntity;
import fr.epita.socra.presentation.missiondto.CreateMissionRequest;

import javax.enterprise.context.ApplicationScoped;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@ApplicationScoped
public class CreateMissionRequestToMissionEntity implements Converter<CreateMissionRequest, MissionEntity> {
    @Override
    public MissionEntity convertNotNull(CreateMissionRequest from) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date beginning = null;
        try {
            beginning = formatter.parse(from.getBeginning());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new MissionEntity(
                -1,
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
