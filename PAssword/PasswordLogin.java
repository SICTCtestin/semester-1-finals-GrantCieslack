import java.util.Scanner;

import javax.imageio.plugins.tiff.ExifTIFFTagSet;
import javax.swing.plaf.synth.SynthEditorPaneUI;
import javax.xml.crypto.Data;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Files;
import java.io.File;
import java.nio.file.Paths;

public class PasswordLogin {

    public static void main(){
        if(Files.exists(Paths.get("data.txt"))){
            //NEED TO FIX READSTRING DOING NEXT LINE
            login();
        }
        else{
        Scanner ui = new Scanner(System.in);
        System.out.println("Welcome to the Password Manager!");
        System.out.println("Please enter username for new account:");
            String username=ui.nextLine();
        System.out.printf("Please enter password for %s:\n",username);
            String password=ui.nextLine();
            String loginCreds = username+","+password;
        BufferWriter.writeLine(loginCreds);
        ui.close();
    }
        BufferWriter.saveAndClose();
    }


    private static void login() {
        Scanner ui = new Scanner(System.in);
        //read user/pass from file
        //compare results
        //allow or deny(3 tries!)
        int tries = 3;
        String realUser=BufferWriter.readLine();

        while(tries!=0){
        System.out.println("Please enter username:");
            String username=ui.nextLine();
        System.out.printf("Please enter password for %s:\n",username);
            String password=ui.nextLine();
        String userPass = username+","+password;
        if(userPass.equals(realUser)){
            System.out.println("WELCOME!");
            PasswordManager.accessAccount();
        }
        else{
        tries--;
        System.out.println(tries+" tries left");
        }
        if(tries==0){
            break;
        }
        }
    }

}
