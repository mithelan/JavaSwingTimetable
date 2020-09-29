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
    
private int id;
    private String lecturer1,lecturer2,lecturer3,lecturer4,tag,studentGroup,subject,no_of_students,subgroup,sessionDuration;
  
    
    public Session(String lecturer1,String tag
    ,String studentGroup,String subject,String no_of_students,int id ){
        
       this.lecturer1=lecturer1;
      
       this.tag=tag;
       this.studentGroup=studentGroup;
       this.subject=subject;
       this.no_of_students=no_of_students;
       this.id=id;
//       this.subgroup=subgroup;
//       this.sessionDuration=sessionDuration;
    }
    
    public String getlecturer1(){
        return lecturer1;
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
                 public int getid(){
        return id;
    }
            
            
//        public String  getsubgroup(){
//        return subgroup;
//    }  
//        public String getsessionDuration(){
//        return sessionDuration;
//    }
    
    
    
}

