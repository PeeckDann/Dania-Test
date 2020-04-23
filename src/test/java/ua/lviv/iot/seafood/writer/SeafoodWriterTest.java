package ua.lviv.iot.seafood.writer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import org.junit.jupiter.api.Test;

import ua.lviv.iot.seafood.manager.BaseSeafoodManagerTest;
import ua.lviv.iot.seafood.model.Seafood;

public class SeafoodWriterTest extends BaseSeafoodManagerTest {

    @Test
    public void testWriteToFile() throws IOException {
        try (Writer fileWriter = new FileWriter("File.csv")) {
            SeafoodWriter writer = new SeafoodWriter();
            writer.setCsvWriter(fileWriter);
            writer.writeToFile(fish);
        }
    }

    @Test
    public void testUsingString() throws IOException {
        try (Writer csvWriter = new StringWriter()) {
            SeafoodWriter writer = new SeafoodWriter();
            writer.setCsvWriter(csvWriter);
            writer.writeToFile(fish);
            String expectedString = "";
            for (Seafood seafood : fish) {
                expectedString += seafood.toCSV() + "\r\n";
            }
            assertEquals(expectedString, writer.toString());
        }
    }
}