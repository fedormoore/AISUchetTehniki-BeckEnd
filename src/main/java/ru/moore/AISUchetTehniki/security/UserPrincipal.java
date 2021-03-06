package ru.moore.AISUchetTehniki.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserPrincipal {

    private Long id;

    private Long organization_id;

}
