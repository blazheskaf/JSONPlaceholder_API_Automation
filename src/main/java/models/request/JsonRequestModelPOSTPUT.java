package models.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

//REQUEST BODY vo Postman ima : title i body

public class JsonRequestModelPOSTPUT {
    String title;
    String body;
}
