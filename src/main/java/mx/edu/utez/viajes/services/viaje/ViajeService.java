package mx.edu.utez.viajes.services.viaje;

import mx.edu.utez.viajes.models.viaje.Viaje;
import mx.edu.utez.viajes.models.viaje.ViajeRepository;
import mx.edu.utez.viajes.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ViajeService {

    @Autowired
    private ViajeRepository repository;

    public Response<List<Viaje>> getAll() {
        return new Response<List<Viaje>>(
                this.repository.findAll(),
                false,
                200,
                "OK"
        );
    }

    public Response<Viaje> getOne(Long id) {
        Viaje viaje = this.repository.findById(id).orElse(null);
        if (viaje == null) {
            return new Response<>(null, true, 404, "No se encontró el viaje con el ID proporcionado");
        } else {
            return new Response<>(viaje, false, 200, "OK");
        }
    }

    public Response<Viaje> createViaje(Viaje viaje) {
        Viaje viajeGuardado = this.repository.save(viaje);
        return new Response<>(viajeGuardado, false, 200, "Se ha creado el viaje correctamente");
    }

    public Response<Viaje> update(Viaje viaje) {
        if (this.repository.existsById(viaje.getId())) {
            Viaje viajeActualizado = this.repository.save(viaje);
            return new Response<>(viajeActualizado, false, 200, "Se ha actualizado el viaje correctamente");
        } else {
            return new Response<>(null, true, 404, "No se encontró el viaje con el ID proporcionado");
        }
    }

    public Response<Viaje> delete(Long id) {
        if (this.repository.existsById(id)) {
            this.repository.deleteById(id);
            return new Response<>(null, false, 200, "Se ha eliminado el viaje correctamente");
        } else {
            return new Response<>(null, true, 404, "No se encontró el viaje con el ID proporcionado");
        }
    }
}
