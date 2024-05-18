package github.mariapas235.utils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XMLManager {

    /**
     * Writes an object to an XML file.
     * @param c the object to write
     * @param filename the name of the XML file
     * @return true if the operation is successful, false otherwise
     */
    public static <T> boolean writeXML(T c,String filename){
        boolean result=false;
        JAXBContext context;
        try{
            context = JAXBContext.newInstance(c.getClass());
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            m.setProperty(Marshaller.JAXB_ENCODING,"UTF-8");
            m.marshal(c,new File(filename));
            result=true;
        }catch (JAXBException e){
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Reads an object from an XML file.
     * @param c an instance of the object to read, used for type inference
     * @param filename the name of the XML file
     * @return the object read from the XML file
     */
    public static<T> T readXML(T c,String filename){
        T result = c;
        JAXBContext context;

        try{
            context = JAXBContext.newInstance(c.getClass());
            Unmarshaller um = context.createUnmarshaller();
            result = (T) um.unmarshal(new File(filename));
        }catch (JAXBException e){
            e.printStackTrace();
        }
        return result;
    }
}
