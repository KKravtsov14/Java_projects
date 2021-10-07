import java.io.IOException;

public class FileAccountManager implements AccountManager{

    public static void newAccount(String fullName, String birth, String email, String password)
            throws AccountAlreadyExistsException, IOException {
        Account account = new Account(fullName, birth, email, password, false);
        AccountManager.register(account);
    }

    public static void remover(String email, String password) throws IOException, WrongCredentialsException {
        AccountManager.removeAccount(email, password);

    }

    public static Account loginer(String email, String password) throws AccountBlockedException,
            IOException,
            WrongCredentialsException {
        return AccountManager.login(email, password);

    }

}
