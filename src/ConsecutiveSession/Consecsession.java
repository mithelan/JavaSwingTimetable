/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConsecutiveSession;

/**
 *
 * @author Microsoft
 */
public class Consecsession {
    private int id;
    private String lecture;
    private String lab;
    private String tutorial;
    
    
    public Consecsession(int id,String lecture,String lab,String tutorial){
        this.id=id;
        this.lecture=lecture;
        this.lab=lab;
        this.tutorial=tutorial;
    }
    
     public int getid(){
        return id;
    }
     
      public String getlecture(){
        return lecture;
    }
    
     public String  getlab(){
        return lab;
    }
    public String gettutorial(){
        return tutorial;
    }
    
}
