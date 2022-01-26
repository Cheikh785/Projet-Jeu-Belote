import java.lang.reflect.Array;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        Random random = new Random();
        int nb, k=0;
        Integer tab[] = new Integer[52];
        int existTab[] = new int[52];
        nb = random.nextInt(52);

//        int i = 0;
        for (int i = 0; i < 52; i++) {
            tab[i] = i;
        }
//        Arrays.sort(tab);
        List<Integer> intList = Arrays.asList(tab);
        Collections.shuffle(intList);
        intList.toArray(tab);
        for (int j = 0; j < 52; j++)
            System.out.println(tab[j]);
        Arrays.sort(tab);
        System.out.println("-----------------------------------");
        for (int l = 0; l < 52; l++)
            System.out.println(tab[l]);
    }

}
