public class Multiplication implements IOperation {
    private float result;

    private static Multiplication multiplicationInstance;

    public float calculate (float firstNUm, float secondNum){
        result =  firstNUm * secondNum;
        return result;
    }

    private Multiplication() { }

    static {
        multiplicationInstance = new Multiplication();
    }

    public static Multiplication getInstance() {
        return multiplicationInstance;
    }

}
