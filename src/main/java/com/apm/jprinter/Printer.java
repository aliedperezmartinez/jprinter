package com.apm.jprinter;

/**
 * A higher level abstraction. Implementations print an object to the printer.
 * @author alied
 * @param <T> The class to print.
 */
public interface Printer<T> {

    static final int DEFAULT_WIDTH = 40;

    void print(T object) throws PrintException;

}
