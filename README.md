
# Sistema de Gestión de Eventos Universitarios

Proyecto desarrollado en Java para aplicar conceptos de Programación Orientada a Objetos mediante la gestión de eventos universitarios, actividades e inscripciones.

## Funcionalidades

- Creación y administración de eventos universitarios y salas.
- Gestión de actividades: charlas, talleres y cursos.
- Inscripción de estudiantes con control de cupos y excepciones.
- Confirmación de inscripciones y generación de tickets de acceso.
- Envío concurrente de tickets mediante hilos (`Thread`).
- Filtrado de actividades por tipo y cálculo de costos de materiales.
- Persistencia de eventos mediante serialización de objetos.
- Aplicación de herencia, clases abstractas, interfaces, clases anidadas y polimorfismo.

## Tecnologías

- Java
- IntelliJ IDEA
- Git y GitHub

## Estructura principal

- `tp1`: clases principales del sistema, como `App`, `EventoUniversitario`, `Actividad`, `Inscripcion`, `Estudiante` y `Sala`.
- `tp1.hilos`: implementación del envío concurrente de tickets.
- `tp1.certificacion`: funcionalidades relacionadas con la emisión de certificados.
- `excepciones`: excepciones personalizadas, como `CupoExcedidoException`.

## Ejecución

1. Clonar o descargar el repositorio.
2. Abrir el proyecto en IntelliJ IDEA.
3. Configurar un JDK compatible con el código fuente.
4. Ejecutar la clase `tp2.App`.



