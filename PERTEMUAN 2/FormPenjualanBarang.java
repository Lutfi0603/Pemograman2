package penjualanbarangapp_p2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class FormPenjualanBarang extends JFrame {

    private JTable tabelBarang;
    private DefaultTableModel model;

    public FormPenjualanBarang() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Form Penjualan Barang");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 430);
    }

    private void initComponents() {
        Color warnaLatar = new Color(220, 240, 255); // biru muda lembut
        Color warnaInput = new Color(255, 255, 245); // putih kekuningan
        Color warnaTombol = new Color(200, 220, 255); // biru pastel

        JPanel panel = new JPanel(null); // pakai layout null
        panel.setBackground(warnaLatar); // set background panel

        JLabel lblKode = new JLabel("Kode Barang");
        JLabel lblNama = new JLabel("Nama Barang");
        JLabel lblJumlah = new JLabel("Jumlah");
        JLabel lblHarga = new JLabel("Harga");

        JTextField txtKode = new JTextField();
        JTextField txtNama = new JTextField();
        JTextField txtJumlah = new JTextField();
        JTextField txtHarga = new JTextField();

        // Set warna input
        txtKode.setBackground(warnaInput);
        txtNama.setBackground(warnaInput);
        txtJumlah.setBackground(warnaInput);
        txtHarga.setBackground(warnaInput);

        JButton btnSimpan = new JButton("Simpan");
        JButton btnHapus = new JButton("Hapus");
        JButton btnTutup = new JButton("Tutup");

        // Set warna tombol
        btnSimpan.setBackground(warnaTombol);
        btnHapus.setBackground(warnaTombol);
        btnTutup.setBackground(warnaTombol);

        JScrollPane scrollPane = new JScrollPane();
        tabelBarang = new JTable();
        tabelBarang.setBackground(Color.WHITE);
        scrollPane.setViewportView(tabelBarang);

        // Tabel model
        String[] kolom = {"Kode Barang", "Nama Barang", "Jumlah", "Harga", "Total"};
        model = new DefaultTableModel(null, kolom);
        tabelBarang.setModel(model);

        // Posisi komponen
        lblKode.setBounds(20, 20, 100, 25);
        txtKode.setBounds(130, 20, 150, 25);
        lblNama.setBounds(20, 50, 100, 25);
        txtNama.setBounds(130, 50, 150, 25);
        lblJumlah.setBounds(20, 80, 100, 25);
        txtJumlah.setBounds(130, 80, 150, 25);
        lblHarga.setBounds(20, 110, 100, 25);
        txtHarga.setBounds(130, 110, 150, 25);

        btnSimpan.setBounds(310, 20, 100, 25);
        btnHapus.setBounds(310, 50, 100, 25);
        btnTutup.setBounds(310, 80, 100, 25);
        scrollPane.setBounds(20, 160, 540, 200);

        panel.add(lblKode); panel.add(txtKode);
        panel.add(lblNama); panel.add(txtNama);
        panel.add(lblJumlah); panel.add(txtJumlah);
        panel.add(lblHarga); panel.add(txtHarga);
        panel.add(btnSimpan); panel.add(btnHapus); panel.add(btnTutup);
        panel.add(scrollPane);

        setContentPane(panel); // Ganti konten utama frame

        // Tombol simpan
        btnSimpan.addActionListener(e -> {
            try {
                String kode = txtKode.getText();
                String nama = txtNama.getText();
                int jumlah = Integer.parseInt(txtJumlah.getText());
                double harga = Double.parseDouble(txtHarga.getText());
                double total = jumlah * harga;

                model.addRow(new Object[]{kode, nama, jumlah, harga, total});

                txtKode.setText("");
                txtNama.setText("");
                txtJumlah.setText("");
                txtHarga.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Jumlah dan Harga harus berupa angka!");
            }
        });

        // Tombol hapus
        btnHapus.addActionListener(e -> {
            int row = tabelBarang.getSelectedRow();
            if (row != -1) {
                model.removeRow(row);
            } else {
                JOptionPane.showMessageDialog(this, "Pilih baris yang ingin dihapus.");
            }
        });

        // Tombol tutup
        btnTutup.addActionListener(e -> dispose());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new FormPenjualanBarang().setVisible(true);
        });
    }
}
