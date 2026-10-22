package tp2;

import tp2.certificacion.Certificable;

public class Taller extends Actividad implements Certificable {

    private boolean requiereNotebook;


    public Taller(int id,
                  String titulo,
                  int cupoMaximo,
                  boolean requiereNotebook) {

        super(id, titulo, cupoMaximo);

        this.requiereNotebook = requiereNotebook;
    }


    @Override
    public double calcularCostoMateriales() {

        if (requiereNotebook) {
            return 5000;
        }

        return 2000;
    }


    @Override
    public String getTipo() {

        return "Taller";
    }

    @Override
    public String generarCertificado(Estudiante estudiante) {
        return "\n===== CERTIFICADO DE ASISTENCIA ====="
                + "\nEntidad emisora: " + ENTIDAD_EMISORA
                + "\nSe certifica que: " + estudiante.getNombre()
                + "\nParticipó en la actividad: " + getTitulo()
                + "\nTipo de actividad: " + getTipo()
                + "\n=====================================";
    }

}