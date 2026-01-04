package datafactory;

import models.request.JsonRequestModelPOSTPUT;

public class JsonPlaceDataFactoryPOSTPUT {
    private JsonRequestModelPOSTPUT requestpost;

    public JsonPlaceDataFactoryPOSTPUT(JsonRequestModelPOSTPUT requestBody) {

        requestpost = requestBody;
    }

    public JsonPlaceDataFactoryPOSTPUT setTitle(String title) {
        requestpost.setTitle(title);
        return this;
    }


    public JsonPlaceDataFactoryPOSTPUT setBody(String body) {
        requestpost.setBody(body);
        return this;
    }

    public JsonRequestModelPOSTPUT createRequest() {
        return requestpost;
    }

}

