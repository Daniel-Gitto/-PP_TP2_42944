package tp1;

import java.time.LocalDate;

public class Inscripcion {

    private LocalDate fecha;
    private String estado;

    private Estudiante estudiante;
    private Actividad actividad;


    // =========================================
    // CONSTRUCTOR
    // =========================================

    public Inscripcion(Estudiante estudiante,
                       Actividad actividad) {

        this.estudiante = estudiante;
        this.actividad = actividad;

        this.fecha = LocalDate.now();
        this.estado = "Activa";
    }


    // =========================================
    // GETTERS
    // =========================================

    public LocalDate getFecha() {
        return fecha;
    }

    public String getEstado() {
        return estado;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public Actividad getActividad() {
        return actividad;
    }


    // =========================================
    // MOSTRAR INSCRIPCION
    // =========================================

    @Override
    public String toString() {

        return "Estudiante: "
                + estudiante.getNombre()
                + " | Fecha: "
                + fecha
                + " | Estado: "
                + estado;
    }
}