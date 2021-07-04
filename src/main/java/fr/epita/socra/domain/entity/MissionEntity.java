package fr.epita.socra.domain.entity;

import java.util.Date;

public record MissionEntity(
        long id,
        String location,
        int duration,
        int price,
        float remote,
        Date beginning,
        String job,
        String context,
        String description) {
}