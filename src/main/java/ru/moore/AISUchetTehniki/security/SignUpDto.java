package ru.moore.AISUchetTehniki.security;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.moore.AISUchetTehniki.models.Entity.spr.Organization;

@Data
@NoArgsConstructor
public class SignUpDto {

    private Organization organization;

    private String email;
    private String password;

    private String firstName;
    private String lastName;

    private boolean confirmation;
    private String confirmationCode;

}
