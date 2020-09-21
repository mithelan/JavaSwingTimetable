/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spm;

/**
 *
 * @author Microsoft
 */
public class ysdetails {
     private int id;
    private String year;
    private String semester;
    
    
    public ysdetails(int id,String year,String semester){
         this.id=id;
        this.year=year;
        this.semester=semester;
    }
 
        
      public int getid(){
        return id;
    }
      
       public String getyear(){
        return year;
    }
      public String getsemester(){
        return semester;
    }
    
    
    
}
