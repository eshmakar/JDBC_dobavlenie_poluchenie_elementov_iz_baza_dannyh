public class Connections {//все настройки подключения здесь
    public static final String URL = "jdbc:mysql://localhost:3306/cars";
    public static final String LOGIN = "root";
    public static final String PASSWORD = "root";
    public static void registerDriver() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
