/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TA_OOP;

import com.sun.xml.internal.ws.policy.sourcemodel.ModelNode;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author acer */
public class GUI_Transaksi extends javax.swing.JFrame {
    String id,nama;
    int jumlah,harga,total,uang,kembali,hasil;
    count hit;
    java.util.Date date;
    java.sql.Date sqldate;
    /**
     * Creates new form Order
     */
    public GUI_Transaksi() {
        initComponents();
        tampil();
        //tampilRecord();
    }
    public Connection conn;
    public void koneksi() throws SQLException {
        try {
        conn=null;
        Class.forName("com.mysql.jdbc.Driver");
        conn=
       DriverManager.getConnection("jdbc:mysql://localhost/db_toko?user=root&password=");
        }
        catch (ClassNotFoundException ex){
           Logger.getLogger(GUI_Transaksi.class.getName()).log(Level.SEVERE,null,ex);
        }
        catch (SQLException e) {
           Logger.getLogger(GUI_Transaksi.class.getName()).log(Level.SEVERE,null,e);
        }
        catch (Exception es) {
           Logger.getLogger(GUI_Transaksi.class.getName()).log(Level.SEVERE,null,es);
        }
    }
    
    public void tampil() {
        DefaultTableModel tabelhead = new DefaultTableModel();
        tabelhead.addColumn("ID Barang");
        tabelhead.addColumn("Nama Barang");
        tabelhead.addColumn("Jumlah Stok");
        tabelhead.addColumn("Harga");
        try {
            koneksi();
            String sql = "SELECT * FROM tb_databarang";
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            while(res.next()){
            tabelhead.addRow(new Object[]{res.getString(1),res.getString(2),res.getString(4),res.getString(5),});
            }
            tabelOrder.setModel(tabelhead);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "BELUM TERKONEKSI");
        }
    }
    
//    public void tampilRecord() {
//        DefaultTableModel tabelhead = new DefaultTableModel();
//        tabelhead.addColumn("KODE");
//        tabelhead.addColumn("NAMA");
//        tabelhead.addColumn("STOK");
//        tabelhead.addColumn("HARGA");
//        tabelhead.addColumn("TANGGAL");
//        try {
//            koneksi();
//            String sql = "SELECT * FROM tb_record";
//            Statement stat = conn.createStatement();
//            ResultSet res = stat.executeQuery(sql);
//            while(res.next()){
//            tabelhead.addRow(new Object[]{res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),});
//            }
//            tabelTotal.setModel(tabelhead);
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "BELUM TERKONEKSI");
//        }
//    }
    
    public void search(){
       try{
        try (Statement statement = conn.createStatement()) {
        String sql="SELECT * FROM tb_databarang WHERE `id_barang`LIKE '%"+txtSearch.getText()+"%'";
        ResultSet rs=statement.executeQuery(sql); //menampilkandata dari sql query
        if(rs.next()) // .next() = scanner method
        {
            txtIDbrg.setText(rs.getString(1));
            txtNamabrg.setText(rs.getString(2));         
            txtHrg.setText(rs.getString(5));
        }
            else{
                JOptionPane.showMessageDialog(null, "Data yang And cari tidak ada");
            }
               }
                }catch (Exception ex){
                 JOptionPane.showMessageDialog(null, "Terjadi Kesalahan!");
            }
       }
    
    public void refresh(){
        new GUI_Transaksi().setVisible(true);
        this.setVisible(false);
    }
    
