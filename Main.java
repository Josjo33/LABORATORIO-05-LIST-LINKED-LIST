public class Main {
    public static void main(String[] args) {
        // Crear una instancia de GestorDeTareas para Tareas
        GestorDeTareas<Tarea> gestor = new GestorDeTareas<>();

        // Crear algunas tareas
        Tarea tarea1 = new Tarea("Tarea 1", 2);
        Tarea tarea2 = new Tarea("Tarea 2", 1);
        Tarea tarea3 = new Tarea("Tarea 3", 3);

        // Agregar tareas
        gestor.agregarTarea(tarea1);
        gestor.agregarTarea(tarea2);
        gestor.agregarTarea(tarea3);

        // Imprimir todas las tareas
        System.out.println("Tareas actuales:");
        gestor.imprimirTareas();

        // Eliminar una tarea
        gestor.eliminarTarea(tarea2);

        // Imprimir las tareas actuales después de eliminar
        System.out.println("\nTareas después de eliminar:");
        gestor.imprimirTareas();

        // Verificar si una tarea existe
        System.out.println("\n¿Contiene la tarea 1? " + gestor.contieneTarea(tarea1));

        // Obtener la tarea más prioritaria
        Tarea tareaPrioritaria = gestor.obtenerTareaMasPrioritaria();
        System.out.println("\nTarea más prioritaria: " + tareaPrioritaria);

        // Invertir la lista de tareas
        gestor.invertirTareas();
        System.out.println("\nTareas invertidas:");
        gestor.imprimirTareas();

        // Crear una lista enlazada para tareas completadas
        GestorDeTareas<Tarea> tareasCompletadas = new GestorDeTareas<>();
        tareasCompletadas.agregarTarea(tarea1);  // Transferir tareas completadas

        // Mostrar las tareas completadas
        System.out.println("\nTareas completadas:");
        tareasCompletadas.imprimirTareas();
    }
}