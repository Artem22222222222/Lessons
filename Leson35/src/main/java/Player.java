public class Player {
    private String name;
    private int level;
    private int characters_id;
    private int account_id;

    public Player(String name, int level, int characters_id, int account_id) {
        this.name = name;
        this.level = level;
        this.characters_id = characters_id;
        this.account_id = account_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getCharacters_id() {
        return characters_id;
    }

    public void setCharacters_id(int characters_id) {
        this.characters_id = characters_id;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }
}
