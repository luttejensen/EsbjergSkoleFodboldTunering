/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esbjergskolefodboldtunering.be;

/**
 *
 * @author luttejensen
 */
public class Team 
{
    
    private String teamID;
    private String teamName;
    private String group;
    private int totalPoint;
    
//    public Team(String teamName, String group)
//    {
//        this.teamID = teamID;
//        this.teamName = teamName;
//        this.group = group;
//        totalPoint = 0;
//    }
    
    public Team(String teamName)
    {
        this.teamID = teamID;
        this.teamName = teamName;
        this.group = group;
        totalPoint = 0;
    }
    
//    public Team(String teamID, String teamName, String group)
//    {
//        this.teamID = teamID;
//        this.teamName = teamName;
//        this.group = group;
//        totalPoint = 0;
//    }

    public String getTeamID() {
        return teamID;
    }

    public void setTeamID(String teamID) {
        this.teamID = teamID;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getTotalPoint() {
        return totalPoint;
    }

    public void setTotalPoint(int totalPoint) {
        this.totalPoint = totalPoint;
    }
    
    
}
