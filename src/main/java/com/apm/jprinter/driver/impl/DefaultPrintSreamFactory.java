package com.apm.jprinter.driver.impl;

import com.apm.jprinter.PrintException;
import com.apm.jprinter.PrintStreamFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DefaultPrintSreamFactory implements PrintStreamFactory {

    private final File printerPort;
    private final String charset;

    public DefaultPrintSreamFactory(File printerPort, String charset) {
        this.printerPort = printerPort;
        this.charset = charset;
    }

    @Override
    public PrintStream create() throws PrintException {
        try {
            return new PrintStream(printerPort, charset);
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
            throw new PrintException(ex);
        }
    }

}
