package mx.edu.utez.viajes.controllers.viaje;

import mx.edu.utez.viajes.controllers.viaje.dtos.ViajeDto;
import mx.edu.utez.viajes.services.viaje.ViajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api-viajes/viaje")
@CrossOrigin(origins = {"*"})
public class viajeController {
    @Autowired
    private ViajeService service;

    // Endpoint que devuelve una lista de todos los Pokemons
    @GetMapping("/")
    public ResponseEntity getAll() {
        return new ResponseEntity(
                this.service.getAll(),
                HttpStatus.OK
        );
    }

    // Endpoint que devuelve un Pokemon según el id proporcionado
    @GetMapping("/{id}")
    public ResponseEntity getOne(
            @PathVariable("id") Long id
    ) {
        return new ResponseEntity(
                this.service.getOne(id),
                HttpStatus.OK
        );
    }

    // Endpoint que crea un nuevo Pokemon en la base de datos
    @PostMapping("/")
    public ResponseEntity createViaje(
            @RequestBody ViajeDto viaje
    ) {
        return new ResponseEntity(
                this.service.createViaje(viaje.parseToViaje()),
                HttpStatus.CREATED
        );
    }

    // Endpoint que actualiza la información de un Pokemon existente
    @PutMapping("/{id}")
    public ResponseEntity update(
            @PathVariable Long id,
            @RequestBody ViajeDto viaje
    ) {
        viaje.setId(id);
        return new ResponseEntity(
                this.service.update(viaje.parseToViaje()),
                HttpStatus.OK
        );
    }

    // Endpoint que elimina un Pokemon según el id proporcionado
    @DeleteMapping("/{id}")
    public ResponseEntity delete(
            @PathVariable("id") Long id
    ) {
        return new ResponseEntity(
                this.service.delete(id),
                HttpStatus.OK
        );
    }
}
