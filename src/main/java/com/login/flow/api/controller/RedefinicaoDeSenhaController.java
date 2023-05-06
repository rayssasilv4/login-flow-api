package com.login.flow.api.controller;

import java.util.Optional;

import org.hibernate.internal.util.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.login.flow.api.dto.RedefinicaoDeSenhaDto;
import com.login.flow.api.model.Usuario;
import com.login.flow.api.repository.UsuarioRepository;

@RestController
public class RedefinicaoDeSenhaController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping(value = "/redefinicaoDeSenha")
    public Object redefinirSenha(@RequestBody RedefinicaoDeSenhaDto redefinicaoDeSenhaDto) {
        String email = redefinicaoDeSenhaDto.getEmail();
        String senhaAtual = redefinicaoDeSenhaDto.getSenhaAtual();
        String novaSenha = redefinicaoDeSenhaDto.getNovaSenha();

        Optional<Usuario> usuarioEmail = usuarioRepository.findByEmail(email);

        if (usuarioEmail.isEmpty()) {
            return "Usuário não cadastrado";
        }

        Usuario usuario = usuarioEmail.get();
        String senhaUsuario = usuario.getSenha();

        if (!senhaAtual.equals(senhaUsuario)) {
            return "Senha inválida";
        }

        usuario.setSenha(novaSenha);

        return usuarioRepository.save(usuario);

    }

}
