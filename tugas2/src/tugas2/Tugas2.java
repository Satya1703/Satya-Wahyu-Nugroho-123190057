/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas2;

import java.util.Scanner;
import java.util.InputMismatchException;
/**
 *
 * @author Asus
 */
public class Tugas2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = 0, pilih = 0;
        String b = "0", c = "0";
        
        System.out.println("Musuh Mendekat");
        System.out.println("Serang menggunakan : ");
        System.out.println("1. Kapak");
        System.out.println("2. Pedang");
        try
        {
            System.out.print("Pilih : ");
            pilih = input.nextInt(); //data yang harus di inputkan adalah 1 atau 2 bukan huruf
        }
        catch (InputMismatchException error)
                {
                    System.out.println("Terdapat error" + error.getMessage());
                }
        finally
        {
            switch (pilih) {
                case 1:
                    try
                    {
                        input.nextLine();
                        System.out.println("anda memilih kapak");
                        System.out.print("masukkan elemen : "); //data yang harus di inputkan berupa huruf misal: api,air dll
                        b = input.nextLine();
                        System.out.print("masukkan berapa kali serangan : "); //data yang harus di inputkan berupa angka saja misal: 1, 2, 3...
                        a = input.nextInt();
                        input.nextLine();
                        System.out.print("masukkan nama kapak : "); //data yang harus di inputkan berupa huruf misal: juki,excal dll
                        c = input.nextLine();
                    }
                    catch (Exception error)
                    {
                        System.out.println("Terdapat error " + error.getMessage());
                    }
                    finally
                    {
                        kapak k = new kapak(b, a, 200);
                        k.setNama(c);
                        System.out.print("kapak " + k.getNama());
                        k.menyerang();
                    }   break;
                case 2:
                    try
                    {
                        input.nextLine();
                        System.out.println("anda memilih pedang");
                        System.out.print("masukkan elemen : "); //data yang harus di inputkan berupa huruf misal: api,air dll
                        b = input.nextLine();
                        System.out.print("masukkan berapa kali serangan : "); //data yang harus di inputkan berupa angka saja misal: 1, 2, 3...
                        a = input.nextInt();
                    }
                    catch (Exception error)
                    {
                        System.out.println("Terdapat error " + error.getMessage());
                    }
                    finally
                    {
                        input.nextLine();
                        pedang p = new pedang(b, a, 500);
                        p.menyerang();
                    }   break;
                default:
                    System.out.println("pilihan tidak ada");
                    break;
            }
        }
    }
    
}
