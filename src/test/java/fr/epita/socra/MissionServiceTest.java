package fr.epita.socra;

import fr.epita.socra.converter.Converter;
import fr.epita.socra.converter.entitymodel.MissionEntityToMissionModel;
import fr.epita.socra.converter.entitymodel.MissionModelToMissionEntity;
import fr.epita.socra.data.model.MissionModel;
import fr.epita.socra.domain.entity.MissionEntity;
import fr.epita.socra.domain.service.MissionService;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MissionServiceTest {
    private Converter<MissionModel, MissionEntity> missionModelToMissionEntityConverter= new MissionModelToMissionEntity();
    private Converter<MissionEntity, MissionModel> missionEntityToMissionModelConverter = new MissionEntityToMissionModel();
    private List<MissionModel> missionListMock= new ArrayList<>();
    private MissionService missionService = new MissionService();

    @BeforeEach
    public void initMisisonList()
    {
        missionListMock.clear();

        var id = 1;
        var location = "Issy-les-Moulineaux";
        var duration = 12;
        int price = 0;
        var remote = 0.8f;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date beginning = null;
        try {
            beginning = formatter.parse("2021-05-12");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        var job = "Développeur ReactJs";
        var context = "intégration au sein de l’équipe Engineering du pôle Industrialisation, Cloud and Data, le consultant contribuera aux activités APIs et API Management.";
        var description = "Participer aux Comités d’Architecture pour garantir la bonne conformité des bonnes pratiques des APIs. Promouvoir les pratiques API First au sein du groupe. Rédiger / Maintenir un Guideline de développement d’API (créationde modèle d’API, ...)";
        MissionModel missionModel = new MissionModel(id, location, duration, price, remote, beginning, job, context, description);

        this.missionListMock.add(missionModel);

        id = 2;
        location = "Le Kremlin-Bicêtre";
        duration = 6;
        price = 0;
        remote = 0.5f;
        beginning = null;
        try {
            beginning = formatter.parse("2021-07-02");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        job = "Stagiaire développeur Java";
        context = "Dans la démarche de refonte de leur SI, EPITA a besoin d'une nouvelle application";
        description = "Création d'une application permettant de recenser des missions d'une entreprise, tout en utilisant les bonnes pratiques (Clean code, architecture, tests, CI ....). Création d'une API Rest";
        missionModel = new MissionModel(id, location, duration, price, remote, beginning, job, context, description);

        this.missionListMock.add(missionModel);

        id = 3;
        location = "Sancerre";
        duration = 2;
        price = 5000;
        remote = 0.0f;
        beginning = null;
        try {
            beginning = formatter.parse("2021-09-15");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        job = "Web Designer";
        context = "Ayant gagner la compétition du plus beau village français, Sancerre souhaite créer une application mobile pour valoriser son patrimoine";
        description = "Création de maquettes Adobe XD d'une application mobile permettant de recenser les différents lieux touristiques du village";
        missionModel = new MissionModel(id, location, duration, price, remote, beginning, job, context, description);

        this.missionListMock.add(missionModel);

        id = 4;
        location = "Bordeaux";
        duration = 6;
        price = 0;
        remote = 0.5f;
        beginning = null;
        try {
            beginning = formatter.parse("2022-07-02");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        job = "Stagiaire développeur ReactJs";
        context = "Souhaitant augmenter sa visibilité, le Château Lafon-Rochet souhaite créer un site e-commerce";
        description = "Création du frontend d'une application permettant de commander des bouteilles ou des caisse de vin, la partie backend sera réalisée dans le même temps par un autre stagiaire";
        missionModel = new MissionModel(id, location, duration, price, remote, beginning, job, context, description);

        this.missionListMock.add(missionModel);

        id = 5;
        location = "Paris";
        duration = 1;
        price = 0;
        remote = 1.0f;
        beginning = null;
        try {
            beginning = formatter.parse("2022-01-16");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        job = "Développeur Android Kotlin";
        context = "Dans la cadre de la réalisation d'une application permettant de visualiser les photos prises par les différents rovers, la Nasa a besoin d'une application Android";
        description = "Création d'une application permettant de visualiser les photos prises par les rovers, une API est déjà existante";
        missionModel = new MissionModel(id, location, duration, price, remote, beginning, job, context, description);

        this.missionListMock.add(missionModel);

        id = 6;
        location = "Belgrade";
        duration = 3;
        price = 1500;
        remote = 1f;
        beginning = null;
        try {
            beginning = formatter.parse("2022-04-25");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        job = "Développeur Wix";
        context = "Pour la refonte de leur site vitrine, VIP Mobile a besoin d'un nouveau frontend";
        description = "Création d'un frontend permettant de visualiser les produits et les différentes annonces de l'entreprise";
        missionModel = new MissionModel(id, location, duration, price, remote, beginning, job, context, description);

        this.missionListMock.add(missionModel);

        id = 7;
        location = "Barcelonnette";
        duration = 6;
        price = 500;
        remote = 0.75f;
        beginning = null;
        try {
            beginning = formatter.parse("2022-03-17");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        job = "Rédacteur";
        context = "Ayant pour devoir la rédaction d'un rapport sur le bouquetin des Alpes, un élève de l'Epita est à la recherche d'un rédacteur";
        description = "Rédaction d'un mémoire de 50 pages sur les bouquetins des Alpes, le but étant d'étudier leur comportement";
        missionModel = new MissionModel(id, location, duration, price, remote, beginning, job, context, description);

        this.missionListMock.add(missionModel);

        id = 8;
        location = "Le Kremlin-Bicêtre";
        duration = 5;
        price = 15000;
        remote = 0.8f;
        beginning = null;
        try {
            beginning = formatter.parse("2022-08-29");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        job = "Stagiaire développeur Java";
        context = "Dans le cadre de la production d'une nouvelle solution l'entreprise Uber a besoin d'une nouvelle application";
        description = "Création d'une application permettant de livrer des oeuvres d'art, Uber a beosin d'une application web Java utilisant quarkus et vaadin";
        missionModel = new MissionModel(id, location, duration, price, remote, beginning, job, context, description);

        this.missionListMock.add(missionModel);

        id = 9;
        location = "Montreuil";
        duration = 12;
        price = 75000;
        remote = 0.25f;
        beginning = null;
        try {
            beginning = formatter.parse("2022-05-19");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        job = "Stagiaire développeur Java";
        context = "Afin d'améliorer les compétences de leurs équipes, l'entreprise Ubisoft recherche un formateur";
        description = "Pour développer les compétences de leurs équipes, l'entreprise Ubisoft recherche un formateur experimenté dans les moteurs de jeu. Une première formation consistera à expliquer aux développeurs comment exécuter une testsuite";
        missionModel = new MissionModel(id, location, duration, price, remote, beginning, job, context, description);

        this.missionListMock.add(missionModel);

        id = 10;
        location = "Marseille";
        duration = 6;
        price = 1;
        remote = 0.0f;
        beginning = null;
        try {
            beginning = formatter.parse("2022-06-23");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        job = "Stagiaire chargée de communication";
        context = "Afin de redorer son image, l'entreprise Harmoniks a besoin d'une personne chargée de communication";
        description = "L'entreprise Harmoniks ayant connu une année catastrophique, elle cherche à redorer son image. Une campagne publicitaire est déjà prévue. Cependant, aucune communication digitale n'est actuellement faite.";
        missionModel = new MissionModel(id, location, duration, price, remote, beginning, job, context, description);

        this.missionListMock.add(missionModel);
    }

    @Test
    void checkFindAllMisisons()
    {
        var res = missionService.findAllMission();
        Collections.sort(missionListMock, (m1, m2) -> (int) (m1.getId() - m2.getId()));
        assertEquals(missionListMock, res);
    }
    @Test
    void checkFindOneMisisonFound()
    {
        var res = missionService.findOneMission(1l);
        assertEquals(missionListMock.get(0), res);
    }
    @Test
    void checkFindOneMisisonNotFound()
    {
        var res = missionService.findOneMission(11l);
        assertNull(res);
    }
}