package com.apm.jprinter.driver.impl;

import com.apm.jprinter.driver.PrinterDriver;
import java.io.IOException;
import java.io.PrintStream;

/**
 * An implementation for the Epson TM-U220 ESC/POS commands.
 * @author alied
 */
public class EpsonTMU220Driver implements PrinterDriver {
    public static final String CHARSET = "Cp437";

    private static final byte[] INITIALISE = new byte[]{0x1b, '@'};
    private static final byte[] START_DOUBLE_WIDTH = new byte[] {0x1b, '!', 0x20};
    private static final byte[] END_DOUBLE_WIDTH = new byte[] {0x1b, '!', 0x00};
    private static final byte[] START_RIGHT_JUSTIFICATION = new byte[] {0x1b, 'a', 0x02};
    private static final byte[] END_RIGHT_JUSTIFICATION = new byte[] {0x1b, 'a', 0x00};
    private static final byte[] FEED_ONE_LINE_BACK = new byte[] {0x1b, 'e', 0x01};
    private static final byte[] FEED_LINE = new byte[] {0x1b, 'd'};
    private static final byte[] CUT_PAPER = new byte[] {0x1d, 'V', 0x01};
    private static final byte[] SET_ABSOLUTE_HOR_POSITION = new byte[]{0x1b, '$'};
    private static final byte[] PRINT_GRAPHICS = new byte[]{0x1b, '*', 0x00};

    @Override
    public PrinterDriver setAbsoluteHorizontalPosition(byte horPos, PrintStream out) throws IOException {
        out.write(SET_ABSOLUTE_HOR_POSITION);
        out.write(new byte[]{(byte)(horPos%0x100), (byte)(horPos/0x100)});
        return this;
    }

    @Override
    public PrinterDriver printGraphics(byte[] graphic, PrintStream out) throws IOException {
        out.write(PRINT_GRAPHICS);
        out.write(graphic);
        return this;
    }

    @Override
    public PrinterDriver initialisePrinter(PrintStream out) throws IOException {
        out.write(INITIALISE);
        return this;
    }

    @Override
    public PrinterDriver feedLines(byte lines, PrintStream out) throws IOException {
        out.write(FEED_LINE);
        out.write(lines);
        return this;
    }

    @Override
    public PrinterDriver startDoubleWidth(PrintStream out) throws IOException {
        out.write(START_DOUBLE_WIDTH);
        return this;
    }

    @Override
    public PrinterDriver endDoubleWidth(PrintStream out) throws IOException {
        out.write(END_DOUBLE_WIDTH);
        return this;
    }

    @Override
    public PrinterDriver cutPaperOneCorner(PrintStream out) throws IOException {
        out.write(CUT_PAPER);
        return this;
    }

    @Override
    public PrinterDriver feedOneLineBack(PrintStream out) throws IOException {
        out.write(FEED_ONE_LINE_BACK);
        return this;
    }

    @Override
    public PrinterDriver startRightJustification(PrintStream out) throws IOException {
        out.write(START_RIGHT_JUSTIFICATION);
        return this;
    }

    @Override
    public PrinterDriver endRightJustification(PrintStream out) throws IOException {
        out.write(END_RIGHT_JUSTIFICATION);
        return this;
    }

}
