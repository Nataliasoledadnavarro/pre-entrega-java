//CrudGames.java --> CRUD principal de juegos

package boardgamescrud;

import java.util.ArrayList;

/**
 * CRUD de juegos (físicos y digitales).
 * Permite crear, listar, modificar y eliminar elementos del ArrayList.
 */
public class CrudGames extends CrudConsole {

    private ArrayList<Game> games = new ArrayList<>();

    @Override
    public void showMenu() {
        int option;
        do {
            System.out.println("\n===== MENU CRUD DE JUEGOS =====");
            System.out.println("1. Crear juego");
            System.out.println("2. Listar juegos");
            System.out.println("3. Modificar juego");
            System.out.println("4. Eliminar juego");
            System.out.println("0. Volver al MENU principal");
            option = readInt("Seleccione una opción: ");

            switch (option) {
                case 1 -> createGame();
                case 2 -> listGames();
                case 3 -> updateGame();
                case 4 -> deleteGame();
                case 0 -> System.out.println("Volviendo al MENU principal...");
                default -> System.out.println("Opción inválida. Intente nuevamente.");
            }

        } while (option != 0);
    }

    // Crear un nuevo juego
    private void createGame() {
        System.out.println("\n--- Crear nuevo juego ---");

        int id = games.size() + 1;
        String name = readString("Ingrese el nombre del juego: ");
        double price = readDouble("Ingrese el precio: ");

        System.out.print("Seleccione el tipo de juego (1 = Físico / 2 = Digital): ");
        int typeOption = readInt("");

        Game newGame;

        if (typeOption == 1) {
            int players = readInt("Ingrese la cantidad de jugadores: ");
            String type = readString("Ingrese el tipo de juego (ej. Estrategia, Colaborativo, Familiar...): ");
            int playTime = readInt("Ingrese la duración promedio (en minutos): ");
            newGame = new BoardGame(id, name, price, null, players, type, playTime);
        } else {
            String platform = readString("Ingrese la plataforma (PC, Mobile, etc.): ");
            newGame = new DigitalGame(id, name, price, null, platform);
        }

        games.add(newGame);
        System.out.println("✅ Juego creado correctamente.");
    }

    //Listar todos los juegos
    private void listGames() {
        System.out.println("\n--- Lista de juegos ---");
        if (games.isEmpty()) {
            System.out.println("No hay juegos cargados.");
            return;
        }

        for (Game g : games) {
            System.out.println(g);
        }
    }

    // EDitar un juego 
    private void updateGame() {
        System.out.println("\n--- Modificar juego ---");
        if (games.isEmpty()) {
            System.out.println("No hay juegos para modificar.");
            return;
        }

        int id = readInt("Ingrese el ID del juego a modificar: ");
        Game game = findGameById(id);

        if (game == null) {
            System.out.println("No se encontró un juego con ese ID.");
            return;
        }

        String newName = readString("Ingrese el nuevo nombre (" + game.getName() + "): ");
        double newPrice = readDouble("Ingrese el nuevo precio (" + game.getPrice() + "): ");

        game.setName(newName);
        game.setPrice(newPrice);

        System.out.println("Juego actualizado correctamente.");
    }

    //  Eliminar un juego
    private void deleteGame() {
        System.out.println("\n--- Eliminar juego ---");
        if (games.isEmpty()) {
            System.out.println("No hay juegos para eliminar.");
            return;
        }

        int id = readInt("Ingrese el ID del juego a eliminar: ");
        Game game = findGameById(id);

        if (game == null) {
            System.out.println("No se encontró un juego con ese ID.");
            return;
        }

        games.remove(game);
        System.out.println("Juego eliminado correctamente.");
    }

    // Buscar juego por ID
    private Game findGameById(int id) {
        for (Game g : games) {
            if (g.getId() == id) {
                return g;
            }
        }
        return null;
    }
}