//    public void Add(){
//        String IDBarang = txtIDbrg.getText();
//        String NamaBarang = txtNamabrg.getText();
//        String JumlahStok = txtJml.getText();
//        String Harga = txtHrg.getText();
//        try {
//           koneksi();
//           Statement statement = conn.createStatement();
//           statement.executeUpdate("INSERT INTO tb_mahasiswa(nim,nama, prodi, angkatan)"+"VALUES('"+IDBarang+"','"+NamaBarang+"','"+JumlahStok+"','"+Harga+"')");
//           statement.close();
//           JOptionPane.showMessageDialog(null, "Berhasil MemasukanData Mahasiswa!");
//           } catch (Exception e) {
//           JOptionPane.showMessageDialog(null, "Terjadi KesalahanInput!");
//           }
//           refresh();
//        }
    
    public void clear(){
            txtIDbrg.setText("");
            txtNamabrg.setText("");
            txtJml.setText("");
            txtHrg.setText("");
    }
    
    
//    public void delete(){
//        int ok=JOptionPane.showConfirmDialog(null,"Apakah Anda yakinakan menghapus data ?","Konfirmasi",JOptionPane.YES_NO_OPTION);
//        if(ok==0){
//        try{
//            String sql="DELETE FROM tb_databa WHERE nim='"+txtIDbrg.getText()+"'";
//            PreparedStatement stmt=conn.prepareStatement(sql);
//            stmt.executeUpdate();
//            JOptionPane.showMessageDialog(null,"Data Berhasil dihapus");
//            clear();
//            }catch(Exception e){
//                JOptionPane.showMessageDialog(null,"Data gagal dihapus");
//            }
//        }
//    }
    
    void itempilih(){
        txtIDbrg.setText(id);
        txtNamabrg.setText(nama);
        txtJml.setText(String.valueOf(jumlah));
        txtHrg.setText(String.valueOf(harga));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelOrder = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        W = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtIDbrg = new javax.swing.JTextField();
        txtNamabrg = new javax.swing.JTextField();
        txtJml = new javax.swing.JTextField();
        txtHrg = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelTotal = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        txtDelete = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        Kembalian = new javax.swing.JLabel();
        txtMskUang = new javax.swing.JTextField();
        txtKembalian = new javax.swing.JTextField();
        btnCheckout = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        txtDate = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabelOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID Barang", "Nama Barang", "Jumlah Stok", "Harga"
            }
        ));
        tabelOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelOrderMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelOrder);

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Order");

        W.setText("ID Barang");

        jLabel3.setText("Nama Barang");

        jLabel4.setText("Jumlah");

        jLabel5.setText("Harga");

        tabelTotal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Barang", "Nama Barang", "Jumlah", "Harga", "Tanggal"
            }
        ));
        jScrollPane2.setViewportView(tabelTotal);

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        txtDelete.setText("Delete");
        txtDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDeleteActionPerformed(evt);
            }
        });

        jLabel6.setText("Masukan Uang");

        Kembalian.setText("Kembalian");

        btnCheckout.setText("Checkout");
        btnCheckout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckoutActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        jLabel2.setText("Tanggal");

        jLabel7.setText("Total :");

        lblTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTotal.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(23, 23, 23)))
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel4))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnClear))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txtDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                                    .addComponent(txtJml, javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(txtHrg, javax.swing.GroupLayout.Alignment.TRAILING)))))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(408, 408, 408)
                                                .addComponent(Kembalian)
                                                .addGap(41, 41, 41))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addGap(18, 18, 18)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtMskUang)
                                            .addComponent(txtKembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(W))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtIDbrg, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                            .addComponent(txtNamabrg))))))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCheckout)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDelete)
                        .addGap(21, 21, 21))))
            .addGroup(layout.createSequentialGroup()
                .addGap(301, 301, 301)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotal)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearch))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(W)
                            .addComponent(txtIDbrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNamabrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtHrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtJml, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd)
                            .addComponent(btnClear))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMskUang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Kembalian)
                            .addComponent(txtKembalian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCheckout)
                            .addComponent(txtDelete))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblTotal))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        search();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        int Harga = Integer.parseInt(txtHrg.getText());
        int Jumlah = Integer.parseInt(txtJml.getText());
        int h =  (Harga*Jumlah);
        date = txtDate.getDate();
        sqldate = new  java.sql.Date(date.getTime());
        String ch = String.valueOf(h);
        int total = Integer.parseInt(lblTotal.getText());
        hit = new count_total();
        DefaultTableModel table = (DefaultTableModel)tabelTotal.getModel();
        table.addRow(new Object[]{txtIDbrg.getText(), txtNamabrg.getText(),
                                  txtJml.getText(), ch, sqldate});
        
        int numrow = tabelTotal.getRowCount();
        int tot = 0;
        
        for (int i = 0; i < numrow; i++) {
            int val = Integer.parseInt((String)tabelTotal.getValueAt(i, 3));
            tot += val;
            
        }
        hit.hitung(tot);
        lblTotal.setText(Integer.toString(hit.hitung(tot)));
        
        String Kode    = txtIDbrg.getText();
        String Nama = txtNamabrg.getText();
