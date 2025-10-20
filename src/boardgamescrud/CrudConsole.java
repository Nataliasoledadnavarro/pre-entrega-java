//CrudConsole.java --> Clase genérica base
package boardgamescrud;

import java.util.Scanner;

// Clase base genérica para los CRUD por consola.
// Define la estructura general y métodos de utilidad comunes para todos los
// CRUD.

public abstract class CrudConsole {

    // Scanner compartido por todos los CRUD
    protected Scanner scanner = new Scanner(System.in);

    // Muestra el MENU principal del CRUD y gestiona las opciones seleccionadas.
    // Cada clase hija implementará su propio MENU.

    public abstract void showMenu();

    // Lee un texto desde consola validando que no esté vacío.

    protected String readString(String message) {
        System.out.print(message);
        String input = scanner.nextLine().trim();

        // Validación campo no vacío
        while (input.isEmpty()) {
            System.out.print("El valor no puede estar vacío. Intente nuevamente: ");
            input = scanner.nextLine().trim();
        }
        return input;
    }

    // Lee un número entero desde consola con validación básica.

    protected int readInt(String message) {
        System.out.print(message);
        while (!scanner.hasNextInt()) {
            System.out.print("Ingrese un número válido: ");
            scanner.next(); // limpiar entrada no válida
        }
        int value = scanner.nextInt();
        scanner.nextLine(); 
        return value;
    }

    // Lee un número decimal (double) desde consola con validación básica.

    protected double readDouble(String message) {
        System.out.print(message);
        while (!scanner.hasNextDouble()) {
            System.out.print("Ingrese un valor numérico válido: ");
            scanner.next();
        }
        double value = scanner.nextDouble();
        scanner.nextLine(); 
        return value;
    }
}
