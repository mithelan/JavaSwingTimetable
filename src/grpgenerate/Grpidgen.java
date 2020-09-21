/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grpgenerate;

/**
 *
 * @author Microsoft
 */
public class Grpidgen {
    
    private int id;
    private String grpidg;
    
    public Grpidgen(int id,String grpidg){
        this.id=id;
        this.grpidg=grpidg;
    }

  public int getid(){
        return id;
    }
      
       public String getgrpidg(){
        return grpidg;
    }



    
}
