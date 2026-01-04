package objectbuilder;
import models.request.JsonRequestModelPOSTPUT;


//tuka ke zadadam default vrednosti na title i body

public class JsonPlaceObjectBuilder {
    public static JsonRequestModelPOSTPUT creatingBody() {
        return JsonRequestModelPOSTPUT.builder()
                .title("Default title")
                .body("Default body")
                .build();
    }
    public static JsonRequestModelPOSTPUT updatingBody(){
        return  JsonRequestModelPOSTPUT.builder()
                .title ("Updated title")
                .body ("Updated body")
                .build();
    }
}
