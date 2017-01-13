/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esbjergskolefodboldtunering.dal;

import esbjergskolefodboldtunering.be.Team;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luttejensen
 */
public class dalTeamManager 
{
   
    
    /**
     * save teams
     * @param teamName
     */
    public void saveTeams(Team team)
    {
        String teamString = "";
        String fileName = team.getTeamName() + ".txt";
        File file = new File("DataFiler/Teams/" + fileName);
        System.out.println(file.getAbsolutePath());
        
        // her tjekker vi om teamet allerede eksistere, hvis det gør, så gemmer vi den ikke
        if (!file.exists())
        {
            try 
            {
                file.createNewFile();   
            }
            catch (IOException ex)
             {
                   Logger.getLogger(dalTeamManager.class.getName()).log(Level.SEVERE, null, ex); 
             }
        }
        // her fortæller vi de parameter vores team skal have
//        teamString += team.getTeamID()
//                    + ","
//                    + team.getTeamName()
//                    + ","
//                    + team.getGroup();

        teamString += team.getTeamName();
        
        // her gemmer vi teamet
        try (BufferedWriter bufWriter = new BufferedWriter(new FileWriter("DataFiler/Teams/" + fileName)))
        {
            bufWriter.write(teamString);
            System.out.println(teamString);
        }
        catch (IOException ex)
        {
            Logger.getLogger(dalTeamManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    /**
     * get saved teams and return them in a list
     * @return 
     * @throws java.io.IOException
     */
    public List<Team> allTeams() throws IOException
    {
        File dir1 = new File("DataFiler/Teams/");
        if (!dir1.exists())
        {
            dir1.mkdir();
        }
        
        List<Team> allTeams = new ArrayList<>();
        
        Path dir = Paths.get("DataFiler/Teams/");
                
         try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, "*.txt"))
         {
             for (Path entry : stream) 
             {
                try (BufferedReader buffReader = new BufferedReader(new FileReader("DataFiler/Teams/" + entry.getFileName())))
                {
                    String dataLinje = buffReader.readLine();
                   //String[] splitData = dataLinje.split(",");
                   
                  // String teamID = splitData[1];
                  // String teamName = splitData[0];
                    //String group = splitData[2];
                    
 //                   Team team = new Team(teamName, group);
                    
                   // Team team = new Team(teamID, teamName, group);
                     String teamName = dataLinje;
                     Team team = new Team(teamName);
                    allTeams.add(team);
                }
             }
                                        
             }
         
        return allTeams;
    }
}
