package models.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
//1. Си ставам анотации
//2. Си декларирам променливи, што ги содржи response body
//3. Тука сум готова и одам во  Client класа.

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class JsonResponseModelGET {
    int userId, id;
    String body, title;
}
