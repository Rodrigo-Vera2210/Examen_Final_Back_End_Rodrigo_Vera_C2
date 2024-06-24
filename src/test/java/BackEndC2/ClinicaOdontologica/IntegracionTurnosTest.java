package BackEndC2.ClinicaOdontologica;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import BackEndC2.ClinicaOdontologica.entity.Domicilio;
import BackEndC2.ClinicaOdontologica.entity.Odontologo;
import BackEndC2.ClinicaOdontologica.entity.Paciente;
import BackEndC2.ClinicaOdontologica.entity.Turno;
import BackEndC2.ClinicaOdontologica.service.OdontologoService;
import BackEndC2.ClinicaOdontologica.service.PacienteService;
import BackEndC2.ClinicaOdontologica.service.TurnoService;

@SpringBootTest
@AutoConfigureMockMvc(addFilters=false)
public class IntegracionTurnosTest {
    @Autowired
    private TurnoService turnoService;
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private OdontologoService odontologoService;
    @Autowired
    private MockMvc mockMvc;

    public void cargarDatos(){
        Paciente pacienteGuardado = pacienteService.guardarPaciente(new Paciente("Renyi","Vera","0803351412",LocalDate.of(2024,5,10),new Domicilio("Sicilia",123,"Quito","Ecuador"),"renyi@gmail.com"));
        Odontologo odontologoGuardado = odontologoService.guardarOdontologo(new Odontologo("ABC123","Rodrigo","Vera"));
        Turno turnoGuardado = turnoService.guardarTurno(new Turno(pacienteGuardado, odontologoGuardado, LocalDate.now()));
    }

    @Test
    public void listarTodosLosTurnos() throws  Exception{
        cargarDatos();
        MvcResult respuesta = mockMvc.perform(MockMvcRequestBuilders.get("/turno").accept(MediaType.APPLICATION_JSON)).andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        assertFalse(respuesta.getResponse().getContentAsString().isEmpty());
    }
}
