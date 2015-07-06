/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjectOrientedDesign;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author marcsantiago
 */
// Design a musical jukebox using object oriented design


class CD{
    private final String cdName;
    private final String [] songs;
    private final String album;
    public CD(String cdName, String [] songs){
        this.cdName = cdName;
        this.songs = songs;
        this.album = cdName + " " + Arrays.toString(songs);
    }
    
    public String getAlbum(){
        return album;
    }
    
    public String getCDName(){
        return cdName;
    }
}

class CDPlayer{
    private final int maxCDS = 10;
    private final ArrayList<CD> cdList = new ArrayList<>();
    
    public void addCD(String cdName, String [] songs){
        if(cdList.size() < 10){
            cdList.add(new CD(cdName, songs));
        }
        else{
            System.out.println("CD player is full try removing a cd first");
        }
    }
    
    public void removeCD(String cdName){
        for (int i = 0; i < cdList.size(); i++) {
            if(cdList.get(i).getCDName().equals(cdName)){
                cdList.remove(i);
            }
        }
    }
    
    public void clearCDList(){
        cdList.clear();
    }
    
    public ArrayList<CD> getCDList(){
        return cdList;
    }
}

class User extends CDPlayer{
    private String name = "";
    private String id = "";
    private final ArrayList<User> users = new ArrayList<>();
    
    public User(){

    }
 
    public User(String name, String id){
        this.name = name;
        this.id = id;
    }

    
    public void addUser(String name, String id){        
        User newPerson = new User(name, id);
        if(!users.contains(newPerson)){
            users.add(newPerson);
        }
    }
    
    public void deleteUser(String name, String id){
        try{
            users.remove(new User(name, id));
        }
        catch(Exception e){
            System.out.println(e);
        }
        
    }
    
    public ArrayList<User> getUsers(){
        return users;
    }
    
    public String getName(){
        return name;
    }
    
    public String getID(){
        return id;
    }
    
}

public class JukeBox extends User{
    private User defaultUser;
    private Map<User, ArrayList<CD> > saveState = new HashMap<>();
    public JukeBox(String name, String id) {
        addUser(name, id);
        defaultUser = new User(name, id);
    }   
    
    public void changeDefaultUser(String name, String id){  
        User newPerson = new User(name, id);
        for(User u : getUsers()){
            if(newPerson.getName().equals(u.getName())){
                this.defaultUser = newPerson;
            }
        }
        clearCDList();
    }
    
    public void saveUserMusic(){
        saveState.put(defaultUser, getCDList());
    }
    
    public void displayCurrentUserInformation(){
        if(!saveState.isEmpty()){
            System.out.println("User: " + defaultUser.getName() + " ID: " + defaultUser.getID());
            ArrayList<CD> v  = saveState.get(defaultUser);
            for(CD c : v){
                System.out.println(c.getCDName() + " "  + c.getAlbum());
            }     
        }
        else{
            System.out.println("No Data has been saved to display");
            System.out.println("Remeber to save user data");
        }
        
    }
}