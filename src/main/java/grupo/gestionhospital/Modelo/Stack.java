
package grupo.gestionhospital.Modelo;


public class Stack {
    private List data;
    
    public Stack(){
        data = new List();
    }
    
    public int size(){
        return data.size();
    }
    
    public boolean isEmpty(){
        return data.isEmpty();
    }
    
    public void push(Object e){
        data.addFirst(e);
    }
    
    public Object pop(){
        if(isEmpty()){
            System.out.println("La pila está vacía.");
            return null;
        }
        
        return data.removeFirst();
    }
    
    public Object top(){
        if(isEmpty()){
            System.out.println("La pila está vacía.");
            return null;
        }
        
        return data.first().getData();
    }
    
    public void showStack() {
        if (isEmpty()) {
            System.out.println("[ Pila vacía ]");
            return;
        }

        Node current = data.first();
        System.out.println("Contenido de la pila: ");
        while (current != null) {
            System.out.println("| " + current.getData() + " |");
            current = current.getNext();
        }
        System.out.println("-----");
    }
}
