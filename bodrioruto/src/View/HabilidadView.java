/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;
import Model.Habilidad;
import java.util.List;

public class HabilidadView {
    public void displayHabilidadDetails(Habilidad habilidad) {
        System.out.println(habilidad);
    }

    public void displayAllHabilidades(List<Habilidad> habilidades) {
        for (Habilidad habilidad : habilidades) {
            displayHabilidadDetails(habilidad);
        }
    }

    public void displayHabilidadCreated() {
        System.out.println("Ninja creado exitosamente.");
    }

    public void displayHabilidadNotFound() {
        System.out.println("Ninja no encontrado.");
    }
}
