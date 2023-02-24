package mx.edu.utez.viajes.models.destino;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinoRepository extends JpaRepository<Destino, Long> {
    boolean existsByNombre(String nombre);
}

