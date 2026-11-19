package datos;

import modelo.Estudiante;
import java.util.ArrayList;
import java.util.List;

public class RepositorioEstudiante {
    private List<Estudiante> listaEstudiantes = new ArrayList<>();

    public void guardar(Estudiante estudiante) {
        listaEstudiantes.add(estudiante);
    }

    public boolean actualizar(Estudiante estudianteActualizado) {
        for (int i = 0; i < listaEstudiantes.size(); i++) {
            if (listaEstudiantes.get(i).getId().equals(estudianteActualizado.getId())) {
                listaEstudiantes.set(i, estudianteActualizado);
                return true;
            }
        }
        return false;
    }

    public boolean eliminar(String id) {
        return listaEstudiantes.removeIf(e -> e.getId().equals(id));
    }

    public List<Estudiante> listarTodos() {
        return new ArrayList<>(listaEstudiantes);
    }
}