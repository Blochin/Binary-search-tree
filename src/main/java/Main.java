import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DataHolder dataHolder = new DataHolder("src/main/resources/dictionary.txt",50000);
        Search search = new Search(dataHolder);
        search.getBinarySearchTree().print();

        while (true){
            Scanner sc= new Scanner(System.in);
            System.out.print("Enter a string: ");
            String str= sc.nextLine();
            if(str.equals("exit")){
                break;
            }else{
                search.pocet_porovnani(str);
            }
        }
    }
}
