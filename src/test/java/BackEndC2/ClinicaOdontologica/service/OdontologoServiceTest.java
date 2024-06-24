package BackEndC2.ClinicaOdontologica.service;

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

import BackEndC2.ClinicaOdontologica.entity.Odontologo;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OdontologoServiceTest {
    @Autowired
    private OdontologoService odontologoService;

    @Test
    @Order(1)
    public void guardarOdontologoTest(){
        Odontologo odontologo = new Odontologo("123LDO","Rafael","Rodriguez");
        Odontologo odontologoGuardado = odontologoService.guardarOdontologo(odontologo);
        assertEquals(1L,odontologoGuardado.getId());
    }

    @Test
    @Order(2)
    public void buscarOdontologoPorId(){
        Long id = 1L;
        Optional<Odontologo> odontologoBuscado = odontologoService.buscarPorId(id);
        assertNotNull(odontologoBuscado.get());
    }

    @Test
    @Order(3)
    public void actualizarOdontologoTest(){
        Optional<Odontologo> odontologoBuscado = odontologoService.buscarPorId(1L);
        if(odontologoBuscado.isPresent()){
            odontologoBuscado.get().setApellido("Vera");;
        }
        odontologoService.actualizarOdontologo(odontologoBuscado.get());
        assertEquals("Vera", odontologoBuscado.get().getApellido()); 
    }

    @Test
    @Order(4)
    public void buscarTodos(){
        List<Odontologo> odontologos = odontologoService.buscarTodos();
        assertEquals(1, odontologos.size());
    }

    @Test
    @Order(5)
    public void eliminarOdontologo(){
        odontologoService.eliminarOdontologo(1L);
        Optional<Odontologo> odontologoBuscado = odontologoService.buscarPorId(1L);
        assertFalse(odontologoBuscado.isPresent());
    }
}
