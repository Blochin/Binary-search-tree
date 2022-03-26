public class Main {
    public static void main(String[] args) {
        DataHolder dataHolder = new DataHolder("src/main/resources/dictionary.txt",50000);
        Search search = new Search(dataHolder);
        dataHolder.doStuff();
    }
}
