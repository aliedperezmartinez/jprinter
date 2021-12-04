package com.apm.jprinter;

import com.apm.jprinter.driver.PrinterDriver;
import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * A {@link Printer} base class which uses a {@link PrintStream} as output. Extend this class and implement the method {@link #doPrint(java.lang.Object, java.io.PrintStream)
 * } with the concrete logic to print your object.
 *
 * @author alied
 * @param <T>
 */
public abstract class PrintStreamPrinter<T> implements Printer<T> {

    private static final Logger LOGGER = Logger.getLogger(PrintStreamPrinter.class.getName());

    protected final int width;
    protected final String delimiter;
    protected final PrintStreamFactory printStreamFactory;
    private final PrinterDriver driver;

    public PrintStreamPrinter(int width, String delimiter, PrintStreamFactory printStreamFactory, PrinterDriver driver) {
        this.width = width;
        this.delimiter = delimiter;
        this.printStreamFactory = printStreamFactory;
        this.driver = driver;
    }

    public PrintStreamPrinter(int width, PrintStreamFactory printStreamFactory, PrinterDriver driver) {
        this(width, getDelimiterString(width), printStreamFactory, driver);
    }

    @Override
    public void print(T object) throws PrintException {
        try (final PrintStream out = printStreamFactory.create()) {
            driver.initialisePrinter(out);
            doPrint(object, out);
            driver.initialisePrinter(out);
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
            throw new PrintException("An error ocurred printing " + object, ex);
        }
    }

    protected abstract void doPrint(T object, PrintStream out) throws IOException;

    /**
     * A convenient method to separate logical sections. Can use it if needed.
     * @param out the port to print to
     * @throws IOException if there is a problem communicating with the printer.
     */
    protected void endSection(final PrintStream out) throws IOException {
        out.println(delimiter);
    }

    /**
     * A default delimiter consisting of as many dashes as the width.
     * @param width
     * @return a {@link String} of dashes to be used as delimiter.
     */
    private static String getDelimiterString(int width) {
        return Stream.generate(() -> "-").limit(width).collect(Collectors.joining());
    }

}
