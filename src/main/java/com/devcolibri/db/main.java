package com.devcolibri.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class main {


    public static void main(String[] args) {
        DBWorker worker = new DBWorker();

        String query = "select * from user";
        try {
            Statement statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));

                System.out.println(user);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

/*
        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);


        } catch (SQLException e) {
            System.err.println("Не удалось загрузить класс драйвера!");
        }

        try (Connection ;
                Statement statement = connection.createStatement()) {
            //добавляем данные
            //statement.execute("Insert into users (name, age, email) values('Alex', 30, 'alex@mail.com');");

            //обновляем данные
            //statement.executeUpdate("UPDATE users SET name = 'Petro', age = 29, email = 'petro@mail.ru' WHERE ID=15;");
            //вариант обновления данных где фиксируем количество изменений
            //int res = statement.executeUpdate("UPDATE users SET name = 'Petro', age = 29, email = 'petro@mail.ru' WHERE ID=15;");
            //System.out.println(res);

            //вывод данных. Сохраняем в res данные из БД
            //ResultSet res = statement.executeQuery("SELECT * FROM users;");

            /* пакетная загрузка. создаем пакет и одной командой загружаем.
            statement.addBatch("Insert into users (name, age, email) values('Stepan', 33, 'st@mail.com');");
            statement.addBatch("Insert into users (name, age, email) values('Stepan2', 34, 'st2@mail.com');");
            statement.addBatch("Insert into users (name, age, email) values('Stepan3', 35, 'st3@mail.com');");
            statement.executeBatch();
            // если надо очистить пакет/запросы (batch'и)  существует метод:
            statement.clearBatch();


            // statement.close(); // не требуется если используешь try-with-resourses

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
*/