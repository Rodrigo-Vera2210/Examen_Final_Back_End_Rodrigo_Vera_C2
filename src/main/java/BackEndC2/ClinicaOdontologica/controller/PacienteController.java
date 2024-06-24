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

import BackEndC2.ClinicaOdontologica.entity.Paciente;
import BackEndC2.ClinicaOdontologica.exception.ResourceNotFoundException;
import BackEndC2.ClinicaOdontologica.service.PacienteService;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    /* 
    @GetMapping
    public String buscarPacientePorCorreo(Model model, @RequestParam("email") String email){
        Paciente paciente = pacienteService.buscarPorEmail(email);
        model.addAttribute("nombre", paciente.getNombre());
        model.addAttribute("apellido", paciente.getApellido());
        return "index";
        //return pacienteService.buscarPorEmail(email).toString();
    }
    */

    @PostMapping
    public ResponseEntity<Paciente> registrarPaciente(@RequestBody Paciente paciente){
        System.out.println(paciente.getDomicilio());
        return  ResponseEntity.ok(pacienteService.guardarPaciente(paciente));
    }

    @PutMapping
    public String actualizarPaciente(@RequestBody Paciente paciente){
        Optional<Paciente> pacienteBuscado = pacienteService.buscarPaciente(paciente.getId());
        if (pacienteBuscado != null) {
            pacienteService.actualizarPaciente(paciente);
            return "paciente actualizado";
        }else{
            return "paciente no encontrado";
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Paciente>> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(pacienteService.buscarPaciente(id));
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> buscarTodos(){
        return ResponseEntity.ok(pacienteService.buscarTodos());
    }

    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) throws ResourceNotFoundException{
        if (pacienteService.buscarPaciente(id).isPresent()) {
            pacienteService.eliminarPaciente(id);
            return ResponseEntity.ok("Paciente eliminado con exito");
        }
        throw new ResourceNotFoundException("No existe el paciente " + id);
    }

}
