
package tp2;

import java.time.LocalDate;
import java.io.Serializable;
import java.util.UUID;

public class Inscripcion implements Serializable {

    private static final long serialVersionUID = 1L;

    private LocalDate fecha;
    private String estado;

    private Estudiante estudiante;
    private Actividad actividad;

    private TicketDeAcceso ticket;

    // =========================================
    // CONSTRUCTOR
    // =========================================

    public Inscripcion(Estudiante estudiante, Actividad actividad) {
        this.estudiante = estudiante;
        this.actividad = actividad;
        this.fecha = LocalDate.now();
        this.estado = "Activa";
        this.ticket = null;
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

    public TicketDeAcceso getTicket() {
        return ticket;
    }

    // =========================================
    // CONFIRMAR INSCRIPCION
    // =========================================

    public void confirmarInscripcion() {
        estado = "Confirmada";
        generarTicket();
    }

    // =========================================
    // GENERAR TICKET
    // =========================================

    public TicketDeAcceso generarTicket() {

        if (!"Confirmada".equalsIgnoreCase(estado)) {
            System.out.println(
                    "No se puede generar el ticket: la inscripción no está confirmada."
            );
            return null;
        }

        if (ticket == null) {
            ticket = new TicketDeAcceso();
        }

        return ticket;
    }

    // =========================================
    // CLASE ANIDADA MIEMBRO
    // =========================================

    public class TicketDeAcceso implements Serializable {

        private static final long serialVersionUID = 1L;

        private String idTicket;
        private LocalDate fechaEmision;

        public TicketDeAcceso() {
            this.idTicket = UUID.randomUUID().toString();
            this.fechaEmision = LocalDate.now();
        }

        public String getIdTicket() {
            return idTicket;
        }

        public LocalDate getFechaEmision() {
            return fechaEmision;
        }

        public void enviarTicket() {
            System.out.println(
                    "[Hilo: " + Thread.currentThread().getName() + "] "
                            + "Enviando ticket " + idTicket
                            + " al estudiante " + estudiante.getNombre()
                            + " para la actividad " + actividad.getTitulo()
            );
        }

        @Override
        public String toString() {
            return "TicketDeAcceso{" +
                    "idTicket='" + idTicket + '\'' +
                    ", fechaEmision=" + fechaEmision +
                    '}';
        }
    }

    // =========================================
    // MOSTRAR INSCRIPCION
    // =========================================

    @Override
    public String toString() {
        return "Estudiante: " + estudiante.getNombre()
                + " | Fecha: " + fecha
                + " | Estado: " + estado
                + " | Ticket: "
                + (ticket == null ? "Sin ticket" : ticket.getIdTicket());
    }
}
