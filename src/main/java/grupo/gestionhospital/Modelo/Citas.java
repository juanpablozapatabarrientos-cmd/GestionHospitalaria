
package grupo.gestionhospital.Modelo;


public class Citas {
    
    private int consecutivo;
    private int idPaciente;
    private String especialidad;
    
    public Citas(int consecutivo ,int idPaciente, String especialidad){
        this.consecutivo = consecutivo;
        this.idPaciente = idPaciente;
        this.especialidad  = especialidad;
    }

    public int getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(int consecutivo) {
        this.consecutivo = consecutivo;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    @Override
    public String toString() {
        return "Cita #" + consecutivo + " | ID Paciente: " + idPaciente + " | Especialidad: " + especialidad;
    }
    
}
