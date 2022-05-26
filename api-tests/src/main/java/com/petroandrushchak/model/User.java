package com.petroandrushchak.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    String email;
    String password;

}
