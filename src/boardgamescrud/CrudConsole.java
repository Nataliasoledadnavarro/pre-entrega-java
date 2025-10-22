//CrudConsole.java --> Clase genérica base
package boardgamescrud;

import java.util.Scanner;
import java.util.ArrayList;

// Clase base genérica para los CRUD por consola.
// T representa el tipo de entidad que manejará (Game, Category, etc.)

public abstract class CrudConsole<T> {

    // Scanner compartido por todos los CRUD
    protected Scanner scanner = new Scanner(System.in);
    // Lista genérica que cada subclase inicializará
    protected ArrayList<T> items = new ArrayList<>();

    // Métodos abstractos que cada subclase debe implementar
    public abstract void create();

    public abstract void list();

    public abstract void update();

    public abstract void delete();

    // Metodo para que cada subclase defina su título
    public abstract String getMenuTitle();

    // Método para mostrar el menú (reutilizarn todos)
    public void showMenu() {
        int option;
        do {
            System.out.println("\n===== " + getMenuTitle() + " ====="); 
            System.out.println("1. Crear");
            System.out.println("2. Listar");
            System.out.println("3. Actualizar");
            System.out.println("4. Eliminar");
            System.out.println("0. Volver al menú principal");
            option = readInt("Seleccione una opción: ");

            switch (option) {
                case 1 -> create();
                case 2 -> list();
                case 3 -> update();
                case 4 -> delete();
                case 0 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("xxx Opción inválida. Intente nuevamente. xxx");
            }

        } while (option != 0);
    }

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