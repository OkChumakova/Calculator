public class Addition implements IOperation {

    private float result;

    private static Addition additionInstance;

    public float calculate (float firstNUm, float secondNum){
        result =  firstNUm + secondNum;
        return result;
    }

    private Addition() { }

    static {
        additionInstance = new Addition();
    }

    public static Addition getInstance() {
        return additionInstance;
    }

}
