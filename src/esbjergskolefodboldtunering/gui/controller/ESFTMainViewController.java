/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esbjergskolefodboldtunering.gui.controller;

import esbjergskolefodboldtunering.be.Team;
import esbjergskolefodboldtunering.gui.model.modelManager;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author luttejensen
 */
public class ESFTMainViewController implements Initializable {

    @FXML
    private Button btnHold; 
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private TableView<?> tablVGruppeC;
    @FXML
    private TableView<?> tablVGruppeD;
    @FXML
    private TableView<?> tblVGruppeB;
    @FXML
    private TableView<Team> tblVGruppeA;
    @FXML
    private TableColumn<Team, String> tblColumnHNGruppeB;
    @FXML
    private TableColumn<Team, String> tblColumnHNGruppeA;
    
     
    private modelManager modelmanager;
    private int currentNumberOfTeamsInGroup1;
    
    public ESFTMainViewController()
    {
        modelmanager = new modelManager();
        //currentNumberOfTeamsInGroup1 = tblVGruppe1.getItems().size();
    }
  
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        populateTableView();
    } 
    
    
    /**
     * populate tableview
     */
    public void populateTableView()
    {
      tblColumnHNGruppeA.setCellValueFactory(new PropertyValueFactory<>("teamName"));
     // tblColumnGruppe1ID.setCellValueFactory(new PropertyValueFactory<>("teamID"));
      tblVGruppeA.setItems(modelmanager.loadTeams());  
    }
    /**
     * use exit button to close program
     * exit the program
     */
    @FXML
    private void exitButton(ActionEvent event)
    {
        System.exit(1);
    }
    
    /**
     * use the Hold button
     * open view with all teams 
     * here you can add a new team
     */
    @FXML
    private void holdButton(ActionEvent event) throws IOException
    {
        modelmanager.openNewWindow(anchorPane, "holdView");
    }
    

    
}
