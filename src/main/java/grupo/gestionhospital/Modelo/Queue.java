
package grupo.gestionhospital.Modelo;

import grupo.gestionhospital.Modelo.Node;

public class Queue {
    private List data;

    public Queue() {
        data = new List();
    }

    public int size() {
        return data.size();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public void enqueue(Object e) {
        data.addLast(e);
    }

    public Object dequeue() {
        if (isEmpty()) {
            System.out.println("La cola está vacía.");
            return null;
        }
        return data.removeFirst();
    }

    public Object front() {
        if (isEmpty()) {
            System.out.println("La cola está vacía.");
            return null;
        }
        return data.first().getData();
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("[ cola vacía ]");
            return;
        }

        Node current = data.first();
        System.out.println("Contenido de la cola: ");
        while (current != null) {
            System.out.println("| " + current.getData() + " |");
            current = current.getNext();
        }
        System.out.println("-----");
    }
    public void showQueueRecursivo(Node current) {
    
        if (current == null) {
        return;
    }
    System.out.println("| " + current.getData() + " |");

    showQueueRecursivo(current.getNext());
}
}
