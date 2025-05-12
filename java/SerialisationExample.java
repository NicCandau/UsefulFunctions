import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
        // This is a 'try with resources' - a try statement that declares a resource, 
        // that will automatically close after the try statement has finished (or an exception has occurred).
        try(
            FileOutputStream fileOutputStream = new FileOutputStream(saveFile);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        ){
            // Checks if file exists -> creates file if not.
            saveFile.createNewFile();
            objectOutputStream.writeObject(person);
            objectOutputStream.flush();
        }
        catch (IOException e){
            System.out.println("Error when creating save file:" +e.getMessage());
        }
    }

    /**
     * The 'load' method deserialises a 'Person' object from a file.
     */
    public static Person loadPerson() throws IOException, ClassNotFoundException{
        // Check that the file exists.
        if (!saveFile.exists()){
            throw new FileNotFoundException("Save file does not exist");
        }
        try(
            FileInputStream fileInputStream = new FileInputStream(saveFile);
            ObjectInputStream objectInputStream =  new ObjectInputStream(fileInputStream);
        ){
            return (Person) objectInputStream.readObject();
        }
        catch (IOException | ClassNotFoundException e){
            System.out.println("Error when loading save file: " + e.getMessage());
        }
        return null;
    }
}
