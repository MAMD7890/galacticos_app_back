package galacticos_app_back.galacticos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "recordatorio_pago")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecordatorioPago {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRecordatorio;
    
    @ManyToOne
    @JoinColumn(name = "id_estudiante")
    private Estudiante estudiante;
    
    @Column(columnDefinition = "DATETIME")
    private LocalDateTime fechaEnvio;
    
    @Column(length = 255)
    private String mensaje;
    
    @Enumerated(EnumType.STRING)
    private EstadoRecordatorio estado;
    
    public enum EstadoRecordatorio {
        ENVIADO, PENDIENTE
    }
}
