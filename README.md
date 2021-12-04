# jprinter
A simple Java library to print to a printer. It's aimed at small dot matrix printers, but can be used with anything accepting ESC codes. You'll probably need to bring yor own driver, though...
More functionality can be added, but I haven had the need (nor actual hardware to test it currently)

This library is part of a bigger project. TL;DR: I needed to print to an Epson TM-U220, but there was the possibility of a different printer to be used (which never hapened anyway)
A driver for the Epson TM-U220 is provided.

The basic usage is:
1. Implement a `Printer<T>` for the class(es) you need to print.
2. Create a new `PrintStreamFactory` with a `File` of the printer port and the charset to use.
3. Create a new `PrinterDriver` for the printer to use.
4. Create a new instance of the `Printer<T>` implemented in step 1.
5. Print!

Very simple example:
```
public class PersonStreamPrinter extends PrintStreamPrinter<Person> {

    protected void doPrint(Person person, PrintStream out) throws IOException {
        driver.startDoubleWidth(out).
            print(person.getLastName(), out).
            endDoubleWidth(out).
            println(", " + person.getName(), out).
            println("Age: " + person.getAge(), out)
            cutPaperOneCorner(out);
    }

}

// ...
    final File printerPort = new File(properties.getProperty("printer.port"));
    final PrintStreamFactory streamFactory = new DefaultPrintSreamFactory(printerPort, EpsonTMU220Driver.CHARSET)
    final Printer printer = new PersonStreamPrinter(40, streamFactory, new EpsonTMU220Driver());

// ...
    final Person person = getPerson();
    printer.print(person);
```
