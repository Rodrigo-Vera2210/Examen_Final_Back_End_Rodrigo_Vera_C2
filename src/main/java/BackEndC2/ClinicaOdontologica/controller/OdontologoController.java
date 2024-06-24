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

import BackEndC2.ClinicaOdontologica.entity.Odontologo;
import BackEndC2.ClinicaOdontologica.exception.ResourceNotFoundException;
import BackEndC2.ClinicaOdontologica.service.OdontologoService;

@RestController
@RequestMapping("/odontologo")
public class OdontologoController {
    @Autowired
    private OdontologoService odontologoService;

    @PostMapping
    public ResponseEntity<Odontologo> registrarUnOdontologo(@RequestBody Odontologo odontologo){
        return ResponseEntity.ok(odontologoService.guardarOdontologo(odontologo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Odontologo>> busOdontologoPorId(@PathVariable Long id){
        return ResponseEntity.ok(odontologoService.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<Odontologo>> buscarTodos(){
        List<Odontologo> odontologos = odontologoService.buscarTodos();
        for (Odontologo odontologo : odontologos) {
            System.out.println(odontologo.getApellido());
        }
        return ResponseEntity.ok(odontologos);
    }

    @PutMapping
    public ResponseEntity<String> actualizarOdontologo(@RequestBody Odontologo odontologo){
        if(odontologoService.buscarPorId(odontologo.getId()).isPresent()){
            odontologoService.actualizarOdontologo(odontologo);
            return ResponseEntity.ok().body("Se actualizo con exito");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarOdontologo(@PathVariable Long id) throws ResourceNotFoundException{
        if(odontologoService.buscarPorId(id).isPresent()){
            odontologoService.eliminarOdontologo(id);
            return ResponseEntity.ok().body("Se elimino con exito");
        }
        throw new ResourceNotFoundException("Odontologo con id " + id + "no encontrado");
    }
}
