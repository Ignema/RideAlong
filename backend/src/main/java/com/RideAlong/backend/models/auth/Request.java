package com.RideAlong.backend.models.auth;

import lombok.Data;

@Data
public class Request {
    private String email;
    private String password;
}
