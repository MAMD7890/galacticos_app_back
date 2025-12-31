package galacticos_app_back.galacticos.repository;

import galacticos_app_back.galacticos.entity.ProfesorEquipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesorEquipoRepository extends JpaRepository<ProfesorEquipo, Integer> {
}
