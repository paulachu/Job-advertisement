package fr.epita.socra;

import fr.epita.socra.data.model.MissionModel;
import fr.epita.socra.data.repository.MissionRepository;
import fr.epita.socra.domain.entity.MissionEntity;
import fr.epita.socra.presentation.missiondto.CreateMissionRequest;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.vertx.core.json.JsonObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.is;


@QuarkusTest
public class IntegrationTest {

    @InjectMock
    MissionRepository missionRepository;
    private ArrayList<MissionModel> missionListMock = new ArrayList<>();
    private Timestamp beginning;

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
    void initList()
    {
        missionListMock.clear();

        var id = 1;
        var location = "Issy-les-Moulineaux";
        var duration = 12;
        int price = 0;
        var remote = 0.8f;

        Timestamp beginning = StringToTimestamp("2021-05-12");
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
        beginning = StringToTimestamp("2021-07-02");
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
        beginning = StringToTimestamp("2021-09-15");
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
        beginning = StringToTimestamp("2022-07-02");
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
        beginning = StringToTimestamp("2022-01-16");
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
        beginning = StringToTimestamp("2022-04-25");
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
        beginning = StringToTimestamp("2022-03-17");
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
        beginning = StringToTimestamp("2022-08-29");
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
        beginning = StringToTimestamp("2022-05-19");
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
        beginning = StringToTimestamp("2022-06-23");
        job = "Stagiaire chargée de communication";
        context = "Afin de redorer son image, l'entreprise Harmoniks a besoin d'une personne chargée de communication";
        description = "L'entreprise Harmoniks ayant connu une année catastrophique, elle cherche à redorer son image. Une campagne publicitaire est déjà prévue. Cependant, aucune communication digitale n'est actuellement faite.";
        missionModel = new MissionModel(id, location, duration, price, remote, beginning, job, context, description);

        this.missionListMock.add(missionModel);
    }
    @Test
    void findAllMissions()
    {
        Mockito.when(missionRepository.listAll()).thenReturn(missionListMock);
        when().get("/mission").then().body("$.size()", is(10),
                        "[9].job", is("Développeur ReactJs"),
                        "[9].context", is("intégration au sein de l’équipe Engineering du pôle Industrialisation, Cloud and Data, le consultant contribuera aux activités APIs et API Management."),
                        "[9].description", is("Participer aux Comités d’Architecture pour garantir la bonne conformité des bonnes pratiques des APIs. Promouvoir les pratiques API First au sein du groupe. Rédiger / Maintenir un Guideline de développement d’API (créationde modèle d’API, ...)"),
                        "[9].duration", is(12),
                        "[9].price", is(0),
                        "[9].remote", is(0.8f),
                        "[9].location", is("Issy-les-Moulineaux"));
    }
    @Test
    void findOneById()
    {
        Mockito.when(missionRepository.findById(1l)).thenReturn(missionListMock.get(0));
        when().get("/mission/1").then().body("job", is("Développeur ReactJs"),
                "context", is("intégration au sein de l’équipe Engineering du pôle Industrialisation, Cloud and Data, le consultant contribuera aux activités APIs et API Management."),
                "description", is("Participer aux Comités d’Architecture pour garantir la bonne conformité des bonnes pratiques des APIs. Promouvoir les pratiques API First au sein du groupe. Rédiger / Maintenir un Guideline de développement d’API (créationde modèle d’API, ...)"),
                "duration", is(12),
                "price", is(0),
                "remote", is(0.8f),
                "location", is("Issy-les-Moulineaux"));
    }

