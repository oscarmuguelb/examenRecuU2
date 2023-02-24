package mx.edu.utez.viajes.controllers.usuario.dtos;

import lombok.*;
import mx.edu.utez.viajes.models.usuario.Usuario;
import mx.edu.utez.viajes.models.viaje.Viaje;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UsuarioDto {
    private Long id;
    private String nombre;
    private String correo;
    private String fechaN;
    private List<Viaje> viajes;
    public Usuario parseTousuario() {
        return new Usuario(
                getId(),
                getNombre(),
                getCorreo(),
                getFechaN(), viajes
        );
    }
}

