package ddsoft.crawler;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    public static List<Student> parse(URL url) {
        try (InputStream is = url.openStream())
        {
            return parse(is);
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }
    public static List<Student> parse(String fileName) {
        File file=new File(fileName);
        try (InputStream is = new FileInputStream(file))
        {
            return parse(is);
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public static List<Student> parse(InputStream is) {
        List<Student> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line;
            String[] spl;
            while ((line = br.readLine()) != null) {
                spl = line.split(";");
                list.add(new Student(Double.parseDouble(spl[0]), spl[1], spl[2], Integer.parseInt(spl[3])));
            }
            return list;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static List<Student> parse( File file) throws IOException
    {
        try( InputStream stream = new FileInputStream( file ) )
        {
            return parse(stream);
        }
    }

}
