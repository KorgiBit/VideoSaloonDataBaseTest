import java.util.HashMap;

public class GameCatalog {
    private HashMap<Integer, Integer> gameList = new HashMap<Integer, Integer>();
    private String catalogName;

    public GameCatalog(HashMap<Integer, Integer> gameList, String catalogName) {
        this.gameList = gameList;
        this.catalogName = catalogName;
    }

    public HashMap<Integer, Integer> getGameList() {
        return gameList;
    }

    public void setGameList(HashMap<Integer, Integer> gameList) {
        this.gameList = gameList;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }
}
