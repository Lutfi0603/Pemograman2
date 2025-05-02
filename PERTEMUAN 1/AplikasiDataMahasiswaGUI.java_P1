package aplikasidata;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AplikasiDataMahasiswaGUI extends JFrame {
    
    private static final int MAKS_DATA = 100;
    private String[] nim = new String[MAKS_DATA];
    private String[] nama = new String[MAKS_DATA];
    private double[] uts = new double[MAKS_DATA];
    private double[] uas = new double[MAKS_DATA];
    private double[] nilaiAkhir = new double[MAKS_DATA];
    private char[] grade = new char[MAKS_DATA];
    private int jumlahData = 0;
    
    // UI components
    private JTextField txtNim, txtNama, txtUts, txtUas;
    private JButton btnInput, btnTampil;
    private JTable table;
    private DefaultTableModel model;
    
    public AplikasiDataMahasiswaGUI() {
        // Set title and layout
        setTitle("Aplikasi Data Mahasiswa");
        setLayout(new BorderLayout());
        
        // Create input panel
        JPanel panelInput = new JPanel();
        panelInput.setLayout(new GridLayout(5, 2, 10, 10));
        
        panelInput.add(new JLabel("NIM:"));
        txtNim = new JTextField();
        panelInput.add(txtNim);
        
        panelInput.add(new JLabel("Nama:"));
        txtNama = new JTextField();
        panelInput.add(txtNama);
        
        panelInput.add(new JLabel("Nilai UTS:"));
        txtUts = new JTextField();
        panelInput.add(txtUts);
        
        panelInput.add(new JLabel("Nilai UAS:"));
        txtUas = new JTextField();
        panelInput.add(txtUas);
        
        btnInput = new JButton("Input Data");
        panelInput.add(btnInput);
        
        // Add panelInput to frame
        add(panelInput, BorderLayout.NORTH);
        
        // Create table model with spacing adjustments
        String[] columns = {"NIM", "Nama", "UTS", "UAS", "Nilai Akhir", "Grade"};
        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);
        
        // Set table preferences for spacing and margins
        table.setRowHeight(30); // Increase row height for better readability
        table.setIntercellSpacing(new Dimension(10, 10)); // Set the spacing between cells
        table.setPreferredScrollableViewportSize(new Dimension(550, 300)); // Adjust table size
        table.setFillsViewportHeight(true);
        
        // Set table column width for neatness
        table.getColumnModel().getColumn(0).setPreferredWidth(100); // NIM column
        table.getColumnModel().getColumn(1).setPreferredWidth(150); // Nama column
        table.getColumnModel().getColumn(2).setPreferredWidth(100); // UTS column
        table.getColumnModel().getColumn(3).setPreferredWidth(100); // UAS column
        table.getColumnModel().getColumn(4).setPreferredWidth(150); // Nilai Akhir column
        table.getColumnModel().getColumn(5).setPreferredWidth(60);  // Grade column
        
        // Add table to frame
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
        
        // Create button to display data
        btnTampil = new JButton("Tampil Data");
        JPanel panelTampil = new JPanel();
        panelTampil.add(btnTampil);
        add(panelTampil, BorderLayout.SOUTH);
        
        // Event Handling
        btnInput.addActionListener((ActionEvent e) -> {
            // Input data
            if (jumlahData < MAKS_DATA) {
                nim[jumlahData] = txtNim.getText();
                nama[jumlahData] = txtNama.getText();
                uts[jumlahData] = Double.parseDouble(txtUts.getText());
                uas[jumlahData] = Double.parseDouble(txtUas.getText());
                
                // Calculate final score
                nilaiAkhir[jumlahData] = (uts[jumlahData] * 0.4) + (uas[jumlahData] * 0.6);
                
                // Determine grade
                if (nilaiAkhir[jumlahData] >= 80) {
                    grade[jumlahData] = 'A';
                } else if (nilaiAkhir[jumlahData] >= 70) {
                    grade[jumlahData] = 'B';
                } else if (nilaiAkhir[jumlahData] >= 60) {
                    grade[jumlahData] = 'C';
                } else if (nilaiAkhir[jumlahData] >= 50) {
                    grade[jumlahData] = 'D';
                } else {
                    grade[jumlahData] = 'E';
                }
                
                // Clear input fields
                txtNim.setText("");
                txtNama.setText("");
                txtUts.setText("");
                txtUas.setText("");
                
                jumlahData++;
            } else {
                JOptionPane.showMessageDialog(null, "Data sudah penuh!");
            }
        });
        
        btnTampil.addActionListener((ActionEvent e) -> {
            // Display data in table
            model.setRowCount(0); // Clear the table
            for (int i = 0; i < jumlahData; i++) {
                model.addRow(new Object[]{
                    nim[i], nama[i], uts[i], uas[i], nilaiAkhir[i], grade[i]
                });
            }
        });
        
        // Frame settings
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AplikasiDataMahasiswaGUI().setVisible(true);
        });
    }
}
