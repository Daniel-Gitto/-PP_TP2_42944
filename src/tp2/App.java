
package tp2;

import java.util.ArrayList;
import java.util.List;

import excepciones.CupoExcedidoException;
import tp2.certificacion.Certificable;
import tp2.hilos.EnvioTicketsThread;

public class App {

    public static void main(String[] args) {

        // ========================================
        // EJERCICIO 1: CREAR ESTUDIANTES
        // ========================================

        List<Estudiante> estudiantes = new ArrayList<>();

        estudiantes.add(new Estudiante("50111", "Ana Gomez"));
        estudiantes.add(new Estudiante("50222", "Lionel Messis"));
        estudiantes.add(new Estudiante("50333", "Coto Romero"));
        estudiantes.add(new Estudiante("50444", "Martha Sanchez"));

        // ========================================
        // CREAR EVENTOS
        // ========================================

        EventoUniversitario evento1 =
                new EventoUniversitario(
                        "E01",
                        "Jornada de Software",
                        10000,
                        false
                );

        EventoUniversitario evento2 =
                new EventoUniversitario(
                        "E02",
                        "Jornada de Hackathon",
                        8000,
                        true
                );

        // ========================================
        // ASIGNAR SALAS
        // ========================================

        Sala sala1 = new Sala(1, "Laboratorio Multimedial");
        Sala sala2 = new Sala(2, "Laboratorio IA");

        evento1.asignarSala(sala1);
        evento2.asignarSala(sala2);

        // ========================================
        // CREAR ACTIVIDADES
        // ========================================

        evento1.crearActividad(
                1, "Taller de Spring Boot", 1, "Taller"
        );

        evento1.crearActividad(
                2, "Charla de Arquitectura Limpia", 20, "Charla"
        );

        evento1.crearActividad(
                5, "Curso de Java", 25, "Curso"
        );

        evento2.crearActividad(
                3, "Competencia de Programación con IA", 1, "Taller"
        );

        evento2.crearActividad(
                4, "Charla sobre prompt de IA", 20, "Charla"
        );

        evento2.crearActividad(
                6, "Curso de Inteligencia Artificial", 20, "Curso"
        );

        // ========================================
        // OBTENER ACTIVIDADES
        // ========================================

        Actividad actividad1 = evento1.getActividades().get(0);
        Actividad actividad2 = evento1.getActividades().get(1);

        Actividad actividad3 = evento2.getActividades().get(0);
        Actividad actividad4 = evento2.getActividades().get(1);

        // ========================================
        // EJERCICIO 4: INSCRIPCIONES
        // ========================================

        System.out.println("\n===== INSCRIPCIONES =====");

        Inscripcion inscripcion1 = null;
        Inscripcion inscripcion2 = null;
        Inscripcion inscripcion3 = null;
        Inscripcion inscripcion4 = null;

        Inscripcion inscripcion5 = null;
        Inscripcion inscripcion6 = null;
        Inscripcion inscripcion7 = null;
        Inscripcion inscripcion8 = null;

        try {
            inscripcion1 = actividad1.inscribir(estudiantes.get(0));
            inscripcion2 = actividad1.inscribir(estudiantes.get(1));
        } catch (CupoExcedidoException e) {
            System.out.println("Evento 1: " + e.getMessage());
        }

        try {
            inscripcion3 = actividad2.inscribir(estudiantes.get(1));
            inscripcion4 = actividad2.inscribir(estudiantes.get(2));
        } catch (CupoExcedidoException e) {
            System.out.println("Evento 1: " + e.getMessage());
        }

        try {
            inscripcion5 = actividad3.inscribir(estudiantes.get(0));
            inscripcion6 = actividad3.inscribir(estudiantes.get(2));
        } catch (CupoExcedidoException e) {
            System.out.println("Evento 2: " + e.getMessage());
        }

        try {
            inscripcion7 = actividad4.inscribir(estudiantes.get(0));
            inscripcion8 = actividad4.inscribir(estudiantes.get(1));
        } catch (CupoExcedidoException e) {
            System.out.println("Evento 2: " + e.getMessage());
        }

        // ========================================
        // CONFIRMAR ALGUNAS INSCRIPCIONES
        // La confirmación genera el ticket.
        // ========================================

        if (inscripcion1 != null) {
            inscripcion1.confirmarInscripcion();
        }

        if (inscripcion3 != null) {
            inscripcion3.confirmarInscripcion();
        }

        if (inscripcion5 != null) {
            inscripcion5.confirmarInscripcion();
        }

        if (inscripcion7 != null) {
            inscripcion7.confirmarInscripcion();
        }

        // ========================================
        // EJERCICIO 3: FILTRAR ACTIVIDADES
        // ========================================

        System.out.println("\n===== EJERCICIO 3: EVENTO 1 =====");

        List<Charla> charlasEvento1 =
                evento1.filtrarActividadesPorTipo(Charla.class);

        List<Taller> talleresEvento1 =
                evento1.filtrarActividadesPorTipo(Taller.class);

        List<Curso> cursosEvento1 =
                evento1.filtrarActividadesPorTipo(Curso.class);

        System.out.println("Cantidad de charlas: " + charlasEvento1.size());
        System.out.println("Cantidad de talleres: " + talleresEvento1.size());
        System.out.println("Cantidad de cursos: " + cursosEvento1.size());

        System.out.println("Costo de materiales por tipo:");
        System.out.println("Charlas: $"
                + evento1.calcularCostoMateriales(charlasEvento1));
        System.out.println("Talleres: $"
                + evento1.calcularCostoMateriales(talleresEvento1));
        System.out.println("Cursos: $"
                + evento1.calcularCostoMateriales(cursosEvento1));

        System.out.println("\n===== EJERCICIO 3: EVENTO 2 =====");

        List<Charla> charlasEvento2 =
                evento2.filtrarActividadesPorTipo(Charla.class);

        List<Taller> talleresEvento2 =
                evento2.filtrarActividadesPorTipo(Taller.class);

        List<Curso> cursosEvento2 =
                evento2.filtrarActividadesPorTipo(Curso.class);

        System.out.println("Cantidad de charlas: " + charlasEvento2.size());
        System.out.println("Cantidad de talleres: " + talleresEvento2.size());
        System.out.println("Cantidad de cursos: " + cursosEvento2.size());

        System.out.println("Costo de materiales por tipo:");
        System.out.println("Charlas: $"
                + evento2.calcularCostoMateriales(charlasEvento2));
        System.out.println("Talleres: $"
                + evento2.calcularCostoMateriales(talleresEvento2));
        System.out.println("Cursos: $"
                + evento2.calcularCostoMateriales(cursosEvento2));

        // ========================================
        // EJERCICIO 4: HILOS DE ENVÍO DE TICKETS
        // ========================================

        System.out.println("\n===== EJERCICIO 4: ENVIO DE TICKETS =====");

        EnvioTicketsThread hiloEvento1 =
                new EnvioTicketsThread(evento1);

        EnvioTicketsThread hiloEvento2 =
                new EnvioTicketsThread(evento2);

        // start() inicia cada hilo de forma concurrente.
        hiloEvento1.start();
        hiloEvento2.start();

        // El hilo principal continúa mientras se envían los tickets.
        System.out.println(
                "\n[Hilo: " + Thread.currentThread().getName()
                        + "] Mostrando datos de los eventos."
        );

        System.out.println("\n===== EVENTO 1 =====");
        evento1.mostrarDatos();

        System.out.println("\n===== EVENTO 2 =====");
        evento2.mostrarDatos();

        System.out.println(
                "[Hilo: " + Thread.currentThread().getName()
                        + "] Terminó de mostrar los datos."
        );

        // Esperamos a que ambos envíos finalicen antes de continuar.
        try {
            hiloEvento1.join();
            hiloEvento2.join();

            System.out.println(
                    "[Hilo: " + Thread.currentThread().getName()
                            + "] Los dos envíos finalizaron."
            );

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Se interrumpió la espera de los hilos.");
        }

        // ========================================
        // COPIAR EVENTOS
        // ========================================

        EventoUniversitario copiaEvento1 =
                new EventoUniversitario(evento1);

        EventoUniversitario copiaEvento2 =
                new EventoUniversitario(evento2);

        System.out.println("\n===== COPIA EVENTO 1 =====");
        copiaEvento1.mostrarDatos();

        System.out.println("\n===== COPIA EVENTO 2 =====");
        copiaEvento2.mostrarDatos();

        System.out.println(
                "\nCantidad total de eventos creados: "
                        + EventoUniversitario.getCantidadEventos()
        );

        // ========================================
        // TP2: PRUEBA DE EXCEPCIONES Y PERSISTENCIA
        // ========================================

        System.out.println("\n===== EJERCICIO 1 - TP2 =====");

        evento1.crearActividad(
                7,
                "Actividad de prueba de excepciones",
                1,
                "Charla"
        );

        Actividad actividadPrueba =
                evento1.getActividades().get(
                        evento1.getActividades().size() - 1
                );

        try {
            Inscripcion inscripcionPrueba =
                    actividadPrueba.inscribir(estudiantes.get(0));

            System.out.println(
                    "Inscripción exitosa: " + inscripcionPrueba
            );

        } catch (CupoExcedidoException e) {
            System.out.println(
                    "No se pudo inscribir al primer estudiante: "
                            + e.getMessage()
            );
        }

        try {
            actividadPrueba.inscribir(estudiantes.get(1));
            System.out.println("Segunda inscripción exitosa.");

        } catch (CupoExcedidoException e) {
            System.out.println(
                    "Inscripción rechazada por cupo completo: "
                            + e.getMessage()
            );
        }

        try {
            boolean guardado = evento1.persistirEvento();

            if (guardado) {
                EventoUniversitario recuperado =
                        EventoUniversitario.recuperarEvento("evento.dat");

                if (recuperado != null) {
                    System.out.println(
                            "\nEvento recuperado desde el archivo:"
                    );
                    recuperado.mostrarDatos();
                }
            }

        } catch (RuntimeException e) {
            System.out.println(
                    "Error durante la persistencia: " + e.getMessage()
            );

        } finally {
            System.out.println(
                    "Finalizó el proceso de inscripción y persistencia."
            );
        }
    }

    // ========================================
    // MÉTODO DEL EJERCICIO DE CERTIFICACIÓN
    // ========================================

    private static void emitirCertificados(EventoUniversitario evento) {

        System.out.println("\nCertificados del evento: " + evento);

        for (Actividad actividad : evento.getActividades()) {

            if (actividad instanceof Certificable certificable) {

                for (Inscripcion inscripcion : actividad.getInscripciones()) {
                    System.out.println(
                            certificable.generarCertificado(
                                    inscripcion.getEstudiante()
                            )
                    );
                }

            } else {
                System.out.println(
                        "La actividad \"" + actividad.getTitulo()
                                + "\" (" + actividad.getTipo()
                                + ") no emite certificados."
                );
            }
        }
    }
}
