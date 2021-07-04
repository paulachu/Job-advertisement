package fr.epita.socra.domain.service;

import fr.epita.socra.domain.entity.MissionEntity;

import java.util.List;

public interface MissionServiceInterface {
    List<MissionEntity> findAllMission();
    MissionEntity findOneMission(long missionId);
    List<MissionEntity> searchMission(String search);
    MissionEntity createMission(MissionEntity mission);
    MissionEntity updateMission(MissionEntity mission);
}
