public class Accounts {
    String title;
    String userName;
    String passWord;
    String category;
    public Accounts(){
        title = "untitled account";
        userName = "no username";
        passWord = "no password";
        category = "no category";
        System.out.println("Object Created");
    }
    public Accounts(String t, String un, String pw, String c){
        title = t;
        userName = un;
        passWord = pw;
        category = c;
    }
    public void setTitle(String t){
        this.title=t;
    }
    public void setUsername(String un){
        this.userName=un;
    }
    public void setPassword(String pw){
        this.passWord=pw;
    }
    public void setCategory(String c){
        this.passWord=c;
    }

    public String getTitle(String t){
        return title;
    }
    public String getUsername(String un){
        return userName;
    }
    public String getPassword(String pw){
        return passWord;
    }
    public String getCategory(String c){
        return category;
    }
    
}
