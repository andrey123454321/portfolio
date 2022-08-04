public class ParameterizedClass2 {
    public static void main(String[] args) {
        Pair<String,Integer> pair1 = new Pair<>("privet", 1) ;
        int n = pair1.getValue2();
        String s = pair1.getValue1();
    }
}
class Pair <V1,V2>{
    private V1 value1;
    private V2 value2;
    public Pair (V1 value1 , V2 value2 ){
        this.value1 = value1;
        this.value2 = value2;
    }

    public V1 getValue1() {
        return value1;
    }

    public V2 getValue2() {
        return value2;
    }
}