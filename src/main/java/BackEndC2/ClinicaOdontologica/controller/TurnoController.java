package BackEndC2.ClinicaOdontologica.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import BackEndC2.ClinicaOdontologica.entity.Turno;
import BackEndC2.ClinicaOdontologica.exception.ResourceNotFoundException;
import BackEndC2.ClinicaOdontologica.service.OdontologoService;
import BackEndC2.ClinicaOdontologica.service.PacienteService;
import BackEndC2.ClinicaOdontologica.service.TurnoService;

@RestController
@RequestMapping("/turno")
public class TurnoController {
    @Autowired
    private TurnoService turnoService;
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private OdontologoService odontologoService;

    @PostMapping
    public ResponseEntity<Turno> guardarTurno(@RequestBody Turno turno){
        if(pacienteService.buscarPaciente(turno.getPaciente().getId()) != null && odontologoService.buscarPorId(turno.getOdontologo().getId()) != null){
            return ResponseEntity.ok(turnoService.guardarTurno(turno));
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Turno>> listarTodosLosTurnos(){
        return ResponseEntity.ok(turnoService.listarTurnos());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarTurno(@PathVariable Long id) throws ResourceNotFoundException{
        if(turnoService.buscarPorID(id) != null){
            turnoService.eliminarTurnos(id);
            return ResponseEntity.ok("El turno se ha eliminado con exito");
        }else{
            throw new ResourceNotFoundException("Turno con id " + id + "no encontrado");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Turno>> buscarTurno(@PathVariable Long id){
        return ResponseEntity.ok(turnoService.buscarPorID(id));
    }

    @PutMapping
    public ResponseEntity<Turno> editarTurno(@RequestBody Turno turno){
        if(turnoService.buscarPorID(turno.getId()) != null){
            turnoService.actualizarTurnos(turno);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
