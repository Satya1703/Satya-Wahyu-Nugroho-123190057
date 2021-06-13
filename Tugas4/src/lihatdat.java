import java.awt.FlowLayout;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class lihatdat {
        public static void main(String[] args) {
        new lihat();
    }  
}

class lihat extends JFrame implements ActionListener{
    String email, username, password, nama, tempat, tanggal, jk, domisili, desc;
    JLabel lid = new JLabel ("id");
    JTextField fid = new JTextField(11);
    JButton tambah = new JButton("Tambah Data");
    JButton edit = new JButton("Edit Data");
    JButton hapus = new JButton("Hapus Data");
    
    String[][] data = new String[500][10];
    String[] kolom = {"email", "username", "password","nama","tempat","tanggal","kelamin","domisili","desc","id"};
    JTable tabel;
    JScrollPane scrollPane;
    
    String id;
    String DBurl = "jdbc:mysql://localhost/form";
    String DBusername = "root";
    String DBpassword = "";
    Connection koneksi;
    Statement statement;
    ResultSet resultSet;
    
    public lihat(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection(DBurl,DBusername, DBpassword);
            statement = koneksi.createStatement();
            String sql = "select * from akun";
            resultSet = statement.executeQuery(sql);
            int p = 0;
            while (resultSet.next()) {
                data[p][0] = resultSet.getString("email");
                data[p][1] = resultSet.getString("username");
                data[p][2] = resultSet.getString("password");
                data[p][3] = resultSet.getString("nama");
                data[p][4] = resultSet.getString("tempat");
                data[p][5] = resultSet.getString("tanggal");
                data[p][6] = resultSet.getString("kelamin");
                data[p][7] = resultSet.getString("domisili");
                data[p][8] = resultSet.getString("desk");
                data[p][9] = resultSet.getString("id");
                p++;
            }
            statement.close();
            koneksi.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Gagal Ditampilkan", "Hasil", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Tidak Ditemukan!", "Hasil", JOptionPane.ERROR_MESSAGE);
        }
        
        tabel = new JTable(data, kolom);
        scrollPane = new JScrollPane(tabel);
        
        setTitle("Data");
        setVisible(true);
        
        setLayout(null);
        add(tambah);
        add(edit);
        add(hapus);
        
        tambah.setBounds(30,10,120,20);
        edit.setBounds(170,10,120,20);
        hapus.setBounds(310,10,120,20);
        setLayout(new FlowLayout());
        add(lid);
        add(fid);
        add(scrollPane);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        pack();
        setLocationRelativeTo(null);
        
        tambah.addActionListener(this);
        edit.addActionListener(this);
        hapus.addActionListener(this);
    }
    
    public void actionPerformed(java.awt.event.ActionEvent e) {
        if (e.getSource() == tambah){
            new Tambah();
            dispose();
        }
        if (e.getSource() == edit){
            id = fid.getText();
            if (id.isEmpty() ) {
                JOptionPane.showMessageDialog(null,"id tidak boleh kosong");
                fid.requestFocus();
            }
            else{
                
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    koneksi = DriverManager.getConnection(DBurl,DBusername, DBpassword);
                    statement = koneksi.createStatement();
                    String sql = "select * from akun where id='" + id + "'";
                    resultSet = statement.executeQuery(sql);
                    if(resultSet.next()){
                        email = resultSet.getString("email");
                        username = resultSet.getString("username");
                        password = resultSet.getString("password");
                        nama = resultSet.getString("nama");
                        tempat = resultSet.getString("tempat");
                        tanggal = resultSet.getString("tanggal");
                        jk = resultSet.getString("kelamin");
                        domisili = resultSet.getString("domisili");
                        desc = resultSet.getString("desk");
                        id = resultSet.getString("id");
                    } 
                    statement.close();
                    koneksi.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Gagal Dicari!", "Hasil", JOptionPane.ERROR_MESSAGE);
                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "Tidak Ditemukan!", "Hasil", JOptionPane.ERROR_MESSAGE);
                }
                
                try {
                    FileWriter myWriter = new FileWriter("data.txt", false);
                    myWriter.write(""+email);
                    myWriter.write("\r\n");   // write new line
                    myWriter.write(""+username);
                    myWriter.write("\r\n");   // write new line
                    myWriter.write(""+password);
                    myWriter.write("\r\n");   // write new line
                    myWriter.write(""+nama);
                    myWriter.write("\r\n");   // write new line
                    myWriter.write(""+tempat);
                    myWriter.write("\r\n");   // write new line
                    myWriter.write(""+tanggal);
                    myWriter.write("\r\n");   // write new line
                    myWriter.write(""+jk);
                    myWriter.write("\r\n");   // write new line
                    myWriter.write(""+domisili);
                    myWriter.write("\r\n");   // write new line
                    myWriter.write(""+desc);
                    myWriter.write("\r\n");
                    myWriter.write(""+id);
                    myWriter.close();
                } catch (IOException x) {
                    x.printStackTrace();
                }
                new Edit();
                dispose();
            }
        }
        if (e.getSource() == hapus){
            id = fid.getText();
            if (id.isEmpty() ) {
                JOptionPane.showMessageDialog(null,"id tidak boleh kosong");
                fid.requestFocus();
            }
            else{
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    koneksi = DriverManager.getConnection(DBurl,DBusername, DBpassword);
                    statement = koneksi.createStatement();
                    String sql = "delete from akun where id=" + id;
                    statement.executeUpdate(sql);
                        JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus!", "Hasil",JOptionPane.INFORMATION_MESSAGE); 
                    statement.close();
                    koneksi.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Data Gagal Dihapus!", "Hasil", JOptionPane.ERROR_MESSAGE);
                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "Driver Tidak Ditemukan!", "Hasil", JOptionPane.ERROR_MESSAGE);
                }
                new lihat();
                dispose();
            }
        }
    }
}