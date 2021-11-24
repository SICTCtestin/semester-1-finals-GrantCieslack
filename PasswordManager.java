import java.util.Scanner;
import javax.print.DocFlavor.SERVICE_FORMATTED;
import java.util.ArrayList;
import java.nio.file.Files;
import java.io.File;
import java.nio.file.Paths;

public class PasswordManager {
    public static String userData;
    public static ArrayList <Accounts>  savedAccounts = new ArrayList<Accounts>();

    public static void main(String[] args){
        PasswordLogin.main();
    }
    public static void firstTimeSetup(String u){
      userData=u;
      addAcct();
      accessAccount(userData);
    }
    public static void accessAccount(String u){
      userData=u;

        Scanner ui = new Scanner(System.in);
        //display categories
        //allow to see passwords, add passwords, delete passwords, delete accounts,
        
        dataConversion();

            System.out.println("Enter the Category you want to view ([all] to see all)?");
            viewCat(ui.nextLine());
    }
    

    public static void dataConversion(){
        // int i=0;
        
        boolean data = true;

        while(data){
          String temp = (BufferWriter.readLine());
          if(temp==null){
              data=false;
            }
          else{
          splitDat(temp);
            }
        }

        
      
    }

    public static void splitDat(String s){
        //splits Strings from txt and makes them into accounts
        String[] temp = s.split(",", 4);
        String t =temp[0];
        String un =temp[1];
        String pw =temp[2];
        String c =temp[3];
        
        savedAccounts.add(new Accounts(t,un,pw,c));
    }

    public static void viewCat(String c){
        //show category and accounts associated
        Scanner ui = new Scanner(System.in);

        if(c.equals("all")){
          int i=0;
          while(i<savedAccounts.size()){
                printArray(i);
              i++;           
            }
        }
        else{
          int i=0;       
          while(i<savedAccounts.size()){
            if(savedAccounts.get(i).getCategory(null).equals(c)){
                printArray(i);
            }
              i++;         
          }

        System.out.println("Would you like to: [add] a account, [delete] a account, [change] a password");

        String input = ui.nextLine();
        if(input.equals("add")){
            addAcct();
        }
        else if(input.equals("delete")){
          System.out.println("Enter number of the account to delete");
          int d = ui.nextInt();
          savedAccounts.remove(d);
          rewriteFile();
        }
        else if(input.equals("change")){
            System.out.println("Enter number of the account");
            int ch = ui.nextInt();
            System.out.println("What is the new Password?");
            savedAccounts.get(ch).setPassword(ui.nextLine());
            rewriteFile();
        }
        else{accessAccount(userData);}

        accessAccount(userData);
    }
    }

    public static void printArray(int i){
        Accounts temp = savedAccounts.get(i);
        String t = temp.getTitle(null);
        String u = temp.getUsername(null);
        String p = temp.getPassword(null);
        String c = temp.getCategory(null);

        System.out.printf("%d - Account: %s ; User: %s ; Password: %s ; Category: %s\n",i,t,u,p,c);
    }

    public static void saveData(String t, String u, String p, String c){
        BufferWriter.writeLine(t+","+u+","+p+","+c);
        
    }
    
    public static void addAcct(){
        Scanner ui = new Scanner(System.in);
        //Accounts(String t, String un, String pw, String c)
        System.out.println("Enter title of new account");
        String t = ui.nextLine();

        System.out.println("Enter username of new account");
        String un = ui.nextLine();

        System.out.println("Enter password of new account");
        String pw = ui.nextLine();
        PasswordCheck.checkPass(pw);

        System.out.println("Enter category of new account");
        String c = ui.nextLine();

        saveData(t, un, pw, c);
        splitDat(t+","+un+","+pw+","+c);
    }

    public static void rewriteFile(){
      BufferWriter.deleteFile();
      BufferWriter.writeLine(userData);
    int i=0;       
          while(i<savedAccounts.size()){
            System.out.println("saving account");
            Accounts temp = savedAccounts.get(i);
        String t = temp.getTitle(null);
        String u = temp.getUsername(null);
        String p = temp.getPassword(null);
        String c = temp.getCategory(null);
        saveData(t, u, p, c);
              i++; 
      
    }
}
}