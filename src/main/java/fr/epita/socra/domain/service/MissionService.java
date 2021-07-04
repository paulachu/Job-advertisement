package fr.epita.socra.domain.service;

import fr.epita.socra.domain.entity.MissionEntity;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class MissionService implements MissionServiceInterface {
    @Override
    public List<MissionEntity> findAllMission() {
        return null;
    }

    @Override
    public MissionEntity findOneMission(long missionId) {
        return null;
    }

    @Override
    public List<MissionEntity> searchMission(String search) {
        return null;
    }

    @Override
    public MissionEntity createMission(MissionEntity mission) {
        return null;
    }

    @Override
    public MissionEntity updateMission(MissionEntity mission) {
        return null;
    }
}
