
package BackEndC2.ClinicaOdontologica.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import BackEndC2.ClinicaOdontologica.entity.Usuario;
import BackEndC2.ClinicaOdontologica.entity.UsuarioRole;
import BackEndC2.ClinicaOdontologica.repository.UsuarioRepository;

@Component
public class DatosIniciales implements ApplicationRunner{
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String passSinCifrar = "admin";
        String passCifrado = passwordEncoder.encode(passSinCifrar);
        Usuario usuario = new Usuario("donra2210@gmail.com","rodrigo",passCifrado, "rodrigo22", UsuarioRole.ROLE_ADMIN);
        usuarioRepository.save(usuario);
    }

}
