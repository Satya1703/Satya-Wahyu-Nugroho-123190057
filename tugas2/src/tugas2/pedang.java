/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas2;

/**
 *
 * @author Asus
 */
public class pedang extends senjata {
    
 
        
    public pedang(String elemen, int serangan, int damage) {
        super(elemen, serangan, damage);
    }

    @Override
    int dampak() {
        return(serangan*damage);
    }
    
    void menyerang() {
            System.out.println("senjata pedang menghasilkan damage sebesar " + dampak());
        }
}
