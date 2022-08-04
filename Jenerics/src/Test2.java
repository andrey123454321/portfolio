import java.util.ArrayList;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        List<?> list = new ArrayList<String>();//<?>-супертип (вместо вопроса может быть обсолютно любой класс)
        List<? super Number> list3 = new ArrayList<Object>();//можем использовать родительские классы Number
        //? - Wildcard
        //пишем метод, который будет выводить на экран обсолютно любой лист
        List<String> list1 = new ArrayList<>();
        list1.add("ok");
        list1.add("privet");
        list1.add("poka");
        ArrayList<Double> list2 = new ArrayList<>();
        list2.add(3.12);
        list2.add(2.11);
        list2.add(4.15);
        System.out.println (summ(list2));
        showListInfo(list1);
        showListInfo(list2);
    }

    static void showListInfo(List<?> list){
        System.out.println(list);
    }
    public static double summ (ArrayList<? extends Number> a1 ){
        double summ=0;
        for(Number n : a1 ){
            summ+=  n.doubleValue();
        }
        return summ;
    }
}
