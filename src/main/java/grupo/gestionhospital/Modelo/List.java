
package grupo.gestionhospital.Modelo;

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
    
    public void addFirst(Object e){
        Node newNode = new Node(e);
        
        if(isEmpty()){
            head = newNode;
            tail = newNode;
        }else{
            newNode.setNext(head);
            head = newNode;
        }
        
        size++;
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
            System.out.println("La lista esta vacia.");
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

    public boolean eliminarPorId(int idPaciente) {
        if (isEmpty()) {
            return false;
        }

        Paciente primero = (Paciente) head.getData();
        if (primero.getIdPaciente() == idPaciente) {
            removeFirst();
            return true;
        }

        Node anterior = head;
        Node actual = head.getNext();

        while (actual != null) {
            Paciente p = (Paciente) actual.getData();
            if (p.getIdPaciente() == idPaciente) {
                anterior.setNext(actual.getNext());
                if (actual == tail) {
                    tail = anterior;
                }
                actual.setNext(null);
                size--;
                return true;
            }
            anterior = actual;
            actual = actual.getNext();
        }

        return false;
    }
    
    public String showList() {
        if (isEmpty()) {
            return "[ Lista vacia ]";
        }
        
        String resultado = "";
        Node current = head;
        while (current != null) {
            resultado += "| " + current.getData() + " |\n";
            current = current.getNext();
        }
        resultado += "-----";
        
        return resultado;
    }
}
