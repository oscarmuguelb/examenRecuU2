package mx.edu.utez.viajes.services.usuario;

import mx.edu.utez.viajes.models.usuario.Usuario;
import mx.edu.utez.viajes.models.usuario.UsuarioRepository;
import mx.edu.utez.viajes.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    public Response getAll() {
        return new Response<>(repository.findAll(), false, 200, "OK");
    }

    public Response getById(long id) {
        return new Response<>(repository.findById(id), false, 200, "OK");
    }

    public Response insert(Usuario usuario) {
        if (repository.existsByNombre(usuario.getNombre()))
            return new Response(null, true, 200, "El usuario ya existe");
        return new Response(repository.save(usuario), false, 200, "Usuario registrado correctamente");
    }

    public Response update(Usuario usuario) {
        if (repository.existsById(usuario.getId()))
            return new Response(repository.save(usuario), false, 200, "Usuario actualizado correctamente");
        return new Response(null, true, 200, "No se encontró el usuario a actualizar");
    }

    public Response delete(long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return new Response(null, false, 200, "Usuario eliminado correctamente");
        }
        return new Response(null, true, 200, "No se encontró el usuario a eliminar");
    }
}
