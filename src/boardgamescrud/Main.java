// Main.java --> Punto de entrada con menú

package boardgamescrud;

public class Main {
    public static void main(String[] args) {
        // Prueba de compilación
        Category category = new Category(1, "Estrategia", "Juegos de estrategia por turnos");
        BoardGame game1 = new BoardGame(1, "Catan", 15000, category, 4, "Estrategia", 60);
        DigitalGame game2 = new DigitalGame(2, "Monopoly Digital", 12000, category, "PC");

        game1.showDetails();
        game2.showDetails();
    }
}
