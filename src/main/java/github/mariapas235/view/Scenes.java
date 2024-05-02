package github.mariapas235.view;

public enum Scenes {
    WELCOME("view/welcome.fxml"),
    ROOT("view/layout.fxml"),
    LOGIN("view/login.fxml"),
    REGISTRER("view/registrer.fxml"),
    REGISTRERWORKER("view/registrerWorker.fxml"),
    LOGINWORKER("view/loginWorker.fxml"),
    REGISTRERBOSS("view/registrerBoss.fxml"),
    LOGINBOSS("view/logInBoss.fxml");

    private String url;
    Scenes(String url){
        this.url=url;
    }
    public String getUrl(){
        return url;
    }
}
