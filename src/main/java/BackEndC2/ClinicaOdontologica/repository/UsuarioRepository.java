package BackEndC2.ClinicaOdontologica.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import BackEndC2.ClinicaOdontologica.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    Optional<Usuario> findByEmail(String email);
}
