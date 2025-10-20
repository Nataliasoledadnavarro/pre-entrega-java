// Main.java --> Punto de entrada con MENU

package boardgamescrud;

import java.util.Scanner;

//Clase principal del sistema.
// Orquesta los diferentes CRUD del proyecto (juegos, CATEGORIAS, etc.).

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        CrudGames crudGames = new CrudGames();
        CrudCategories crudCategories = new CrudCategories();

        int option;

        do {
            System.out.println("\n===== MENU PRINCIPAL - TIENDA DE JUEGOS =====");
            System.out.println("1. Gestionar juegos");
            System.out.println("2. Gestionar CATEGORIAS");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Ingrese un número válido: ");
                scanner.next();
            }

            option = scanner.nextInt();
            scanner.nextLine(); 

            switch (option) {
                case 1 -> crudGames.showMenu();
                case 2 -> crudCategories.showMenu();
                case 0 -> System.out.println("Saliendo del sistema. ¡Gracias por visitar la tienda de juegos!");
                default -> System.out.println("Opción inválida. Intente nuevamente.");
            }

        } while (option != 0);

        scanner.close();
    }
}
