/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas1;

import java.util.Scanner;

/**
 *
 * @author Asus
 */
public class Tugas1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a;
        String b, c;
        
        System.out.println("Musuh Mendekat");
        System.out.println("Serang menggunakan : ");
        System.out.println("1. Kapak");
        System.out.println("2. Pedang");
        System.out.print("Pilih : ");
        int pilih = input.nextInt();
        if (pilih == 1) {
            input.nextLine();
            System.out.println("anda memilih kapak");
            System.out.print("masukkan elemen : ");
            b = input.nextLine();
            System.out.print("masukkan berapa kali serangan : ");
            a = input.nextInt();
            input.nextLine();
            System.out.print("masukkan nama kapak : ");
            c = input.nextLine();
            kapak k = new kapak(b, a, 200);
            k.setNama(c);
            System.out.print("kapak " + k.getNama());
            k.menyerang();
        }
        else if (pilih == 2) {
            input.nextLine();
            System.out.println("anda memilih pedang");
            System.out.print("masukkan elemen : ");
            b = input.nextLine();
            System.out.print("masukkan berapa kali serangan : ");
            a = input.nextInt();
            input.nextLine();
            pedang p = new pedang(b, a, 500);
            p.menyerang();
        }
        else {
            System.out.println("pilihan tidak ada");
        }
    }
    
}
