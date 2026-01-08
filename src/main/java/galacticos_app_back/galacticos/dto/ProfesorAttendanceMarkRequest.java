package galacticos_app_back.galacticos.dto;

import java.time.LocalDate;

public class ProfesorAttendanceMarkRequest {
    private Integer idProfesor;
    private LocalDate fecha;

    public Integer getIdProfesor() { return idProfesor; }
    public void setIdProfesor(Integer idProfesor) { this.idProfesor = idProfesor; }
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
}
