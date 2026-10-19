package tp1;

import java.util.ArrayList;
import java.util.List;

public class EventoUniversitario {

    private final String id;
    private String titulo;
    private double costoBase;
    private boolean gratuito;
    private static int cantidadEventos = 0;

    private Sala sala;
    private List<Actividad> actividades;


    // =========================================
    // CONSTRUCTOR
    // =========================================

    public EventoUniversitario(String id,
                               String titulo,
                               double costoBase,
                               boolean gratuito) {

        this.id = id;
        this.titulo = titulo;
        this.costoBase = costoBase;
        this.gratuito = gratuito;

        this.actividades = new ArrayList<>();

        cantidadEventos++;
    }


    // =========================================
    // CONSTRUCTOR DE COPIA
    // =========================================

    public EventoUniversitario(EventoUniversitario otro) {

        this.id = "copy "+otro.id;
        this.titulo = otro.titulo;
        this.costoBase = otro.costoBase;
        this.gratuito = otro.gratuito;

        this.sala = otro.sala;

        this.actividades = new ArrayList<>(otro.actividades);

        cantidadEventos++;
    }


    // =========================================
    // CALCULAR COSTO ESTIMADO
    // =========================================
    // E3:
    // Si el evento es gratuito, el costo es 0.
    //
    // Si no es gratuito:
    //
    // (costoBase + costo de cada actividad) * 1.21

    public double calcularCostoEstimado() {

        if (gratuito) {
            return 0;
        }

        double costoTotal = costoBase;

        for (Actividad act : actividades) {

            costoTotal +=
                    act.calcularCostoMateriales();
        }

        return costoTotal * 1.21;
    }


    // =========================================
    // ASIGNAR SALA
    // =========================================

    public void asignarSala(Sala sala) {

        this.sala = sala;
    }


    // =========================================
    // CREAR ACTIVIDAD
    // =========================================
    // E3:
    // Ahora recibe también el tipo de actividad:
    //
    // "Charla"
    // "Taller"
    //
    // La colección sigue siendo:
    //
    // List<Actividad>
    //
    // pero puede almacenar objetos Charla
    // y Taller.

    public void crearActividad(int id,
                               String titulo,
                               int cupo,
                               String tipo) {

        Actividad nuevaActividad;

        if (tipo.equalsIgnoreCase("Charla")) {

            nuevaActividad =
                    new Charla(
                            id,
                            titulo,
                            cupo,
                            "Disertante"
                    );

        } else {

            nuevaActividad =
                    new Taller(
                            id,
                            titulo,
                            cupo,
                            true
                    );
        }

        actividades.add(nuevaActividad);
    }


    // =========================================
    // MOSTRAR DATOS
    // =========================================

    public void mostrarDatos() {

        System.out.println("======================================");
        System.out.println("ID: " + id);
        System.out.println("Titulo: " + titulo);
        System.out.println("Costo base: $" + costoBase);
        System.out.println("Gratuito: " + gratuito);

        System.out.println(
                "Costo estimado: $"
                        + calcularCostoEstimado()
        );


        // =========================================
        // SALA
        // =========================================

        if (sala != null) {

            System.out.println(
                    "Sala: "
                            + sala.getId()
                            + " - "
                            + sala.getNombre()
            );
        }


        // =========================================
        // ACTIVIDADES
        // =========================================

        System.out.println(
                "--- Actividades del evento ---"
        );

        if (actividades.isEmpty()) {

            System.out.println(
                    "  No hay actividades registradas."
            );

        } else {

            for (Actividad act : actividades) {

                // E3:
                // mostrarIdentificacion() es final
                // y se ejecuta desde Actividad.
                //
                // getTipo() funciona de forma
                // polimórfica según sea Charla
                // o Taller.

                act.mostrarIdentificacion();

                System.out.println(
                        "Costo materiales: $"
                                + act.calcularCostoMateriales()
                );

                act.mostrarInscripciones();

                System.out.println();
            }
        }

        System.out.println(
                "======================================"
        );
    }


    // =========================================
    // GET CANTIDAD DE EVENTOS
    // =========================================

    public static int getCantidadEventos() {

        return cantidadEventos;
    }


    // =========================================
    // GET ACTIVIDADES
    // =========================================

    public List<Actividad> getActividades() {

        return actividades;
    }
}