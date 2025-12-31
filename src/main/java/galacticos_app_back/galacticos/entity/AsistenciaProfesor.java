package galacticos_app_back.galacticos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.math.BigDecimal;

@Entity
@Table(name = "asistencia_profesor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AsistenciaProfesor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAsistenciaProfesor;
    
    @ManyToOne
    @JoinColumn(name = "id_profesor")
    private Profesor profesor;
    
    @ManyToOne
    @JoinColumn(name = "id_equipo")
    private Equipo equipo;
    
    @Column
    private LocalDate fecha;
    
    @Column(precision = 5, scale = 2)
    private BigDecimal horasTrabajadas;
}
