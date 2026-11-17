
package grupo.gestionhospital.Vista;
import grupo.gestionhospital.Controlador.*;
import grupo.gestionhospital.Modelo.*;
import java.util.Scanner;


public class HospitalVista {
    
    private HospitalControlador controlador;
    
    public HospitalVista(){
        this.controlador = new HospitalControlador();
    }
    
    public static void main(String[] args) {
        HospitalVista vista = new HospitalVista();
        vista.iniciar();
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
            System.out.println("7.  Atender la siguiente cita");
            System.out.println("8.  Mostrar citas pendientes");
            System.out.println("9.  Ver la ultima atencion");
            System.out.println("10. Ver historial completo");
            System.out.println("11. Guardar pacientes EPS en CSV");
            System.out.println("12. Guardar pacientes Sisben en CSV");
            System.out.println("13. Eliminar paciente por ID");
            System.out.println("14. Mostrar recorridos del arbol (InOrden, PreOrden, PostOrden)");
            System.out.println("0.  Salir");
            System.out.println("Seleccione una opcion: ");
            option = sc.nextInt();
            sc.nextLine();
            
            switch(option){
                
                case 1:
                    System.out.println("\n--- REGISTRO DE PACIENTE EPS ---");
                    System.out.println("Nombre: "); 
                    String nombre = sc.nextLine();
                    System.out.println("Apellido: ");
                    String apellido = sc.nextLine();
                    System.out.println("Edad: ");
                    int edad = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Telefono: ");
                    String telefono = sc.nextLine();
                    System.out.println("Nombre de la EPS: ");
                    String nombreEps = sc.nextLine();
                    System.out.println("Id del paciente: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    
                    boolean registrado = controlador.registrarPacienteEps(nombreEps, id, nombre, apellido, edad, telefono);
                    
                    if(registrado){
                        System.out.println("Paciente registrado exitosamente.");
                    }else{
                        System.out.println("Paciente ya registrado anteriormente.");
                    }
                    break;
                case 2:
                    System.out.println("\n--- REGISTRO DE PACIENTE Sisben ---");
                    System.out.println("Nombre: "); 
                    String nombreS = sc.nextLine();
                    System.out.println("Apellido: ");
                    String apellidoS = sc.nextLine();
                    System.out.println("Edad: ");
                    int edadS = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Telefono: ");
                    String telefonoS = sc.nextLine();
                    System.out.println("Puntaje del sisben: ");
                    String puntajeSisben = sc.nextLine();
                    System.out.println("Id del paciente: ");
                    int idS = sc.nextInt();
                    sc.nextLine();
                    
                    registrado = controlador.registrarPacienteSisben(puntajeSisben, idS, nombreS, apellidoS, edadS, telefonoS);
                    
                    if(registrado){
                        System.out.println("Paciente registrado exitosamente.");
                    }else{
                        System.out.println("Paciente ya registrado anteriormente.");
                    }

                    break;    
                case 3:
                    System.out.println("Ingrese el ID del paciente que desea buscar: ");
                    int idBusqueda = sc.nextInt();
                    sc.nextLine();
                    
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
                    sc.nextLine();
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
                    Citas citaAtendida = controlador.siguienteCita();
                    if (citaAtendida != null) {
                        System.out.println("Atendiendo cita: " + citaAtendida);
                    }
                    break;
                case 8:
                    controlador.citasPendientes();
                    break;
                case 9:
                    Citas ultima = controlador.ultimaAtencion();
                    if (ultima != null) {
                        System.out.println("Ultima atencion: " + ultima);
                    }
                    break;
                case 10:
                    controlador.historialAtendido();
                    break;
                case 11: 
                    controlador.guardarPacientesEpsCSV();
                    break;
                case 12: 
                    controlador.guardarPacientesSisbenCSV();
                    break;
                case 13:
                    System.out.println("Ingrese el ID del paciente que desea eliminar: ");
                    int idEliminar = sc.nextInt();
                    sc.nextLine();
                    
                    boolean eliminado = controlador.eliminarPaciente(idEliminar);
                    if (eliminado) {
                        System.out.println("Paciente eliminado correctamente del arbol y de su lista.");
                    }
                    break;
                case 14:
                    controlador.mostrarRecorridosArbol();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opcion no valida.");
                    break;
            }    
        }while(option != 0);
        sc.close();
    }
}

