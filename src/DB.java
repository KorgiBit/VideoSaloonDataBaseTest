import java.sql.*;

public class DB {
    private static Connection connection;
    private static final String database = "GameCatalog.db";
    private static final String gameCatalogTable = "gameCatalog";
    private static final String recordsTable = "records";


    public static void openConnection() throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:" + database);
    }
    public static void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    public static void createTableForCatalog() throws SQLException {
        Statement statement = connection.createStatement();
        String SQL = """
            CREATE TABLE IF NOT EXISTS gameCatalog (
            ID            INTEGER PRIMARY KEY AUTOINCREMENT,
            gameName       STRING,
            gameGenre      STRING,
            publishingYear INTEGER
            )""";
        statement.executeUpdate(SQL);
    }
    public static void createTableForRecords() throws SQLException {
        Statement statement = connection.createStatement();
        String SQL = """
            CREATE TABLE IF NOT EXISTS records (
            ID            INTEGER PRIMARY KEY AUTOINCREMENT,
            personId       STRING,
            gameExemplaryId      STRING,
            dateOfRent DATETIME,
            dateOfReturn DATETIME
            )""";
        statement.executeUpdate(SQL);
    }
    public static void createTableForGameExemplary() throws SQLException {
        Statement statement = connection.createStatement();
        String SQL = """
            CREATE TABLE IF NOT EXISTS gameExemplary (
            exemplaryID  INTEGER PRIMARY KEY AUTOINCREMENT,
            gameId       INTEGER
            )""";
        statement.executeUpdate(SQL);
    }

    static void addGame(String gameName, String gameGenre,Integer publishingYear) throws SQLException {
            String SQL = "INSERT INTO " + gameCatalogTable + " (gameName, gameGenre, publishingYear) VALUES (?,?,?)";
            PreparedStatement insertStatement = connection.prepareStatement(SQL);
            insertStatement.setString(1, gameName);
            insertStatement.setString(2, gameGenre);
            insertStatement.setInt(3, publishingYear);
            insertStatement.executeUpdate();  // Метод, запускающий сформированный запрос
            // Дополнительная (необязательная) проверка сгенерированного ID:
            // если ID был сгенерирован, значит пользователь был добавлен
            ResultSet generatedKeys = insertStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                System.out.format("Добавлена игра %s с ID: %d \n",
                        gameName, generatedKeys.getLong(1));
            }
    }
    static void makeRecord(int personId, int gameExamplaryId) throws SQLException {
        String SQL = "INSERT INTO " + recordsTable + " (personId, gameExemplaryId, dateOfRent) VALUES (?,?,?)";
        PreparedStatement insertStatement = connection.prepareStatement(SQL);
        insertStatement.setInt(1, personId);
        insertStatement.setInt(2, gameExamplaryId);
        java.util.Date currentDate = new java.util.Date();
        long currentTimeMillis = currentDate.getTime();
        java.sql.Date sqlDate = new java.sql.Date(currentTimeMillis);
        insertStatement.setDate(3, sqlDate);
        insertStatement.executeUpdate();


        ResultSet generatedKeys = insertStatement.getGeneratedKeys();
        if (generatedKeys.next()) {
            System.out.format("Добавлена запись с ID: %d\n", generatedKeys.getLong(1));
            System.out.format("Человек с ID: %d взял игру с ID: %d\n", personId, gameExamplaryId);
        }
    }
}
