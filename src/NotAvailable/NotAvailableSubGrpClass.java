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
public class NotAvailableSubGrpClass {
     private int id;
    private String Day;
    private String subgroup;
    private String nat;


    public NotAvailableSubGrpClass(int id,String Day,String subgroup,String nat){
        this.id=id;
        this.nat=nat;
        this.subgroup=subgroup;
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
     public String getsubgroup(){
       return subgroup;
   }
    









}
