import java.sql.*;

public class DataBase {
    // URL для підключення до бази даних
    static String url = "jdbc:postgresql://localhost:5432/base2";
    // Ім'я користувача
    static String user = "postgres";
    // Пароль
    static String password = "252525b1";

    Connection connection = null;
    public DataBase() {
        createTables();
    }
    public void addPlayer(Player player) {
        String name = player.getName();
        int level = player.getLevel();
        int characters_id = player.getCharacters_id();
        int account_id = player.getAccount_id();
        try (Connection connection = connect()) {
            String insertSQL = "INSERT INTO players (name, level, character_id, account_id) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(insertSQL);
            statement.setString(1, name);
            statement.setInt(2, level);
            statement.setInt(3, characters_id);
            statement.setInt(4, account_id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }
    public void addCharacter(Character character) {
        String name = character.getName();
        int power = character.getPower();
        try (Connection connection = connect()) {
            String insertSQL = "INSERT INTO characters (name, power) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(insertSQL);
            statement.setString(1, name);
            statement.setInt(2, power);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }
    public void getPlayerPurchases(int playerId) {
        String SQL = "INSERT INTO accounts (name, power) " +
                "SELECT p.name, c.power " +
                "FROM players p " +
                "JOIN characters c ON c.id = p.character_id " +
                "WHERE p.id = ?;";
        try (Connection conn = connect();
             PreparedStatement pstat = conn.prepareStatement(SQL)) {

            pstat.setInt(1, playerId);
            pstat.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void createTables() {
        String sqlP = "CREATE TABLE IF NOT EXISTS players (" +
                "id SERIAL PRIMARY KEY," +
                "name VARCHAR(255) NOT NULL," +
                "level INTEGER NOT NULL," +
                "character_id INTEGER NOT NULL, " +
                "account_id INTEGER NOT NULL" +
                ");";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {

            stmt.execute(sqlP);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        String sqlC = "CREATE TABLE IF NOT EXISTS characters (" +
                "id SERIAL PRIMARY KEY," +
                "name VARCHAR(255) NOT NULL," +
                "power INTEGER NOT NULL"+
                ");";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {

            stmt.execute(sqlC);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        String sqlA = "CREATE TABLE IF NOT EXISTS accounts (" +
                "id SERIAL PRIMARY KEY," +
                "name VARCHAR(255) NOT NULL," +
                "power INTEGER NOT NULL"+
                ");";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {

            stmt.execute(sqlA);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
