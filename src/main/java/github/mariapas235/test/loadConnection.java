package github.mariapas235.test;
import github.mariapas235.model.connection.ConnectionProperties;
import github.mariapas235.utils.XMLManager;


public class loadConnection {
    public static void main(String[] args) {
        ConnectionProperties c = XMLManager.readXML(new ConnectionProperties(),"connection.xml");
        System.out.println(c);

    }

}
