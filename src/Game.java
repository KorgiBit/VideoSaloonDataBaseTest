public class Game
{
    private int gameId;
    private String gameName;
    private String gameGenre;
    private int gameYearOfPublishing;

    public Game(int gameId, String gameName, String gameGenre, int gameYearOfPublishing) {
        this.gameId = gameId;
        this.gameName = gameName;
        this.gameGenre = gameGenre;
        this.gameYearOfPublishing = gameYearOfPublishing;
    }

    public int getGameId() {
        return gameId;
    }

    public String getGameName() {
        return gameName;
    }

    public String getGameGenre() {
        return gameGenre;
    }

    public int getGameYearOfPublishing() {
        return gameYearOfPublishing;
    }
}
