import java.util.Scanner;

public class Banken {
    
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        boolean run = true;

        int saldo = 0;

        System.out.println("Välkommen till banken!");
        while(run){
            System.out.println("[Alternativ 1-4] 1.Se saldo 2.Sätt in pengar 3.Ta ut pengar 4.Avsluta");
            if(hasNextIntCheck(input)){
                int choice = input.nextInt();

                switch(choice){

                case 1:
                System.out.println(showAmount(saldo));
                break;

                case 2:
                saldo = depositAmount(saldo, input);
                break;

                case 3:
                saldo = withdrawalAmount(saldo, input);
                break;
                case 4:
                run = turnOff(run);
                break;
                
            }
            }
            else{
                System.out.println("Du kan enbart välja mellan 1,2,3 och 4");
                input.nextLine();
            }

        }
        
    }

    public static boolean hasNextIntCheck(Scanner choiceInput){
        if(choiceInput.hasNextInt()){
            return true;
        }
        else{
            return false;
        }
    }

    public static String showAmount (int saldo){
        String saldoReturnToUser = "Ditt saldo är " + saldo + "kr";
        return saldoReturnToUser;
    }
    public static int depositAmount(int saldo, Scanner input){
        System.out.println("Hur mycket vill du sätta in?");
                if(hasNextIntCheck(input)){
                    int deposit = input.nextInt();
                    int saldoReturn = saldo += deposit;
                    return saldoReturn;
                }
                else{
                    System.out.println("Oj! nu skrev du inte en siffra");
                    input.nextLine();
                    
                }
                input.nextLine();
                return 0;
    }

    public static int withdrawalAmount (int saldo, Scanner input){
        System.out.println("Hur mycket vill du ta ut?");
                if(hasNextIntCheck(input)){
                    int withdrawal = input.nextInt();
                    if(saldo - withdrawal < 0){
                        System.out.println("Du kan inte ta ut mer pengar än du har! du har " + saldo + "kr på kontot men försökte ta ut " + withdrawal + "kr");
                    }
                    else{
                        saldo -=withdrawal;
                        return saldo;
                    }
                }
                else{
                    System.out.println("Oj! nu skrev du inte en siffra");
                    input.nextLine();
                    
                }
                input.nextLine();
                return saldo;
    }

    public static boolean turnOff (boolean run){
        run = false;
        return run;
    }
}
