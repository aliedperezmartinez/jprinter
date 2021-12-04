package com.apm.jprinter.driver;

import java.io.IOException;
import java.io.PrintStream;

/**
 * The main interface to be implemented. This abstracts the basic printer functionality. Concrete drivers will implement
 * this interface.
 */
public interface PrinterDriver {

    /**
     * Sets the printer head position in absolute terms. It is up to the printer driver to handle under/overflows.
     *
     * @param horPos the amount of characters to move the print head counting from the left margin.
     * @param out the port to print to
     * @return this printer driver for chaining.
     * @throws IOException if there is a problem communicating with the printer.
     */
    PrinterDriver setAbsoluteHorizontalPosition(byte horPos, PrintStream out) throws IOException;

    /**
     * Prints a graphic
     * @param graphic the graphic data
     * @param out the port to print to
     * @return this printer driver for chaining.
     * @throws IOException if there is a problem communicating with the printer.
     */
    PrinterDriver printGraphics(byte[] graphic, PrintStream out) throws IOException;

    /**
     * Resets the printer to is default settings. Recommended to issue before printing  a document and after the document is printed.
     * @param out the port to print to
     * @return this printer driver for chaining.
     * @throws IOException if there is a problem communicating with the printer.
     */
    PrinterDriver initialisePrinter(PrintStream out) throws IOException;

    /**
     * Feed the specified number of lines
     * @param lines the amount of lines to feed.
     * @param out the port to print to
     * @return this printer driver for chaining.
     * @throws IOException if there is a problem communicating with the printer.
     */
    PrinterDriver feedLines(byte lines, PrintStream out) throws IOException;

    /**
     * After issuing this command the printer will print in double width mode
     * @param out the port to print to
     * @return this printer driver for chaining.
     * @throws IOException if there is a problem communicating with the printer.
     */
    PrinterDriver startDoubleWidth(PrintStream out) throws IOException;

    /**
     * After issuing this command the printer will no longer print in double width mode
     * @param out the port to print to
     * @return this printer driver for chaining.
     * @throws IOException if there is a problem communicating with the printer.
     */
    PrinterDriver endDoubleWidth(PrintStream out) throws IOException;

    /**
     * If the printer supports it, cut the paper. An empty implementation is provided.
     * @param out the port to print to
     * @return this printer driver for chaining.
     * @throws IOException if there is a problem communicating with the printer.
     */
    default PrinterDriver cutPaperOneCorner(PrintStream out) throws IOException {return this;}

    /**
     * Feeds the paper by one line. Can chain if more lines are needed.
     * @param out the port to print to
     * @return this printer driver for chaining.
     * @throws IOException if there is a problem communicating with the printer.
     */
    PrinterDriver feedOneLineBack(PrintStream out) throws IOException;

    /**
     * After issuing this command the printer will print right aligned
     * @param out the port to print to
     * @return this printer driver for chaining.
     * @throws IOException if there is a problem communicating with the printer.
     */
    PrinterDriver startRightJustification(PrintStream out) throws IOException;

    /**
     * After issuing this command the printer will no longer print right aligned
     * @param out the port to print to
     * @return this printer driver for chaining.
     * @throws IOException if there is a problem communicating with the printer.
     */
    PrinterDriver endRightJustification(PrintStream out) throws IOException;

    /**
     * A convenience method to chain control and text. A default implementation is provided.
     * @param out the port to print to
     * @param text the text to print
     * @return this printer driver for chaining.
     * @throws IOException if there is a problem communicating with the printer.
     */
    default PrinterDriver println(String text, PrintStream out) throws IOException {
        out.println(text);
        return this;
    }

    /**
     * A convenience method to chain control and text. A default implementation is provided.
     * @param out
     * @return this printer driver for chaining.
     * @throws IOException if there is a problem communicating with the printer.
     */
    default PrinterDriver println(PrintStream out) throws IOException {
        out.println();
        return this;
    }

    /**
     * A convenience method to chain control and text. A default implementation is provided.
     * @param out the port to print to
     * @param text the text to print
     * @return this printer driver for chaining.
     * @throws IOException if there is a problem communicating with the printer.
     */
    default PrinterDriver print(String text, PrintStream out) throws IOException {
        out.print(text);
        return this;
    }

}
