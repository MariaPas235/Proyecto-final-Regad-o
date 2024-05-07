package github.mariapas235.model.entity;

public class Session {
    private static Session _instance;
    private static Person userLogged;
    private Session(){

    }

    public static Session getInstance(){
        if (_instance==null){
            _instance = new Session();
            _instance.logIn(userLogged);
        }
        return _instance;
    }
    public void logIn(Person person){
        userLogged=person;
    }

    public Person getUserLogged(){
        return userLogged;
    }

    public void logOut(){
        userLogged=null;
    }
}

