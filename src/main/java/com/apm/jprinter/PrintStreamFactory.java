package com.apm.jprinter;

import java.io.PrintStream;

/**
 * A factory to create a {@link PrintStream}. Used by {@link PrintStreamPrinter}.
 * @author alied
 */
public interface PrintStreamFactory {

    /**
     * A default implementation. Just print to the standard output. Useful for tests.
     */
    public static final PrintStreamFactory TO_STANDARD_OUTPUT = () -> System.out;

    /**
     * Create a new {@link PrintStream} to print to. Used by {@link PrintStreamPrinter}.
     *
     * @return a new {@link PrintStream}. Should be able to be closed after printing a document. If a new document is
     * needed, the factory can return a new one. Caching, pooling or any other strategy is left to implementations.
     *
     * @throws PrintException if there was a problem creating the stream.
     */
    PrintStream create() throws PrintException;

}
