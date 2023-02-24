package mx.edu.utez.viajes.models.usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.viajes.models.viaje.Viaje;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "usuarios")
@NoArgsConstructor // generación de constructor sin argumentos con Lombok
@AllArgsConstructor // generación de constructor con todos los argumentos con Lombok
@Setter // generación de los setters con Lombok
@Getter // generación de los getters con Lombok
public class Usuario {
    @Id // definición del atributo como llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // definición del tipo de generación de la llave primaria
    private Long id; // atributo id de tipo Long
    private String nombre;
    private String Correo;
    private String fechaN;
    @OneToMany(mappedBy = "usuario")
    private List<Viaje> viajes;

}
