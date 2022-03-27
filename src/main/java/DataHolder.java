import binary_tree.BinarySearchTree;
import binary_tree.Node;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.List;

public class DataHolder {
    private Map<String,Integer> occurrenceDictionary = new HashMap<>();
    private Map<String,Integer> fullDictionary = new HashMap<>();
    private Integer freq = 0;
    private List<Double> p;
    private List<Double> q;

    private final int occurrences;

    public DataHolder(String path, int occurrences){
        this.occurrences = occurrences;
        try {
            File file = new File(path);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(" ");
                if(Integer.parseInt(data[0]) > occurrences){
                   this.occurrenceDictionary.put(data[1], Integer.parseInt(data[0]));
                }
                this.freq+=Integer.parseInt(data[0]);
                this.fullDictionary.put(data[1], Integer.parseInt(data[0]));
            }
            scanner.close();
        } catch (
                FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public Map<String, Integer> getOccurrenceDictionary() {
        return occurrenceDictionary;
    }

    public void setOccurrenceDictionary(Map< String, Integer> occurrenceDictionary) {
        this.occurrenceDictionary = occurrenceDictionary;
    }

    public Map<String, Integer> getFullDictionary() {
        return fullDictionary;
    }

    public void setFullDictionary(Map<String, Integer> fullDictionary) {
        this.fullDictionary = fullDictionary;
    }

    public List<Double> getP() {
        return p;
    }

    public void setP(List<Double> p) {
        this.p = p;
    }

    public List<Double> getQ() {
        return q;
    }

    public void setQ(List<Double> q) {
        this.q = q;
    }

    public int getOccurrences() {
        return occurrences;
    }

    public Integer getFreq() {
        return freq;
    }

    public void setFreq(Integer freq) {
        this.freq = freq;
    }
}
