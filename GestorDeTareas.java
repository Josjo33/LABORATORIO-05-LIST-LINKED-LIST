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

    // Ejercicio 1: Buscar un elemento genérico en una lista
    public boolean buscarElemento(Node<T> head, T valor) {
        Node<T> current = head;
        while (current != null) {
            if (current.value.equals(valor)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Ejercicio 2: Invertir una lista genérica
    public LinkedList<T> invertirLista(Node<T> head) {
        LinkedList<T> listaInvertida = new LinkedList<>();
        Node<T> current = head;
    
        while (current != null) {
            listaInvertida.insertFirst(current.value);
            current = current.next;
        }
    
        return listaInvertida;
    }

    // Ejercicio 3: Insertar un nodo al final
    public Node<T> insertarAlFinal(Node<T> head, T valor) {
        Node<T> newNode = new Node<>(valor);
    
        if (head == null) {
            return newNode;  // Si la lista está vacía, el nuevo nodo es el head
        }
    
        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }
    
        current.next = newNode;  // Agregar al final
    
        return head;
    }

    // Ejercicio 4: Contar los nodos
    public int contarNodos(Node<T> head) {
        int count = 0;
        Node<T> current = head;
    
        while (current != null) {
            count++;
            current = current.next;
        }
    
        return count;
    }

    // Ejercicio 5: Comparar dos listas
    public boolean sonIguales(Node<T> head1, Node<T> head2) {
        Node<T> current1 = head1;
        Node<T> current2 = head2;
    
        while (current1 != null && current2 != null) {
            if (!current1.value.equals(current2.value)) {
                return false;  // Si algún valor no coincide, las listas no son iguales
            }
            current1 = current1.next;
            current2 = current2.next;
        }
    
        return current1 == null && current2 == null;  // Ambas listas deben llegar a null al mismo tiempo
    }

    // Ejercicio 6: Concatenar dos listas
    public Node<T> concatenarListas(Node<T> head1, Node<T> head2) {
        if (head1 == null) return head2;  // Si la primera lista está vacía, retorna la segunda
        if (head2 == null) return head1;  // Si la segunda lista está vacía, retorna la primera

        Node<T> current = head1;
        while (current.next != null) {
            current = current.next;
        }

        current.next = head2;  // Conecta el final de la primera lista con la segunda

        return head1;
    }
}