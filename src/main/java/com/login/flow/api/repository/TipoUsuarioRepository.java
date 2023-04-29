package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.TipoUsuario;

public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Integer> {

}
