import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//получаем список всех машин
public class GettingCars {
    public static void showCars() {
        Connections.registerDriver();

        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection(Connections.URL, Connections.LOGIN, Connections.PASSWORD);
            statement = connection.createStatement();

            String getAllCars = "select * from carsshop";
            ResultSet resultSet = statement.executeQuery(getAllCars);//получаем как бы stream всех данных по запросу
            List<Cars> carsList = new ArrayList<>();//все это добро храним в листе

            while (resultSet.next()) {//получаем по одному все значения
                int id = resultSet.getInt(1);//первое поле, то есть id
                String name = resultSet.getString("name");//второе поле, название машины
                double price = resultSet.getDouble("price");//цена
                carsList.add(new Cars(id, name, price));//все это добавляем в лист
            }

            carsList.forEach(System.out::println); //выводим все данные из листа на экран

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
