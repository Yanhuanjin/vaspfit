import com.sun.javafx.scene.control.skin.VirtualFlow;
import com.sun.jmx.remote.internal.ArrayQueue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class IO {
    public static void main(String[] args) {
        File f = new File("C:/Users/yanfa/Desktop/OUTCAR");
        try (FileReader fr = new FileReader(f);
             BufferedReader br = new BufferedReader(fr)){
            while (true) {
                String line = br.readLine();
                if (null == line)
                    break;
                if (line.contains("NELECT")){
                    List<String> e = Arrays.asList(line.trim().split("\\s+"));
                    System.out.println(e.get(2));
                }
            }
                //if (line.contains("E-fermi"))
                    //System.out.println(line);
        }catch (IOException e){
            e.printStackTrace();
        }
    }




}
