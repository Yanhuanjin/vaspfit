import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class IO {

    // properties
    private float value;
    private String filePath;

    //constructor
    public IO(String filePath){
        this.filePath = filePath;
    }

    // parser
    public float parser(IO io, String keywords){
        List<String> lines = io.readFile();
        for (String line : lines) {
            if (line.contains(keywords)) {
                value = Float.parseFloat(io.getPara(line, 2));
            }

        }
        return value;
    }

    // reader
    private List<String> readFile(){
        File f = new File(filePath);
        List<String> StrList = new ArrayList<>();
        try (FileReader fr = new FileReader(f);
             BufferedReader br = new BufferedReader(fr)) {
            while (true) {
                String line = br.readLine();
                if (null == line)
                    break;
                else
                    StrList.add(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return StrList;
    }

    //
    private String getPara(String line, int position){
        List<String> para = Arrays.asList(line.trim().split("\\s+"));
        return para.get(position);
    }

    public static void main(String[] args) {
        IO io = new IO("C:/Users/yanfa/Desktop/OUTCAR");
        float NELECT = io.parser(io, "NELECT");
        System.out.println(NELECT);
        float FERMI = io.parser(io, "E-fermi");
        System.out.println(FERMI);
    }



}
