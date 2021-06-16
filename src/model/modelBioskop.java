/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.controllerBioskop;
import java.io.File;
import koneksi.Koneksi;
import view.formBioskop;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;


public class modelBioskop implements controllerBioskop {
    
    @Override
    public void Simpan(formBioskop tb) throws SQLException {
        try {
            Connection c = Koneksi.getKoneksi();
            String sql = "INSERT INTO bioskop VALUES (?,?,?,?,?,?)";
            
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, tb.noKursi.getText());
            p.setString(2, tb.namaPembeli.getText());
            p.setString(3, tb.namaFilm.getText());
            p.setString(4, tb.harga.getText());
            p.setString(5, tb.jumlahBeli.getText());
            p.setString(6, tb.total.getText());
            p.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data berhasil di simpan");
            p.close();
        } catch (Exception e) {
            System.out.println(e);
        }finally{
            Tampil(tb);
            tb.setLebarKolom();
            Bersih(tb);
        }
   
    }

    @Override
    public void Update(formBioskop tb) throws SQLException {
        try {
            Connection c = Koneksi.getKoneksi();
            String sql = "update bioskop set nama_pembeli = ?, "
                    + " film = ?, "
                    + " harga = ?, "
                    + " jumlah_beli = ?,"
                    + " total = ? " 
                    + " where no_kursi = ?";
            PreparedStatement p = c.prepareStatement(sql);
            
            p.setString(1, tb.namaPembeli.getText());
            p.setString(2, tb.namaFilm.getText());
            p.setString(3, tb.harga.getText());
            p.setString(4, tb.jumlahBeli.getText());
            p.setString(5, tb.total.getText());
            p.setString(6, tb.noKursi.getText());
            p.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data berhasil di diupdate");
            p.close();
        } catch (Exception e) {
            System.out.println(e);
        }finally{
            Tampil(tb);
            tb.setLebarKolom();
            Bersih(tb);
        }
    }

    @Override
    public void Delete(formBioskop tb) throws SQLException {
        try {
            Connection c = Koneksi.getKoneksi();
            String sql = "DELETE FROM bioskop WHERE no_kursi = ?";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, tb.noKursi.getText());
            p.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data berhasil di hapus");
            p.close();
        } catch (Exception e) {
            System.out.println(e);
        }finally{
            Tampil(tb);
            tb.setLebarKolom();
            Bersih(tb);
        }
    }

    @Override
    public void Tampil(formBioskop tb) throws SQLException {
        tb.model.getDataVector().removeAllElements();
        tb.model.fireTableDataChanged();
        
        try {
            Connection c = Koneksi.getKoneksi();
            Statement s = c.createStatement();
            String sql = "SELECT * FROM bioskop order by no_kursi asc";
            ResultSet res = s.executeQuery(sql);
            
            while(res.next()){
            Object[] ob = new Object[6];
            ob[0] = res.getString(1);
            ob[1] = res.getString(2);
            ob[2] = res.getString(3);
            ob[3] = res.getString(4);
            ob[4] = res.getString(5);
            ob[5] = res.getString(6);
            tb.model.addRow(ob);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }

    @Override
    public void KlikTable(formBioskop tb) throws SQLException {
        try {
            int pilih = tb.jTable1.getSelectedRow();
            if (pilih == -1){
                return;
            }
            tb.noKursi.setText(tb.model.getValueAt(pilih, 0).toString());
            tb.namaPembeli.setText(tb.model.getValueAt(pilih, 1).toString());
            tb.namaFilm.setText(tb.model.getValueAt(pilih, 2).toString());
            tb.harga.setText(tb.model.getValueAt(pilih, 3).toString());
            tb.jumlahBeli.setText(tb.model.getValueAt(pilih, 4).toString());
            tb.total.setText(tb.model.getValueAt(pilih, 5).toString());
        } catch (Exception e) {
        }
    }


    @Override
    public void Bersih(formBioskop tb) throws SQLException {
        tb.noKursi.setText(null);
        tb.namaPembeli.setText(null);
        tb.namaFilm.setText(null);
        tb.harga.setText(null);
        tb.jumlahBeli.setText(null);
        tb.total.setText(null);
    }

}
