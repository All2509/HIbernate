package jm.task.core.jdbc.util;


import java.util.Properties;
import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;



public class Util {

    private static SessionFactory sessionFactory = null;
    static  {
        try {
            Properties settings = new Properties();
            settings.setProperty("hibernate.connection.url","jdbc:mysql://127.0.0.1:3306/new_schema" );
            settings.setProperty("hibernate.connection.username", "jpauser");
            settings.setProperty("hibernate.connection.password","jpapwd" );
            settings.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");
            settings.setProperty("hibernate.hbm2ddl.auto", "create");

            sessionFactory = new org.hibernate.cfg.Configuration()
                    .addProperties(settings)
                    .addAnnotatedClass(User.class)
                    .buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Session getSession() throws HibernateException{
        return sessionFactory.openSession();
    }

    public static void close() throws HibernateException{
        getSession().close();
    }

}