//        int tot_lama = tot;
//        int tot_baru = tot_lama - tot;
        try {
        koneksi();
            Statement statement = conn.createStatement();
            statement.executeUpdate("INSERT INTO tb_transaksi(id_barang, nama_barang, jumlah, harga, tanggal, total)" 
                                    +"VALUES('"+Kode+"','"+Nama+"','"+Jumlah+"','"+Harga+"','"+sqldate+"','"+ch+"')");
            statement.close();
            //JOptionPane.showMessageDialog(null, "Berhasil Memasukan Data Bunga!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Input!");
        }
        clear();
        //refresh();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_btnClearActionPerformed

    private void tabelOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelOrderMouseClicked
        // TODO add your handling code here:
        int tabel = tabelOrder.getSelectedRow();
        id = tabelOrder.getValueAt(tabel, 0).toString();
        nama = tabelOrder.getValueAt(tabel, 1).toString();
        harga = Integer.parseInt(tabelOrder.getValueAt(tabel, 3).toString());
        itempilih();
    }//GEN-LAST:event_tabelOrderMouseClicked

    private void btnCheckoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckoutActionPerformed
        // TODO add your handling code here:
        hit = new count_kembali();
        total = Integer.parseInt(lblTotal.getText());
        uang = Integer.parseInt(txtMskUang.getText());
        hasil = (uang - total);
        hit.hitung(hasil);
        txtKembalian.setText(String.valueOf(hit.hitung(hasil)));
        JOptionPane.showMessageDialog(null, "Data Berhasil Di Input !!");
        tabelTotal.setModel(new DefaultTableModel(null, new String[]{"ID Barang", "Nama Barang", "Jumlah", "Harga", "Tanggal"}));
        txtMskUang.setText("");
        txtKembalian.setText("");
        lblTotal.setText("");
    }//GEN-LAST:event_btnCheckoutActionPerformed

    private void txtDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDeleteActionPerformed
        // TODO add your handling code here:
        DefaultTableModel table = (DefaultTableModel) tabelTotal.getModel();
        hit = new count_total();
        try {
            int sri = tabelTotal.getSelectedRow();
            table.removeRow(sri);
            int numrow = tabelTotal.getRowCount();
            int tot = 0;

            for (int i = 0; i < numrow; i++) {
                int val = Integer.parseInt((String)tabelTotal.getValueAt(i, 3));
                tot += val;

            }
            hit.hitung(tot);
            lblTotal.setText(Integer.toString(hit.hitung(tot)));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_txtDeleteActionPerformed

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
            java.util.logging.Logger.getLogger(GUI_Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_Transaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Kembalian;
    private javax.swing.JLabel W;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCheckout;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tabelOrder;
    private javax.swing.JTable tabelTotal;
    private com.toedter.calendar.JDateChooser txtDate;
    private javax.swing.JButton txtDelete;
    private javax.swing.JTextField txtHrg;
    private javax.swing.JTextField txtIDbrg;
    private javax.swing.JTextField txtJml;
    private javax.swing.JTextField txtKembalian;
    private javax.swing.JTextField txtMskUang;
    private javax.swing.JTextField txtNamabrg;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
