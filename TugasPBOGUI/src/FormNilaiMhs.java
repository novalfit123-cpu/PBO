/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author loq
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class FormNilaiMhs extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormNilaiMhs.class.getName());

    DefaultTableModel tabel1;
    Object[] list_mhs = new Object[9];
    int x=0;
    DBConnection dbConn = new DBConnection();
    Connection con = dbConn.getConnection();
    /**
     * Creates new form FormNilaiMhs
     */
    public FormNilaiMhs() {
        initComponents();
    }
    
    // 1. Method untuk mengosongkan semua kotak inputan
    public void kosongkanTextField() {
        nim.setText("");
        nama.setText("");
        nUTS.setText("");
        nUAS.setText("");
        nTugas.setText("");
        nUTS1.setText("");
        nUAS1.setText("");
        nTugas1.setText("");
        nUTS2.setText("");
        nTugas2.setText("");
        nUAS2.setText("");
    }

    // 2. Method untuk membersihkan isi tabel
    public void kosongkanTabel() {
        DefaultTableModel model = (DefaultTableModel) this.tabel.getModel();
        model.setRowCount(0);
    }

    // 3. Method utama untuk menghitung nilai (Memanggil class Mhs yang sudah kamu buat)
    public void prosesHitungNilai() {
        try {
            String ni = nim.getText();
            String na = nama.getText();
            // Mengambil angka dari text field
            Double ts = Double.parseDouble(nUTS.getText());
            Double as = Double.parseDouble(nUAS.getText());
            Double tgs = Double.parseDouble(nTugas.getText());

            // Memasukkan data ke Class Mhs
            Mhs m = new Mhs(ni, na, ts, as, tgs);
            
            // Menampilkan hasil perhitungan ke kotak hasil
            nUTS1.setText("" + m.uts());
            nUAS1.setText("" + m.uas());
            nTugas1.setText("" + m.tugas());
            nUTS2.setText("" + m.nilaiAkhir());
            nUAS2.setText("" + m.getNilHuruf(m.nilaiAkhir()));
            nTugas2.setText("" + m.getPredikat(m.getNilHuruf(m.nilaiAkhir())));
            
            // Menyalakan tombol simpan setelah perhitungan selesai
            simpan.setEnabled(true);
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Inputan Anda Kosong atau Bukan Angka", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public ArrayList[] getMhsList() throws SQLException {
        String queryCount = "SELECT COUNT(*) as c FROM mhs";
        Statement st;
        ResultSet rsCount, rs;
        st = con.createStatement();
        rsCount = st.executeQuery(queryCount);
        int sizeTable = 0;

        while (rsCount.next()) {
            sizeTable = rsCount.getInt("c");
        }
        
        ArrayList[] mhsList = new ArrayList[sizeTable];
        String query = "SELECT * FROM mhs";
        rs = st.executeQuery(query);

        int x = 0;
        while (rs.next()) {
            mhsList[x] = new ArrayList<>();
            mhsList[x].add(rs.getString("nim"));
            mhsList[x].add(rs.getString("nama"));
            mhsList[x].add(rs.getDouble("nilai_uts"));
            mhsList[x].add(rs.getDouble("nilai_uas"));
            mhsList[x].add(rs.getDouble("nilai_tugas"));
            mhsList[x].add(rs.getDouble("nilai_akhir"));
            mhsList[x].add(rs.getString("nilai_huruf"));
            mhsList[x].add(rs.getString("predikat"));
            x++;
        }
        return mhsList;
    }
    
    public void tampilkanDiTabel() throws SQLException {
        ArrayList[] list = getMhsList();
        DefaultTableModel model = (DefaultTableModel) tabel.getModel();

        Object[] row = new Object[9];
        for (int i = 0; i < list.length; i++) {
            row[0] = i + 1;
            row[1] = list[i].get(0);
            row[2] = list[i].get(1);
            row[3] = list[i].get(2);
            row[4] = list[i].get(3);
            row[5] = list[i].get(4);
            row[6] = list[i].get(5);
            row[7] = list[i].get(6);
            row[8] = list[i].get(7);

            model.addRow(row);
        }
    }
    
    public void terpilih(int index) throws SQLException {
        ArrayList[] list = getMhsList();
        nim.setText((String) list[index].get(0));
        nama.setText((String) list[index].get(1));
        nUTS.setText(list[index].get(2).toString());
        nUAS.setText(list[index].get(3).toString());
        nTugas.setText(list[index].get(4).toString());
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        nim = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        nama = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        nUTS = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        nUAS1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        nTugas = new javax.swing.JTextField();
        proses = new javax.swing.JButton();
        simpan = new javax.swing.JButton();
        tambahLain = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        update = new javax.swing.JButton();
        proses1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        keluar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        nUTS1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        nUTS2 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        nUAS = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        nTugas2 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        nTugas1 = new javax.swing.JTextField();
        nUAS2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Form Nilai Mahasiswa");

        jLabel2.setText("NIM");

        jLabel3.setText("Nama");

        jLabel4.setText("Nilai UTS");

        jLabel5.setText("Nilai UAS");

        jLabel6.setText("Tugas 30%");

        proses.setText("Proses");
        proses.addActionListener(this::prosesActionPerformed);

        simpan.setText("Simpan");
        simpan.addActionListener(this::simpanActionPerformed);

        tambahLain.setText("Tambah Lain");
        tambahLain.addActionListener(this::tambahLainActionPerformed);

        hapus.setBackground(new java.awt.Color(255, 51, 51));
        hapus.setText("Hapus");
        hapus.addActionListener(this::hapusActionPerformed);

        update.setBackground(new java.awt.Color(51, 102, 255));
        update.setText("Update");
        update.addActionListener(this::updateActionPerformed);

        proses1.setBackground(new java.awt.Color(153, 255, 153));
        proses1.setText("Proses");
        proses1.addActionListener(this::proses1ActionPerformed);

        keluar.setText("Keluar");
        keluar.addActionListener(this::keluarActionPerformed);

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel);

        jLabel7.setText("UTS 35%");

        nUTS1.addActionListener(this::nUTS1ActionPerformed);

        jLabel8.setText("Nilai Akhir");

        jLabel9.setText("UAS 35%");

        jLabel10.setText("Predikat");

        jLabel11.setText("Nilai Tugas");

        jLabel12.setText("Nilai Huruf");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator2))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nUTS, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nim, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(97, 97, 97)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(65, 65, 65)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(202, 202, 202)
                                                .addComponent(jLabel11)
                                                .addGap(2, 2, 2)
                                                .addComponent(nTugas, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(proses1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(proses, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(432, 432, 432)
                        .addComponent(tambahLain, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(keluar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(315, 315, 315)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(nUTS2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(26, 26, 26)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(nUTS1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nUAS, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(nUAS1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(nTugas2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(46, 46, 46)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(nUAS2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(nTugas1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                .addGap(0, 217, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(nUTS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nTugas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(proses, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tambahLain, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(8, 8, 8)
                                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(proses1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(62, 62, 62)
                                        .addComponent(keluar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(nUTS1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(nUAS1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(nTugas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(nUTS2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(nTugas2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(nUAS2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nUAS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void prosesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prosesActionPerformed
prosesHitungNilai();        
    }//GEN-LAST:event_prosesActionPerformed

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
try{
            PreparedStatement ps = con.prepareStatement("INSERT INTO mhs(nim,nama,nilai_uts,nilai_uas,nilai_tugas,nilai_akhir,nilai_huruf,predikat) values(?,?,?,?,?,?,?,?) ");
            ps.setString(1, nim.getText());
            ps.setString(2, nama.getText());
            ps.setString(3, nUTS.getText());
            ps.setString(4, nUAS.getText());
            ps.setString(5, nTugas.getText());
            ps.setString(6, nUTS2.getText());
            ps.setString(7, nUAS2.getText());
            ps.setString(8, nTugas2.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data tersimpan");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Data tidak tersimpan");
        }
        
        try {
            kosongkanTextField();
            kosongkanTabel();
            tampilkanDiTabel();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(FormNilaiMhs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_simpanActionPerformed

    private void tambahLainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahLainActionPerformed
kosongkanTextField();
    simpan.setEnabled(false); // Mematikan tombol simpan sampai tombol proses diklik lagi
    }//GEN-LAST:event_tambahLainActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
try {
        PreparedStatement ps = con.prepareStatement("DELETE FROM mhs WHERE nim = ?");
        ps.setString(1, nim.getText());
        ps.executeUpdate();
        JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
        
        kosongkanTextField();
        kosongkanTabel();
        tampilkanDiTabel();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Data gagal dihapus");
    }
    }//GEN-LAST:event_hapusActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
String updateQuery = "UPDATE mhs SET nim=?, nama=?, nilai_uts=?, nilai_uas=?, nilai_tugas=?, nilai_akhir=?, nilai_huruf=?, predikat=? WHERE nim=?";
    try {
        PreparedStatement ps = con.prepareStatement(updateQuery);
        ps.setString(1, nim.getText());
        ps.setString(2, nama.getText());
        ps.setString(3, nUTS.getText());
        ps.setString(4, nUAS.getText());
        ps.setString(5, nTugas.getText());
        ps.setString(6, nUTS2.getText());
        ps.setString(7, nUAS2.getText());
        ps.setString(8, nTugas2.getText());
        ps.setString(9, nim.getText()); // NIM sebagai kunci data mana yang diubah
        
        ps.executeUpdate();
        JOptionPane.showMessageDialog(null, "Data berhasil diupdate");
        
        kosongkanTextField();
        kosongkanTabel();
        tampilkanDiTabel();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Data gagal diupdate");
    }
    }//GEN-LAST:event_updateActionPerformed

    private void proses1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proses1ActionPerformed
prosesHitungNilai();
    update.setEnabled(true);
    }//GEN-LAST:event_proses1ActionPerformed

    private void keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarActionPerformed
System.exit(0);
    }//GEN-LAST:event_keluarActionPerformed

    private void nUTS1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nUTS1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nUTS1ActionPerformed

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
 int index = tabel.getSelectedRow(); // Mengambil baris mana yang diklik
    try {
        terpilih(index); // Memindahkan data dari tabel ke kotak teks
    } catch (SQLException ex) {
        java.util.logging.Logger.getLogger(FormNilaiMhs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    // Menyalakan tombol-tombol yang tadi mati
    proses1.setEnabled(true);
    hapus.setEnabled(true);
    }//GEN-LAST:event_tabelMouseClicked

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new FormNilaiMhs().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton hapus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton keluar;
    private javax.swing.JTextField nTugas;
    private javax.swing.JTextField nTugas1;
    private javax.swing.JTextField nTugas2;
    private javax.swing.JTextField nUAS;
    private javax.swing.JTextField nUAS1;
    private javax.swing.JTextField nUAS2;
    private javax.swing.JTextField nUTS;
    private javax.swing.JTextField nUTS1;
    private javax.swing.JTextField nUTS2;
    private javax.swing.JTextField nama;
    private javax.swing.JTextField nim;
    private javax.swing.JButton proses;
    private javax.swing.JButton proses1;
    private javax.swing.JButton simpan;
    private javax.swing.JTable tabel;
    private javax.swing.JButton tambahLain;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
