/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Asus
 */

package kuiss;

import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.util.regex.Matcher; 
import java.util.regex.Pattern;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class hasil {
    public static void main(String[] args) {
        new hasilll();
        
    }
}

class hasilll extends JFrame{
    String email, username, password, nama, tempat, tanggal, jk, domisili, desc;
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
    
    public hasilll (){  
        setTitle("data");
        setSize(600,400);
        
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

        
        lemail.setBounds(10,10,120,20); femail.setBounds(120,10,205,20);
        lusername.setBounds(10,40,120,20); fusername.setBounds(120,40,205,20);
        lpassword.setBounds(10,70,120,20); fpassword.setBounds(120,70,205,20);
        lnama.setBounds(10,100,120,20); fnama.setBounds(120,100,205,20);
        ltempat.setBounds(10,130,120,20); ftempat.setBounds(120,130,150,20);
         ltanggal.setBounds(10,160,120,20); ftanggal.setBounds(120,160,205,20);
        ljk.setBounds(10,190,120,20); fjk.setBounds(120,190,205,20);
        ldomisili.setBounds(10,220,120,20); fdomisili.setBounds(120,220,205,20);
        ldesc.setBounds(10,260,120,20); fdesc.setBounds(120,260,205,20);
        setVisible(true);
        
        try {
      File myObj = new File("data.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        System.out.println(data);
        if(email == null) email = data;
        else if(username == null) username = data;
        else if(password == null) password = data;
        else if(nama == null) nama = data;
        else if(tempat == null) tempat = data;
        else if(tanggal == null) tanggal = data;
        else if(jk == null) jk = data;
        else if(domisili == null) domisili = data;
        else if(desc == null) desc = data;
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
        femail.setText(""+email);
        fusername.setText(""+username);
        fpassword.setText(""+password);
        fnama.setText(""+nama);
        ftempat.setText(""+tempat);
        ftanggal.setText(""+tanggal);
        fjk.setText(""+jk);
        fdomisili.setText(""+domisili);
        fdesc.setText(""+desc);
    }
    
}