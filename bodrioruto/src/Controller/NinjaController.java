/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Ninja;
import Model.NinjaDAO;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author camper
 */
public class NinjaController {
    private NinjaDAO ninjaDAO;
    
    public NinjaController(){
        this.ninjaDAO = new NinjaDAO();
    }
    
     public void crearNinja(Scanner scanner) {
        try {
            System.out.print("Nombre del Ninja: ");
            String nombre = scanner.nextLine();

            System.out.print("Rango del Ninja: ");
            String rango = scanner.nextLine();

            System.out.print("Aldea del ninja: ");
            String aldea = scanner.nextLine();

            Ninja ninja = new Ninja(nombre, rango, aldea);

            ninjaDAO.addNinja(ninja);

            System.out.println("Evento creado con éxito.");
        } catch (SQLException e) {
            mostrarError("Error al agregar el evento: " + e.getMessage());
        } catch (NumberFormatException e) {
            mostrarError("Error en el formato de número: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            mostrarError("Error en el estado o formato de fecha: " + e.getMessage());
        }
    }

    public void listarNinjas() {
        try {
            List<Ninja> ninjas = ninjaDAO.listarNinjas();
            if (ninjas.isEmpty()) {
                System.out.println("No hay eventos para mostrar.");
            } else {
                // Uso de Stream API para mostrar eventos
                ninjas.stream()
                    .forEach(ninja -> {
                        System.out.println(ninja);
                        System.out.println(); // Línea en blanco para separación
                    });
            }
        } catch (SQLException e) {
            mostrarError("Error al listar eventos: " + e.getMessage());
        }
    }
    
    private void mostrarError(String mensaje) {
        System.err.println(mensaje);
    }
    
}