    @Test
    void searchMission()
    {
        Mockito.when(missionRepository.listAll()).thenReturn(missionListMock);
        when().get("/mission/search/Java").then().statusCode(200).body("$.size()", is(3),
                "[1].job", is("Stagiaire développeur Java"),
                "[1].context", is("Afin d'améliorer les compétences de leurs équipes, l'entreprise Ubisoft recherche un formateur"),
                "[1].description", is("Pour développer les compétences de leurs équipes, l'entreprise Ubisoft recherche un formateur experimenté dans les moteurs de jeu. Une première formation consistera à expliquer aux développeurs comment exécuter une testsuite"),
                "[1].duration", is(12),
                "[1].price", is(75000),
                "[1].remote", is(0.25f),
                "[1].location", is("Montreuil"));
    }
    @Test
    void createMission()
    {
        Mockito.doNothing().when(missionRepository).persist(ArgumentMatchers.any(MissionModel.class));
        Mockito.when(missionRepository.isPersistent(ArgumentMatchers.any(MissionModel.class))).thenReturn(true);

        RequestSpecification request = RestAssured.given();
        JsonObject requestParams = new JsonObject();
        requestParams.put("location", "Montreux");
        requestParams.put("duration", 2);

        requestParams.put("price", 3000000);
        requestParams.put("remote", 0.0f);
        requestParams.put("beginning", "2021-08-08");
        requestParams.put("job", "Développeur humouristique");
        requestParams.put("context", "La pandémie c'est pas drole");
        requestParams.put("description", "Venez remonter le moral de nos équipes de développeurs.");
        request.header("Content-Type","application/json");
        request.body(requestParams.toString());
        request.post("/mission").then().statusCode(201).body("job", is("Développeur humouristique"),
                "context", is("La pandémie c'est pas drole"),
                "description", is("Venez remonter le moral de nos équipes de développeurs."),
                "duration", is(2),
                "price", is(3000000),
                "remote", is(0.0f),
                "location", is("Montreux"));
    }
    @Test
    void updateMissionSuccess()
    {
        Mockito.doNothing().when(missionRepository).persist(ArgumentMatchers.any(MissionModel.class));
        Mockito.when(missionRepository.isPersistent(ArgumentMatchers.any(MissionModel.class))).thenReturn(true);

        RequestSpecification request = RestAssured.given();
        JsonObject requestParams = new JsonObject();
        requestParams.put("location", "Montreux");
        requestParams.put("duration", 2);
        requestParams.put("id", "1");
        requestParams.put("price", 3000000);
        requestParams.put("remote", 0.0f);
        requestParams.put("beginning", "2021-08-08");
        requestParams.put("job", "Développeur humouristique");
        requestParams.put("context", "La pandémie c'est pas drole");
        requestParams.put("description", "Venez remonter le moral de nos équipes de développeurs.");
        request.header("Content-Type","application/json");

        request.body(requestParams.toString());
        request.post("/mission").then().statusCode(201).body("job", is("Développeur humouristique"),
                "context", is("La pandémie c'est pas drole"),
                "description", is("Venez remonter le moral de nos équipes de développeurs."),
                "duration", is(2),
                "price", is(3000000),
                "remote", is(0.0f),
                "location", is("Montreux"));
    }
    @Test
    void updateMissionWrongId()
    {
        Mockito.doNothing().when(missionRepository).persist(ArgumentMatchers.any(MissionModel.class));
        Mockito.when(missionRepository.isPersistent(ArgumentMatchers.any(MissionModel.class))).thenReturn(true);

        RequestSpecification request = RestAssured.given();
        JsonObject requestParams = new JsonObject();
        requestParams.put("id", "-1");
        requestParams.put("location", "Montreux");
        requestParams.put("duration", 2);

        requestParams.put("price", 3000000);
        requestParams.put("remote", 0.0f);
        requestParams.put("beginning", "2021-08-08");
        requestParams.put("job", "Développeur humouristique");
        requestParams.put("context", "La pandémie c'est pas drole");
        requestParams.put("description", "Venez remonter le moral de nos équipes de développeurs.");
        request.header("Content-Type","application/json");
        request.body(requestParams.toString());
        request.put("/mission").then().statusCode(304);
    }
    @Test
    void updateMissionWrongDateFormat()
    {
        Mockito.doNothing().when(missionRepository).persist(ArgumentMatchers.any(MissionModel.class));
        Mockito.when(missionRepository.isPersistent(ArgumentMatchers.any(MissionModel.class))).thenReturn(true);

        RequestSpecification request = RestAssured.given();
        JsonObject requestParams = new JsonObject();
        requestParams.put("id", "1");
        requestParams.put("location", "Montreux");
        requestParams.put("duration", 2);

        requestParams.put("price", 3000000);
        requestParams.put("remote", 0.0f);
        requestParams.put("beginning", "2021/08/08");
        requestParams.put("job", "Développeur humouristique");
        requestParams.put("context", "La pandémie c'est pas drole");
        requestParams.put("description", "Venez remonter le moral de nos équipes de développeurs.");
        request.header("Content-Type","application/json");
        request.body(requestParams.toString());
        request.put("/mission").then().statusCode(304);
    }
}
