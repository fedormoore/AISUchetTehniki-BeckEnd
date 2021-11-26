package ru.moore.AISUchetTehniki.security.dto;

import lombok.Data;

@Data
public class JwtRequest {

    private String login;
    private String password;

}
