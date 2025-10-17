package boardgamescrud;
 // Subclase concreta que representa un juego de mesa físico.
 // Hereda de Game e implementa el método abstracto showDetails().

public class BoardGame extends Game {

    // Atributos específicos del juego de mesa
    private int players; // cantidad de jugadores recomendada
    private String type; // tipo de juego (estrategia, party, familiar, etc.)
    private int playTime; // duración promedio de la partida (en minutos)

    // Constructor vacío
    public BoardGame() {
    }

    // constructor con parámetros (incluye atributos heredados)
    public BoardGame(int id, String name, double price, Category category, int players, String type, int playTime) {
        super(id, name, price, category);
        this.players = players;
        this.type = type;
        this.playTime = playTime;
    }

    // getters y Setters
    public int getPlayers() {
        return players;
    }

    public void setPlayers(int players) {
        this.players = players;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPlayTime() {
        return playTime;
    }

    public void setPlayTime(int playTime) {
        this.playTime = playTime;
    }

    // Implementación del método abstracto showDetails()
    @Override
    public void showDetails() {
        System.out.println("=== Board Game Details ===");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Price: $" + price);
        System.out.println("Category: " + (category != null ? category.getName() : "No category"));
        System.out.println("Players: " + players);
        System.out.println("Type: " + type);
        System.out.println("Play Time: " + playTime + " minutes");
        System.out.println("===========================");
    }

    // listados generales
    @Override
    public String toString() {
        return super.toString() + " | Players: " + players + " | Type: " + type + " | Play Time: " + playTime + " min";
    }
}
