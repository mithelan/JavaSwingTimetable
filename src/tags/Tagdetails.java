/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tags;

/**
 *
 * @author Microsoft
 */
public class Tagdetails {
    private int id;
    private String tag;
    
    public Tagdetails(int id,String tag){
        this.id=id;
        this.tag=tag;
    }
    
     public int getid(){
        return id;
    }
      
       public String gettag(){
        return tag;
    }

    
    
}
