/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package casoprogramado2;

/**
 *
 * @author fabri
 */
public class Boletos {

    private int numero;
    private boolean disponible;
    private String nombreComprador;
    private String telefonoComprador;

    public Boletos(int numero) {
        this.numero = numero;
        this.disponible = true;
        this.nombreComprador = "";
        this.telefonoComprador = "";
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getNombreComprador() {
        return nombreComprador;
    }

    public void setNombreComprador(String nombreComprador) {
        this.nombreComprador = nombreComprador;
    }

    public String getTelefonoComprador() {
        return telefonoComprador;
    }

    public void setTelefonoComprador(String telefonoComprador) {
        this.telefonoComprador = telefonoComprador;
    }

    
    
    
    
    
    public String toString() {
        return "Boleto #" + numero + "\n"
                + "Comprador: " + nombreComprador + "\n"
                + "Telefono: " + telefonoComprador;
    }
}
