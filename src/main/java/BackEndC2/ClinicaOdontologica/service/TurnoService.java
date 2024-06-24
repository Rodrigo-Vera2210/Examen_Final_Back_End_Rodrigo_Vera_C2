package BackEndC2.ClinicaOdontologica.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BackEndC2.ClinicaOdontologica.entity.Turno;
import BackEndC2.ClinicaOdontologica.repository.TurnoRepository;

@Service
public class TurnoService {
    @Autowired
    private TurnoRepository turnoiRepository;

    public Turno guardarTurno(Turno turno){
        return turnoiRepository.save(turno);
    }

    public Optional<Turno> buscarPorID(Long id){
        return turnoiRepository.findById(id);
    }

    public List<Turno> listarTurnos(){
        return turnoiRepository.findAll();
    }

    public void actualizarTurnos(Turno turno){
        turnoiRepository.save(turno);
    }

    public void eliminarTurnos(Long id){
        turnoiRepository.deleteById(id);
    }
}
