import java.util.Scanner;

public class PasswordGen {
    public static void main(String[] args) {
    Scanner ui = new Scanner(System.in);
    System.out.println("How long do you want your random password to be? ");
    int length = ui.nextInt();
    
        String randomPassword = "";
      for(int j = 0; j < length; j++) {
    
        randomPassword += randomCharacter();
      }

      //DO SOMETHING WITH THE CREATED PASSWORD
      //save it to text file
      System.out.printf("Your amazing new password is: %s",randomPassword);
    }

    public static char randomCharacter() {
        int rand = (int)(Math.random()*62);
        /*0-61 inclusive = all possible values of rand
        //0-9 inclusive = 10 possible numbers/digits
        //10-35 inclusive = 26 possible uppercase letters
        //36-61 inclusive = 26 possible lowercase letters
        //If rand is between 0 (inclusive) and 9 (inclusive), we can say it's a number/digit
        //If rand is between 10 (inclusive) and 35 (inclusive), we can say it's an uppercase letter
        //If rand is between 36 (inclusive) and 61 (inclusive), we can say it's a lowercase letter*/
        if(rand <= 9) {
            int number = rand + 48;
            return (char)(number);
        } else if(rand <= 35) {
            //Uppercase letter (65-90 in ASCII)
            //To convert from 10-35 to 65-90, we can add 55 to rand because 65-10 = 55
            int uppercase = rand + 55;
            //This way, rand = 10 => uppercase = 65 => 'A'
            return (char)(uppercase);
        } else {
            //Lowercase letter (97-122 in ASCII)
            //To convert from 36-61 to 97-122, we can add 61 to rand because 97-36 = 61
            int lowercase = rand + 61;
            //This way, rand = 36 => lowercase = 97 => 'a'
            return (char)(lowercase);
        }
    }
}
//sources: https://junilearning.com/blog/coding-projects/make-a-java-random-password-generator/
