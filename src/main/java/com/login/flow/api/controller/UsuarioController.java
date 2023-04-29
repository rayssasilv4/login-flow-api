package com.login.flow.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.login.flow.api.repository.UsuarioRepository;

import com.login.flow.api.model.Usuario;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public Usuario criarNovoUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @GetMapping
    public List<Usuario> obterUsuario() {
        return usuarioRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<Usuario> obterUsuarioPeloId(@PathVariable(value = "id") Integer id) {
        return usuarioRepository.findById(id);
    }

    @GetMapping(value = "/email/{email}")
    public Optional<Usuario> obterUsuarioPeloEmail(@PathVariable(value = "email") String email) {
        return usuarioRepository.findByEmail(email);
    }

    @DeleteMapping(value = "/{id}")
    public String deletarUsuarioPeloId(@PathVariable(value = "id") Integer id) {
        usuarioRepository.deleteById(id);
        return "Usuário deletado com sucesso!";
    }

    @PutMapping
    public Usuario atualizarUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

}
