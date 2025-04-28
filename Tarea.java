
public class Tarea {
    private String titulo;
    private int prioridad;

    // Constructor para inicializar la tarea
    public Tarea(String titulo, int prioridad) {
        this.titulo = titulo;
        this.prioridad = prioridad;
    }

    // Getters y setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    // Método toString para mostrar la tarea
    @Override
    public String toString() {
        return "Tarea: " + titulo + ", Prioridad: " + prioridad;
    }
}