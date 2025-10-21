//Category.java --> Entidad independiente
package boardgamescrud;
// Clase simple que representa la categoría del juego.

public class Category {

    private int id;
    private String name;
    private String description;

    // Constructor vacío
    public Category() {
    }

    // Constructor con parámetros
    public Category(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("El ID no puede ser negativo.");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("La descipción es requerida.");
        }
        this.description = description;
    }

    // Método para mostrar información
    @Override
    public String toString() {
        return "ID: " + id + " | Categoría: " + name + " | Descripción: " + description;
    }
}
