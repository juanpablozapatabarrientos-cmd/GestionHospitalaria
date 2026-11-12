
package grupo.gestionhospital.Controlador;

import grupo.gestionhospital.Modelo.*;

public class HospitalControlador {
    
    private List listaEps;
    private List listaSisben;
    private Arbol arbolPacientes;
    private Queue colaPacientes;
    private Stack pilaPacientes;
    private int consecutivoCitas;
    
    public HospitalControlador(){
        this.listaEps = new List();
        this. listaSisben = new List();
        this.arbolPacientes = new Arbol();
        this.colaPacientes = new Queue();
        this.pilaPacientes = new Stack();
        this. consecutivoCitas = 1;
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
            System.out.println("No hay mas citas por atender. ");
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
    
    
    
    
    
    
    
    
}
