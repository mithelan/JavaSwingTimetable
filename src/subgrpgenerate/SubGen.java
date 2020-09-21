/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subgrpgenerate;

/**
 *
 * @author Microsoft
 */
public class SubGen {
    
    private int id;
    private String subgrpidg;
    
    
    public SubGen(int id , String subgrpidg){
        this.id=id;
        this.subgrpidg=subgrpidg;
    }
    
      public int getid(){
        return id;
    }
      
       public String getsubgrpidg(){
        return subgrpidg;
    }
    
    
    
}
