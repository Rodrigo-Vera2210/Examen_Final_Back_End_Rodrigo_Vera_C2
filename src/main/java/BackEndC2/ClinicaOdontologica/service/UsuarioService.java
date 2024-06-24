/* */
package BackEndC2.ClinicaOdontologica.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import BackEndC2.ClinicaOdontologica.entity.Usuario;
import BackEndC2.ClinicaOdontologica.repository.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService{
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException{
        Optional<Usuario> usuarioBuscado = usuarioRepository.findByEmail(userName);
        if (usuarioBuscado.isPresent()) {
            return usuarioBuscado.get();
        } else {
            throw new UsernameNotFoundException("No existe el usuario " + userName);
        }
    }
}
