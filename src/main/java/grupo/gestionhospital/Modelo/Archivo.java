
package grupo.gestionhospital.Modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Archivo {
    public static void guardarPacientesEPS(List listaEps, String nombreArchivo) {
        if (listaEps == null || listaEps.isEmpty()) {
            System.out.println("La lista de pacientes EPS está vacía. No hay datos para guardar.");
            return;
        }
        try (PrintWriter pw = new PrintWriter(new FileWriter(nombreArchivo))) {
            pw.println("id,nombre,apellido,edad,telefono,eps");

            Node actual = listaEps.first();
            while (actual != null) {
                if (actual.getData() instanceof PacienteEps) {
                    PacienteEps p = (PacienteEps) actual.getData();
                    pw.println(p.getIdPaciente() + "," +
                               p.getNombre() + "," +
                               p.getApellido() + "," +
                               p.getEdad() + "," +
                               p.getTelefonoPaciente() + "," +
                               p.getNombreEps());
                }
                actual = actual.getNext();
            }
            System.out.println("Archivo " + nombreArchivo + " guardado con éxito.");
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo EPS: " + e.getMessage());
        }
    }
    public static void guardarPacientesSisben(List listaSisben, String nombreArchivo) {
        if (listaSisben == null || listaSisben.isEmpty()) {
            System.out.println("La lista de pacientes SISBEN está vacía. No hay datos para guardar.");
            return;
        }

        try (PrintWriter pw = new PrintWriter(new FileWriter(nombreArchivo))) {
            pw.println("id,nombre,apellido,edad,telefono,puntajeSisben");

            Node actual = listaSisben.first();
            while (actual != null) {
                if (actual.getData() instanceof PacienteSisben) {
                    PacienteSisben p = (PacienteSisben) actual.getData();
                    pw.println(p.getIdPaciente() + "," +
                               p.getNombre() + "," +
                               p.getApellido() + "," +
                               p.getEdad() + "," +
                               p.getTelefonoPaciente() + "," +
                               p.getPuntajeSisben());
                    }
                actual = actual.getNext();
            }
            System.out.println("Archivo " + nombreArchivo + " guardado con éxito.");
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo SISBEN: " + e.getMessage());
        }
    }
    
}
