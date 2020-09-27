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
public class NotAvailableLecClass {
    
    private int id;
    private String Day;
    private String lecturer;
    private String nat;
   
    
    
    public NotAvailableLecClass(int id,String Day,String lecturer,String nat){
        this.id=id;
        this.nat=nat;
        this.lecturer=lecturer;
        this.Day=Day;
        
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
     public String getlecturer(){
       return lecturer;
   }
    
    
    
    
    
    
}
