
package tp2.hilos;

import tp2.Actividad;
import tp2.EventoUniversitario;
import tp2.Inscripcion;

public class EnvioTicketsThread extends Thread {

    private final EventoUniversitario evento;

    public EnvioTicketsThread(EventoUniversitario evento) {
        this.evento = evento;
    }

    @Override
    public void run() {
        System.out.println(
                "[Hilo: " + Thread.currentThread().getName()
                        + "] Iniciando envío de tickets del evento: "
                        + evento.getTitulo()
        );

        for (Actividad actividad : evento.getActividades()) {
            for (Inscripcion inscripcion : actividad.getInscripciones()) {

                if ("Confirmada".equalsIgnoreCase(inscripcion.getEstado())) {
                    Inscripcion.TicketDeAcceso ticket =
                            inscripcion.getTicket();

                    if (ticket != null) {
                        ticket.enviarTicket();
                    }
                }
            }
        }

        System.out.println(
                "[Hilo: " + Thread.currentThread().getName()
                        + "] Finalizó el envío de tickets del evento: "
                        + evento.getTitulo()
        );
    }
}
