package jm.task.core.jdbc.util;


import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/pp114";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "Admin";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static SessionFactory sessionFactory = null;
    public static Connection getConnectionJDBC(){
        Connection connection;
        try {
            connection = DriverManager.getConnection(URL,LOGIN,PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//
        return connection;
    }

    public static SessionFactory getConnectionHibernate(){
        try {
            Configuration configuration = new Configuration()
                    .setProperty("hibernate.connection.driver_class",DRIVER)
                    .setProperty("hibernate.connection.url",URL)
                    .setProperty("hibernate.connection.username",LOGIN)
                    .setProperty("hibernate.connection.password",PASSWORD)
                    .setProperty("hibernate.dialect","org.hibernate.dialect.MySQLDialect")
                    .setProperty("current_session_context_class","thread")
                    .addAnnotatedClass(User.class);
            sessionFactory = configuration.buildSessionFactory();
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (HibernateException e) {
            e.printStackTrace();
        }

    return sessionFactory;
    }
}
