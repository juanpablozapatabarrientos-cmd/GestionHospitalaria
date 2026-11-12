
package grupo.gestionhospital.Modelo;

public abstract class Paciente {
    private int idPaciente;
    private String nombre;
    private String apellido;
    private int edad;
    private String telefonoPaciente;
    
    public Paciente(int idPaciente, String nombre, String apellido,
            int edad, String telefonoPaciente){
        this.idPaciente = idPaciente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.telefonoPaciente = telefonoPaciente;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTelefonoPaciente() {
        return telefonoPaciente;
    }

    public void setTelefonoPaciente(String telefonoPaciente) {
        this.telefonoPaciente = telefonoPaciente;
    }
    
    public abstract void mostrarInformacion();
    
    //Falta crear metodo abstracto "ToCsv"
    
}
