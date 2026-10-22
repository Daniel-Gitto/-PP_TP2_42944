package tp2;

import java.util.ArrayList;
import java.util.List;
import excepciones.CupoExcedidoException;
import java.io.Serializable;

public abstract class Actividad implements Serializable {

    // =========================================
    // ATRIBUTOS
    // =========================================

    private int id;
    private String titulo;
    private int cupoMaximo;

    public static final int CUPO_MINIMO = 1;

    private List<Inscripcion> inscripciones;


    // =========================================
    // CONSTRUCTOR
    // =========================================

    public Actividad(int id,
                     String titulo,
                     int cupoMaximo) {

        this.id = id;
        this.titulo = titulo;


        if (cupoMaximo < CUPO_MINIMO) {
            this.cupoMaximo = CUPO_MINIMO;
        } else {
            this.cupoMaximo = cupoMaximo;
        }

        this.inscripciones = new ArrayList<>();
    }


    // =========================================
    // INSCRIBIR ESTUDIANTE
    // =========================================


    public Inscripcion inscribir(Estudiante estudiante)
            throws CupoExcedidoException {

        if (inscripciones.size() >= cupoMaximo) {
            throw new CupoExcedidoException(
                    "No hay cupo disponible para la actividad: " + titulo
            );
        }

        Inscripcion inscripcion = new Inscripcion(estudiante, this);
        inscripciones.add(inscripcion);

        return inscripcion;
    }



    // =========================================
    // MOSTRAR INSCRIPCIONES
    // =========================================

    public void mostrarInscripciones() {

        System.out.println(
                "Inscripciones de: " + titulo
        );

        for (Inscripcion inscripcion : inscripciones) {

            System.out.println(inscripcion);
        }
    }


    // =========================================
    // MOSTRAR IDENTIFICACION
    // =========================================

    public final void mostrarIdentificacion() {

        System.out.println(
                "Tipo de actividad: " + getTipo()
        );

        System.out.println(
                "ID: " + id
        );

        System.out.println(
                "Título: " + titulo
        );
    }


    // =========================================
    // MÉTODOS ABSTRACTOS
    // =========================================

    public abstract double calcularCostoMateriales();

    public abstract String getTipo();


    // =========================================
    // GETTERS
    // =========================================

    public int getId() {return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getCupoMaximo() {

        return cupoMaximo;
    }

    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }

}