package BackEndC2.ClinicaOdontologica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import BackEndC2.ClinicaOdontologica.entity.Turno;

public interface TurnoRepository extends JpaRepository<Turno, Long>{
    
}
