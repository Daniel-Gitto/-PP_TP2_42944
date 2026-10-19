
public class App {

    public static void main(String[] args) {

        //Crear Evento
        EventoUniversitario evento1 = new EventoUniversitario("E01", "Jornada de BD", 10000, false);
        EventoUniversitario evento2 = new EventoUniversitario("E02", "Jornada de IA", 8000, true);


        //Crear copia de eventos
        EventoUniversitario copiaEvento1 = new EventoUniversitario(evento1);
        EventoUniversitario copiaEvento2 = new EventoUniversitario(evento2);

        System.out.println();
        System.out.println("Evento 1");

        evento1.mostrarDatos();


        System.out.println();
        System.out.println("COPIA EVENTO 1");

        copiaEvento1.mostrarDatos();

        System.out.println();
        System.out.println("EVENTO 2");

        evento2.mostrarDatos();

        System.out.println();
        System.out.println("COPIA EVENTO 2");

        copiaEvento2.mostrarDatos();

        //Mostrar Contador
        System.out.println();
        System.out.println(
                "Cantidad total de eventos creados: "
                        + EventoUniversitario.getCantidadEventos());






    }
}