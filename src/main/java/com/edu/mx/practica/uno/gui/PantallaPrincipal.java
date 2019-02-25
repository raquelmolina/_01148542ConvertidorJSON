package com.edu.mx.practica.uno.gui;

import com.edu.mx.practica.uno.convertidor.Convertidor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import com.edu.mx.practica.uno.Entidad.Persona;
import static java.lang.Class.forName;


public class PantallaPrincipal extends JFrame{

    JTextArea txtAreaConvertir,txtAreaConvertido;
    JPanel pPrincipal;
    JButton btnConvertir;
    JComboBox combo;
    JFrame ventana;
    Persona p;
    String[] bebe;

    public String string;

    public PantallaPrincipal() {
        setDefaultCloseOperation(3);
        setBounds(50,50,860,600);
        setTitle("Conversiones");
        iniciar();
    }

    public void iniciar(){

        pPrincipal = new JPanel();
        pPrincipal.setBounds(50,50,4000,800);
        pPrincipal.setBackground(Color.BLUE);
        pPrincipal.setVisible(true);

        txtAreaConvertir = new JTextArea();
        txtAreaConvertir.setBounds(50, 50, 300, 400);
        txtAreaConvertir.setVisible(true);

        txtAreaConvertido = new JTextArea();
        txtAreaConvertido.setBounds(500, 50, 300, 400);
        txtAreaConvertido.setVisible(true);

        btnConvertir = new JButton("Convertir");
        btnConvertir.setBounds(380, 225, 90,50);
        btnConvertir.setVisible(true);

        btnConvertir.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent e) {
                String tipo = (String) combo.getSelectedItem();
                String texto = txtAreaConvertir.getText();
                if(texto.trim().length()==0){
                    JOptionPane.showMessageDialog(null,"Texto Vacio", "No hay texto", JOptionPane.WARNING_MESSAGE);
                }
                else {
                    Convertidor convertidor = new Convertidor();
                    if (tipo.equals("JAVA")) {
                        convertidor = new Convertidor();
                        bebe = texto.split("-");
                        p = new Persona(bebe[0],bebe[1],bebe[2]);
                        String resultado = convertidor.Objecttojson(p);
                        txtAreaConvertido.setText("");
                        txtAreaConvertido.setText(resultado);

                    }
                    else {
                        JOptionPane.showMessageDialog(null,"Formato Invalido", "Formato Invalido", JOptionPane.WARNING_MESSAGE);
                    }
                    if (tipo.equals("XML") && texto.startsWith("<") && texto.endsWith(">")) {
                        txtAreaConvertido.setText(convertidor.convertirJsonToClase(texto));
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"Formato Invalido", "Formato Invalido", JOptionPane.WARNING_MESSAGE);
                    }

                }
            }
        });

        combo = new JComboBox();
        combo.setBounds(50,500,200,20);
        combo.addItem("XML");
        combo.addItem("JAVA");

        this.add(btnConvertir);
        this.add(combo);
        this.add(txtAreaConvertir);
        this.add(txtAreaConvertido);
        this.add(pPrincipal);
    }


    public static void main(String args[]) {
        PantallaPrincipal P = new PantallaPrincipal();
        P.setVisible(true);
    }
}