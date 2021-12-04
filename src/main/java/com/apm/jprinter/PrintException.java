package com.apm.jprinter;

public class PrintException extends Exception {

    public PrintException(String msg) {
        super(msg);
    }

    public PrintException(Throwable cause) {
        super(cause);
    }

    public PrintException(String message, Throwable cause) {
        super(message, cause);
    }

}
