/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjectOrientedDesign;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Random;
/**
 *
 * @author marcsantiago
 */

// Image you have a call center with three levels of employees: respondent, manager, and director.
// An in coming call must first be allocated to a respondent who is free.  If the respondent can't handle the call
// he or she must escalate the call to a manager.  If the manager is not free or not able to handle it, then the call
// should be escalated to the director.  Design the classes and data structures for this problem.  Implement a method
// dispatchCall() which assigns a call to the first available employee.
public class CallCenter {
    Queue<Respondent> respondent = new LinkedList<>();
    Queue<Manager> manager = new LinkedList<>(); 
    Queue<Director> director = new LinkedList<>(); 
    public CallCenter(int numberOfRespondents, int numberOfManagers, int numberOfDirectors){
        for (int i = 0; i < numberOfRespondents; i++) {
            respondent.add(new Respondent());
        }
        
        for (int i = 0; i < numberOfManagers; i++) {
            manager.add(new Manager());
        }
        
        for (int i = 0; i < numberOfDirectors; i++) {
            director.add(new Director());
        }
    }
    
    
    public void dispatchCall(){
        // test arbitrary number of calls
        Random r = new Random();
        int calls = r.nextInt(10);
        
        while(calls != 0){
            // respondents should take the call first
            while(!respondent.isEmpty()){
                Respondent obj = respondent.peek();
                if(obj.isBusy()){
                    respondent.remove();
                }
                else{
                    System.out.println(obj + " can take the call");
                    obj.setBusy(true);
                    respondent.add(obj);
                    calls--;
                }
            }
            // managers should take the call second
            while(!manager.isEmpty()){
                Manager obj = manager.peek();
                if(obj.isBusy()){
                    manager.remove();
                }
                else{
                    System.out.println(obj + " can take the call");
                    obj.setBusy(true);
                    manager.add(obj);
                    calls--;
                }
            }
            // director should take the call second
            while(!director.isEmpty()){
                Director obj = director.peek();
                if(obj.isBusy()){
                    director.remove();
                }
                else{
                    System.out.println(obj + " can take the call");
                    obj.setBusy(true);
                    director.add(obj);
                    calls--;
                }
            }
            
            //since directors are all used but the loop is still running
            //nothing is available and I should break the loop
            if(director.isEmpty() && calls != 0){
                System.out.println("All persons are busy please try your call again later");
                return;
            }
        }
        
    }
    
    
}

class Employee{
    private String name;
    private int age;
    private boolean busy = false;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isBusy() {
        return busy;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }
    
    
}

class Respondent extends Employee{
    private final int level = 1;

    public int getLevel() {
        return level;
    }
       
    
}

class Manager extends Employee{
    private final int level = 2;

    public int getLevel() {
        return level;
    }
}

class Director extends Employee{
    private final int level = 3;

    public int getLevel() {
        return level;
    }
}