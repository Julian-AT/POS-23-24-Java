package at.htldonaustadt.schmidt.scanneruebungen.backend;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.security.InvalidParameterException;
import java.util.*;

public class ColorScanner {

    private String fileName;

    // Array for colors, booleans, strings & numbers
    private static List<String> Colors = new ArrayList<>() {
        {
            add("green");
            add("red");
            add("orange");
            add("yellow");
        }
    };

    // Hashmap for storing string with the value of Lists of strings, numbers & booleans
    private HashMap<String, List<Object>> scMap = new HashMap<>() {
        {
            put("booleans", new ArrayList<>());
            put("colors", new ArrayList<>());
            put("floats", new ArrayList<>());
        }
    };




    // constructor
    public ColorScanner(String inputFile) {
        this.fileName = inputFile;
    }

    public void printMap() {
        System.out.println(scMap);
    }


    // getter
    public int getMapLength(String key) {
        return scMap.get(key).size();
    }

    private boolean handleLength(String key) {
        float len = getMapLength(key);
        return len > 0;
    }

    public Float[] floatArrConverter(HashMap<String, List<Object>> map) {
        return Arrays.copyOf(map.get("floats").toArray(), map.get("floats").toArray().length, Float[].class);
    }

    public Boolean[] booleanArrConverter(HashMap<String, List<Object>> map) {
        return Arrays.copyOf(map.get("booleans").toArray(), map.get("booleans").toArray().length, Boolean[].class);
    }

    public String[] colorArrConverter(HashMap<String, List<Object>> map) {
        return Arrays.copyOf(map.get("colors").toArray(), map.get("colors").toArray().length, String[].class);
    }


    public float getDeviation() {
        if(!handleLength("floats")) {
            return 0;
        }

        // get float array from object array (only convert floats if necessary)
        Float[] floats = floatArrConverter(scMap);
        float len = floats.length;

        // calc sum of floats (Σx)
        float xo = getSum();

        // calc mean of sum from floats (μ)
        float mean = xo / len;


        // calc variance of sum from floats (σ²)
        float xu = 0;
        for(float i : floats) {
            xu += Math.pow((i - mean), 2);
        }

        // return square root of negative length times σ² (variance)
        // formula: σ=sqrt((1)/(len)+sum(xi - mean)²)
        return (float)Math.sqrt((1 / len) * xu);
    }

    public float getSum() {
        if(!handleLength("floats")) {
            return 0;
        }

        // only convert floats if necessary
        Float[] floats = floatArrConverter(scMap);

        float sum = 0;
        for(float i : floats) {
            sum += i;
        }

        return  sum;
    }

    public float getAverage() {
        return getSum() / getMapLength("floats");
    }

    public int getBooleansLength(Boolean bool) {
        if(!handleLength("floats")) {
            return 0;
        }

        Boolean[] booleans = booleanArrConverter(scMap);
        int count = 0;
        for(Boolean b: booleans) {
            if(b.equals(bool)) {
                count++;
            }
        }

        return count;
    }

    public int getColorsLength(String color) {
        if(!handleLength("colors") || !Colors.contains(color)) {
            return 0;
        }

        String[] colors = colorArrConverter(scMap);

        int count = 0;
        for(String i : colors) {
            if(i.equals(color)) {
                count++;
            }
        }

        return count;
    }

    public void scanFile() {
        try (Scanner scanner = new Scanner(new File(fileName)))  {
            while (scanner.hasNext()) {
                String line = scanner.next();
                if(line.equals("true") || line.equals("false")) {
                    scMap.get("booleans").add(Boolean.parseBoolean(line));
                } else if (Colors.contains(line)) {
                    scMap.get("colors").add(line);
                } else if (Float.parseFloat(line) > 0) {
                    scMap.get("floats").add(Float.parseFloat(line));
                }
                else {
                    throw new InvalidParameterException("Invalid parameter: " + line);
                }
            }
        }
        catch (FileNotFoundException e) {
            // Print localized error message + Stack Trace
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }
}
