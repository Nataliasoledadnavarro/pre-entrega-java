//Game.java --> Clase abstracta base (heredada por otras)
package boardgamescrud;

// Clase abstracta base que representa un juego genérico.

public abstract class Game implements Sellable {

    protected int id;
    protected String name;
    protected double price;
    protected Category category;

    public Game() {
    }

    public Game(int id, String name, double price, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("El ID no puede ser negativo");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        this.name = name.trim();
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        if (category == null) {
            throw new IllegalArgumentException("La categoría es requerida");
        }
        if (category.getName() == null || category.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("La categoría debe tener un nombre válido");
        }
        this.category = category;
    }

    public abstract void showDetails();

    @Override
    public String toString() {
        return "ID: " + id +
                " | Nombre: " + name +
                " | Precio: $" + price +
                " | Categoría: " + category.getName();
    }

    @Override
    public double calculateFinalPrice() {
        // Precio base sin descuentos, puede sobreescribirse en subclases
        return price;
    }

}
