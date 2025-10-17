//Game.java --> Clase abstracta base (heredada por otras)
package boardgamescrud;

// Clase abstracta base que representa un juego genérico.

public abstract class Game {

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
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public abstract void showDetails();

    @Override
    public String toString() {
        return "ID: " + id +
                " | Nombre: " + name +
                " | Precio: $" + price +
                " | Categoría: " + (category != null ? category.getName() : "Sin categoría");
    }
}
