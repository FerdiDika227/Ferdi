/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datamahasiswa;

import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class ReportUtil {

    public static void showLaporanMahasiswa() {
        Connection conn = null;
        try {
            // 1) Load JRXML dari classpath (src/report/LaporanMahasiswa.jrxml)
            InputStream jrxml = ReportUtil.class.getResourceAsStream("/report/LaporanMahasiswa.jrxml");
            if (jrxml == null) {
                throw new RuntimeException("File /report/LaporanMahasiswa.jrxml tidak ditemukan di classpath.");
            }

            // 2) Compile report dari InputStream
            JasperReport jasperReport = JasperCompileManager.compileReport(jrxml);

            // 3) Ambil connection via HibernateUtil
            conn = HibernateUtil.getConnection(); // pastikan HibernateUtil.getConnection() sudah benar

            // 4) Fill report (no parameters)
            HashMap<String, Object> params = new HashMap<>();
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, conn);

            // 5) Tampilkan via JasperViewer
            JasperViewer.viewReport(jasperPrint, false);

        } catch (JRException ex) {
            ex.printStackTrace();
            throw new RuntimeException("JRException: " + ex.getMessage(), ex);
        } finally {
            // Jangan menutup connection yang dikelola oleh connection pool; 
            // jika menggunakan DriverManager, sebaiknya close:
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close(); // jika connection adalah hasil DriverManager
                }
            } catch (Exception e) {
                // ignore
            }
        }
    }
}

