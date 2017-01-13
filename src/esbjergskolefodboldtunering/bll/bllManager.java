/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esbjergskolefodboldtunering.bll;

import esbjergskolefodboldtunering.be.Team;
import esbjergskolefodboldtunering.dal.dalTeamManager;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author luttejensen
 */
public class bllManager 
{
    private dalTeamManager dalTmanager;
    private Team team;
    
    public bllManager()
    {
        dalTmanager = new dalTeamManager();
    }

    /**
     * get all teams from file
     * @return 
     * @throws java.io.IOException 
     */
    public List<Team> allTeams() throws IOException 
    {
        return dalTmanager.allTeams();
    }

    
    /**
     * save team
     * @param teamName 
     */
    public void saveTeams(Team team)
    { 
        dalTmanager.saveTeams(team);
    }
    
}
