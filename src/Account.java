public class Account {
    private String fullName;
    private String birth;
    private String email;
    private String password;
    private boolean blocked;

    Account(String fullName, String birth, String email, String password, boolean blocked){
        setFullName(fullName);
        setBirth(birth);
        setEmail(email);
        setPassword(password);
        setBlocked(blocked);
    }

    public void setFullName(String fullName){
        this.fullName = fullName;
    }

    public void setBirth(String birth){
        this.birth = birth;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setBlocked(boolean blocked){
        this.blocked = blocked;
    }

    public String getFullName(){
        return this.fullName;
    }

    public String getBirth(){
        return this.birth;
    }

    public String getEmail(){
        return this.email;
    }

    public String getPassword(){
        return this.password;
    }

    public boolean getBlocked(){
        return this.blocked;
    }

    @Override
    public String toString(){
        return this.fullName;
    }


}
