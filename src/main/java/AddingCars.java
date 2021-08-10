import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//здесь можно вручную добавлять машины на базу данных
public class AddingCars {
    public static void adding(){
        Connections.registerDriver();//загружаем драйвер для работы с MySql

        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection(Connections.URL, Connections.LOGIN, Connections.PASSWORD);//получаем подключение
            statement = connection.createStatement();//готовим подключение
//            String createDataBase = "CREATE DATABASE cars";
//            String selectDataBase = "USE cars";
//            String createTableCarsShop = "create table carsshop(id int auto_increment PRIMARY KEY, name varchar(30) not null, price double not NULL)";

//            statement.execute(createDataBase);
//            statement.execute(selectDataBase);
//            statement.execute(createTableCarsShop);
//            System.out.println("The table carsShop created successfully!");
            statement.addBatch("insert into carsshop(name, price) VALUES ('KALINA', 650000)");//запросы
            statement.addBatch("insert into carsshop(name, price) VALUES ('LARGUS', 75000)");
            statement.addBatch("insert into carsshop(name, price) VALUES ('MERSEDES', 4555000)");
            statement.executeBatch();//все запросы выполняем за один раз
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }


    }
}
