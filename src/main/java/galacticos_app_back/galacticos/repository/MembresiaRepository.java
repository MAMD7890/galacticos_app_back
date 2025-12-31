package galacticos_app_back.galacticos.repository;

import galacticos_app_back.galacticos.entity.Membresia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MembresiaRepository extends JpaRepository<Membresia, Integer> {
    List<Membresia> findByEstudianteIdEstudiante(Integer idEstudiante);
    List<Membresia> findByEquipoIdEquipo(Integer idEquipo);
    List<Membresia> findByEstado(Membresia.EstadoMembresia estado);
}
