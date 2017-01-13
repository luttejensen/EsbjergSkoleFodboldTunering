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
 * FXML Controller class
 *
 * @author luttejensen
 */
public class HoldViewController implements Initializable {

    @FXML
    private TableColumn<Team, String> teamIDColumnHV;
    @FXML
    private TableColumn<Team, String> holdNavnColumnHV;
    @FXML
    private TableColumn<Team, String> gruppeColumnHV;
    @FXML
    private Button exitHVButton;
    @FXML
    private TableView<Team> hVTableView;
    @FXML
    private Button btnTilføjHold;
    @FXML
    private AnchorPane anchorPane;
    
    private modelManager modelmanager;
    
    public HoldViewController()
    {
        modelmanager = new modelManager();
    }

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        populateTableView();
        //teamIDColumnHV.setCellValueFactory(new PropertyValueFactory<>("teamID"));
        //holdNavnColumnHV.setCellValueFactory(new PropertyValueFactory<>("teamName"));
        //gruppeColumnHV.setCellValueFactory(new PropertyValueFactory<>("group"));
       // holdNavnColumnHV.setCellValueFactory(value -> new SimpleObjectProperty<>(value.getValue().getTeamName()));
        
        //hVTableView.setItems(modelmanager.getAllTeams());  
    } 
    
     /**
     * populate tableview with teams
     */
    public void populateTableView()
   {
     holdNavnColumnHV.setCellValueFactory(new PropertyValueFactory<>("teamName"));
     teamIDColumnHV.setCellValueFactory(new PropertyValueFactory<>("teamID"));
     gruppeColumnHV.setCellValueFactory(new PropertyValueFactory<>("group"));
     hVTableView.setItems(modelmanager.loadTeams());
       
       
   }

    /**
     * use the Tilføj hold button
     * add a new team 
     * @param event 
     */
    @FXML
    private void addTeamButton(ActionEvent event) throws IOException 
    {
       modelmanager.openNewWindow(anchorPane, "tilføjHold");
    }
    
    

    /**
     * use the exit button
     * exit current window and return to main window
     * @param event 
     */
    @FXML
    private void exitholdView(ActionEvent event) throws IOException 
    {
        modelmanager.openNewWindow(anchorPane, "ESFTMainView");
    }
    
}
