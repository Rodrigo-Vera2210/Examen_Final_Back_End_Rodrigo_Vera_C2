package BackEndC2.ClinicaOdontologica.entity;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nombre;
    @Column 
    private String userName;
    @Column
    private String email;
    @Column 
    private String password;
    @Enumerated(EnumType.STRING)
    private UsuarioRole usuarioRole;

    public Usuario() {
    }

    public Usuario(String email, String nombre, String password, String userName, UsuarioRole usuarioRole) {
        this.email = email;
        this.nombre = nombre;
        this.password = password;
        this.userName = userName;
        this.usuarioRole = usuarioRole;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    

    public void setPassword(String password) {
        this.password = password;
    }

    public UsuarioRole getUsuarioRole() {
        return usuarioRole;
    }

    public void setUsuarioRole(UsuarioRole usuarioRole) {
        this.usuarioRole = usuarioRole;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //este metodo permite saber cuales son las autirizaciones que tiene el usuario en cuestion
        SimpleGrantedAuthority simpleGrantedAuthority= new SimpleGrantedAuthority(usuarioRole.name());

        return Collections.singletonList(simpleGrantedAuthority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
