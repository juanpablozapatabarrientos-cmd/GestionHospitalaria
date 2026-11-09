
package grupo.gestionhospital;




public class PacienteSisben extends Paciente{
    
    private String nombreEps;
    
    public PacienteSisben(String nombreEps,int idPaciente, String nombre, String apellido,
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
    public void MostrarInformacion(){
        System.out.println("-----------------------");
        System.out.println("Informacion del paciente");
        //Terminar el MostrarInformacion

    }
    
}
