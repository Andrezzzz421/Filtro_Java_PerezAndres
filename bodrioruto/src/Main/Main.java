package Main;
import Controller.*;
import Database.ConectionDB;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    
    private static NinjaController ninjaController;
    private static HabilidadController habilidadController;
    private static MisionController misionController;
    
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ConectionDB.init();
        
        ninjaController = new NinjaController();
        habilidadController = new HabilidadController();
        misionController = new MisionController();
        
        // Menú principal
        while (true) {
            displayMenu("Menú Para Ninjas pro", new String[]{
                "1. Gestión de Ninjas",
                "2. Gestion de Habilidades",
                "3. Gestion de Misiones",
                "4. Salir"
            });
            int choice = getChoice(1, 4);

            switch (choice) {
                case 1 -> menuGestionNinjas();
                case 2 -> menuGestionHabilidades();
                case 3 -> menuGestionMision();
                case 4 -> {
System.out.println("Saliendo... Hasta luego!");
scanner.close();
return;
                }
                default -> System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }
    }

    
    
        private static void menuGestionNinjas() {
        while (true) {
            displayMenu("Gestión de Ninjas", new String[]{
                "1. Crear Ninjas",
                "2. Listar ninjas",
                "3. Volver al menú principal"
            });
            int choice = getChoice(1, 3);

            switch (choice) {
                case 1 -> ninjaController.crearNinja(scanner);
                case 2 -> ninjaController.listarNinjas();
                case 3 -> {
                    return;
                }
                default -> System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }
    }
        
        private static void menuGestionHabilidades() {
        while (true) {
            displayMenu("Gestión de Habilidades", new String[]{
                "1. Crear Habilidades",
                "2. Listar Habilidades",
                "3. Volver al menú principal"
            });
            int choice = getChoice(1, 3);

            switch (choice) {
                case 1 -> habilidadController.crearHabilidad(scanner);
                case 2 -> habilidadController.listarHabilidades();
                case 3 -> {
                    return;
                }
                default -> System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }
    }
        
        private static void menuGestionMision() {
        while (true) {
            displayMenu("Gestión de Mision", new String[]{
                "1. Crear Mision",
                "2. Listar Mision",
                "3. Volver al menú principal"
            });
            int choice = getChoice(1, 3);

            switch (choice) {
                case 1 -> misionController.crearMisiones(scanner);
                case 2 -> misionController.listarMisiones();
                case 3 -> {
                    return;
                }
                default -> System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }
    }
    private static void displayMenu(String title, String[] options) {
        System.out.println("\n" + title);
        System.out.println("--------------------------------------------------");
        for (String option : options) {
            System.out.println(option);
        }
        System.out.println("--------------------------------------------------");
        System.out.print("Seleccione una opción: ");
    }

    private static int getChoice(int min, int max) {
        while (true) {
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice >= min && choice <= max) {
                    return choice;
                }
                System.out.println("Opción fuera de rango. Intente de nuevo.");
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
            }
        }
    }
}


