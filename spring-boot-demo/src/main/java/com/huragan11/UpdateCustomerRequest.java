package com.huragan11;

import lombok.Builder;
import lombok.Getter;
import lombok.Value;

@Value
@Getter
@Builder
public class UpdateCustomerRequest {
    String name;
    String email;
}
