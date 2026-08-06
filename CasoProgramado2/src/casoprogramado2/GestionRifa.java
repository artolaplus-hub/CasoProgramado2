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
public class GestionRifa {

    private Boletos[][] talonario;
    private int filas = 10;
    private int columnas = 10;
    private int valor = 2000;
    private double variableRifaTodos;
    private int variableRifaMayor;
    private int variableUno;

    public GestionRifa() {
        talonario = new Boletos[filas][columnas];
        variableRifaTodos = 0;
        variableRifaMayor = 0;
        variableUno = 20;
        iniciarTalonario();
    }

    private void iniciarTalonario() {
        int contador = 0;
        for (int fila = 0; fila < filas; fila++) {
            for (int columna = 0; columna < columnas; columna++) {
                talonario[fila][columna] = new Boletos(contador);
                contador++;

            }
        }
    }

    private Boletos buscarBoletosxNumero(int numero) {
        if (numero < 0 || numero >= filas * columnas) {
            return null;
        }
        int fila = numero / columnas;
        int columna = numero % columnas;
        return talonario[fila][columna];
    }

    public void imprimirTalonario() {
        String texto = "Talonario";

        for (int fila = 0; fila < filas; fila++) {
            String lineaFila = "";
            for (int columna = 0; columna < columnas; columna++) {
                Boletos boleto = talonario[fila][columna];
                if (boleto.isDisponible()) {
                    lineaFila += String.format("%02d", boleto.getNumero()) + " ";
                } else {
                    lineaFila += " X ";
                }
            }
            texto += lineaFila + "\n"; // el salto de linea da formato a la cuadricula
        } 

        JOptionPane.showMessageDialog(null, texto);
    }

    public void ventaManual() {
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de boleto que desea comprar (0-99):"));

        Boletos boleto = buscarBoletosxNumero(numero);

        if (boleto == null) {
            JOptionPane.showMessageDialog(null, "El numero ingresado no es valido. Debe estar entre 0 y 99.");
            return;
        }

        if (!boleto.isDisponible()) {
            JOptionPane.showMessageDialog(null, "El boleto num " + numero + " ya fue vendido. No se puede comprar.");
            return;
        }

        String nombreComprador = JOptionPane.showInputDialog("Ingrese su nombre ");
        String telefonoComprador =  JOptionPane.showInputDialog("Ingrese su numero de telefono ");
        

        JOptionPane.showMessageDialog(null, "Compra realizada. Numero de boleto: "+ numero);
    }

    public void calcularVariablesRifa() {
        variableRifaTodos = 0;
        variableRifaMayor = 0;
        for (int fila = 0; fila < filas; fila++) {
            for (int columna = 0; columna < columnas; columna++) {
                Boletos boleto = talonario[fila][columna];
                if (boleto.isDisponible()) {
                    variableRifaTodos += valor;
                    variableRifaMayor += boleto.getNumero();
                }
            }
        }
    }

    public void galloTapado() { // comprar al azar
        calcularVariablesRifa();

        int cantidad = Integer.parseInt(JOptionPane.showInputDialog("¿Cuantos boletos desea comprar al azar?"));

        if (cantidad <= 0) {
            JOptionPane.showMessageDialog(null, "Ingrese un numero mayor a 0.");
            return;
        }
        int disponibles = 0;
        for (int fila = 0; fila < filas; fila++) {
            for (int columna = 0; columna < columnas; columna++) {
                if (talonario[fila][columna].isDisponible()) {
                    disponibles++;
                }
            }
        }
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del comprador:");
        String telefono = JOptionPane.showInputDialog("Ingrese el telefono del comprador:");

        String resultado = "Boletos asignados al azar:";
        int asignados = 0;

        while (asignados < cantidad) {
            int numeroAleatorio = (int) (Math.random() * (filas * columnas));
            Boletos boleto = buscarBoletosxNumero(numeroAleatorio);

            if (boleto.isDisponible()) {
                boleto.setNombreComprador(nombre);
                boleto.setTelefonoComprador(telefono);
                boleto.setDisponible(false);
                resultado += "Boleto num" + boleto.getNumero() + "\n";
                asignados++;
            }

        }

        JOptionPane.showMessageDialog(null, resultado);
    }
}
