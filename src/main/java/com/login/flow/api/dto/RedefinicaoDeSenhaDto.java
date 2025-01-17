package com.login.flow.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RedefinicaoDeSenhaDto {

    private String email;
    private String novaSenha;
    private String senhaAtual;
}
