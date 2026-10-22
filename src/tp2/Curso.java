package tp2;
import tp2.certificacion.Certificable;
public class Curso extends Actividad implements Certificable {
    private int nivel;

    public Curso(int id, String titulo, int cupoMaximo, int nivel) {
        super(id, titulo, cupoMaximo);
        this.nivel = nivel;
    }

    @Override
    public double calcularCostoMateriales() {
        return 3000;
    }

    @Override
    public String getTipo() {
        return "Curso";
    }

    public int getNivel() {
        return nivel;
    }

    @Override
    public String generarCertificado(Estudiante estudiante) {
        return "\n===== CERTIFICADO DE ASISTENCIA ====="
                + "\nEntidad emisora: " + ENTIDAD_EMISORA
                + "\nSe certifica que: " + estudiante.getNombre()
                + "\nParticipó en la actividad: " + getTitulo()
                + "\nTipo de actividad: " + getTipo()
                + "\nNivel del curso: " + nivel
                + "\n=====================================";
    }
}

