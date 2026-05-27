package model.exceptions;

public class ExceptionDomain extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ExceptionDomain(String msg) {
        super(msg);
    }

}
