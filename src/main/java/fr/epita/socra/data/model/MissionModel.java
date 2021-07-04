package fr.epita.socra.data.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "missions")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@With
public class MissionModel extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
}
