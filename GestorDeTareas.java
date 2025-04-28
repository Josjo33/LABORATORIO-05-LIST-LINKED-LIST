public class GestorDeTareas<T> {
    private Node<T> head; // Cabeza de la lista

    // Constructor para inicializar el gestor de tareas
    public GestorDeTareas() {
        this.head = null;
    }

    // Método para agregar una tarea al final de la lista
    public void agregarTarea(T tarea) {
        Node<T> newNode = new Node<>(tarea);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Método para eliminar una tarea específica
    public boolean eliminarTarea(T tarea) {
        if (head == null) return false;

        // Si la tarea a eliminar es el primer nodo
        if (head.value.equals(tarea)) {
            head = head.next;
            return true;
        }

        Node<T> current = head;
        while (current.next != null) {
            if (current.next.value.equals(tarea)) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        return false; // No se encontró la tarea
    }

    // Método para verificar si una tarea existe
    public boolean contieneTarea(T tarea) {
        Node<T> current = head;
        while (current != null) {
            if (current.value.equals(tarea)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Método para imprimir todas las tareas
    public void imprimirTareas() {
        Node<T> current = head;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }

    // Método para contar el total de tareas
    public int contarTareas() {
        int count = 0;
        Node<T> current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    // Método para obtener la tarea más prioritaria (si se está trabajando con objetos Tarea)
    public T obtenerTareaMasPrioritaria() {
        Node<T> current = head;
        T tareaMasPrioritaria = null;
        int maxPrioridad = Integer.MIN_VALUE;

        while (current != null) {
            if (current.value instanceof Tarea) {
                Tarea tarea = (Tarea) current.value;
                if (tarea.getPrioridad() > maxPrioridad) {
                    maxPrioridad = tarea.getPrioridad();
                    tareaMasPrioritaria = (T) tarea;
                }
            }
            current = current.next;
        }
        return tareaMasPrioritaria;
    }

    // Método para invertir la lista de tareas
    public void invertirTareas() {
        Node<T> prev = null;
        Node<T> current = head;
        Node<T> next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev; // Cambiar la cabeza de la lista a la nueva cabeza invertida
    }
}