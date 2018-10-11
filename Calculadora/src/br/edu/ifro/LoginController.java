/*Autor Eisen*/
package br.edu.ifro;
import br.edu.ifro.HistoricoController;
import com.google.common.hash.Hashing;
import java.awt.event.ItemEvent;
import java.io.IOException;


import javafx.event.ActionEvent;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

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
    private void Btlogin(ActionEvent event){
             
        if(txtlogin.getText().equals("Professor") && (txtsenha.getText().equals("professor") || (pwsenha.getText().equals("professor")))){
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
