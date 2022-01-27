import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParseTest {


    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testGetLinksEmptyFile() throws IOException{

        Path fileName = Path.of("empty-file.md");
        String contents = Files.readString(fileName); 
        ArrayList<String> res = new ArrayList<String>();
        res.add("No links in this file");
        assertEquals(res , MarkdownParse.getLinks(contents)); 
        
    }
    @Test 
    public void testGetLinksTestFile() throws IOException{
        Path fileName = Path.of("test-file.md");
        String contents = Files.readString(fileName); 
        ArrayList<String> res = new ArrayList<String>();
        res.add("https://something.com");
        res.add("some-page.html");
        assertEquals(res , MarkdownParse.getLinks(contents)); 
    }

    @Test 
    public void testGetLinksTestFileTwo() throws IOException{
        Path fileName = Path.of("test-file2.md");
        String contents = Files.readString(fileName); 
        ArrayList<String> res = new ArrayList<String>();
        res.add("differentlink.com");
        assertEquals(res , MarkdownParse.getLinks(contents)); 
    }

    @Test 
    public void testGetLinksTestFileThree() throws IOException{
        Path fileName = Path.of("testfile3.md");
        String contents = Files.readString(fileName); 
        ArrayList<String> res = new ArrayList<String>();
        res.add("https://www.google.com/");
        res.add("https://www.google.com/");
        assertEquals(res , MarkdownParse.getLinks(contents)); 
    }



}