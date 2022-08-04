public class ParameterizedClass {
    public static void main(String[] args) {
        Info<String> info = new Info<>("Hello");
        System.out.println(info);// toString можно не прописывать
        String s = info.getValue();
        Info<Integer> info2 = new Info<>(32);
        System.out.println(info2);
        int n = info2.getValue();

    }
}

class Info <T> {   //T - заполнитель или хранитель типа( вместо него подставляется новый тип при создании объекта)
    //<T extends Number&f>  T - наследует Number и реализует интерфей f
    private T value; // не может быть статичной
    public Info(T value){
        this.value = value;
    }
    public String toString(){
        return "{[" + value + "]}";
    }
    public T getValue() {
        return value;
    }
}