package BackEndC2.ClinicaOdontologica.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import BackEndC2.ClinicaOdontologica.entity.Domicilio;
import BackEndC2.ClinicaOdontologica.entity.Paciente;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PacienteServiceTest {
    @Autowired
    private PacienteService pacienteService;

    @Test
    @Order(1)
    public void guardarPacienteTest(){
        Paciente paciente = new Paciente("Rodrigo","Vera","0812316549",LocalDate.of(2024, 06, 22),new Domicilio("Sicilia",123,"Quito","Pichincha"),"donra2210@hotmail.com");
        Paciente pacienteGuardado = pacienteService.guardarPaciente(paciente);
        assertEquals(1L,pacienteGuardado.getId());
    }

    @Test
    @Order(2)
    public void buscarPacientePorId(){
        Long id = 1L;
        Optional<Paciente> pacienteBuscado = pacienteService.buscarPaciente(id);
        assertNotNull(pacienteBuscado.get());
    }

    @Test
    @Order(3)
    public void actualizarPacienteTest(){
        Optional<Paciente> pacienteBuscado = pacienteService.buscarPaciente(1L);
        if(pacienteBuscado.isPresent()){
            pacienteBuscado.get().setApellido("Rodriguez");
        }
        pacienteService.actualizarPaciente(pacienteBuscado.get());
        assertEquals("Rodriguez", pacienteBuscado.get().getApellido()); 
    }

    @Test
    @Order(4)
    public void buscarTodos(){
        List<Paciente> pacientes = pacienteService.buscarTodos();
        assertEquals(1, pacientes.size());
    }

    @Test
    @Order(5)
    public void eliminarPaciente(){
        pacienteService.eliminarPaciente(1L);
        Optional<Paciente> pacienteBuscado = pacienteService.buscarPaciente(1L);
        assertFalse(pacienteBuscado.isPresent());
    }
}
