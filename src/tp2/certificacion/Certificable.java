package tp2.certificacion;
import tp2.Estudiante;
public interface Certificable {
    String ENTIDAD_EMISORA = "Universidad Tecnológica Nacional - FRM";

    String generarCertificado(Estudiante estudiante);
}

