package hu.feladat.spring.config;

public class NotFoundException extends RuntimeException{

    public NotFoundException(){
        super();
    }

    public NotFoundException(String message, Throwable reason){
        super(message, reason);
    }
    public NotFoundException(String message){
        super(message);
    }
    public NotFoundException(Throwable reason){
        super(reason);
    }

    public NotFoundException(String message, Throwable reason, boolean isSuppressed, boolean writableStackTrace){
        super(message, reason, isSuppressed, writableStackTrace );
    }
}