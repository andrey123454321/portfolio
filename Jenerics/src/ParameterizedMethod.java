import java.util.ArrayList;
import java.util.List;

public class ParameterizedMethod {
    public static void main(String[] args) {
        ArrayList<Integer> al1 = new ArrayList<Integer>();
        al1.add(10);
        al1.add(20);
        al1.add(5);
        int a = GenMethod.getSecondElement(al1);
        System.out.println(a);
        ArrayList<String> al2 = new ArrayList<String>();
        al2.add("abv");
        al2.add("bcv");
        al2.add("fsw");
        String s = GenMethod.getSecondElement(al2);
        System.out.println(s);
    }

}
class GenMethod {
    public static <T> T getSecondElement(ArrayList<T> a1){ // возвращает тип T - дженерик
        return a1.get(1);
    }
}
