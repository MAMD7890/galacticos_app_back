package galacticos_app_back.galacticos.repository;

import galacticos_app_back.galacticos.entity.AsistenciaEstudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsistenciaEstudianteRepository extends JpaRepository<AsistenciaEstudiante, Integer> {
}
