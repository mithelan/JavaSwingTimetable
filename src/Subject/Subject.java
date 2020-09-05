/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Subject;

/**
 *
 * @author ASUS
 */
public class Subject {
     private int lduration,tduration,eduration,labhour,id;
    private String year,semester,sname,scode;
  
    
    public Subject(String year,String semester,String sname,String scode, int lduration,int tduration,int eduration,int labhour,int id )
    {  
       this.year=year;
       this.semester=semester;
       this.sname=sname;
       this.scode=scode;
       this.lduration=lduration;
       this.tduration=tduration;
       this.eduration=eduration;
        this.labhour=labhour;
         this.id=id;
    }
    
   
    
    public String getyear(){
        return year;
    }
      public String getsemester(){
        return semester;
    }
     public String getsname(){
        return sname;
    }
      public String getscode(){
        return scode;
    }
        public int getlduration(){
        return lduration;
    }
          public int gettduration(){
        return tduration;
    }
            public int geteduration(){
        return eduration;
    }
               public int getlabhour(){
        return labhour;
    }
                public int getid(){
        return id;
    }
         
         
    
}
