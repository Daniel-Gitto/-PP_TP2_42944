package tp2;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.InvalidClassException;
import java.io.StreamCorruptedException;
import java.io.OptionalDataException;
import java.io.EOFException;

public class EventoUniversitario implements Serializable {

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
    //TP1
    // "Charla"
    // "Taller"
    // TP2 Ej2 creamos Curso
    //
    // La colección sigue siendo:
    //
    // List<Actividad>
    //
    // pero puede almacenar objetos Charla
    // y Taller.
    // CREAMOS ACTIVIDAD

    public void crearActividad(
            int id,
            String titulo,
            int cupo,
            String tipo
    ) {
        Actividad nuevaActividad;

        if (tipo.equalsIgnoreCase("Charla")) {
            nuevaActividad = new Charla(
                    id, titulo, cupo, "Disertante"
            );

        } else if (tipo.equalsIgnoreCase("Taller")) {
            nuevaActividad = new Taller(
                    id, titulo, cupo, true
            );

        } else if (tipo.equalsIgnoreCase("Curso")) {
            nuevaActividad = new Curso(
                    id, titulo, cupo, 1
            );

        } else {
            throw new IllegalArgumentException(
                    "Tipo de actividad inválido: " + tipo
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
    public String getTitulo() {
        return titulo;
    }

    // =========================================
    // Vamos a crear los metodos para que maneje todas las excepciones que se puedan producir
    // =========================================

    //persistirEvento() escribe el objeto actual (this) en el archivo evento.dat
    public boolean persistirEvento() {
        try (ObjectOutputStream salida = new ObjectOutputStream(
                new FileOutputStream("evento.dat"))) {

            salida.writeObject(this);
            System.out.println("Evento guardado correctamente en evento.dat.");
            return true;

        } catch (FileNotFoundException e) {
            System.out.println("Error: no se pudo crear o abrir el archivo para guardar.");
        } catch (InvalidClassException e) {
            System.out.println("Error: incompatibilidad entre versiones de clases.");
        } catch (IOException e) {
            System.out.println("Error de entrada/salida al guardar el evento: "
                    + e.getMessage());
        }

        return false;
    }
    //recuperarEvento(String ruta) lee el archivo y devuelve el evento recuperado, o null si se produce un error.
    public static EventoUniversitario recuperarEvento(String ruta) {
        try (ObjectInputStream entrada = new ObjectInputStream(
                new FileInputStream(ruta))) {

            Object objeto = entrada.readObject();

            if (objeto instanceof EventoUniversitario evento) {
                System.out.println("Evento recuperado correctamente.");
                return evento;
            }

            System.out.println("Error: el archivo no contiene un EventoUniversitario.");
            return null;

        } catch (FileNotFoundException e) {
            System.out.println("Error: no se encontró el archivo " + ruta);
        } catch (InvalidClassException e) {
            System.out.println("Error: la versión de la clase no coincide con el archivo.");
        } catch (StreamCorruptedException e) {
            System.out.println("Error: el archivo está dañado o no tiene un formato válido.");
        } catch (EOFException e) {
            System.out.println("Error: el archivo está vacío o no contiene más datos.");
        } catch (OptionalDataException e) {
            System.out.println("Error: se encontraron datos inesperados en el archivo.");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: no se encontró una clase necesaria para recuperar el evento.");
        } catch (IOException e) {
            System.out.println("Error de entrada/salida al recuperar el evento: "
                    + e.getMessage());
        }

        return null;
    }

    // Metodo para filtrar las actividades por tipo usando Wildcard

    public <T extends Actividad> List<T> filtrarActividadesPorTipo(
            Class<T> tipo) {

        List<T> resultado = new ArrayList<>();

        for (Actividad actividad : actividades) {
            if (tipo.isInstance(actividad)) {
                resultado.add(tipo.cast(actividad));
            }
        }

        return resultado;
    }
    //Metodo para calcular los costos de los materiales

    public double calcularCostoMateriales(
            List<? extends Actividad> actividades) {

        double total = 0;

        for (Actividad actividad : actividades) {
            total += actividad.calcularCostoMateriales();
        }

        return total;
    }

}