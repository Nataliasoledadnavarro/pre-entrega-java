//CrudGames.java --> CRUD principal de juegos

package boardgamescrud;

import java.util.ArrayList;

/**
 * CRUD específico para juegos.
 * Extiende CrudConsole<Game> para manejar objetos de tipo Game.
 */
public class CrudGames extends CrudConsole<Game> {

    private ArrayList<Category> categories; // Lista compartida de categorías

    // Constructor que recibe la lista compartida de categorías
    public CrudGames(ArrayList<Category> sharedCategories) {
        this.categories = sharedCategories;
    }

    @Override
    public void create() {
        System.out.println("\n--- Crear nuevo juego ---");

        // Valida que haya categorías disponibles
        if (categories.isEmpty()) {
            System.out.println("xxx Error: Crear al menos una categoría antes de crear juegos. xxx");
            System.out.println("Volver al menú principal y seleccionar el menú de categorías primero.");
            return;
        }

        int id = items.size() + 1; 
        String name = readString("Ingrese el nombre del juego: ");
        double price = readDouble("Ingrese el precio: ");
        Category selectedCategory = selectCategory();

        System.out.print("Seleccione el tipo de juego (1 = Físico / 2 = Digital): ");
        int typeOption = readInt("");

        Game newGame;

        if (typeOption == 1) {
            int players = readInt("Ingrese la cantidad de jugadores: ");
            String type = readString("Ingrese el tipo de juego: ");
            int playTime = readInt("Ingrese la duración promedio (en minutos): ");
            newGame = new BoardGame(id, name, price, selectedCategory, players, type, playTime);
        } else {
            String platform = readString("Ingrese la plataforma: ");
            newGame = new DigitalGame(id, name, price, selectedCategory, platform);
        }

        items.add(newGame);
        System.out.println("*** Juego creado correctamente. ***");
    }

    @Override
    public void list() {
        System.out.println("\n--- Lista de Juegos ---");
        
        if (items.isEmpty()) {
            System.out.println("xxx No hay juegos registrados. xxx");
            return;
        }

        for (Game game : items) {
            System.out.println(game.toString());
        }
    }

    @Override
    public void update() {
        System.out.println("\n--- Actualizar juego ---");
        
        if (items.isEmpty()) {
            System.out.println("xxx No hay juegos para actualizar. xxx");
            return;
        }

        list(); // Mostrar lista actual
        int id = readInt("Ingrese el ID del juego a actualizar: ");
        Game game = findGameById(id);

        if (game != null) {
            String newName = readString("Nuevo nombre (actual: " + game.getName() + "): ");
            double newPrice = readDouble("Nuevo precio (actual: " + game.getPrice() + "): ");

            game.setName(newName);
            game.setPrice(newPrice);
            System.out.println("*** Juego actualizado correctamente. ***");
        } else {
            System.out.println("xxx Juego no encontrado. xxx");
        }
    }

    @Override
    public void delete() {
        System.out.println("\n--- Eliminar juego ---");
        
        if (items.isEmpty()) {
            System.out.println("No hay juegos para eliminar.");
            return;
        }

        list(); // Mostrar lista actual
        int id = readInt("Ingrese el ID del juego a eliminar: ");
        Game game = findGameById(id);

        if (game != null) {
            items.remove(game);
            System.out.println("*** Juego eliminado correctamente. ***");
        } else {
            System.out.println("xxx Juego no encontrado. xxx");
        }
    }

    // Métodos auxiliares específicos de CrudGames
    private Category selectCategory() {
        System.out.println("\n--- Seleccionar categoría ---");
        
        for (int i = 0; i < categories.size(); i++) {
            System.out.println((i + 1) + ". " + categories.get(i).getName());
        }
        
        int option;
        while (true) {
            option = readInt("Seleccione una categoría (1-" + categories.size() + "): ");
            if (option >= 1 && option <= categories.size()) {
                return categories.get(option - 1);
            }
            System.out.println("xxx Opción inválida. Intente nuevamente. xxx");
        }
    }

    private Game findGameById(int id) {
        for (Game game : items) {
            if (game.getId() == id) {
                return game;
            }
        }
        return null;
    }
}
