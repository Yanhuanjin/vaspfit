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
                    String[] e = line.split("\\s+");
                    for (int i = 0; i < e.length; i++) {
                        System.out.print(e[i]);
                    }
                    System.out.println();
                    removeSpace(Arrays.asList(e));

                }
            }
                //if (line.contains("E-fermi"))
                    //System.out.println(line);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void removeSpace(List<String> d){
        System.out.println(d);
        List<String> x = new ArrayList<String>();
        for (int i = 0; i <d.size(); i++) {
            if(d.get(i) != null) {
                System.out.print(d.get(i) + "/");
                x.add(d.get(i));
            }
        }
        System.out.println();
        for (int i = 0; i < x.size(); i++) {
            System.out.print(x.get(i));
        }
        System.out.println();
        System.out.println(x.get(3));
    }



}
