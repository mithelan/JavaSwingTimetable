/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

/**
 *
 * @author ASUS
 */
public class GenerateSession {
    
    private int sessionId;
    private String GenerateSession;
    
    public GenerateSession(int sessionId,String GenerateSession){
        this.sessionId=sessionId;
        this.GenerateSession=GenerateSession;
        
    }
     public int getsessionId(){
        return sessionId;
    }
    
    public String getGenerateSession(){
        return GenerateSession;
    }
    
    
    
    
}
