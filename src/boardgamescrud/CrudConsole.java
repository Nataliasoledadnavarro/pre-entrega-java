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

    // Lee un número entero desde consola e implmenta validaciones.

    protected int readInt(String message) {
        while (true) {
            try {
                System.out.print(message);
                String input = scanner.nextLine().trim();
                int value = Integer.parseInt(input);

                if (value < 0) {
                    System.out.println("El número no puede ser negativo. Intente nuevamente.");
                    continue;
                }

                return value;
            } catch (NumberFormatException e) {
                System.out.println("Debe ser un número entero válido. Intente nuevamente.");
            }
        }
    }

    // Lee un número decimal (double) desde consola e implmenta validaciones.
    protected double readDouble(String message) {
        while (true) {
            try {
                System.out.print(message);
                String input = scanner.nextLine().trim();
                double value = Double.parseDouble(input);
                
                if (value < 0) {
                    System.out.println("El precio no puede ser negativo. Intente nuevamente.");
                    continue;
                }
                
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Debe ser un número válido (use punto para decimales). Intente nuevamente.");
            }
        }
    }
}