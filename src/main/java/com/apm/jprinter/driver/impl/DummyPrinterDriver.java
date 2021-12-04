package com.apm.jprinter.driver.impl;

import com.apm.jprinter.driver.PrinterDriver;
import java.io.IOException;
import java.io.PrintStream;

/**
 * A dummy printer driver implementation. Useful for tests.
 * @author alied
 */
public class DummyPrinterDriver implements PrinterDriver {

    @Override
    public PrinterDriver setAbsoluteHorizontalPosition(byte horPos, PrintStream out) throws IOException {
        return this;
    }

    @Override
    public PrinterDriver printGraphics(byte[] graphic, PrintStream out) throws IOException {
        return this;
    }

    @Override
    public PrinterDriver initialisePrinter(PrintStream out) throws IOException {
        return this;
    }

    @Override
    public PrinterDriver feedLines(byte lines, PrintStream out) throws IOException {
        for (int i = 0; i < lines; i++) {
            out.println();
        }
        return this;
    }

    @Override
    public PrinterDriver startDoubleWidth(PrintStream out) throws IOException {
        return this;
    }

    @Override
    public PrinterDriver endDoubleWidth(PrintStream out) throws IOException {
        return this;
    }

    @Override
    public PrinterDriver feedOneLineBack(PrintStream out) throws IOException {
        return this;
    }

    @Override
    public PrinterDriver startRightJustification(PrintStream out) throws IOException {
        return this;
    }

    @Override
    public PrinterDriver endRightJustification(PrintStream out) throws IOException {
        return this;
    }

}
