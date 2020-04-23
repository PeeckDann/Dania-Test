package ua.lviv.iot.seafood.writer;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import ua.lviv.iot.seafood.model.Seafood;

public class SeafoodWriter {

    private Writer csvWriter;

    public void setCsvWriter(Writer csvWriter) {
        this.csvWriter = csvWriter;
    }

    public void writeToFile(List<Seafood> seafood) throws IOException {
        String infoToWrite;
        for (Seafood food : seafood) {
            infoToWrite = food.toCSV() + "\r\n";
            csvWriter.write(infoToWrite);
        }
    }

    public String toString() {
        return csvWriter.toString();
    }
}