package fr.epita.socra;

import fr.epita.socra.presentation.resource.MissionResource;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.when;

@QuarkusTest
@TestHTTPEndpoint(MissionResource.class)
class MissionResourceTest {


    @Test
    void findOneMissionNotExist()
    {
        when().get("-1")
                .then()
                .statusCode(400);
    }

    @Test
    void updateMissionWithoutBody() {
        when().patch()
                .then()
                .statusCode(405);
    }

    @Test
    void createMissionWithoutBody() {
        when().post()
                .then()
                .statusCode(415);
    }
}