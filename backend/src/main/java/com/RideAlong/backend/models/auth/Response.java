package com.RideAlong.backend.models.auth;

import lombok.Data;

@Data
public class Response {
    private String jwt;
    private String userId;

    public Response(String jwt, String userId) {
        this.jwt = jwt;
        this.userId = userId;
    }
}
