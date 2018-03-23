/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifro;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author 80923755268
 */
public class CalculadoraController implements Initializable {
    
    @FXML
    private TextField txtnum01;
    
    @FXML
    private TextField txtnum02;
    
    @FXML
    private ComboBox cboxop;
    
    @FXML
    private TextField txtresultado;
    
    @FXML
    private Button botsoma;
    
    @FXML
    private void soma(ActionEvent event){
        double num01 = Double.parseDouble(txtnum01.getText());
        double num02 = Double.parseDouble(txtnum02.getText());
        if(cboxop.getValue().equals("+")){
            double soma = num01 + num02;
            String srtsoma = Double.toString(soma);
            txtresultado.setText(srtsoma);
        }
        else
            if(cboxop.getValue().equals("-")){
                double subtr = num01 - num02;
                String srtsubtr = Double.toString(subtr);
            txtresultado.setText(srtsubtr);
            }
        else if(cboxop.getValue().equals("*")){
                double mult = num01 * num02;
                String srtmult= Double.toString(mult);
            txtresultado.setText(srtmult);
            }
        else if(cboxop.getValue().equals("/")){
                double div = num01 / num02;
                String srtdiv= Double.toString(div);
            txtresultado.setText(srtdiv);
            }
        else{
                JOptionPane.showMessageDialog(null, "Parâmetro Incorreto");
        }
    }
    
    @FXML
    private void limpa(ActionEvent ev){
        txtnum01.setText("");
        txtnum02.setText("");
        txtresultado.setText("");
        cboxop.setValue(0);
        
    }
    
    @FXML
    private void cancela(ActionEvent e){
        
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
