package mx.edu.utez.viajes.models.destino;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.viajes.models.viaje.Viaje;

import javax.persistence.*; // importación de JPA
import java.util.List;

// Definición de la entidad Destino
@Entity
@Table(name = "destinos")
@NoArgsConstructor // generación de constructor sin argumentos con Lombok
@AllArgsConstructor // generación de constructor con todos los argumentos con Lombok
@Setter // generación de los setters con Lombok
@Getter // generación de los getters con Lombok
public class Destino {
    @Id // definición del atributo como llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // definición del tipo de generación de la llave primaria
    private Long id; // atributo id de tipo Long
    private int calificacion;
    private String descripcion;
    private Boolean disponibilidad;
    private String nombre;
    private int precio;


    @OneToMany(mappedBy = "destino")
    private List<Viaje> viajes;

    public Destino(Long id, String nombre, String descripcion, int calificacion, boolean disponibilidad, int precio) {
    }
}
