package pl.millennium.gnomix.domain;

public class ErrorMessage {

    protected static String Msg = "That book has already been registered!";

    protected static String ErrMsg = "Invalid option. Please try and choose again.";

    protected static String error = "Book has not been found in database.";

    protected static String FatalError = "There are no books registered in the database.";

    public static String getMsg(){
        return Msg;
    }

    public static String getErrMsg(){
        return ErrMsg;
    }

    public static String getError(){
        return error;
    }

    public static String getFatalError(){
        return FatalError;
    }
}
