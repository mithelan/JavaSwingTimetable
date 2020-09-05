/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lecturer;

/**
 *
 * @author ASUS
 */
class User {
    
    private int empid;
    private String firstname,lastname,faculty,building,center,department,level,rank;
  
    
    public User(int empid, String firstname,String lastname,String faculty,String building
    ,String center,String department,String level,String rank ){
        
       this.empid=empid;
       this.firstname=firstname;
       this.lastname=lastname;
       this.building=building;
       this.center=center;
       this.faculty=faculty;
       this.level=level;
       this.rank=rank;
       this.department=department;
    }
    
    public int getempid(){
        return empid;
    }
    
    public String getfirstname(){
        return firstname;
    }
      public String getlastname(){
        return lastname;
    }
     public String getbuilding(){
        return building;
    }
      public String getcenter(){
        return center;
    }
        public String getfaculty(){
        return faculty;
    }
          public String getlevel(){
        return level;
    }
            public String getrank(){
        return rank;
    }
        public String getdepartment(){
        return department;
    }    
    
    
    
}
