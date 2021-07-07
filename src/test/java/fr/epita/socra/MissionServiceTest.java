package fr.epita.socra;

import fr.epita.socra.converter.entitymodel.MissionEntityToMissionModel;
import fr.epita.socra.converter.entitymodel.MissionModelToMissionEntity;
import fr.epita.socra.data.repository.MissionRepository;
import fr.epita.socra.domain.entity.MissionEntity;
import fr.epita.socra.domain.service.MissionService;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.*;

import javax.inject.Inject;
import javax.persistence.PersistenceException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MissionServiceTest {
    private List<MissionEntity> missionListMock = new ArrayList<>();
    @Inject
    MissionService missionService;

    public Timestamp StringToTimestamp(String stringDate)
    {

        Date tmp = null;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            tmp = formatter.parse(stringDate);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return new Timestamp(tmp.getTime());
    }
    @BeforeEach
    public void initMisisonList() {
        missionListMock.clear();

        var id = 1;
        var location = "Issy-les-Moulineaux";
        var duration = 12;
        int price = 0;
        var remote = 0.8f;

        Timestamp
            beginning = StringToTimestamp("2021-05-12");
        var job = "Développeur ReactJs";
        var context = "intégration au sein de l’équipe Engineering du pôle Industrialisation, Cloud and Data, le consultant contribuera aux activités APIs et API Management.";
        var description = "Participer aux Comités d’Architecture pour garantir la bonne conformité des bonnes pratiques des APIs. Promouvoir les pratiques API First au sein du groupe. Rédiger / Maintenir un Guideline de développement d’API (créationde modèle d’API, ...)";
        MissionEntity missionEntity = new MissionEntity(id, location, duration, price, remote, beginning, job, context, description);

        this.missionListMock.add(missionEntity);

        id = 2;
        location = "Le Kremlin-Bicêtre";
        duration = 6;
        price = 0;
        remote = 0.5f;
            beginning = StringToTimestamp("2021-07-02");
        job = "Stagiaire développeur Java";
        context = "Dans la démarche de refonte de leur SI, EPITA a besoin d'une nouvelle application";
        description = "Création d'une application permettant de recenser des missions d'une entreprise, tout en utilisant les bonnes pratiques (Clean code, architecture, tests, CI ....). Création d'une API Rest";
        missionEntity = new MissionEntity(id, location, duration, price, remote, beginning, job, context, description);

        this.missionListMock.add(missionEntity);

        id = 3;
        location = "Sancerre";
        duration = 2;
        price = 5000;
        remote = 0.0f;
            beginning = StringToTimestamp("2021-09-15");
        job = "Web Designer";
        context = "Ayant gagner la compétition du plus beau village français, Sancerre souhaite créer une application mobile pour valoriser son patrimoine";
        description = "Création de maquettes Adobe XD d'une application mobile permettant de recenser les différents lieux touristiques du village";
        missionEntity = new MissionEntity(id, location, duration, price, remote, beginning, job, context, description);

        this.missionListMock.add(missionEntity);

        id = 4;
        location = "Bordeaux";
        duration = 6;
        price = 0;
        remote = 0.5f;
            beginning = StringToTimestamp("2022-07-02");
        job = "Stagiaire développeur ReactJs";
        context = "Souhaitant augmenter sa visibilité, le Château Lafon-Rochet souhaite créer un site e-commerce";
        description = "Création du frontend d'une application permettant de commander des bouteilles ou des caisse de vin, la partie backend sera réalisée dans le même temps par un autre stagiaire";
        missionEntity = new MissionEntity(id, location, duration, price, remote, beginning, job, context, description);

        this.missionListMock.add(missionEntity);

        id = 5;
        location = "Paris";
        duration = 1;
        price = 0;
        remote = 1.0f;
            beginning = StringToTimestamp("2022-01-16");
        job = "Développeur Android Kotlin";
        context = "Dans la cadre de la réalisation d'une application permettant de visualiser les photos prises par les différents rovers, la Nasa a besoin d'une application Android";
        description = "Création d'une application permettant de visualiser les photos prises par les rovers, une API est déjà existante";
        missionEntity = new MissionEntity(id, location, duration, price, remote, beginning, job, context, description);

        this.missionListMock.add(missionEntity);

        id = 6;
        location = "Belgrade";
        duration = 3;
        price = 1500;
        remote = 1f;
            beginning = StringToTimestamp("2022-04-25");
        job = "Développeur Wix";
        context = "Pour la refonte de leur site vitrine, VIP Mobile a besoin d'un nouveau frontend";
        description = "Création d'un frontend permettant de visualiser les produits et les différentes annonces de l'entreprise";
        missionEntity = new MissionEntity(id, location, duration, price, remote, beginning, job, context, description);

        this.missionListMock.add(missionEntity);

        id = 7;
        location = "Barcelonnette";
        duration = 6;
        price = 500;
        remote = 0.75f;
            beginning = StringToTimestamp("2022-03-17");
        job = "Rédacteur";
        context = "Ayant pour devoir la rédaction d'un rapport sur le bouquetin des Alpes, un élève de l'Epita est à la recherche d'un rédacteur";
        description = "Rédaction d'un mémoire de 50 pages sur les bouquetins des Alpes, le but étant d'étudier leur comportement";
        missionEntity = new MissionEntity(id, location, duration, price, remote, beginning, job, context, description);

        this.missionListMock.add(missionEntity);

        id = 8;
        location = "Le Kremlin-Bicêtre";
        duration = 5;
        price = 15000;
        remote = 0.8f;
            beginning = StringToTimestamp("2022-08-29");
        job = "Stagiaire développeur Java";
        context = "Dans le cadre de la production d'une nouvelle solution l'entreprise Uber a besoin d'une nouvelle application";
        description = "Création d'une application permettant de livrer des oeuvres d'art, Uber a beosin d'une application web Java utilisant quarkus et vaadin";
        missionEntity = new MissionEntity(id, location, duration, price, remote, beginning, job, context, description);

        this.missionListMock.add(missionEntity);

        id = 9;
        location = "Montreuil";
        duration = 12;
        price = 75000;
        remote = 0.25f;
            beginning = StringToTimestamp("2022-05-19");
        job = "Stagiaire développeur Java";
        context = "Afin d'améliorer les compétences de leurs équipes, l'entreprise Ubisoft recherche un formateur";
        description = "Pour développer les compétences de leurs équipes, l'entreprise Ubisoft recherche un formateur experimenté dans les moteurs de jeu. Une première formation consistera à expliquer aux développeurs comment exécuter une testsuite";
        missionEntity = new MissionEntity(id, location, duration, price, remote, beginning, job, context, description);

        this.missionListMock.add(missionEntity);

        id = 10;
        location = "Marseille";
        duration = 6;
        price = 1;
        remote = 0.0f;
            beginning = StringToTimestamp("2022-06-23");
        job = "Stagiaire chargée de communication";
        context = "Afin de redorer son image, l'entreprise Harmoniks a besoin d'une personne chargée de communication";
        description = "L'entreprise Harmoniks ayant connu une année catastrophique, elle cherche à redorer son image. Une campagne publicitaire est déjà prévue. Cependant, aucune communication digitale n'est actuellement faite.";
        missionEntity = new MissionEntity(id, location, duration, price, remote, beginning, job, context, description);

        this.missionListMock.add(missionEntity);
    }

    @Order(1)
    @Test
    void checkFindAllMissions() {
        var res = missionService.findAllMission();
        Collections.sort(missionListMock, (m1, m2) -> (int) (m2.id() - m1.id()));
        assertEquals(missionListMock, res);
    }
    @Order(2)
    @Test
    void checkFindOneMisisonFound() {
        var res = missionService.findOneMission(1l);
        assertEquals(missionListMock.get(0), res);
    }
    @Order(3)
    @Test
    void checkFindOneMisisonNotFound() {
        var res = missionService.findOneMission(11l);
        assertNull(res);
    }

    @Order(4)
    @Test
    public void checkSearchMissionEasy() {
        String toSearch = "Java";
        var res = missionService.searchMission(toSearch);
        var expected = List.of(
                missionListMock.get(7),
                missionListMock.get(8),
                missionListMock.get(1)
        );
        assertEquals(expected, res);
    }

    @Order(5)
    @Test
    public void checkSearchMissionComplex() {
        String toSearch = "Développeur application";
        var res = missionService.searchMission(toSearch);
        var expected = List.of(
                missionListMock.get(7),
                missionListMock.get(4),
                missionListMock.get(1),
                missionListMock.get(3),
                missionListMock.get(8),
                missionListMock.get(5),
                missionListMock.get(2),
                missionListMock.get(0)
        );
        assertEquals(expected, res);
    }

    @Order(6)
    @Test
    public void checkSearchMissionDoesntExist() {
        String toSearch = "jen'existepas";
        var res = missionService.searchMission(toSearch);
        List<MissionEntity> expected = new ArrayList<>();
        assertEquals(expected, res);
    }

    @Order(7)
    @Test
    void checkUpdateMissionNotFound() {
        var id = -1;
        var location = "Marseille";
        var duration = 6;
        var price = 1;
        var remote = 0.0f;
        Timestamp beginning = StringToTimestamp("2022-06-23");
        var job = "Stagiaire chargée de communication";
        var context = "Afin de redorer son image, l'entreprise Harmoniks a besoin d'une personne chargée de communication";
        var description = "L'entreprise Harmoniks ayant connu une année catastrophique, elle cherche à redorer son image. Une campagne publicitaire est déjà prévue. Cependant, aucune communication digitale n'est actuellement faite.";
        var missionEntity = new MissionEntity(id, location, duration, price, remote, beginning, job, context, description);

        assertNull(missionService.updateMission(missionEntity));
    }
    @Order(8)
    @Test
    void checkUpdateMissionFound() {
        var id = 9;
        var location = "Montreuil";
        var duration = 12;
        var price = 75000;
        var remote = 0.25f;
        Timestamp beginning = StringToTimestamp("2021-05-19");
        var job = "Formateur moteur de jeu";
        var context = "Afin d'améliorer les compétences de leurs équipes, l'entreprise Ubisoft recherche un formateur";
        var description = "Pour développer les compétences de leurs équipes, l'entreprise Ubisoft recherche un formateur experimenté dans les moteurs de jeu. Une première formation consistera à expliquer aux développeurs comment exécuter une testsuite";
        var missionEntity = new MissionEntity(id, location, duration, price, remote, beginning, job, context, description);

        assertEquals(missionEntity, missionService.updateMission(missionEntity));
    }
    @Order(9)
    @Test
    void checkCreateMissionSuccess() {
        var location = "Montreux";
        var duration = 2;
        var price = 3000000;
        var remote = 0.0f;
        Timestamp beginning = StringToTimestamp("2021-08-08");
        var job = "Développeur humouristique";
        var context = "La pandémie c'est pas drole";
        var description = "Venez remonter le moral de nos équipes de développeurs.";
        var missionEntity = new MissionEntity(11, location, duration, price, remote, beginning, job, context, description);

        assertEquals(missionEntity, missionService.createMission(missionEntity));
    }
    @Order(10)
    @Test
    void checkCreateMissionFailureNoJob() {
        var location = "Montreux";
        var duration = 2;
        var price = 3000000;
        var remote = 0.0f;
        Timestamp beginning = StringToTimestamp("2021-08-08");
        var context = "La pandémie c'est pas drole";
        var description = "Venez remonter le moral de nos équipes de développeurs.";
        var missionEntity = new MissionEntity(-1, location, duration, price, remote, beginning, null, context, description);
        assertThrows(PersistenceException.class, () ->
                missionService.createMission(missionEntity)
        );
    }
    @Order(11)
    @Test
    void checkCreateMissionFailureNoContext() {
        var location = "Montreux";
        var duration = 2;
        var price = 3000000;
        var remote = 0.0f;
        Timestamp beginning = StringToTimestamp("2021-08-08");
        var job = "Développeur humouristique";
        var description = "Venez remonter le moral de nos équipes de développeurs.";
        Date finalBeginning = beginning;
        var missionEntity = new MissionEntity(-1, location, duration, price, remote, finalBeginning, job, null, description);
        assertThrows(PersistenceException.class, () ->
                missionService.createMission(missionEntity)
        );
    }
    @Order(12)
    @Test
    void checkCreateMissionFailureNoDescription() {
        var location = "Montreux";
        var duration = 2;
        var price = 3000000;
        var remote = 0.0f;
        Timestamp beginning = StringToTimestamp("2021-08-08");
        var job = "Développeur humouristique";
        var context = "La pandémie c'est pas drole";
        var missionEntity = new MissionEntity(-1, location, duration, price, remote, beginning, job, context, null);
        assertThrows(PersistenceException.class, () ->
                missionService.createMission(missionEntity)
        );
    }
    @Order(13)
    @Test
    void checkCreateMissionFailureRemoteGreaterThanOne() {
        var location = "Montreux";
        var duration = 2;
        var price = 3000000;
        var remote = 3.0f;
        Timestamp beginning = StringToTimestamp("2021-08-08");
        var job = "Développeur humouristique";
        var context = "La pandémie c'est pas drole";
        var description = "Venez remonter le moral de nos équipes de développeurs.";
        var missionEntity = new MissionEntity(-1, location, duration, price, remote, beginning, job, context, description);
        assertNull(missionService.createMission(missionEntity));
    }
    @Order(14)
    @Test
    void checkCreateMissionFailureRemoteLowerThanZero() {
        var location = "Montreux";
        var duration = 2;
        var price = 3000000;
        var remote = -1.0f;
        Timestamp beginning = StringToTimestamp("2021-08-08");
        var job = "Développeur humouristique";
        var context = "La pandémie c'est pas drole";
        var description = "Venez remonter le moral de nos équipes de développeurs.";
        var missionEntity = new MissionEntity(-1, location, duration, price, remote, beginning, job, context, description);
        assertNull(missionService.createMission(missionEntity));
    }
}