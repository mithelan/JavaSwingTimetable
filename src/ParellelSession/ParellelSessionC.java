/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParellelSession;

/**
 *
 * @author Microsoft
 */
public class ParellelSessionC {
    
    private int id;
    private String startdate;
    private String starttime;
    private int duration;
    private String session1;
    private String session2;
    private String session3;
    
    public ParellelSessionC(int id, String startdate,String starttime,int duration, String session1,String session2,String session3){
        this.id=id;
        this.startdate=startdate;
        this.starttime=starttime;
        this.duration=duration;
        this.session1=session1;
        this.session2=session2;
        this.session3=session3;
    }
    
    
    
    public int getid(){
        return id;
    }
    
      public String getstartdate(){
        return startdate;
    }
    
      public String getstarttime(){
          return starttime;
      }
    public int getduration(){
        return duration;
    }
    
    public String getsession1(){
        return session1;
    }
    public String getsession2(){
        return session2;
    }
    
    public String getsession3(){
        return session3;
    }
    
}
