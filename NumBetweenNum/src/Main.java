import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        ArrayList<Integer> numerot = new ArrayList();

        numerot.add(1);
        numerot.add(3);
        numerot.add(5);
        numerot.add(5);
        numerot.add(6);

        Collections.sort(numerot);

        int pieninVali = Integer.MAX_VALUE;

        for (int i= 0; i < numerot.size() - 1; i++) {
            int nykyinenNumero = numerot.get(i);
            int seuraavaNumero = numerot.get(i + 1);
            int vali = seuraavaNumero - nykyinenNumero - 1;

            if (nykyinenNumero == seuraavaNumero) {
                continue;
            }

            if (vali < pieninVali) {
                pieninVali = vali;
            }
        }
        System.out.println("pienin väli: " + pieninVali);
    }
}