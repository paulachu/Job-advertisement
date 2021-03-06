package fr.epita.socra.data.repository;

import fr.epita.socra.data.model.MissionModel;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MissionRepository implements PanacheRepositoryBase<MissionModel, Long> {
}
