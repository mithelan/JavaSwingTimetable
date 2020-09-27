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
public class NotAvailableSessionClass {
     private int id;
    private String Day;
    private String session;
    private String nat;
    
    
     public NotAvailableSessionClass(int id,String Day,String session,String nat){
        this.id=id;
        this.nat=nat;
        this.session=session;
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
     public String getsession(){
       return session;
   }
    

    
    
}
