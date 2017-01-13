/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esbjergskolefodboldtunering.gui.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import esbjergskolefodboldtunering.be.Team;
import esbjergskolefodboldtunering.gui.model.modelManager;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author luttejensen
 */
public class TilføjHoldController implements Initializable 
{

    @FXML
    private TextField txtFieldTH;
    @FXML
    private TextField txtFielsID;
    @FXML
    private TextField txtFieldGruppe;
    @FXML
    private Button btnTilføjHold;
    @FXML
    private Button btnCancel;
    @FXML
    private Button btnExit;
    @FXML
    private AnchorPane anchorPane;
    
    private modelManager modelmanager;
   
    private Team thisTeamID;
    private Team teams;
    private Team thisTeamName;
    private Team thisGroup;
    
    
    public TilføjHoldController()
    {
        modelmanager = new modelManager();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
    }   

    /**
     * use the Tilføj Hold button
     * save the team
     * @param event 
     */
    @FXML
    private void tilføjHoldButton(ActionEvent event) 
    {
       beforeSaveTeam();
    }
    
    /**
     * assign properties to team before we save it
     */
    private void beforeSaveTeam() 
    {
       String teamName = txtFieldTH.getText();
       String teamID = txtFielsID.getText();
       String group = txtFieldGruppe.getText();
       
       if (txtFieldTH.getText().isEmpty() && txtFieldGruppe.getText().isEmpty())
       {
           Alert alert = new Alert(Alert.AlertType.WARNING);
           alert.setTitle("fejl");
           alert.setHeaderText("Husk at udfylde hold navn" );
           alert.showAndWait();
       }
       else
       {
           //teams = new Team(teamID, teamName, group);
           teams = new Team(teamName);
           //teams = new Team(teamName, group);
           modelmanager.saveTeam(teams);
       }
      try 
        {
            modelmanager.openNewWindow(anchorPane, "holdView");
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(TilføjHoldController.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }

    /**
     * use the cancel button
     * exit the current window and return to the holdView
     * @param event 
     */
    @FXML
    private void cancelButton(ActionEvent event) throws IOException 
    {
        modelmanager.openNewWindow(anchorPane, "holdView");
    }

    /**
     * use the exit button
     * exit the current window and return to the main view
     * @param event 
     */
    @FXML
    private void exitButton(ActionEvent event) throws IOException 
    {
        modelmanager.openNewWindow(anchorPane, "ESFTMainView");
    }
    
    /**
     *set teamName for new team, from textField
     * @param teamName
     */
    public void settxtFieldTH(Team teamName)
    {
        thisTeamName = teamName;
        txtFieldTH.setText(thisTeamName.getTeamName());
    }
    
    /**
     * set ID for new team
     * @param teamID
     */
    public void setTxtFieldTID(Team teamID)
    {
        thisTeamID = teamID;
        txtFielsID.setText(thisTeamID.getTeamID());
    }
    
    /**
     * set group for new team
     * @param group
     */
    public void setTxtFieldGrupppe(Team group)
    {
        thisGroup = group;
        txtFieldGruppe.setText(thisGroup.getGroup());
    }
    
    
}
