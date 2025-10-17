// DigitalGame.java --> Subclase 2 de Game
package boardgamescrud;
// Subclase concreta que representa un juego digital.

// Hereda de Game e implementa el método abstracto showDetails().

public class DigitalGame extends Game {

    // Atributo específico del juego digital
    private String platform; // plataforma del juego (PC, Mobile, etc.)

    // Constructor vacío
    public DigitalGame() {
    }

    // Agrego parametros al cronstructor
    public DigitalGame(int id, String name, double price, Category category, String platform) {
        super(id, name, price, category);
        this.platform = platform;
    }

    // Getter y Setter
    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    // Implementación del método abstracto showDetails()
    @Override
    public void showDetails() {
        System.out.println("=== Digital Game Details ===");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Price: $" + price);
        System.out.println("Category: " + (category != null ? category.getName() : "No category"));
        System.out.println("Platform: " + platform);
        System.out.println("============================");
    }

    // toString() para listados generales
    @Override
    public String toString() {
        return super.toString() + " | Platform: " + platform;
    }

    @Override
    public double calculateFinalPrice() {
        // descuento del 10% para juegos digitales
        return price * 0.9;
    }

}
