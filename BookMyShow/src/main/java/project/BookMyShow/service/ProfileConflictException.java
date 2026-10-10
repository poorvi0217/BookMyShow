package project.BookMyShow.service;

public class ProfileConflictException extends RuntimeException{

    public ProfileConflictException(String msg){
        super(msg);
    }
}
