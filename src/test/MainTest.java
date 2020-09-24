import com.example.project.Flags;

import com.example.project.Printer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.*;

public class MainTest {
    @Test
    void main() throws IOException {
        CharArrayWriter l = new CharArrayWriter();

        String[] args = new String[]{"testFolder"};
        Flags flags = new Flags();
        flags.Arguments(args);
        Printer.printLs(new PrintWriter(l), flags);
        assertEquals("testF testFile1 testFile2", l.toString());

        l.reset();
        args = new String[] {"-l", "testFolder"};
        flags.Arguments(args);
        Printer.printLs(new PrintWriter(l), flags);
        assertEquals("7-- Sep 24 2020 0 testF\n" +
                        "7-- Sep 24 2020 3788 testFile1\n" +
                        "7-- Sep 24 2020 11364 testFile2",
                l.toString());

        l.reset();
        args = new String[] {"-l", "-r", "testFolder"};
        flags.Arguments(args);
        Printer.printLs(new PrintWriter(l), flags);
        assertEquals("7-- Sep 24 2020 11364 testFile2\n" +
                        "7-- Sep 24 2020 3788 testFile1\n" +
                        "7-- Sep 24 2020 0 testF",
                l.toString());

        l.reset();
        args = new String[] {"-l", "-r", "-h", "testFolder"};
        flags.Arguments(args);
        Printer.printLs(new PrintWriter(l), flags);
        assertEquals("rwx Sep 24 2020 11К testFile2\n" +
                        "rwx Sep 24 2020 3К testFile1\n" +
                        "rwx Sep 24 2020 0Б testF",
                l.toString());
    }
}
