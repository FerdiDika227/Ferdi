/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datamahasiswa;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ControllerMahasiswa {

    // CREATE
    public void insertData(String npm, String nama, int tinggi, boolean pindah) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        DataMahasiswa mhs = new DataMahasiswa(npm, nama, tinggi, pindah);
        session.save(mhs);

        tx.commit();
        session.close();
    }

    // READ
    public DefaultTableModel showData() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<DataMahasiswa> list = session.createQuery("FROM DataMahasiswa", DataMahasiswa.class).list();
        session.close();

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("NPM");
        model.addColumn("Nama");
        model.addColumn("Tinggi");
        model.addColumn("Pindahan");

        for (DataMahasiswa mhs : list) {
            model.addRow(new Object[]{
                    mhs.getNpm(),
                    mhs.getNama(),
                    mhs.getTinggi(),
                    mhs.isPindah() ? "Ya" : "Tidak"
            });
        }

        return model;
    }

    // UPDATE
    public void updateData(String npm, String nama, int tinggi, boolean pindah) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        DataMahasiswa mhs = session.get(DataMahasiswa.class, npm);
        if (mhs != null) {
            mhs.setNama(nama);
            mhs.setTinggi(tinggi);
            mhs.setPindah(pindah);
            session.update(mhs);
        }

        tx.commit();
        session.close();
    }

    // DELETE
    public void deleteData(String npm) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        DataMahasiswa mhs = session.get(DataMahasiswa.class, npm);
        if (mhs != null) {
            session.delete(mhs);
        }

        tx.commit();
        session.close();
    }
}

