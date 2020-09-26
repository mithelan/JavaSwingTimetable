/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OverSession;

/**
 *
 * @author Microsoft
 */
public class OverlapSession {
    
    private int id;
    private String day;
    private String starttime;
    private String session1;
    private String session2;
    
    public OverlapSession(int id,String day,String starttime,String session1,String session2){
        this.id=id;
        this.day=day;
        this.starttime=starttime;
        this.session1=session1;
        this.session2=session2;
        
    }
    
    public int getid(){
        return id;
    }
    
    public String getday(){
        return day;
    }
    
    public String getstarttime(){
        return starttime;
        
    }
    public String getsession1(){
        return session1;
    }
     public String getsession2(){
        return session2;
    }
}
