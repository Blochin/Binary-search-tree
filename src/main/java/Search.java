import binary_tree.BinarySearchTree;
import binary_tree.Node;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Search {
    DataHolder dataHolder;
    BinarySearchTree binarySearchTree;

    public Search(DataHolder dataHolder){
        this.dataHolder = dataHolder;

        this.dataHolder.setOccurrenceDictionary(sortDictionary(this.dataHolder.getOccurrenceDictionary()));
        this.dataHolder.setFullDictionary(sortDictionary(this.dataHolder.getFullDictionary()));
        this.dataHolder.setQ(calculateQ(this.dataHolder.getFreq(), this.dataHolder.getFullDictionary(), this.dataHolder.getOccurrences()));
        this.dataHolder.setP(calculateP(this.dataHolder.getFreq(), this.dataHolder.getOccurrenceDictionary()));
        int[][] obst = obst(this.dataHolder.getP(),this.dataHolder.getQ(), this.dataHolder.getOccurrenceDictionary().size());
        this.binarySearchTree = constructOptimalBinarySearchTree(
                obst,
                1,
                this.dataHolder.getOccurrenceDictionary().size()
        );
    }

    public void pocet_porovnani(String search){
        System.out.println(binarySearchTree.getRoot().compare(search,1));
    }

    private Map<String ,Integer> sortDictionary(Map<String,Integer> map){
        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
        return sortedMap;
    }

    private List<Double> calculateQ(int freq , Map<String,Integer> dictionary, int occurrences){
        List<Double> q = new ArrayList<>();
        double q_freq = 0;
        for (Map.Entry<String, Integer> word : dictionary.entrySet()){
            if(word.getValue() < occurrences){
                q_freq += word.getValue();
            }else{
                q.add(q_freq/freq);
                q_freq = 0;
            }
        }
        if(q_freq != 0){
            q.add(q_freq/freq);
        }
        return q;
    }

    private List<Double> calculateP(int freq , Map<String,Integer> dictionary){
        List<Double> p = new ArrayList<>();
        p.add(-1.0);
        for (Map.Entry<String, Integer> word : dictionary.entrySet()){
            p.add((double)(word.getValue())/freq);
        }
        return p;
    }

    private static int[][] obst(List<Double> p,  List<Double> q, int n){
        double[][] w = new double[n+2][n+2];
        int[][] root = new int[n+2][n+2];
        double[][] e = new double[n+2][n+2];
        for(int i=0;i<=n;i++){
            e[i+1][i] = q.get(i);
            w[i+1][i] = q.get(i);
        }
        for(int k=1;k<=n;k++){
            for(int i=1;i<=n-k+1;i++){
                int j = i+k-1;
                e[i][j] = Integer.MAX_VALUE;
                w[i][j] = w[i][j-1] + p.get(j) + q.get(j);
                for(int r=i;r<=j;r++){
                    double t = e[i][r-1] + e[r+1][j] + w[i][j];
                    if(t < e[i][j]){
                        e[i][j] = t;
                        root[i][j] = r;
                    }
                }
            }
        }
        return root;
    }

    private BinarySearchTree constructOptimalBinarySearchTree(int[][] root, int lowerKey,int higherKey){
        int value = root[lowerKey][higherKey];
        Node node = new Node(this.dataHolder.getOccurrenceDictionary().keySet().toArray()[value-1].toString());
        if(lowerKey<=value-1){
            node.setLeftNode(constructOptimalBinarySearchTree(root, lowerKey, value-1).getRoot());
        }else{
            node.setLeftNode(null);
        }
        if(higherKey >=value+1){
            node.setRightNode(constructOptimalBinarySearchTree(root,     value+1, higherKey).getRoot());
        }else{
            node.setRightNode(null);
        }
        return new BinarySearchTree(node);
    }

    public BinarySearchTree getBinarySearchTree() {
        return binarySearchTree;
    }

    public void setBinarySearchTree(BinarySearchTree binarySearchTree) {
        this.binarySearchTree = binarySearchTree;
    }
}
