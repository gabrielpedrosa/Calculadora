/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifro;

import br.edu.ifro.model.Historico;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * FXML Controller class
 *
 * @author 80923755268
 */
public class HistoricoController implements Initializable {

    @FXML
    private Button botlimpa;
    @FXML
    private Button botvolta;
    @FXML
    private TableView<?> tb_historico;
    @FXML
    private MenuItem calculadora;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("calculadora");
        EntityManager em = emf.createEntityManager();
        
        Query query = em.createQuery("select h from Historico h");
        List<Historico> list_alunos = query.getResultList();
        
        ObservableList obhistorico = FXCollections.observableArrayList(list_alunos);
        tb_historico.setItems(obhistorico);
    }   
        

    @FXML
    private void limpar(ActionEvent event) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("calculadora");
        EntityManager em = emf.createEntityManager();
        
        Historico historico = (Historico) tb_historico.getSelectionModel().getSelectedItem();
        
        Query query = em.createQuery("delete from Historico");
        
        em.getTransaction().begin();
        query.executeUpdate();
        em.getTransaction().commit();
    }

    @FXML
    private void voltar(ActionEvent event) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/br/edu/ifro/Calculadora.fxml"));
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
        Stage stage = (Stage) botvolta.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void calculadora(ActionEvent event) {
         try{
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/br/edu/ifro/Calculadora.fxml"));
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
        Stage stage = (Stage) botvolta.getScene().getWindow();
        stage.close();
    }
    
}
