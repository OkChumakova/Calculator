import java.util.Scanner;

public class NumReader {
    private float number;

    NumReader(Scanner scanner){
        this.number = getNumber(scanner);
    }


    float getNumber(Scanner scanner){
        while(true) {
            System.out.println("Please enter the number (int/float) in the range from -20 to 20:");
            String input = scanner.nextLine();
                try{
                    float numInput = Float.parseFloat(input);
                    if(numInput >= -20 && numInput <= 20){
                        return numInput;
                    } else{
                        Logging.logAction("The number has to be in the range from -20 to 20.", ELogNotifications.ERROR);
                    }

                }catch(NumberFormatException e){
                    Logging.logAction("The number has to be of INT/FLOAT types.", ELogNotifications.ERROR);
                }
        }
    }

    public float getNumber() {
        return number;
    }
}
