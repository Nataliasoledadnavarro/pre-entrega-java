//CrudCategories.java --> CRUD auxiliar
package boardgamescrud;
import java.util.ArrayList;
/**
 * CRUD específico para categorías.
 * Extiende CrudConsole<Category> para manejar objetos de tipo Category.
 */
public class CrudCategories extends CrudConsole<Category> {

    @Override
    public void create() {
        System.out.println("\n--- Crear nueva categoría ---");

        int id = items.size() + 1;
        String name = readString("Ingrese el nombre de la categoría: ");
        String description = readString("Ingrese la descripción: ");

        Category newCategory = new Category(id, name, description);
        items.add(newCategory);
        System.out.println("*** Categoría creada correctamente. ***");
    }

    @Override
    public void list() {
        System.out.println("\n--- Lista de Categorías ---");
        
        if (items.isEmpty()) {
            System.out.println("xxx No hay categorías registradas. xxx");
            return;
        }

        for (Category category : items) {
            System.out.println(category.toString());
        }
    }

    @Override
    public void update() {
        System.out.println("\n--- Actualizar categoría ---");
        
        if (items.isEmpty()) {
            System.out.println("xxx No hay categorías para actualizar. xxx");
            return;
        }

        list();
        int id = readInt("Ingrese el ID de la categoría a actualizar: ");
        Category category = findCategoryById(id);

        if (category != null) {
            String newName = readString("Nuevo nombre (actual: " + category.getName() + "): ");
            String newDescription = readString("Nueva descripción (actual: " + category.getDescription() + "): ");

            category.setName(newName);
            category.setDescription(newDescription);
            System.out.println("*** Categoría actualizada correctamente. ***");
        } else {
            System.out.println("xxx Categoría no encontrada. xxx");
        }
    }

    @Override
    public void delete() {
        System.out.println("\n--- Eliminar categoría ---");
        
        if (items.isEmpty()) {
            System.out.println("xxx No hay categorías para eliminar. xxx");
            return;
        }

        list();
        int id = readInt("Ingrese el ID de la categoría a eliminar: ");
        Category category = findCategoryById(id);

        if (category != null) {
            items.remove(category);
            System.out.println("*** Categoría eliminada correctamente. ***");
        } else {
            System.out.println("xxx Categoría no encontrada. xxx");
        }
    }

    // Método auxiliar específico
    private Category findCategoryById(int id) {
        for (Category category : items) {
            if (category.getId() == id) {
                return category;
            }
        }
        return null;
    }

    // Método para obtener la lista (para compartir con CrudGames)
    public ArrayList<Category> getItems() {
        return items;
    }
}
