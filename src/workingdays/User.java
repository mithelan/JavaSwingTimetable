/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workingdays;

/**
 *
 * @author asvin
 */
class User {
    private String empID,empName,wDays,wTimePerDay,timeSlot;
    private int dayNo;
    
    public User(String empID,String empName,int dayNo,String wDays, String wTimePerDay, String timeSlot){
        this.empID = empID;
        this.empName=empName;
        this.dayNo = dayNo;
        this.wDays=wDays;
        this.wTimePerDay=wTimePerDay;
        this.timeSlot = timeSlot;
    }
    
    public String getempID(){
        return empID;
    }
    
    public String getempName(){
        return empName;
    }
    
     public int getdayNo(){
        return dayNo;
    }
     
      public String getwDays(){
        return wDays;
    }
      
      public String getwTimePerDay(){
        return wTimePerDay;
    }
      
      public String gettimeSlot(){
        return timeSlot;
    }
      
    
}
