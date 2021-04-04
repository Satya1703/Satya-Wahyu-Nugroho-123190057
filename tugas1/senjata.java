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
public abstract class senjata {
    String elemen;
    int serangan;
    int damage;
    
        public senjata(String elemen, int serangan, int damage){
            this.elemen = elemen;
            this.serangan = serangan;
            this.damage = damage;
        }
        
        abstract int dampak();
}
    
