package model;


import controller.controllerLogin;
import koneksi.Koneksi;
import view.formLogin;
import view.formBioskop;
import view.menuAwal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class modelLogin implements controllerLogin {

    @Override
    public void Login(formLogin lgn) throws SQLException {
        try {
            // Membuat Koneksi ke database
            Connection c = Koneksi.getKoneksi();
            // untuk membaca perintah sql dan mengantarkannye ke database
            Statement st = c.createStatement();
            String sql = "SELECT * FROM user where username='"+lgn.username.getText()+"' and password = '"+lgn.password.getText()+"'";
            // interface yang mengontrol letak kursor terhadap suatu record(baris) pada tabel
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                
                if(rs.getString(4).equals("Admin")){
                    new menuAwal().show();
                    lgn.dispose();
                } else {
                    JOptionPane.showMessageDialog(lgn, "Password Salah");
                }
            } else {
                JOptionPane.showMessageDialog(lgn, "Username Belum Terdaftar");
                Bersih(lgn);
                lgn.username.requestFocus();
            }
        } catch (Exception e) {
        }
    }

    @Override
    public void Bersih(formLogin lgn) throws SQLException {
        lgn.username.setText(null);
        lgn.password.setText(null);
        lgn.username.requestFocus();
    }
    
}
