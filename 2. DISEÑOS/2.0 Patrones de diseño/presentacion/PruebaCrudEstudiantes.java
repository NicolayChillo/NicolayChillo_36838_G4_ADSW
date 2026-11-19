package presentacion;

import logica.ControlEstudiante;
import modelo.Estudiante;
import java.util.List;
import java.util.Scanner;

public class PruebaCrudEstudiantes {
    private static ControlEstudiante control = new ControlEstudiante();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion = 0;

        do {
            System.out.println("\n==========================================");
            System.out.println("   CRUD ESTUDIANTES - ARQUITECTURA 3 CAPAS");
            System.out.println("==========================================");
            System.out.println("1. [RF-01] Registrar estudiante");
            System.out.println("2. [RF-04] Listar todos los estudiantes");
            System.out.println("3. [RF-02] Actualizar estudiante (ID no editable)");
            System.out.println("4. [RF-03] Eliminar estudiante");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
                switch (opcion) {
                    case 1:
                        onAgregar();
                        break;
                    case 2:
                        actualizarLista();
                        break;
                    case 3:
                        onActualizar();
                        break;
                    case 4:
                        onEliminar();
                        break;
                    case 5:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("[!] Opción inválida. Intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("[!] Error: Debe ingresar un número del 1 al 5.");
            }
        } while (opcion != 5);
    }

// RF-01: Registrar
    private static void onAgregar() {
        System.out.println("\n--- [RF-01] REGISTRAR ESTUDIANTE ---");
        try {
            System.out.print("Ingrese ID: ");
            String id = scanner.nextLine();

            System.out.print("Ingrese Nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Ingrese Edad: ");
            int edad = Integer.parseInt(scanner.nextLine()); // Conversión a int

            control.agregarEstudiante(id, nombre, edad);
            System.out.println("[OK] Estudiante registrado exitosamente.");
        } catch (NumberFormatException e) {
            System.out.println("[ERROR DE VALIDACIÓN]: La edad debe ser un número entero.");
        } catch (Exception ex) {
            System.out.println("[ERROR DE VALIDACIÓN]: " + ex.getMessage());
        }
    }

    // RF-04: Consultar / Listar
    private static void actualizarLista() {
        System.out.println("\n--- [RF-04] LISTA DE ESTUDIANTES ---");
        List<Estudiante> lista = control.listarTodos();
        if (lista.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
        } else {
            for (Estudiante e : lista) {
                System.out.println(e);
            }
        }
    }

    // RF-02: Actualizar (Mantiene el ID intacto, solo pide nuevos Nombre y Edad)
// RF-02: Actualizar (Mantiene el ID intacto, solo pide nuevos Nombre y Edad)
    private static void onActualizar() {
        System.out.println("\n--- [RF-02] ACTUALIZAR ESTUDIANTE ---");
        try {
            System.out.print("Ingrese el ID del estudiante a modificar: ");
            String id = scanner.nextLine();

            // Se muestra explícitamente que el ID queda fijo y no se solicita uno nuevo
            System.out.println("Editando estudiante con ID fijo: [" + id + "] (El ID no se puede modificar)");

            System.out.print("Ingrese nuevo Nombre: ");
            String nuevoNombre = scanner.nextLine();

            System.out.print("Ingrese nueva Edad: ");
            int nuevaEdad = Integer.parseInt(scanner.nextLine()); // Conversión a int

            control.actualizarEstudiante(id, nuevoNombre, nuevaEdad);
            System.out.println("[OK] Datos actualizados correctamente manteniendo el ID " + id + ".");
            
        } catch (NumberFormatException e) {
            System.out.println("[ERROR DE VALIDACIÓN]: La edad debe ser un número entero.");
        } catch (Exception ex) {
            System.out.println("[ERROR]: " + ex.getMessage());
        }
    }

    // RF-03: Eliminar
    private static void onEliminar() {
        System.out.println("\n--- [RF-03] ELIMINAR ESTUDIANTE ---");
        try {
            System.out.print("Ingrese el ID del estudiante a eliminar: ");
            String id = scanner.nextLine();

            control.eliminarEstudiante(id);
            System.out.println("[OK] Estudiante eliminado correctamente.");
        } catch (Exception ex) {
            System.out.println("[ERROR]: " + ex.getMessage());
        }
    }
}