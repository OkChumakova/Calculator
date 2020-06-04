public class Division implements IOperation {
    private float result;

    private static Division divisionInstance;

    public float calculate (float firstNum, float secondNum){
        result =  firstNum / secondNum;
        return result;
    }


    private Division() { }

    static {
        divisionInstance = new Division();
    }

    public static Division getInstance() {
        return divisionInstance;
    }

}
