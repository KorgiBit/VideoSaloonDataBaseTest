import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException {
        ArrayList<Game> strategyGames = new ArrayList<>();
        strategyGames.add(new Game(1,
                "Civilization",
                "economical strategy",
                2010));

        ArrayList<Person> customersList = new ArrayList<>();
        customersList.add(new Person(1, "Асмодей"));

        DB.openConnection();
        DB.addGame("Stalker", "Action", 2005);

        DB.closeConnection();
    }

}