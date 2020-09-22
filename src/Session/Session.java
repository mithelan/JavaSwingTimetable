/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

/**
 *
 * @author ASUS
 */
class Session {
    

    private String lecturer1,lecturer2,lecturer3,lecturer4,tag,studentGroup,subject,no_of_students,subgroup,sessionDuration;
  
    
    public Session(String lecturer1, String lecturer2,String lecturer3,String lecturer4,String tag
    ,String studentGroup,String subject,String no_of_students,String subgroup,String sessionDuration ){
        
       this.lecturer1=lecturer1;
       this.lecturer2=lecturer2;
       this.lecturer3=lecturer3;
       this.lecturer4=lecturer4;
       this.tag=tag;
       this.studentGroup=studentGroup;
       this.subject=subject;
       this.no_of_students=no_of_students;
       this.subgroup=subgroup;
       this.sessionDuration=sessionDuration;
    }
    
    public String getlecturer1(){
        return lecturer1;
    }
    
    public String getlecturer2(){
        return lecturer2;
    }
      public String getlecturer3(){
        return lecturer3;
    }
     public String getlecturer4(){
        return lecturer3;
    }
      public String gettag(){
        return tag;
    }
        public String getstudentGroup(){
        return studentGroup;
    }
          public String getsubject(){
        return subject;
    }
            public String getno_of_students(){
        return no_of_students;
    }
        public String  getsubgroup(){
        return subgroup;
    }  
        public String getsessionDuration(){
        return sessionDuration;
    }
    
    
    
}

