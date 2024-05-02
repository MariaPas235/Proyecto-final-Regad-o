package github.mariapas235.test;
import github.mariapas235.model.connection.ConnectionProperties;
import github.mariapas235.utils.XMLManager;
public class saveConnection {
    public static void main(String[] args) {
        ConnectionProperties c = new ConnectionProperties("localhost","3306","Irrigation","root","root");
        XMLManager.writeXML(c,"connection.xml");
    }
}
