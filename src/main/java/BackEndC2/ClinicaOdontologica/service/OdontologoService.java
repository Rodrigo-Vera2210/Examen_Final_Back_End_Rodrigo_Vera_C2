package BackEndC2.ClinicaOdontologica.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BackEndC2.ClinicaOdontologica.entity.Odontologo;
import BackEndC2.ClinicaOdontologica.repository.OdontologoRepository;

@Service
public class OdontologoService {
    @Autowired
    private OdontologoRepository odontologoRepository;

    public Odontologo guardarOdontologo(Odontologo odontologo){
        return odontologoRepository.save(odontologo);
    }

    public Optional<Odontologo> buscarPorId(Long id){
        return odontologoRepository.findById(id);
    }

    public List<Odontologo> buscarTodos(){
        return odontologoRepository.findAll();
    }

    public void actualizarOdontologo(Odontologo odontologo){
        Optional<Odontologo> odontologoBuscado = odontologoRepository.findById(odontologo.getId());
        if(odontologoBuscado.isPresent()){
            odontologoRepository.save(odontologo);
        }else{
            System.out.println("Odontologo no encontrado");
        }
    }

    public void eliminarOdontologo(Long id){
        Optional<Odontologo> odontologoBuscado = odontologoRepository.findById(id);
        if(odontologoBuscado.isPresent()){
            odontologoRepository.deleteById(id);
        }else{
            System.out.println("Odontologo no encontrado");
        }
    }
}
