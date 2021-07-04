
package fr.epita.socra;

import fr.epita.socra.converter.dtoentity.*;
import fr.epita.socra.converter.entitymodel.MissionEntityToMissionModel;
import fr.epita.socra.converter.entitymodel.MissionModelToMissionEntity;
import fr.epita.socra.data.model.MissionModel;
import fr.epita.socra.domain.entity.MissionEntity;
import fr.epita.socra.presentation.missiondto.*;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConverterTest {
    @Test
    public void CheckCreateMissionRequestToMissionEntity() {
        var location = "Paris";
        var duration = 3;
        var price = 1025;
        var remote = 0.5f;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date beginning = null;
        try {
            beginning = formatter.parse("2021-08-12");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        var job = "JEE Developer";
        var context = "In a developing team.";
        var description = "The goal is to make a REST API to retrieve personal data.";

        CreateMissionRequest createMissionRequest = new CreateMissionRequest(
                location, duration, price, remote, beginning, job, context, description
        );

        CreateMissionRequestToMissionEntity createMissionRequestToMissionEntity = new CreateMissionRequestToMissionEntity();
        var res = createMissionRequestToMissionEntity.convertNotNull(createMissionRequest);

        var expected = new MissionEntity(-1, location, duration, price, remote, beginning, job, context, description);

        assertEquals(expected, res);
    }

    @Test
    public void CheckMissionEntityToCreateMissionResponse() {
        var location = "Paris";
        var duration = 3;
        var price = 1025;
        var remote = 0.5f;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date beginning = null;
        try {
            beginning = formatter.parse("2021-08-12");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        var job = "JEE Developer";
        var context = "In a developing team.";
        var description = "The goal is to make a REST API to retrieve personal data.";

        MissionEntity missionEntity = new MissionEntity(0, location, duration, price, remote, beginning, job, context, description);

        MissionEntityToCreateMissionResponse missionEntityToCreateMissionResponse = new MissionEntityToCreateMissionResponse();
        var res = missionEntityToCreateMissionResponse.convertNotNull(missionEntity);

        var expected = new CreateMissionResponse(
                location, duration, price, remote, beginning, job, context, description
        );

        assertEquals(expected, res);
    }

    @Test
    public void CheckMissionEntityToFindAllMissionResponse() {
        var location = "Paris";
        var duration = 3;
        var price = 1025;
        var remote = 0.5f;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date beginning = null;
        try {
            beginning = formatter.parse("2021-08-12");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        var job = "JEE Developer";
        var context = "In a developing team.";
        var description = "The goal is to make a REST API to retrieve personal data.";

        MissionEntity missionEntity = new MissionEntity(0, location, duration, price, remote, beginning, job, context, description);

        MissionEntityToFindAllMissionsResponse missionEntityToFindAllMissionsResponse = new MissionEntityToFindAllMissionsResponse();
        var res = missionEntityToFindAllMissionsResponse.convertNotNull(missionEntity);

        var expected = new FindAllMissionsResponse(
                location, duration, price, remote, beginning, job, context, description
        );

        assertEquals(expected, res);
    }

    @Test
    public void CheckMissionEntityToFindOneMissionResponse() {
        var location = "Paris";
        var duration = 3;
        var price = 1025;
        var remote = 0.5f;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date beginning = null;
        try {
            beginning = formatter.parse("2021-08-12");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        var job = "JEE Developer";
        var context = "In a developing team.";
        var description = "The goal is to make a REST API to retrieve personal data.";

        MissionEntity missionEntity = new MissionEntity(0, location, duration, price, remote, beginning, job, context, description);

        MissionEntityToFindOneMissionResponse missionEntityToFindOneMissionResponse = new MissionEntityToFindOneMissionResponse();
        var res = missionEntityToFindOneMissionResponse.convertNotNull(missionEntity);

        FindOneMissionResponse expected = new FindOneMissionResponse(location, duration, price, remote, beginning, job, context, description);

        assertEquals(expected, res);
    }

    @Test
    public void CheckMissionEntityToSearchMissionResponse() {
        var location = "Paris";
        var duration = 3;
        var price = 1025;
        var remote = 0.5f;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date beginning = null;
        try {
            beginning = formatter.parse("2021-08-12");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        var job = "JEE Developer";
        var context = "In a developing team.";
        var description = "The goal is to make a REST API to retrieve personal data.";

        MissionEntity missionEntity = new MissionEntity(0, location, duration, price, remote, beginning, job, context, description);

        MissionEntityToSearchMissionResponse missionEntityToSearchMissionResponse = new MissionEntityToSearchMissionResponse();
        var res = missionEntityToSearchMissionResponse.convertNotNull(missionEntity);

        var expected = new SearchMissionResponse(location, duration, price, remote, beginning, job, context, description);

        assertEquals(expected, res);
    }

    @Test
    public void CheckMissionEntityToUpdateMissionResponse() {
        var location = "Paris";
        var duration = 3;
        var price = 1025;
        var remote = 0.5f;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date beginning = null;
        try {
            beginning = formatter.parse("2021-08-12");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        var job = "JEE Developer";
        var context = "In a developing team.";
        var description = "The goal is to make a REST API to retrieve personal data.";

        MissionEntity missionEntity = new MissionEntity(0, location, duration, price, remote, beginning, job, context, description);

        MissionEntityToUpdateMissionResponse missionEntityToUpdateMissionResponse = new MissionEntityToUpdateMissionResponse();
        var res = missionEntityToUpdateMissionResponse.convertNotNull(missionEntity);

        var expected = new UpdateMissionResponse(0, location, duration, price, remote, beginning, job, context, description);

        assertEquals(expected, res);
    }

    @Test
    public void CheckUpdateRequestToMissionEntity() {
        var id = 2;
        var location = "Paris";
        var duration = 3;
        var price = 1025;
        var remote = 0.5f;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date beginning = null;
        try {
            beginning = formatter.parse("2021-08-12");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        var job = "JEE Developer";
        var context = "In a developing team.";
        var description = "The goal is to make a REST API to retrieve personal data.";

        UpdateMissionRequest updateMissionRequest = new UpdateMissionRequest(id, location, duration, price, remote, beginning, job, context, description);

        UpdateMissionRequestToMissionEntity updateMissionRequestToMissionEntity = new UpdateMissionRequestToMissionEntity();
        var res = updateMissionRequestToMissionEntity.convertNotNull(updateMissionRequest);

        var expected = new MissionEntity(id, location, duration, price, remote, beginning, job, context, description);

        assertEquals(expected, res);
    }

    @Test
    public void CheckMissionEntityToMissionModel()
    {
        var id = 2;
        var location = "Paris";
        var duration = 3;
        var price = 1025;
        var remote = 0.5f;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date beginning = null;
        try {
            beginning = formatter.parse("2021-08-12");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        var job = "JEE Developer";
        var context = "In a developing team.";
        var description = "The goal is to make a REST API to retrieve personal data.";
        MissionEntity missionEntity = new MissionEntity(id, location, duration, price, remote, beginning, job, context, description);
        MissionEntityToMissionModel missionEntityToMissionModel = new MissionEntityToMissionModel();
        MissionModel res = missionEntityToMissionModel.convert(missionEntity);
        MissionModel expected = new MissionModel(id, location, duration, price, remote, beginning, job, context, description);
        assertEquals(expected, res);
    }
    @Test
    public void CheckMissionModelToMissionEntity()
    {
        var id = 2;
        var location = "Paris";
        var duration = 3;
        var price = 1025;
        var remote = 0.5f;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date beginning = null;
        try {
            beginning = formatter.parse("2021-08-12");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        var job = "JEE Developer";
        var context = "In a developing team.";
        var description = "The goal is to make a REST API to retrieve personal data.";
        MissionModel missionModel = new MissionModel(id, location, duration, price, remote, beginning, job, context, description);
        MissionModelToMissionEntity missionModelToMissionEntity = new MissionModelToMissionEntity();
        MissionEntity res = missionModelToMissionEntity.convert(missionModel);
        MissionEntity expected = new MissionEntity(id, location, duration, price, remote, beginning, job, context, description);
        assertEquals(expected, res);
    }
}