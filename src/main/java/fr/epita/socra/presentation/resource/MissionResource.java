package fr.epita.socra.presentation.resource;

import fr.epita.socra.converter.Converter;
import fr.epita.socra.domain.entity.MissionEntity;
import fr.epita.socra.domain.service.MissionServiceInterface;
import fr.epita.socra.presentation.missiondto.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("mission")
@Produces(MediaType.APPLICATION_JSON)
public class MissionResource {
    private MissionServiceInterface missionService;
    private Converter<CreateMissionRequest, MissionEntity> createMissionRequestToMissionEntity;
    private Converter<MissionEntity, CreateMissionResponse> missionEntityToCreateMissionResponse;
    private Converter<MissionEntity, FindAllMissionsResponse> missionEntityToFindAllMissionsResponse;
    private Converter<MissionEntity, FindOneMissionResponse> missionEntityToFindOneMissionResponse;
    private Converter<MissionEntity, SearchMissionResponse> missionEntityToSearchMissionResponse;
    private Converter<MissionEntity, UpdateMissionResponse> missionEntityToUpdateMissionResponse;
    private Converter<UpdateMissionRequest, MissionEntity> updateMissionRequestToMissionEntity;

    public MissionResource(MissionServiceInterface missionService,
                           Converter<CreateMissionRequest, MissionEntity> createMissionRequestToMissionEntity,
                           Converter<MissionEntity, CreateMissionResponse> missionEntityToCreateMissionResponse,
                           Converter<MissionEntity, FindAllMissionsResponse> missionEntityToFindAllMissionsResponse,
                           Converter<MissionEntity, FindOneMissionResponse> missionEntityToFindOneMissionResponse,
                           Converter<MissionEntity, SearchMissionResponse> missionEntityToSearchMissionResponse,
                           Converter<MissionEntity, UpdateMissionResponse> missionEntityToUpdateMissionResponse,
                           Converter<UpdateMissionRequest, MissionEntity> updateMissionRequestToMissionEntity) {
        this.missionService = missionService;
        this.createMissionRequestToMissionEntity = createMissionRequestToMissionEntity;
        this.missionEntityToCreateMissionResponse = missionEntityToCreateMissionResponse;
        this.missionEntityToFindAllMissionsResponse = missionEntityToFindAllMissionsResponse;
        this.missionEntityToFindOneMissionResponse = missionEntityToFindOneMissionResponse;
        this.missionEntityToSearchMissionResponse = missionEntityToSearchMissionResponse;
        this.missionEntityToUpdateMissionResponse = missionEntityToUpdateMissionResponse;
        this.updateMissionRequestToMissionEntity = updateMissionRequestToMissionEntity;
    }

    @GET
    public List<FindAllMissionsResponse> findAllMissions() {
        return missionEntityToFindAllMissionsResponse.convertList(missionService.findAllMission());
    }
}