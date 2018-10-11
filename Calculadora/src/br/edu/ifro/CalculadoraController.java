/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifro;

import br.edu.ifro.model.Historico;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
    private Button botcancela;
    @FXML
    private Button botlimpa;
    @FXML
    private MenuItem historico;
    
    @FXML
    private void soma(ActionEvent event){
        if(txtnum01.getText().equals("") || txtnum02.getText().equals("") || cboxop.getValue().equals("")){
            JOptionPane.showMessageDialog(null, "Os campos marcados com '*' deve ser preenchidos");
        }
        else{
            double num01 = Double.parseDouble(txtnum01.getText());
            double num02 = Double.parseDouble(txtnum02.getText());
            String operacao = cboxop.getValue().toString();
            String srtnum01 = Double.toString(num01);
            String srtnum02 = Double.toString(num02);
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("calculadora");
            EntityManager em = emf.createEntityManager();
            Historico h = new Historico();
            h.setCalc_numero1(srtnum01);
            h.setCalc_numero2(srtnum02);
            h.setCalc_operacao(operacao);
                if(operacao.equals("Soma")){
                    double soma = num01 + num02;
                    String srtsoma = Double.toString(soma);
                    h.setCalc_resultado(srtsoma);
                    txtresultado.setText(srtsoma);
                }
                else if(operacao.equals("Subtração")){
                    double subtr = num01 - num02;
                    String srtsubtr = Double.toString(subtr);
                    h.setCalc_resultado(srtsubtr);
                    txtresultado.setText(srtsubtr);
                }
                else if(operacao.equals("Multiplicação")){
                    double mult = num01 * num02;
                    String srtmult= Double.toString(mult);
                    h.setCalc_resultado(srtmult);
                    txtresultado.setText(srtmult);
                }
                else if(operacao.equals("Divisão")){
                    double div = num01 / num02;
                    String srtdiv= Double.toString(div);
                    h.setCalc_resultado(srtdiv);
                    txtresultado.setText(srtdiv);
                }

            em.getTransaction().begin();
            em.persist(h);
            em.getTransaction().commit();
            
            //limpa(event);
            }
        
    }
    
    @FXML
    private void limpa(ActionEvent ev){
        txtnum01.setText("");
        txtnum02.setText("");
        txtresultado.setText("");
        cboxop.setValue("");
       // cboxop.setPromptText("Operação");
        
    }
    
    @FXML
    private void cancela(ActionEvent e){
       Stage stage = (Stage) botcancela.getScene().getWindow();
        stage.close();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void historico(ActionEvent event) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/br/edu/ifro/Historico.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.setTitle("Historico");
            stage.setScene(scene);
            stage.show();
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        Stage stage = (Stage) botcancela.getScene().getWindow();
        stage.close();
    }
    
}
