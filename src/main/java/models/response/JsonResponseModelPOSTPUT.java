package models.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

//RESPONSE BODY vo Postman mi vrakja : title, body i id.
public class JsonResponseModelPOSTPUT {
    String title, body;
    int id;
}
