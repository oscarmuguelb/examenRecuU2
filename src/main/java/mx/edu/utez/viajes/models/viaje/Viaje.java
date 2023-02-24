package mx.edu.utez.viajes.models.viaje;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.viajes.models.destino.Destino;
import mx.edu.utez.viajes.models.usuario.Usuario;

import javax.persistence.*; // importación de JPA
import java.util.Date;

// Definición de la entidad Viaje
@Entity
@Table(name = "viajes")
@NoArgsConstructor // generación de constructor sin argumentos con Lombok
@AllArgsConstructor // generación de constructor con todos los argumentos con Lombok
@Setter // generación de los setters con Lombok
@Getter // generación de los getters con Lombok
public class Viaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date fechaSalida;
    private Date fechaRegreso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    @JsonIgnore
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_destino", referencedColumnName = "id")
    @JsonIgnore
    private Destino destino;

    public Viaje(Long id, String origen, String destino, Date fechaSalida, Date fechaRegreso, Integer asientosDisponibles, Double precio) {
    }
}
