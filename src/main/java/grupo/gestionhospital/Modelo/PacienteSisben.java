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

    public void setPuntajeSisben(String puntajeSisben) {
        this.puntajeSisben = puntajeSisben;
    }
    
    @Override
    public void mostrarInformacion(){
        System.out.println("-----------------------");
        System.out.println("Informacion del paciente (SISBEN)");
        System.out.println("ID: " + getIdPaciente());
        System.out.println("Nombre: " + getNombre() + " " + getApellido());
        System.out.println("Edad: " + getEdad() + " anos");
        System.out.println("Telefono: " + getTelefonoPaciente());
        System.out.println("Puntaje Sisben: " + this.puntajeSisben);
        System.out.println("-----------------------");
    }
    
    @Override
    public String toCsv(){
        return getIdPaciente() + "," + getNombre() + "," + getApellido() + "," + getEdad() + "," + getTelefonoPaciente() + "," + this.puntajeSisben;
    }

    @Override
    public String toString(){
        return "ID: " + getIdPaciente() + " | Nombre: " + getNombre() + " " + getApellido() + " | Edad: " + getEdad() + " | Telefono: " + getTelefonoPaciente() + " | Puntaje Sisben: " + this.puntajeSisben;
    }
}
