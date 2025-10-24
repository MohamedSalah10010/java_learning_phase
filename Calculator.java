import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public  class Calculator
{

    public static  double add(Double... operands) {

        double sum = 0;
        for (double op : operands) {
            sum += op;
        }

        return sum;
    }

    public static double substract(Double... operands) {


        for (int i = 1; i < operands.length; i++) {
            operands[0] -= operands[i];

        }

        return operands[0];
    }

    public static double multiply(Double... operands) {

        double sum = 1;
        for (double op : operands) {
            sum *= op;
        }

        return sum;
    }

    public static double division(Double... operands) {


        for (int i = 1; i < operands.length; i++) {
            if (operands[i] == 0 ) {
                System.out.println("can't divide by zero");
                break;
            }

            operands[0] /= operands[i];
        }


        return operands[0];
    }


    public static void calculator(List<Double> data, List<Character> operation)
    {
//       List<Double> sum = new ArrayList<>();

        for(int i =0 ; i< data.size();i++){
            if(operation.get(i) == '*' || operation.get(i) == '/')
            {
                if(operation.get(i) == '*' )
                {
                   data.set(i,multiply(data.get(i), data.get(i+1)));
                   data.remove(i+1);
                   operation.remove(i);
                   --i;
                }
                else
                {

                        if (data.get(i+1) == 0 ) {
                            System.out.println("can't divide by zero");
                            break;
                        }
                        data.set(i, division(data.get(i), data.get(i + 1)));
                        data.remove(i + 1);
                        operation.remove(i);
                        --i;
                }
            }
        }
        for(int i =0 ; i< data.size();i++){
            if(operation.get(i) == '+' || operation.get(i) == '-')
            {
                if(operation.get(i) == '+' )
                {
                    data.set(i,add(data.get(i), data.get(i+1)));
                    data.remove(i+1);
                    operation.remove(i);
                    --i;
                }
                else
                {
                    data.set(i, substract(data.get(i), data.get(i + 1)));
                    data.remove(i + 1);
                    operation.remove(i);
                    --i;
                }
            }
        }


        if (operation.getLast() == '=') {
                System.out.print("sum= ");

                System.out.println(data.get(0));
            }
    }



    public static void main(String[] args) {

        System.out.println("Welcome to my humble calculator\nDesigened and developed By\\Mohamed Salah ElMorgel\n2025");
        Character exitFlag = 'N';
        do {
            List<Double> data = new ArrayList<>();
            List<Character> operations = new ArrayList<>();

            int i = 1;
            do {


                System.out.print("Enter opernad" + i + ": ");
                i++;
                Scanner scan = new Scanner(System.in);
                data.add(scan.nextDouble());
                System.out.print("Enter the operation(\" + - * / = \"): ");
                operations.add(scan.next().charAt(0));

                if (operations.getLast() == '=') {

//            Calculator calc = new Calculator();
                    Calculator.calculator(data, operations);

                    System.out.println("Do You want Exit?? (y or n): ");
                    exitFlag = scan.next().charAt(0);
                    exitFlag = exitFlag.toUpperCase(exitFlag);

                }

            } while (operations.getLast() != '=' );

        }while (exitFlag == 'N');

    }
}







    











