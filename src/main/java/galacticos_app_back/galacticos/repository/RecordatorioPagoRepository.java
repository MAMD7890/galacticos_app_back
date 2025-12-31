package galacticos_app_back.galacticos.repository;

import galacticos_app_back.galacticos.entity.RecordatorioPago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordatorioPagoRepository extends JpaRepository<RecordatorioPago, Integer> {
}
