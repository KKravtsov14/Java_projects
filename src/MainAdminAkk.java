import java.io.*;

public class MainAdminAkk {

    public static void main(String[] args) throws IOException, AccountBlockedException, WrongCredentialsException, AccountAlreadyExistsException {

//        FileAccountManager.newAccount("K", "14", "mkil.ru", "k");
        try
        {
            FileAccountManager.loginer("mkil.ru", "p");
        }
        catch (IOException | WrongCredentialsException | AccountBlockedException e){
            System.out.println(e.getMessage());
            try
            {
                FileAccountManager.loginer("mkil.ru", "p");
            }
            catch (IOException | WrongCredentialsException | AccountBlockedException e2){
                System.out.println(e2.getMessage());
                try
                {
                    FileAccountManager.loginer("mlil.ru", "p");
                }
                catch (IOException | WrongCredentialsException | AccountBlockedException e3){
                    System.out.println(e3.getMessage());
                    try
                    {
                        FileAccountManager.loginer("mkil.ru", "p");
                    }
                    catch (IOException | WrongCredentialsException | AccountBlockedException e4){
                        System.out.println(e4.getMessage());
                        try
                        {
                            FileAccountManager.loginer("mkil.ru", "p");
                        }
                        catch (IOException | WrongCredentialsException | AccountBlockedException e5){
                            System.out.println(e5.getMessage());

                            }
                        }
                    }
                }
            }

        FileAccountManager.remover("mpil.ru", "p");

        }

    }
