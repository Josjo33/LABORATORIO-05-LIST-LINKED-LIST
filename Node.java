public class Node<T> {
    T value; // Valor que guardará el nodo
    Node<T> next; // Referencia al siguiente nodo

    // Constructor para inicializar el nodo
    public Node(T value) {
        this.value = value;
        this.next = null;
    }
}