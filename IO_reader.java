import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class IO_reader implements IO_vasp {

    // properties
    private float value;
    private String filePath;

    //constructor
    public IO_reader(String filePath){
        this.filePath = filePath;
    }

    // parser
    @Override
    public float parser(IO_reader ioReader, String keywords){
        List<String> lines = ioReader.readFile();
        for (String line : lines) {
            if (line.contains(keywords)) {
                value = Float.parseFloat(ioReader.getPara(line, 2));
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
        IO_reader ioReader = new IO_reader("C:/Users/yanfa/Desktop/OUTCAR");
        float NELECT = ioReader.parser(ioReader, "NELECT");
        System.out.println(NELECT);
        float FERMI = ioReader.parser(ioReader, "E-fermi");
        System.out.println(FERMI);
    }



}
