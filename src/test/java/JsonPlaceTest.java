import client.JsonPlaceClient;
import datafactory.JsonPlaceDataFactoryPOSTPUT;
import io.restassured.response.Response;
import models.request.JsonRequestModelPOSTPUT;
import models.response.JsonResponseModelGET;
import models.response.JsonResponseModelPOSTPUT;
import objectbuilder.JsonPlaceObjectBuilder;
import org.codehaus.groovy.runtime.ScriptReference;
import org.junit.Test;

import java.util.List;

import static objectbuilder.JsonPlaceObjectBuilder.creatingBody;
import static objectbuilder.JsonPlaceObjectBuilder.updatingBody;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class JsonPlaceTest {
    @Test
    public void postPostDefaultHealthCheckTest(){

        JsonRequestModelPOSTPUT post1 = new JsonPlaceDataFactoryPOSTPUT(creatingBody())
                .createRequest();

        Response postResponse = new JsonPlaceClient()
                .createPost(post1);
        assertEquals(201, postResponse.statusCode());
    }
    @Test
    public void postPostCustomValuesTest(){
        JsonRequestModelPOSTPUT post2 = new JsonPlaceDataFactoryPOSTPUT(creatingBody())
                .setTitle("Naslov")
                .setBody("Ovoj tekst e body")
                .createRequest();

        Response postResponse = new JsonPlaceClient()
                .createPost(post2);

     JsonResponseModelPOSTPUT response = postResponse.body().as(JsonResponseModelPOSTPUT.class);
        assertEquals(201, postResponse.statusCode());
        assertEquals("Naslov", response.getTitle());
        assertEquals("Ovoj tekst e body", response.getBody());
    }
    @Test
    public void putPostDefaultValuesHealthCheckTest(){
        JsonRequestModelPOSTPUT putPost1 = new JsonPlaceDataFactoryPOSTPUT(updatingBody())
                .createRequest();
        Response responseBody = new JsonPlaceClient()
                .updatePost(putPost1, "4");
        assertEquals( 200, responseBody.statusCode());
    }
    @Test
    public void putPostCustomValuesTest(){
        JsonRequestModelPOSTPUT putPost2 = new JsonPlaceDataFactoryPOSTPUT(updatingBody())
                .setTitle("Post 2")
                .setBody("Koregiram")
                .createRequest();
                Response putResponse = new JsonPlaceClient()
                        .updatePost(putPost2, "4");
                assertEquals(200, putResponse .statusCode());
                assertEquals("Post 2", putPost2.getTitle());
                assertEquals("Koregiram", putPost2.getBody());
    }
    @Test
    public void getAllPostsTest(){
        //****
        Response getResponse = new JsonPlaceClient()
                .getAllPost();

        List<JsonResponseModelGET> getResponseList = getResponse
                .body()
                .jsonPath()
                .getList("", JsonResponseModelGET.class);


        assertEquals(200, getResponse.statusCode());
        assertFalse(getResponseList.isEmpty());
    }
    @Test
    public void getSinglePostTest(){
        String title = "eum et est occaecati";
        String body = "ullam et saepe reiciendis voluptatem adipisci\nsit amet autem assumenda provident rerum culpa\nquis hic commodi nesciunt rem tenetur doloremque ipsam iure\nquis sunt voluptatem rerum illo velit";
        Response getResponseSingle = new JsonPlaceClient()
                .getSinglePost("4");

        JsonResponseModelGET responseGet = getResponseSingle.body().as(JsonResponseModelGET.class);
        assertEquals(200, getResponseSingle.statusCode());
        assertEquals(title, responseGet.getTitle());
        assertEquals(body, responseGet.getBody());
    }
    @Test
    public void deletePostTest(){
        Response deleteResponse = new JsonPlaceClient()
                .deletePost("4");
        assertEquals(200, deleteResponse.statusCode());
    }
}
