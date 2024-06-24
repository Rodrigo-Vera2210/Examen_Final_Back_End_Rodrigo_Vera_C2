package BackEndC2.ClinicaOdontologica.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import BackEndC2.ClinicaOdontologica.entity.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long>{
    
    @Query("SELECT p FROM Paciente p WHERE p.email=?1")
    Optional<Paciente> findByEmail(String email);
}
