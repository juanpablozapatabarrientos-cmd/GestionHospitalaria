
package grupo.gestionhospital.Modelo;

import grupo.gestionhospital.Modelo.Paciente;


public class PacienteEps extends Paciente{
    
    private String nombreEps;
    
    public PacienteEps(String nombreEps,int idPaciente, String nombre, String apellido,
            int edad, String telefonoPaciente){
        
        super(idPaciente,nombre, apellido,edad, telefonoPaciente);
        this.nombreEps = nombreEps;
    }

    public String getNombreEps() {
        return nombreEps;
    }

    public void setNombreEps(String nombreEps) {
        this.nombreEps = nombreEps;
    }
    
    @Override
    public void mostrarInformacion(){
        System.out.println("-----------------------");
    System.out.println("Información del paciente (EPS)");
    System.out.println("ID: " + getIdPaciente());
    System.out.println("Nombre: " + getNombre() + " " + getApellido());
    System.out.println("Edad: " + getEdad() + " años");
    System.out.println("Teléfono: " + getTelefonoPaciente());
    System.out.println("EPS: " + this.nombreEps);
    System.out.println("-----------------------");
    }
    
}
