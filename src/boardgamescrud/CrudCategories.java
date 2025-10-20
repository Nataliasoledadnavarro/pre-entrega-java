//CrudCategories.java --> CRUD auxiliar
package boardgamescrud;

import java.util.ArrayList;

// CRUD de CATEGORIAS.
// Permite crear, listar, modificar y eliminar CATEGORIAS desde consola.

public class CrudCategories extends CrudConsole {

    private ArrayList<Category> categories;

    // Constructor que recibe la lista compartida
    public CrudCategories(ArrayList<Category> sharedCategories) {
        this.categories = sharedCategories;
    }

    @Override
    public void showMenu() {
        int option;
        do {
            System.out.println("\n===== MENU CRUD DE CATEGORIAS =====");
            System.out.println("1. Crear categoría");
            System.out.println("2. Listar CATEGORIAS");
            System.out.println("3. Modificar categoría");
            System.out.println("4. Eliminar categoría");
            System.out.println("0. Volver al MENU principal");
            option = readInt("Seleccione una opción: ");

            switch (option) {
                case 1 -> createCategory();
                case 2 -> listCategories();
                case 3 -> updateCategory();
                case 4 -> deleteCategory();
                case 0 -> System.out.println("Volviendo al MENU principal...");
                default -> System.out.println("Opción inválida. Intente nuevamente.");
            }

        } while (option != 0);
    }

    // Crear nueva categoría
    private void createCategory() {
        System.out.println("\n--- Crear nueva categoría ---");
        int id = categories.size() + 1;
        String name = readString("Ingrese el nombre de la categoría: ");
        String description = readString("Ingrese una breve descripción: ");

        Category newCategory = new Category(id, name, description);
        categories.add(newCategory);
        System.out.println("Categoría creada correctamente.");
    }

    // Listar todas las CATEGORIAS
    private void listCategories() {
        System.out.println("\n--- Lista de CATEGORIAS ---");
        if (categories.isEmpty()) {
            System.out.println("No hay CATEGORIAS cargadas.");
            return;
        }

        for (Category c : categories) {
            System.out.println(c);
        }
    }

    // Modificar una categoría
    private void updateCategory() {
        System.out.println("\n--- Modificar categoría ---");
        if (categories.isEmpty()) {
            System.out.println("No hay CATEGORIAS para modificar.");
            return;
        }

        int id = readInt("Ingrese el ID de la categoría a modificar: ");
        Category category = findCategoryById(id);

        if (category == null) {
            System.out.println("No se encontró una categoría con ese ID.");
            return;
        }

        String newName = readString("Nuevo nombre (" + category.getName() + "): ");
        String newDescription = readString("Nueva descripción (" + category.getDescription() + "): ");

        category.setName(newName);
        category.setDescription(newDescription);

        System.out.println("Categoría actualizada correctamente.");
    }

    // Eliminar una categoría
    private void deleteCategory() {
        System.out.println("\n--- Eliminar categoría ---");
        if (categories.isEmpty()) {
            System.out.println("No hay CATEGORIAS para eliminar.");
            return;
        }

        int id = readInt("Ingrese el ID de la categoría a eliminar: ");
        Category category = findCategoryById(id);

        if (category == null) {
            System.out.println("No se encontró una categoría con ese ID.");
            return;
        }

        categories.remove(category);
        System.out.println("Categoría eliminada correctamente.");
    }

    // Buscar categoría por ID
    private Category findCategoryById(int id) {
        for (Category c : categories) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    // Getter para usar desde otros CRUD
    public ArrayList<Category> getCategories() {
        return categories;
    }
}
