/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas1;

/**
 *
 * @author Asus
 */
public class kapak extends senjata {
    private String nama;
    
    public String getNama(){
        return this.nama;
    }
    
    public void setNama(String nama){
        this.nama = nama;
    }
    
    public kapak(String elemen, int serangan, int damage) {
        super(elemen, serangan, damage);
    }

    @Override
    int dampak() {
        return(serangan*damage);
    }
    
    void menyerang() {
            System.out.println(" menghasilkan damage sebesar " + dampak());
        }
}
