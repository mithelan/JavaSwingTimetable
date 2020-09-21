/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subgroup;

/**
 *
 * @author Microsoft
 */
public class Subgroupdetails {
    private int id ;
    private String subgrpid;
    
public Subgroupdetails(int id,String subgrpid){
    this.id=id;
    this.subgrpid=subgrpid;
}
public int getid(){
        return id;
    }
      
       public String getsubgroupid(){
        return subgrpid;
    }






}

