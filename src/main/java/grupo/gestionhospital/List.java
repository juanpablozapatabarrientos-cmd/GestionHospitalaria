
package grupo.gestionhospital;

public class List {
    private Node head;
    private Node tail;
    private int size;

    public List() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Node first() {
        return head;
    }

    public Node last() {
        return tail;
    }

    public void addLast(Object e) {
        Node newNode = new Node(e);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }

        size++;
    }

    public Object removeFirst() {
        if (isEmpty()) {
            System.out.println("La lista está vacía.");
            return null;
        }

        Object removed = head.getData();

        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.getNext();
        }

        size--;
        return removed;
    }
}
