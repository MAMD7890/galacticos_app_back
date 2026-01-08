package galacticos_app_back.galacticos.repository;

import galacticos_app_back.galacticos.entity.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Integer> {
    List<Pago> findByEstudianteIdEstudiante(Integer idEstudiante);
    List<Pago> findByEstadoPago(Pago.EstadoPago estado);
    List<Pago> findByFechaPagoBetween(java.time.LocalDate desde, java.time.LocalDate hasta);
}
