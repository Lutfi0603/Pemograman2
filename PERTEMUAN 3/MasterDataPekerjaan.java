package desain.pkginterface.form.pekerjaan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;

public class MasterDataPekerjaan extends JFrame {
    private JTextField textKode, textNama;
    private JComboBox<String> comboBox;
    private DataPekerjaan dataPekerjaan;

    public MasterDataPekerjaan() {
        setTitle("Master Data Pekerjaan - Lutfi Nurwasfiah");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        JPanel panelAtas = new JPanel();
        panelAtas.setBackground(new Color(173, 255, 173));
        panelAtas.setBounds(10, 10, 370, 200);
        panelAtas.setLayout(null);
        add(panelAtas);
        
        JLabel labelKode = new JLabel("Kode Pekerjaan");
        labelKode.setBounds(20, 20, 100, 25);
        panelAtas.add(labelKode);
        
        textKode = new JTextField();
        textKode.setBounds(130, 20, 100, 25);
        panelAtas.add(textKode);
        
        JButton btnLihat = new JButton("Lihat");
        btnLihat.setBounds(240, 20, 80, 25);
        panelAtas.add(btnLihat);
        
        JLabel labelNama = new JLabel("Nama Pekerjaan");
        labelNama.setBounds(20, 60, 100, 25);
        panelAtas.add(labelNama);
        
        textNama = new JTextField();
        textNama.setBounds(130, 60, 190, 25);
        panelAtas.add(textNama);
        
        JLabel labelJumlah = new JLabel("Jumlah Tugas");
        labelJumlah.setBounds(20, 100, 100, 25);
        panelAtas.add(labelJumlah);
        
        comboBox = new JComboBox<>(new String[]{"1", "2", "3"});
        comboBox.setBounds(130, 100, 100, 25);
        panelAtas.add(comboBox);
        
        JPanel panelBawah = new JPanel();
        panelBawah.setBackground(new Color(255, 182, 193));
        panelBawah.setBounds(10, 220, 370, 80);
        panelBawah.setLayout(null);
        add(panelBawah);
        
        JButton btnSimpan = new JButton("Simpan");
        btnSimpan.setBounds(50, 20, 80, 30);
        panelBawah.add(btnSimpan);
        
        JButton btnHapus = new JButton("Hapus");
        btnHapus.setBounds(140, 20, 80, 30);
        panelBawah.add(btnHapus);
        
        JButton btnTutup = new JButton("Tutup");
        btnTutup.setBounds(230, 20, 80, 30);
        panelBawah.add(btnTutup);
        
        dataPekerjaan = new DataPekerjaan();
        
        btnLihat.addActionListener(e -> dataPekerjaan.setVisible(true));
        
        btnSimpan.addActionListener(e -> {
            String kode = textKode.getText();
            String nama = textNama.getText();
            if (!kode.isEmpty() && !nama.isEmpty()) {
                dataPekerjaan.tambahData(kode, nama);
            }
        });
        
        setLocationRelativeTo(null);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MasterDataPekerjaan().setVisible(true));
    }
}

class DataPekerjaan extends JFrame {
    private DefaultTableModel tableModel;
    private JTable table;
    
    public DataPekerjaan() {
        setTitle("Data Pekerjaan");
        setSize(400, 300);
        setLayout(null);
        
        JPanel panelAtas = new JPanel();
        panelAtas.setBackground(new Color(173, 255, 173));
        panelAtas.setBounds(10, 10, 370, 200);
        panelAtas.setLayout(null);
        add(panelAtas);
        
        String[] columnNames = {"Kode", "Nama Pekerjaan"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 20, 330, 150);
        panelAtas.add(scrollPane);
        
        tambahData("1415", "admin");
        tambahData("2231", "sales");
        tambahData("4444", "direktur");
        tambahData("4545", "kuli");
        
        JPanel panelBawah = new JPanel();
        panelBawah.setBackground(new Color(255, 182, 193));
        panelBawah.setBounds(10, 220, 370, 80);
        panelBawah.setLayout(null);
        add(panelBawah);
        
        JButton btnPilih = new JButton("Pilih");
        btnPilih.setBounds(50, 20, 80, 30);
        panelBawah.add(btnPilih);
        
        JButton btnTutup = new JButton("Tutup");
        btnTutup.setBounds(200, 20, 80, 30);
        panelBawah.add(btnTutup);
        
        btnPilih.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                String kode = tableModel.getValueAt(selectedRow, 0).toString();
                String nama = tableModel.getValueAt(selectedRow, 1).toString();
                JOptionPane.showMessageDialog(this, "Anda memilih: " + kode + " - " + nama);
            }
        });
        
        btnTutup.addActionListener(e -> setVisible(false));
        
        setLocationRelativeTo(null);
    }
    
    public void tambahData(String kode, String nama) {
        tableModel.addRow(new Object[]{kode, nama});
    }
}