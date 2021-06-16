package koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {
    
    // Menggunakan static supaya si koneksi ini bisa langsung dipanggil tanpa melakukan intansiasi
    private static Connection koneksi;
    
    public static Connection getKoneksi() {
        
        if (koneksi == null) {
            try {
                String url = "jdbc:mysql://localhost:3306/tiketbioskop";
                String user = "root";
                String password = "";
                
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                
                koneksi = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                System.out.println("Koneksi DB gagal!");
            }
        }
        return koneksi;
    }    
}
