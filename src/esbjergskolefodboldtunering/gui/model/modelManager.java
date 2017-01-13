/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esbjergskolefodboldtunering.gui.model;

import esbjergskolefodboldtunering.be.Team;
import esbjergskolefodboldtunering.bll.bllManager;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author luttejensen
 */
public class modelManager 
{
    private bllManager bllmanager;
    
    
    public modelManager()
    {
        bllmanager = new bllManager();
    }
    
      /**
     * all teams arranged in a list
     * @return 
     */
    public List<Team> allTeams() 
    {
        try 
        {
            return bllmanager.allTeams();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(modelManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
   
    
    /**
     * ObservableList with all teams
     * @return 
     */
    public ObservableList<Team> loadTeams()
    {
        try 
        {
            ObservableList<Team> savedTeams = FXCollections.observableArrayList(bllmanager.allTeams());
            return savedTeams;
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(modelManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
       
    /**
     * save team 
     * @param team
     */
    public void saveTeam(Team team)
    {
        bllmanager.saveTeams(team);  
    }
    
    /**
     * generate and open a new window
     * @param pane
     * @param viewName
     * @throws java.io.IOException
     */
    public void openNewWindow(Pane pane, String viewName) throws IOException
    {
        Stage primaryStage = (Stage) pane.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/esbjergskolefodboldtunering/gui/view/" + viewName + ".fxml"));
               
        Parent root = loader.load();
        
        Stage newView = new Stage();
        newView.initStyle(StageStyle.TRANSPARENT);
        newView.setScene(new Scene(root, Color.TRANSPARENT));
        newView.initModality(Modality.WINDOW_MODAL);
        newView.initOwner(primaryStage);
        newView.show();
    }
}
