package mx.edu.utez.viajes.controllers.usuario;

import mx.edu.utez.viajes.controllers.usuario.dtos.UsuarioDto;
import mx.edu.utez.viajes.controllers.viaje.dtos.ViajeDto;
import mx.edu.utez.viajes.services.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api-viajes/usuario")
@CrossOrigin(origins = {"*"})
public class usuarioController {

    @Autowired
    private UsuarioService service;

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
                this.service.getById(id),
                HttpStatus.OK
        );
    }

    // Endpoint que crea un nuevo Pokemon en la base de datos
    @PostMapping("/")
    public ResponseEntity save(
            @RequestBody UsuarioDto usuario
    ) {
        return new ResponseEntity(
                this.service.insert(usuario.parseTousuario()),
                HttpStatus.CREATED
        );
    }

    // Endpoint que actualiza la información de un Pokemon existente
    @PutMapping("/{id}")
    public ResponseEntity update(
            @PathVariable Long id,
            @RequestBody UsuarioDto usuario
    ) {
        usuario.setId(id);
        return new ResponseEntity(
                this.service.update(usuario.parseTousuario()),
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
