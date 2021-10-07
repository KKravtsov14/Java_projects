public class WrongCredentialsException extends Exception{

    WrongCredentialsException(String message){
        super(message);
    }

    public String getMessage(String message){
        return message;
    }


}
