/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NotAvailable;

/**
 *
 * @author Microsoft
 */
public class NotAvailableGrpClass {
    
      private int id;
    private String Day;
    private String group;
    private String nat;
   
    
    
    public NotAvailableGrpClass(int id,String Day,String group,String nat){
        this.id=id;
        this.nat=nat;
        this.Day=Day;
        this.group=group;
        
    }
   public int getid(){
       return id;
   }
  
    
    
   public String getnat(){
       return nat;
   }
    public String getday(){
       return Day;
   }
     public String getgroup(){
       return group;
   }
    
    
    
    
}
