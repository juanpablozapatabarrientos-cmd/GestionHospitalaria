
package grupo.gestionhospital.Modelo;

import grupo.gestionhospital.Modelo.Paciente;




public class PacienteSisben extends Paciente{
    
    private String puntajeSisben;
    
    public PacienteSisben(String puntajeSisben,int idPaciente, String nombre, String apellido,
            int edad, String telefonoPaciente){
        
        super(idPaciente,nombre, apellido,edad, telefonoPaciente);
        this.puntajeSisben = puntajeSisben;
    }

    public String getPuntajeSisben() {
        return puntajeSisben;
    }

    public void setPuntajeSisben(String nombreEps) {
        this.puntajeSisben = nombreEps;
    }
    
    @Override
    public void mostrarInformacion(){
        System.out.println("-----------------------");
    System.out.println("Información del paciente (EPS)");
    System.out.println("ID: " + getIdPaciente());
    System.out.println("Nombre: " + getNombre() + " " + getApellido());
    System.out.println("Edad: " + getEdad() + " años");
    System.out.println("Teléfono: " + getTelefonoPaciente());
    System.out.println("EPS: " + this.puntajeSisben);
    System.out.println("-----------------------");
    }
    
    
    //Falta metodo override que se llama toCsv 
}
