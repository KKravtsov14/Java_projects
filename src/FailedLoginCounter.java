import java.util.HashMap;

public class FailedLoginCounter {

    private static FailedLoginCounter instance;

    public static synchronized FailedLoginCounter getInstance() {
        if (instance == null) {
            instance = new FailedLoginCounter();
        }
        return instance;
    }

    FailedLoginCounter() {}

    private HashMap<String, Integer> loginAttempts = new HashMap<>();


    public boolean updater(String email){
        if (loginAttempts.get(email) <= 3) {
            loginAttempts.put(email, loginAttempts.get(email) + 1);
            return true;
        }
        else {
            loginAttempts.put(email, 5);
            return false;
        }
    }

    public void creator(String email){
        if (!loginAttempts.containsKey(email)) {
            loginAttempts.put(email, 0);
        }
    }

    public void deleter(String email){
        if (loginAttempts.containsKey(email)){
            loginAttempts.put(email, 0);
        }
    }
}
