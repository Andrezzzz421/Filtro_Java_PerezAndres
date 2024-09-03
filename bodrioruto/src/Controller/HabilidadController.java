/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.Habilidad;
import Model.HabilidadDAO;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class HabilidadController {
    private HabilidadDAO habilidadDAO;
    
    public HabilidadController(){
        this.habilidadDAO = new HabilidadDAO();
    }
    
public void crearHabilidad(Scanner scanner) {
        try {
            System.out.print("id del Ninja: ");
            int idNinja = scanner.nextInt();

            System.out.print("Nombre de la habilidad: ");
            String nombre = scanner.nextLine();

            System.out.print("Descripcion de la habilidad: ");
            String descripcion = scanner.nextLine();

            Habilidad habilidad = new Habilidad(idNinja, nombre, descripcion);

            habilidadDAO.addHabilidad(habilidad);

            System.out.println("habilidad creado con éxito.");
        } catch (SQLException e) {
            mostrarError("Error al agregar la habilidad: " + e.getMessage());
        } catch (NumberFormatException e) {
            mostrarError("Error en el formato de número: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            mostrarError("Error en el estado o formato de fecha: " + e.getMessage());
        }
    }
    
    public void listarHabilidades() {
        try {
            List<Habilidad> habilidades = habilidadDAO.listarHabilidades();
            if (habilidades.isEmpty()) {
                System.out.println("No hay habilidades para mostrar.");
            } else {
                // Uso de Stream API para mostrar eventos
                habilidades.stream()
                    .forEach(habilidad -> {
                        System.out.println(habilidad);
                        System.out.println(); // Línea en blanco para separación
                    });
            }
        } catch (SQLException e) {
            mostrarError("Error al listar habilidades: " + e.getMessage());
        }
    }
    
    private void mostrarError(String mensaje) {
        System.err.println(mensaje);
    }
}
