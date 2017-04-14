package hierarchyOfExceptions;

/**
 * Created by jon on 13/04/17.
 */
public class UserNotFoundException extends Exception{
    public UserNotFoundException(String message) {
        super(message);
    }
}
