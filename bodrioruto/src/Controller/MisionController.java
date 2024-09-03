/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.Mision;
import Model.MisionDAO;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;


public class MisionController {
  private MisionDAO misionDAO;
    
    public MisionController(){
        this.misionDAO = new MisionDAO();
    }
    
     public void crearMisiones(Scanner scanner) {
        try {
            System.out.print("Descripcion de la Mision: ");
            String descripcion = scanner.nextLine();

            System.out.print("Rango del Ninja: ");
            String rango = scanner.nextLine();

            System.out.print("recompensa del ninja por la mision: ");
            String recompensa = scanner.nextLine();

            Mision misiones = new Mision(descripcion, rango, recompensa);

            misionDAO.addMision(misiones);

            System.out.println("mision creado con éxito.");
        } catch (SQLException e) {
            mostrarError("Error al agregar el evento: " + e.getMessage());
        } catch (NumberFormatException e) {
            mostrarError("Error en el formato de número: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            mostrarError("Error en el estado o formato de fecha: " + e.getMessage());
        }
    }

    public void listarMisiones() {
        try {
            List<Mision> misiones = misionDAO.listarMision();
            if (misiones.isEmpty()) {
                System.out.println("No hay mision para mostrar.");
            } else {
                // Uso de Stream API para mostrar eventos
                misiones.stream()
                    .forEach(mision -> {
                        System.out.println(mision);
                        System.out.println(); // Línea en blanco para separación
                    });
            }
        } catch (SQLException e) {
            mostrarError("Error al mision eventos: " + e.getMessage());
        }
    }
    
    private void mostrarError(String mensaje) {
        System.err.println(mensaje);
    }
    
}
