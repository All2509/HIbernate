package jm.task.core.jdbc;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {

                UserServiceImpl userService = new UserServiceImpl();

                // 1. Создание таблицы
                userService.createUsersTable();

                // 2. Добавление пользователей
                userService.saveUser("Ivan", "Ivanov", (byte) 25);
                System.out.printf("User с именем %s добавлен в базу данных.%n", "Ivan");

                userService.saveUser("Petr", "Petrov", (byte) 30);
                System.out.printf("User с именем %s добавлен в базу данных.%n", "Petr");

                userService.saveUser("Sergey", "Sergeev", (byte) 22);
                System.out.printf("User с именем %s добавлен в базу данных.%n", "Sergey");

                userService.saveUser("Anna", "Sidorova", (byte) 28);
                System.out.printf("User с именем %s добавлен в базу данных.%n", "Anna");

                // 3. Получение всех пользователей и вывод в консоль
                userService.getAllUsers().forEach(user -> System.out.println(user.toString()));

                // 4. Очистка таблицы
                userService.cleanUsersTable();

                // 5. Удаление таблицы
                userService.dropUsersTable();

    }
}

