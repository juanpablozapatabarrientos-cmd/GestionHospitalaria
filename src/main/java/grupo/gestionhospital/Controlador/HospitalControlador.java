
package grupo.gestionhospital.Controlador;

import grupo.gestionhospital.Modelo.*;

public class HospitalControlador {
    
    private List listaEps;
    private List listaSisben;
    private Arbol arbolPacientes;
    private Queue colaPacientes;
    private Stack pilaPacientes;
    private int consecutivoCitas;
    private Archivo archivo;
    
    public HospitalControlador(){
        this.listaEps = new List();
        this.listaSisben = new List();
        this.arbolPacientes = new Arbol();
        this.colaPacientes = new Queue();
        this.pilaPacientes = new Stack();
        this.consecutivoCitas = 1;
        this.archivo = new Archivo();
    }
    
    public boolean registrarPacienteEps(String nombreEps,int idPaciente, String nombre, String apellido,
            int edad, String telefonoPaciente){
        
        if(arbolPacientes.busqueda(idPaciente)){
            return false; 
        }
        
        PacienteEps nuevoPaciente = new PacienteEps(nombreEps, idPaciente, nombre, apellido, edad, telefonoPaciente);
        
        listaEps.addLast(nuevoPaciente);
        
        arbolPacientes.insertarNodo(nuevoPaciente);
        
        
        return true;
    }
    
    public boolean registrarPacienteSisben(String puntajeSisben,int idPaciente, String nombre, String apellido,
            int edad, String telefonoPaciente){
        
        if(arbolPacientes.busqueda(idPaciente)){
            return false; 
        }
        
        PacienteSisben nuevoPaciente = new PacienteSisben(puntajeSisben, idPaciente, nombre, apellido, edad, telefonoPaciente);
        
        listaSisben.addLast(nuevoPaciente);
        
        arbolPacientes.insertarNodo(nuevoPaciente);
        
        
        return true;
    }
    
    public Citas registrarCita(int idPaciente, String especialidad){
        
        if(!arbolPacientes.busqueda(idPaciente)){
            System.out.println("Paciente no registrado.");
            return null;
        }
        
                    
        Citas nuevaCita = new Citas(consecutivoCitas++, idPaciente, especialidad);
        
        colaPacientes.enqueue(nuevaCita);
        
        return nuevaCita;
    }
    
    public Citas siguienteCita(){
        
        if(colaPacientes.isEmpty()){
            System.out.println("No hay mas citas por atender.");
            return null;
        }
        
        Citas citaAtendida = (Citas) colaPacientes.dequeue();
        
        pilaPacientes.push(citaAtendida);
        
        return citaAtendida;
    }
    
    public String showListEps(){
        return listaEps.showList();
    }
    
    public String showListSisben(){
        return listaSisben.showList();
    }
    
    public Paciente buscarPaciente(int id) {
        if (arbolPacientes.busqueda(id)) {
            return arbolPacientes.getUltimoEncontrado();
        }
        return null;
    }

    public boolean eliminarPaciente(int id) {
        Paciente encontrado = buscarPaciente(id);
        if (encontrado == null) {
            System.out.println("No existe un paciente registrado con el ID " + id + ".");
            return false;
        }

        if (colaPacientes.tieneCitaPendiente(id)) {
            System.out.println("No se puede eliminar al paciente con ID " + id + " porque tiene una cita pendiente en la cola.");
            return false;
        }

        arbolPacientes.eliminarPredecesor(encontrado);
        boolean eliminado = listaEps.eliminarPorId(id);
        if (!eliminado) {
            listaSisben.eliminarPorId(id);
        }
        return true;
    }

    public void mostrarRecorridosArbol() {
        if (arbolPacientes.esVacio()) {
            System.out.println("El arbol de pacientes esta vacio.");
            return;
        }
        System.out.println("Recorrido InOrden:");
        arbolPacientes.inOrden();
        System.out.println("Recorrido PreOrden:");
        arbolPacientes.preOrden();
        System.out.println("Recorrido PostOrden:");
        arbolPacientes.postOrden();
    }
    
    public Citas ultimaAtencion(){
        if(pilaPacientes.isEmpty()){
            System.out.println("No hay citas atendidas, atienda primero una cita.");
            return null;
        }
        
        Citas ultimaAtencion = (Citas) pilaPacientes.top();
        
        return ultimaAtencion;
    }
    
    public void historialAtendido(){
        pilaPacientes.showStack();
    }
    
    public void citasPendientes(){
        colaPacientes.showQueue();
    }
    
    public void guardarPacientesEpsCSV() {
        Archivo.guardarPacientesEPS(listaEps, "pacientes_eps.csv");
    }
    
    public void guardarPacientesSisbenCSV() {
        Archivo.guardarPacientesSisben(listaSisben, "pacientes_sisben.csv");
    }

}
