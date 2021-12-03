import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;

public class BufferWriter {

    //global variables to help out
    private static final String DATA_FILE = "data.txt";
    private static Scanner in;
    private static BufferedWriter out;

    //writeString
    public static void writeLine(String s) {
        // check to see if out is assigned
        if (out == null) {
            try {
                out = new BufferedWriter(new FileWriter(DATA_FILE));
            } catch (Exception e) {
                System.err.println("Cannot open file for output!");
                e.printStackTrace();
            }
        }

        try {
            out.write(s);
            out.newLine();
        } catch (Exception e) {
            System.err.println("Cannot write file!");
            e.printStackTrace();
        }
    }   
    //saveAndClose
    public static void saveAndClose(){
        //closes after scanner is done reading the file
        if(in!=null){
            try {
                in.close();
                in = null;
            } catch (Exception e) {
                System.err.println("Cannot close input file!");
                e.printStackTrace();
            }
        }
        //clases after the bufferedwriter is done writing to the file
        if(out!=null){
            try{
                out.close();
                out=null;
            }
            catch(Exception e){
                System.err.println("Cannot close output file!");
                e.printStackTrace();
            }
        }
    }
    //readString
    public static String readLine(){
        //check to see if you are alread reading
        if(in == null){
            try{
                in = new Scanner(new File(DATA_FILE));
            }
            catch(Exception e){
                System.err.println("Cannot Open file for input");
                e.printStackTrace();
            }
        }
        //read in values from the text file
        try{
            //check to see if in hasNext line
            if(in.hasNext()){
                String s = in.nextLine();
                return s;   //grabbing everything
            }
            else{
                return null;
            }
        }
        catch(Exception e){
            System.err.print("Cannot read the file");
            e.printStackTrace();
        }
        return null;
    }
}

