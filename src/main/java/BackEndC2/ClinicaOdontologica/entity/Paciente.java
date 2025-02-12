package BackEndC2.ClinicaOdontologica.entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="pacientes")
public class Paciente {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private String email;
    @Column(unique = true, nullable = false)
    private String cedula;
    @Column
    private LocalDate fechaIngreso;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "domicilio_id", referencedColumnName = "id")
    private Domicilio domicilio;

    public Paciente(String nombre, String apellido, String cedula, LocalDate fechaIngreso, Domicilio domicilio, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.fechaIngreso = fechaIngreso;
        this.domicilio = domicilio;
        this.email= email;
    }

    public Paciente() {
    }

    public Paciente(Long id, String nombre, String apellido, String cedula, LocalDate fechaIngreso, Domicilio domicilio, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.fechaIngreso = fechaIngreso;
        this.domicilio = domicilio;
        this.email= email;
    }
    
    public Long getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public String getCedula() {
        return cedula;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }
    public Domicilio getDomicilio() {
        return domicilio;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Paciente [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", cedula="
                + cedula + ", fechaIngreso=" + fechaIngreso + ", domicilio=" + domicilio + "]";
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    
}
