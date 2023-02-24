package mx.edu.utez.viajes.controllers.viaje.dtos;

import mx.edu.utez.viajes.models.viaje.Viaje;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class ViajeDto {
    private Long id;
    private String origen;
    private String destino;
    private Date fechaSalida;
    private Date fechaRegreso;
    private Integer asientosDisponibles;
    private Double precio;

    public Viaje parseToViaje() {
        return new Viaje(
                getId(),
                getOrigen(),
                getDestino(),
                getFechaSalida(),
                getFechaRegreso(),
                getAsientosDisponibles(),
                getPrecio()
        );
    }
}
