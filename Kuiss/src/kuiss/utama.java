/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kuiss;
/**
 *
 * @author Asus
 */

import javax.swing.*;
import java.awt.event.*;
import java.util.regex.Matcher; 
import java.util.regex.Pattern;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class utama {
    public static void main(String[] args) {
        new GUI();
    }
}

class GUI extends JFrame implements ActionListener{
    String email, username, password, nama, tempat, tanggal, jk, domisili, desc;
    int count=0, check=0;
    JLabel lemail = new JLabel ("E-mail");
    final JTextField femail = new JTextField(30);
    
    JLabel lusername = new JLabel ("Username");
    final JTextField fusername = new JTextField(20);
    
    JLabel lpassword = new JLabel ("Password");
    final JTextField fpassword = new JTextField(20);
    
    JLabel lnama = new JLabel ("Nama Lengkap");
    final JTextField fnama = new JTextField(50);
    
    JLabel ltempat = new JLabel ("Tempat");
    final JTextField ftempat = new JTextField(50);
    
    JLabel ltanggal = new JLabel ("Tanggal Lahir");
    final JTextField ftanggal = new JTextField(50);
    
    JLabel ljk = new JLabel ("Jenis Kelamin");
    final JTextField fjk = new JTextField(50);
    
    JLabel ldomisili = new JLabel ("Domisili");
    final JTextField fdomisili = new JTextField(50);
    
    JLabel ldesc = new JLabel ("Deskripsi");
    final JTextField fdesc = new JTextField(200);
    
    JButton btncek = new JButton("Cek");
    JButton btnin = new JButton("Input");
    final JTextField fcek = new JTextField(10);
    JButton btnout = new JButton("Hasil");
    
    public GUI (){      
        setTitle("data");
        setSize(600,500);
        
        ButtonGroup group = new ButtonGroup();

        setLayout(null);
        add (lemail); add(femail);
        add(lusername); add(fusername);
        add (lpassword); add(fpassword);
        add(lnama); add(fnama);
        add(ltempat); add(ftempat);
        add(ltanggal); add(ftanggal);
        add(ljk); add(fjk);
        add(ldomisili); add(fdomisili);
        add(ldesc); add(fdesc);
        add (btncek); add (btnin); add(btnout);
        add (fcek);

       
        lemail.setBounds(10,10,120,20); femail.setBounds(120,10,205,20);
        lusername.setBounds(10,40,120,20); fusername.setBounds(120,40,205,20);
        lpassword.setBounds(10,70,120,20); fpassword.setBounds(120,70,205,20);
        lnama.setBounds(10,100,120,20); fnama.setBounds(120,100,205,20);
        ltempat.setBounds(10,130,120,20); ftempat.setBounds(120,130,205,20);
        ltanggal.setBounds(10,160,120,20); ftanggal.setBounds(120,160,205,20);
        ljk.setBounds(10,190,120,20); fjk.setBounds(120,190,205,20);
        ldomisili.setBounds(10,220,120,20); fdomisili.setBounds(120,220,205,20);
        ldesc.setBounds(10,260,120,20); fdesc.setBounds(120,260,205,20);
        btncek.setBounds(10,320,120,20); btnin.setBounds(150,320,120,20); btnout.setBounds(290,320,120,20);
        fcek.setBounds(10,350,100,20);
        setVisible(true);
        
        btncek.addActionListener(this);
        btnin.addActionListener(this);
        btnout.addActionListener(this);
    }
    public void actionPerformed(java.awt.event.ActionEvent e) {
        if (e.getSource() == btncek)
        {
            check = 0;
            email = femail.getText();
            String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
            if (email.matches(regex));
            else { 
                femail.setText("email salah");
                check = 1;
            }
            
            username = fusername.getText();
            Pattern pola = Pattern.compile("[^a-zA-Z0-9]");
            Matcher sama = pola.matcher(username);
            boolean id = sama.find();
            if(id) { 
                fusername.setText("tidak boleh mengandung simbol");
                check = 1;
            }
            
            password = fpassword.getText();
            Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
            Matcher matcher = pattern.matcher(password);
            boolean pass = matcher.find();
            if(pass);
            else {
                fpassword.setText("harus mengandung huruf, angka, dan simbol");
                check = 1;
            }
            
            nama = fnama.getText();
            tempat = ftempat.getText();
            tanggal = ftanggal.getText();
            jk = fjk.getText();
            domisili = fdomisili.getText();
            desc = fdesc.getText();
            count = desc.length();
            if (count > 200) { 
                fdesc.setText("maksimal 200 huruf");
                check = 1;
            }
        }
        
        if (e.getSource() == btnin){
            if (check == 1) fcek.setText("masih ada salah");
            else {
                try {
                    FileWriter myWriter = new FileWriter("data.txt", true);
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
                    myWriter.close();
                    fcek.setText("tersimpan");
                } catch (IOException x) {
                    System.out.println("An error occurred.");
                    x.printStackTrace();
                }
            }
        }
        if (e.getSource() == btnout){
            new hasilll();
            dispose();
        }
    }
}