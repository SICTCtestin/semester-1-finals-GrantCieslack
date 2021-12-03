import java.util.Scanner;
public class PasswordCheck {
  public static void checkPass(String p){
      int min =8;
      int d=0;
      int sp=0;
      int uC=0;
      int lC=0;
      String password = p;
      if(password.length()>=min){
          for(int i =0;i<password.length();i++){
              char c = password.charAt(i);
              if(Character.isUpperCase(c)){
                  uC++;
              }
              if(Character.isLowerCase(c)){
                  lC++;
              }
              if(Character.isDigit(c)){
                  d++;
              }
              if(c>=33&&c<=46||c==64){
                  sp++;
              }
          }
          if(sp>=1&&lC>=1&&uC>=1&&d>=1){
              System.out.println(" Password is good:");
          }

      }

      if(password.length()<min){

          for(int i =0;i<password.length();i++){
              char c = password.charAt(i);
              if(Character.isLowerCase(c)){
                  lC++;
              }
              }

          if(lC>0){
              System.out.println(" Password must be atleat "+min+" characters:");
              System.out.println(" You need atleast one upper case chracter:");
              System.out.println(" You need atleast one digit:");
              System.out.println(" You need atleast one special chracter:");



      }
      }
      else if(password.length()<min&&uC>1){
          for(int i =0;i<password.length();i++){
          char c =password.charAt(i);
          if(Character.isLowerCase(c)){
              lC++;
          }
          if(Character.isUpperCase(c)){
              uC++;
          }
          }
          if(lC>0&&uC>0){
          System.out.println("must be atleast "+min+" chracters long");
          System.out.println("need atleast one digit:");
          }
        if(password.length()>=min&&lC>0&&uC>0&&d>0&&sp==0){
          System.out.println("need atleast a special chracter");
      }
        if(password.length()>=min&&lC>0&&uC>0&&d==0&&sp==0){
          System.out.println("need atleast one digit:");
          System.out.println("need atleast one special chracter:");
      }
    }
  }
}
