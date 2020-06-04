public class Subtraction implements IOperation {
    private float result;

    private static Subtraction subtractionInstance;

    public float calculate (float firstNUm, float secondNum){
        result =  firstNUm - secondNum;
        return result;
    }

    private Subtraction() { }

    static {
        subtractionInstance = new Subtraction();
    }

    public static Subtraction getInstance() {
        return subtractionInstance;
    }
    

}
