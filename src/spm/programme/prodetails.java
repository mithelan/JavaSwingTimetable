/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spm.programme;

/**
 *
 * @author Microsoft
 */
public class prodetails {
private String proname;
private int id;


public prodetails(int id,String proname)
{
        this.id=id;
        this.proname=proname;
}


   public int getid(){
        return id;
    }
      
       public String getproname(){
        return proname;
    }


}
