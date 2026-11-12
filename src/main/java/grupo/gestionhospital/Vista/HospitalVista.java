
package grupo.gestionhospital.Vista;
import grupo.gestionhospital.Controlador.*;
import java.util.Scanner;
import grupo.gestionhospital.Modelo.*;


public class HospitalVista {
    
    private HospitalControlador controlador;
    
    public HospitalVista(){
        this.controlador = new HospitalControlador();
    }
    
    
    
    public void iniciar(){
        
        Scanner sc = new Scanner(System.in);
        
        int option = 0;
        
        do{
            System.out.println("--- Sistema Hospitalario ---");
            System.out.println("1.  Registrar paciente Eps");
            System.out.println("2.  Registrar paciente Sisben");
            System.out.println("3.  Buscar paciente por ID");
            System.out.println("4.  Mostrar todos los pacientes de la EPS");
            System.out.println("5.  Mostrar todos los pacientes del Sisben");
            System.out.println("6.  Agendar cita medica");
            System.out.println("7.  Atender la siguiente cita.");
            System.out.println("8.  Mostrar citas pendientes");
            System.out.println("9.  Ver la ultima atencion");
            System.out.println("10. Ver historial completo");
            System.out.println("11. Guardar pacientes EPS en CSV");
            System.out.println("12. Guardar pacientes Sisben en CSV");
            System.out.println("Seleccione una opcion: ");
            option = sc.nextInt();
            
            switch(option){
                
                case 1:
                    System.out.println("\n--- REGISTRO DE PACIENTE EPS ---");
                    System.out.println("Nombre: "); 
                    String nombre = sc.nextLine();
                    System.out.println("Apellido: ");
                    String apellido = sc.nextLine();
                    System.out.println("Edad: ");
                    int edad = sc.nextInt();
                    System.out.println("Telefono: ");
                    String telefono = sc.nextLine();
                    System.out.println("Nombre de la EPS: ");
                    String nombreEps = sc.nextLine();
                    System.out.println("Id del paciente");
                    int id = sc.nextInt();
                    
                    boolean registrado = controlador.registrarPacienteEps(nombreEps, id, nombre, apellido, edad, telefono);
                    
                    if(registrado){
                        System.out.println("Paciente registrado exitosamente.");
                    }else{
                        System.err.println("Paciente ya registrado anteriormente.");
                    }
                    break;
                case 2:
                    System.out.println("\n--- REGISTRO DE PACIENTE Sisben ---");
                    System.out.println("Nombre: "); 
                    String puntajeSisben = sc.nextLine();
                    System.out.println("Apellido: ");
                    String apellidoS = sc.nextLine();
                    System.out.println("Edad: ");
                    int edadS = sc.nextInt();
                    System.out.println("Telefono: ");
                    String telefonoS = sc.nextLine();
                    System.out.println("Nombre de la EPS: ");
                    String nombreS = sc.nextLine();
                    System.out.println("Id del paciente");
                    int idS = sc.nextInt();
                    
                    registrado = controlador.registrarPacienteSisben(puntajeSisben , idS, nombreS, apellidoS, edadS, telefonoS);
                    
                    if(registrado){
                        System.out.println("Paciente registrado exitosamente.");
                    }else{
                        System.err.println("Paciente ya registrado anteriormente.");
                    }

                    break;    
                case 3:
                    
                    System.out.println("Ingrese el ID del paciented que desea buscar: ");
                    int idBusqueda = sc.nextInt();
                    
                    Paciente encontrado = controlador.buscarPaciente(idBusqueda);
                    
                    if (encontrado == null) {
                    System.out.println("Paciente no encontrado, haga primero el registro.");
                    } else {
                     encontrado.mostrarInformacion();
                    }
                    break;
                case 4:
                    
                    String listEps = controlador.showListEps();
                    
                    System.out.println(listEps);
                    break;
                case 5:
                    
                    String listSisben = controlador.showListSisben();
                    
                    System.out.println(listSisben);
                    break;
                case 6:
                    System.out.println("Ingrese el ID del paciente que desea agendar cita: ");
                    int idAgenda = sc.nextInt();
                    System.out.println("Ingrese la especialidad de la cita: ");
                    String especialidad = sc.nextLine();
                    
                    Citas citaCreada = controlador.registrarCita(idAgenda, especialidad);
                    
                    if (citaCreada == null) {
                        System.out.println("No se pudo agendar la cita: el paciente no existe.");
                    } else {
                        System.out.println("Cita agendada exitosamente: " + citaCreada);
                    }
                    break;
     
                case 7: 
                    break;
                case 8: 
                    break;
                case 9: 
                    break;
                case 10:
                    break;
                case 11: 
                    break;
                case 12: 
                    break;
            
            
        }
            
            
            
        }while(option != 0);
    }
    
}


