package com.huragan11;

import lombok.Builder;
import lombok.Getter;
import lombok.Value;

@Value
@Builder
@Getter
public class NewCustomerRequest {
    String name;
    String email;
    Integer age;
}
