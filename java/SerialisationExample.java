import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerialisationExample {
    private static File saveFile = new File("example.txt");
  
    /**
     * The 'save' method serialises a 'Person' object and outputs it to
     * a file (this is the 'flush' method). The ObjectOutputStream must be closed.
     * NOTE: To do this, the class you are serialising, and any of its subclasses,
     *  must implement the 'Serializable' interface.
     */
    public static void save(Person person) throws IOException {
        // Checks if file exists -> creates file if not.
        saveFile.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(saveFile);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(person);
        objectOutputStream.flush();
        objectOutputStream.close();
    }

    /**
     * The 'load' method deserialises a 'Person' object from a file.
     */
    public static Person load() throws IOException, ClassNotFoundException{
        FileInputStream fileInputStream = new FileInputStream(saveFile);
        ObjectInputStream objectInputStream =  new ObjectInputStream(fileInputStream);
        Person person = (Person) objectInputStream.readObject();    
        objectInputStream.close();
        return person;
    }
}
