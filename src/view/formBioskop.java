package view;


import koneksi.Koneksi;
import model.modelBioskop;
import java.awt.Component;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.sql.*;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public final class formBioskop extends javax.swing.JFrame {
    
    // Defaulttabelmodel : membuat model atau isinya
    // Membuat Property defaulttablemodel bernama model
    public DefaultTableModel model;
    
    // Membuat Property bernama header menggunakan Array
    String[] header = {"No Kursi","Nama Pembeli","Film","Harga","Jumlah Beli","Total"};
    
    // Intansiasi pada modelBioskop dengan nama mdl
    modelBioskop mdl = new modelBioskop();
    
    public formBioskop() throws SQLException{
        initComponents();
        //membuat Table Model
        model = new DefaultTableModel(null, header);
        //Menambahkan TableModel ke Tabel
        jTable1.setModel(model);
        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        mdl.Tampil(this);
        loadData();
        setLebarKolom();
    }
    
    public void loadData(){
        // melakukan penghapusan default model dari jtable
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        try{
            // Membuat Koneksi ke database
            Connection c = Koneksi.getKoneksi();
            // untuk membaca perintah sql dan mengantarkannye ke database
            Statement s = c.createStatement();
            String sql = "SELECT * FROM bioskop";
            // interface yang mengontrol letak kursor terhadap suatu record(baris) pada tabel
            ResultSet r = s.executeQuery(sql);
            
            while (r.next()){
                //Melakukan pengecekan baris Data
                Object [] o = new Object [7];
                //Array List Data
                o[0] = r.getString("no_kursi");
                o[1] = r.getString("nama_pembeli");
                o[2] = r.getString("film");
                o[3] = r.getString("harga");
                o[4] = r.getString("jumlah_beli");
                o[5] = r.getString("total");
                model.addRow(o);
            }
            r.close();
            s.close();
        }catch(SQLException e){
            System.out.println("Pengambilan Data Gagal");  
        }
    }
    
    @SuppressWarnings("unchecked")
           
    
    public void setColomnWidth(int kolom){
      DefaultTableColumnModel dtcm = (DefaultTableColumnModel) jTable1.
      getColumnModel();
      TableColumn kolomtabel = dtcm.getColumn(kolom);
      int lebar = 0;
      int margin = 90;
      int a;
      
      TableCellRenderer renderer = kolomtabel.getHeaderRenderer();
      if (renderer ==null){
          renderer = jTable1.getTableHeader().getDefaultRenderer();
      }
      Component komponen = renderer.getTableCellRendererComponent(jTable1, 
                        kolomtabel.getHeaderValue(), false, false, 0, 0);
      lebar = komponen.getPreferredSize().width;
      for (a = 0; a< jTable1.getRowCount(); a++){
          renderer = jTable1.getCellRenderer(a, kolom);
          komponen = renderer.getTableCellRendererComponent(jTable1, 
                  jTable1.getValueAt(a, kolom), false, false, a, kolom);
          int lebarKolom = komponen.getPreferredSize().width;
          lebar = Math.max(lebar, lebarKolom);
      }
      lebar = lebar + margin;
      kolomtabel.setPreferredWidth(lebar);
  
  }
    
    
    public void setLebarKolom(){
      int a;
      for(a =0; a< jTable1.getColumnCount(); a++){
          setColomnWidth(a);
      }
    
  }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPasswordField1 = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        noKursi = new javax.swing.JTextField();
        namaPembeli = new javax.swing.JTextField();
        harga = new javax.swing.JTextField();
        simpan = new javax.swing.JButton();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        keluar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        regular = new javax.swing.JRadioButton();
        gold = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jumlahBeli = new javax.swing.JTextField();
        total = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        namaFilm = new javax.swing.JTextField();
        proses = new javax.swing.JButton();
        cetak = new javax.swing.JButton();

        jPasswordField1.setText("jPasswordField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));

        jPanel2.setBackground(new java.awt.Color(255, 255, 0));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setText("TIKET BIOSKOP");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(117, 117, 117))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jTable1.setBackground(new java.awt.Color(255, 255, 0));
        jTable1.setFont(new java.awt.Font("HP Simplified", 0, 11)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "No Kursi", "Nama Pembeli", "Film", "Harga", "Jumlah Beli", "Total"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 255, 255));
        jLabel2.setText("No Kursi");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 255, 255));
        jLabel3.setText("Nama Pembeli");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 255, 255));
        jLabel4.setText("Harga");

        noKursi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noKursiActionPerformed(evt);
            }
        });

        namaPembeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaPembeliActionPerformed(evt);
            }
        });

        harga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hargaActionPerformed(evt);
            }
        });

        simpan.setText("Simpan");
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });

        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        keluar.setText("Keluar");
        keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keluarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 255, 255));
        jLabel5.setText("Film");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 255, 255));
        jLabel6.setText("Jenis Tiket");

        regular.setText("Regular");
        regular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regularActionPerformed(evt);
            }
        });

        gold.setText("Gold");
        gold.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goldActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 255, 255));
        jLabel7.setText("Jumlah Beli");

        jumlahBeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jumlahBeliActionPerformed(evt);
            }
        });

        total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 255, 255));
        jLabel8.setText("Total");

        namaFilm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaFilmActionPerformed(evt);
            }
        });

        proses.setText("Proses");
        proses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prosesActionPerformed(evt);
            }
        });

        cetak.setText("Cetak");
        cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cetakActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(noKursi, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(regular)
                        .addGap(18, 18, 18)
                        .addComponent(gold))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(total, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(jumlahBeli, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(harga, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addComponent(proses))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(namaFilm, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addComponent(namaPembeli, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(65, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 34, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(simpan)
                        .addGap(29, 29, 29)
                        .addComponent(update)
                        .addGap(32, 32, 32)
                        .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(keluar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cetak))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(noKursi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namaPembeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(namaFilm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(regular)
                    .addComponent(gold))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jumlahBeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(proses))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(simpan)
                    .addComponent(update)
                    .addComponent(delete)
                    .addComponent(keluar)
                    .addComponent(cetak))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void noKursiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noKursiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_noKursiActionPerformed

    private void namaPembeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaPembeliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namaPembeliActionPerformed

    private void hargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hargaActionPerformed
        
    }//GEN-LAST:event_hargaActionPerformed

    private void keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarActionPerformed
        new formLogin().show();
        dispose();
    }//GEN-LAST:event_keluarActionPerformed

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        try {
            // TODO add your handling code here:
            mdl.Simpan(this);
        } catch (SQLException ex) {
            Logger.getLogger(formBioskop.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            loadData();
        }
    }//GEN-LAST:event_simpanActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        try {
            // TODO add your handling code here:
            mdl.Update(this);
        } catch (SQLException ex) {
            Logger.getLogger(formBioskop.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            loadData();
        }
    }//GEN-LAST:event_updateActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        try {
            mdl.Delete(this);
        } catch (SQLException ex) {
            Logger.getLogger(formBioskop.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            loadData();
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int i = jTable1.getSelectedRow();
        if (i == -1){
            // baris tidak terdeteksi
            return;
        }
        String NoKursi = (String) model.getValueAt(i, 0);
        noKursi.setText(NoKursi);
        String NamaPembeli = (String) model.getValueAt(i, 1);
        namaPembeli.setText(NamaPembeli);
        String Film = (String) model.getValueAt(i, 2);
        namaFilm.setText(Film);
        String Harga  = (String) model.getValueAt(i, 3);
        harga.setText(Harga);
        String JumlahBeli = (String) model.getValueAt(i, 4);
        jumlahBeli.setText(JumlahBeli);
        String Total = (String) model.getValueAt(i, 5);
        total.setText(Total);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jumlahBeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jumlahBeliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jumlahBeliActionPerformed

    private void totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalActionPerformed

    private void namaFilmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaFilmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namaFilmActionPerformed

    private void goldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goldActionPerformed
        harga.setText("100000");
    }//GEN-LAST:event_goldActionPerformed

    private void regularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regularActionPerformed
        harga.setText("50000");
    }//GEN-LAST:event_regularActionPerformed

    private void prosesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prosesActionPerformed
        int a = Integer.parseInt(harga.getText());
        int b = Integer.parseInt(jumlahBeli.getText());
        int hasilnya = a*b;
        total.setText("Rp."+hasilnya);        
    }//GEN-LAST:event_prosesActionPerformed

    private void cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cetakActionPerformed
        try{
            String reportName = "src/report/Tiketin.jasper";
            JasperPrint jPrint = JasperFillManager.fillReport(reportName, null, Koneksi.getKoneksi());
            JasperViewer.viewReport(jPrint, false);
        }catch(JRException e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_cetakActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(formBioskop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formBioskop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formBioskop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formBioskop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new formLogin().setVisible(true);
                } catch (Exception e) {
                    Object ex = null;
                    Logger.getLogger(formBioskop.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cetak;
    private javax.swing.JButton delete;
    private javax.swing.JRadioButton gold;
    public javax.swing.JTextField harga;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable1;
    public javax.swing.JTextField jumlahBeli;
    private javax.swing.JButton keluar;
    public javax.swing.JTextField namaFilm;
    public javax.swing.JTextField namaPembeli;
    public javax.swing.JTextField noKursi;
    private javax.swing.JButton proses;
    private javax.swing.JRadioButton regular;
    private javax.swing.JButton simpan;
    public javax.swing.JTextField total;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
