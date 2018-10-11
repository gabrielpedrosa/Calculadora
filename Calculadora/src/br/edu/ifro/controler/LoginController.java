/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifro.controler;

import java.awt.event.ItemEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 80923755268
 */
public class LoginController implements Initializable {

    @FXML
    private TextField txtlogin;
    
    @FXML
    private Button btlogin;
    
    @FXML
    private CheckBox ckboxsenha;
    
    @FXML
    private PasswordField pwsenha;
    
    @FXML
    private TextField txtsenha;
    
    private void ckboxsenha (ItemEvent evt) {
      
    }
    
    @FXML
    private void login(ActionEvent event){
             
        if(txtlogin.getText().equals("root") && (txtsenha.getText().equals("root") || (pwsenha.getText().equals("root")))){
            System.out.println("Parabéns, você entrou na Matrix!");
       
         try{
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/br/edu/ifro/Calculadora.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setResizable(false);
            stage.setTitle("Calculadora");
            stage.setScene(scene);
            stage.show();
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        Stage stage = (Stage) btlogin.getScene().getWindow();
        stage.close();
    
        }
        
	else
            System.out.println("Senha errada!");
			
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

    @FXML
    private void MostrarSenha(MouseEvent event) {
        if (pwsenha.isVisible()) {
            String r = pwsenha.getText();
            pwsenha.setVisible(false);
            txtsenha.setText(r);
        } else {           
            pwsenha.setVisible(true);
            
        }
                
        
        
    }   
    
}
