package logica;

import datos.RepositorioEstudiante;
import modelo.Estudiante;
import java.util.List;

public class ControlEstudiante {
    private RepositorioEstudiante repositorio;

    public ControlEstudiante() {
        this.repositorio = new RepositorioEstudiante();
    }

    // RF-05: Validación de datos obligatorios
    public void validarDatos(String id, String nombre, int edad) throws Exception {
        if (id == null || id.trim().isEmpty()) {
            throw new Exception("El ID es obligatorio.");
        }
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new Exception("El Nombre no puede estar vacío.");
        }
        if (edad <= 0 || edad > 120) {
            throw new Exception("La Edad debe ser un número válido.");
        }
    }

    // RF-01
    public void agregarEstudiante(String id, String nombre, int edad) throws Exception {
        validarDatos(id, nombre, edad);
        Estudiante nuevo = new Estudiante(id, nombre, edad);
        repositorio.guardar(nuevo);
    }

    // RF-02
    public boolean actualizarEstudiante(String id, String nombre, int edad) throws Exception {
        validarDatos(id, nombre, edad);
        Estudiante actualizado = new Estudiante(id, nombre, edad);
        return repositorio.actualizar(actualizado);
    }

    // RF-03 (Aquí puedes agregar la regla académica si tu docente definió una, ej. edad mínima)
    public boolean eliminarEstudiante(String id) throws Exception {
        if (id == null || id.trim().isEmpty()) {
            throw new Exception("Debe especificar un ID para eliminar.");
        }
        return repositorio.eliminar(id);
    }

    // RF-04
    public List<Estudiante> listarTodos() {
        return repositorio.listarTodos();
    }
}