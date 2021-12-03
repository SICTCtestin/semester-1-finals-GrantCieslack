import java.util.Scanner;
import javax.print.DocFlavor.SERVICE_FORMATTED;
import java.util.ArrayList;

public class PasswordManager {

    public static ArrayList <Accounts>  savedAccounts = new ArrayList<Accounts>();

    public static void main(String[] args){
        PasswordLogin.main();
    }

    public static void accessAccount(){
        Scanner ui = new Scanner(System.in);
        //display categories
        //allow to see passwords, add passwords, delete passwords, delete accounts,
        
        dataConversion();
        System.out.println("Would you like to: [view] a category, [add] a category, or [delete] a category");

        //go to category
        if(ui.nextLine().equals("view")){
            System.out.println("Which Category?");
            viewCat(ui.nextLine());
        }

        if(ui.nextLine().equals("add")){
            addCategory(ui.nextLine());
        }
        if(ui.nextLine().equals("delete")){
            System.out.println("Which Category?");
            deleteCat(ui.nextLine());
        }
        
        //once category is selected
    }

    public static void dataConversion(){
        // int i=0;
        while(BufferWriter.readLine()!=null){
            splitDat(BufferWriter.readLine());
            // i++;
        }
        // for(int j = i;j>0;i--){
        // System.out.println(savedAccounts.get(i));
        // }
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
        for(int i = 0; i<savedAccounts.size();i++){
        printArray(i);
        }

        System.out.println("Would you like to: [add] a account, [delete] a account, [change] a account");

        if(ui.nextLine().equals("add")){
            System.out.println("Which Account?");
            addAcct(ui.nextLine());
        }

        if(ui.nextLine().equals("delete")){
            deleteAcct();
        }
        if(ui.nextLine().equals("change")){
            System.out.println("Which Account?");
            changeAcct(ui.nextLine());
        }

        
    }

    public static void printArray(int i){
        Accounts temp = savedAccounts.get(i);
        String t = temp.getTitle(null);
        String u = temp.getUsername(null);
        String p = temp.getPassword(null);
        String c = temp.getCategory(null);

        System.out.printf("%d - Title: %s ; User: %s ; Password: %s ; Cat: %s\n",i,t,u,p,c);
    }

    public static void addCategory(String c){
            //add category
    }

    public static void saveData(String t, String u, String p, String c){
        BufferWriter.writeLine("");
        BufferWriter.writeLine(t+","+u+","+p+","+c);
    }

    public static void deleteCat(String c){
        //delete category and the accounts associated
    }

    public static void addAcct(String c){
        Scanner ui = new Scanner(System.in);
        //Accounts(String t, String un, String pw, String c)
        System.out.println("Enter title of new account");
        String t = ui.nextLine();

        System.out.println("Enter username of new account");
        String un = ui.nextLine();

        System.out.println("Enter password of new account");
        String pw = ui.nextLine();

        saveData(t, un, pw, c);
    }

    public static void deleteAcct(){//dont work
        Scanner ui = new Scanner(System.in);

        System.out.println("Enter number of the account to delete");
        int i = ui.nextInt();
        savedAccounts.remove(i);

    }

    public static void changeAcct(String c){
        
    }

}