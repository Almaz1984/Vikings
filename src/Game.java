import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Game {
    public static Map parseWay(String map){
        Map ways  = new HashMap();
        String way;
        String islandName;
        String tmpString;
        if (map.contains("север")){
            way="cевер";
            tmpString = map.substring(map.indexOf("север"));
            islandName = tmpString.substring(tmpString.indexOf("Остров"), tmpString.indexOf(" ")>0?tmpString.indexOf(" "):tmpString.length());
            ways.put(way, islandName);
        }
        if (map.contains("юг")){
            way="юг";
            tmpString = map.substring(map.indexOf("юг"));
            islandName = tmpString.substring(tmpString.indexOf("Остров"), tmpString.indexOf(" ")>0?tmpString.indexOf(" "):tmpString.length());
            ways.put(way, islandName);
        }
        if (map.contains("запад")){
            way="запад";
            tmpString = map.substring(map.indexOf("запад"));
            islandName = tmpString.substring(tmpString.indexOf("Остров"), tmpString.indexOf(" ")>0?tmpString.indexOf(" "):tmpString.length());
            ways.put(way, islandName);
        }
        if (map.contains("восток")){
            way="восток";
            tmpString = map.substring(map.indexOf("восток"));
            islandName = tmpString.substring(tmpString.indexOf("Остров"), tmpString.indexOf(" ")>0?tmpString.indexOf(" "):tmpString.length());
            ways.put(way, islandName);
        }
        return ways;
    }

    public static ArrayList mapReader(String fileName){
        ArrayList<String> map = new ArrayList<String>();
        try {
            File file = new File(fileName);
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                // считываем остальные строки в цикле
                line = reader.readLine();
                map.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    public static void main(String[] args) {
        ArrayList<String>map = mapReader("D:/file.txt");
        String islandName;
        Island island;
        ArrayList<Island> islands = new ArrayList<Island>();

        for (int i=0; i<map.size()-1; i++){
            String map1 = map.get(i);
            islandName=map1.substring(0,map1.indexOf(" "));
            island = new Island(islandName);
            island.addWay(parseWay(map1));
            islands.add(island);
        }

        //island.addWay();
        //System.out.println(parseWay(map1));

        System.out.println(islands);



    }
}
