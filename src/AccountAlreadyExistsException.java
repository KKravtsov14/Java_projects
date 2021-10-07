public class AccountAlreadyExistsException extends Exception{

    AccountAlreadyExistsException(String message){
        super(message);
    }

    public String getMessage(String message){
        return message;
    }


}
