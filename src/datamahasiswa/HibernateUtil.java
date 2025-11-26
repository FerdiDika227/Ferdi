/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datamahasiswa;

import java.sql.Connection;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Utility Hibernate: buat SessionFactory dan menyediakan method getConnection()
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("❌ Gagal membuat SessionFactory: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * Mengembalikan java.sql.Connection yang didapat dari Session Hibernate.
     * Gunakan try-with-resources jika memanggil method ini agar tidak bocor.
     */
    public static Connection getConnection() {
        // open session, ambil connection, lalu jangan close connection di sini
        Session session = null;
        try {
            session = sessionFactory.openSession();
            // doReturningWork tersedia pada Hibernate modern
            Connection conn = session.doReturningWork(connection -> connection);
            return conn;
        } catch (Exception e) {
            throw new RuntimeException("Gagal mendapatkan Connection dari Hibernate: " + e.getMessage(), e);
        } finally {
            if (session != null && session.isOpen()) {
                // penting: jangan menutup connection yang dikembalikan oleh doReturningWork,
                // menutup session boleh saja — connection biasanya dikelola oleh datasource.
                session.close();
            }
        }
    }
}


