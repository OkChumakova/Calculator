import java.util.Scanner;

public class Main {

    public static void displayAvailableOperations(){
        System.out.println("\nPlease choose one of the following options:" +
                "\n \t + Add" +
                "\n \t - Subtract" +
                "\n \t * Multiply" +
                "\n \t / Divide" +
                "\n \t d Discard the result" +
                "\n \t q Quit the calculator");
    }


    public static void main(String[] args) {

        float result = 0;
        float firstEnteredNumber;
        float secondEnteredNumber;
        boolean isResultDiscarded = false;
        boolean isTheFirstRun = true;
        IOperation operation = null;


        Scanner scanner = new Scanner(System.in);


        while(true){

            if(isTheFirstRun || isResultDiscarded){
                firstEnteredNumber = new NumReader(scanner).getNumber();

                result+= firstEnteredNumber;

                Logging.logAction("The first entered number is: " + firstEnteredNumber, ELogNotifications.INFO);
                isTheFirstRun = false;
                isResultDiscarded = false;
            }

                displayAvailableOperations();

            while(true){
                System.out.println("Please enter the operation: ");

                String enteredOperation = scanner.nextLine();
                switch (enteredOperation) {
                    case "+":
                        operation = Addition.getInstance();
                        break;
                    case "-":
                        operation = Subtraction.getInstance();
                        break;
                    case "*":
                        operation = Multiplication.getInstance();
                        break;
                    case "/":
                        operation = Division.getInstance();
                        break;
                    case "d":
                        result = 0;
                        isResultDiscarded = true;
                        break;
                    case "q":
                        scanner.close();
                        Logging.logAction("The calculator is quited", ELogNotifications.INFO);
                        return;
                    default:
                        Logging.logAction("The entered operation is "
                                                            + enteredOperation
                                                            + " It is not valid."
                                                            , ELogNotifications.ERROR);
                        continue;
                }
                Logging.logAction("The entered operation is: " + enteredOperation, ELogNotifications.INFO);
                break;
            }

            if(!isResultDiscarded){
                secondEnteredNumber =  new NumReader(scanner).getNumber();
                Logging.logAction("The second  entered number is: "+ secondEnteredNumber, ELogNotifications.INFO);

                if(operation.getClass() == Division.class){
                    if(secondEnteredNumber == 0){
                        Logging.logAction("The division by zero is not allowed", ELogNotifications.ERROR);
                        isResultDiscarded = true;
                        continue;
                    }
                }

                result = operation.calculate(result, secondEnteredNumber);
                Logging.logAction("The result of the operation is: " + result, ELogNotifications.INFO);

            }
        }
    }
}
