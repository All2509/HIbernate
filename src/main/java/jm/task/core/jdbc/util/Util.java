package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // Параметры подключения
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver"; // Драйвер базы данных
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/new_schema"; // URL подключения
    private static final String USER = "jpauser"; // Имя пользователя
    private static final String PASSWORD = "jpapwd"; // Пароль

    // Метод для получения соединения с базой данных
    public static Connection getConnection() {
        Connection connection = null;
        try {
            // Загружаем драйвер JDBC
            Class.forName(DB_DRIVER);
            // Устанавливаем соединение
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Соединение с базой данных успешно установлено.");
        } catch (ClassNotFoundException e) {
            System.err.println("Драйвер не найден: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Ошибка подключения: " + e.getMessage());
        }
        return connection;
    }

    // Метод для закрытия соединения
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Соединение с базой данных закрыто.");
            } catch (SQLException e) {
                System.err.println("Ошибка при закрытии соединения: " + e.getMessage());
            }
        }
    }
}