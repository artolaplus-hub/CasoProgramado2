/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package casoprogramado2;

import javax.swing.JOptionPane;

/**
 *
 * @author fabri
 */

import javax.swing.JOptionPane;

import javax.swing.JOptionPane;

public class Menu {
    private GestionRifa gestion;

    // Constructor: el menu necesita una GestionRifa para poder llamar sus metodos
    public Menu() {
        gestion = new GestionRifa();
    }

    public void verMenu() {
        String menu = "Menu \n 1- Modulo Visualizacion \n 2-Ingresar numero de boleto a adquirir \n 3-Comprar boleto al azar \n  4-Módulo de Consulta por Comprador \n 5-Módulo de Estadísticas y Recaudación \n 6-Módulo de Sorteo Complejo \n 7-Salir";
        int i = 0;
        do {
            i = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (i) {
                case 1:
                    // modulo de visualizacion 
                    gestion.imprimirTalonario();
                    break;
                case 2:
                    // modulo venta manual
                    gestion.ventaManual();
                    break;
                case 3:
                    //  modulo gallo tapado 
                    gestion.galloTapado();
                    break;
     
                case 4:
                     JOptionPane.showMessageDialog(null, "No pude :c");
                    break;
                case 5:
                    // modulo de estadisticas 
                    JOptionPane.showMessageDialog(null, "No pude :c");
                    break;
                case 6:
                    // modulo de sorteo 
                     JOptionPane.showMessageDialog(null, "No pude :c");
                    break;
               case 7:
                    // salir 
                     JOptionPane.showMessageDialog(null, "Saliendo");
                    break;
                    
                default:
                    JOptionPane.showMessageDialog(null, "Opcion no valida.");
            }
        } while (i != 8);
    }
}