package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {

    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        //userService.saveUser("Ivan","Ivanov", (byte) 19);
        //userService.saveUser("Anna","Petrova", (byte) 28);
        //userService.saveUser("Vladimir","Kutuzov", (byte) 69);
        //userService.getAllUsers();
        //userService.removeUserById(1);
        //userService.cleanUsersTable();
        //userService.dropUsersTable();
    }
}
