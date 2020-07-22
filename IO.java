import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class IO {
    public static String NELECT;
    public static String FERMI;

    public static void main(String[] args) {
        File f = new File("C:/Users/yanfa/Desktop/OUTCAR");
        try (FileReader fr = new FileReader(f);
             BufferedReader br = new BufferedReader(fr)){
            while (true) {
                String line = br.readLine();
                if (null == line)
                    break;
                if (line.contains("NELECT")){
                    NELECT = getNELECT(line);
                }

            }
            System.out.println(NELECT);

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static String getNELECT(String line){
        List<String> nelect = Arrays.asList(line.trim().split("\\s+"));
        return nelect.get(2);
    }




}
