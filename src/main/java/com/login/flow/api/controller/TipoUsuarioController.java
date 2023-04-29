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

import com.login.flow.api.repository.TipoUsuarioRepository;

import com.login.flow.api.model.TipoUsuario;

@RestController
@RequestMapping(value = "/TiposUsuario")
public class TipoUsuarioController {

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    @PostMapping
    public TipoUsuario criarNovoTipoUsuario(@RequestBody TipoUsuario tipoUsuario) {
        return tipoUsuarioRepository.save(tipoUsuario);
    }

    @GetMapping
    public List<TipoUsuario> obterTipoUsuario() {
        return tipoUsuarioRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<TipoUsuario> obterTipoPeloId(@PathVariable(value = "id") Integer id) {
        return tipoUsuarioRepository.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public String deletarTiposPeloId(@PathVariable(value = "id") Integer id) {
        tipoUsuarioRepository.deleteById(id);
        return "Tipo deletado com sucesso!";
    }

    @PutMapping
    public TipoUsuario atualizarTipo(@RequestBody TipoUsuario tipoUsuario) {
        return tipoUsuarioRepository.save(tipoUsuario);
    }

}
