import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalculatorV1 {

    public double add(Double... operands) {

        double sum = 0;
        for (double op : operands) {
            sum += op;
        }

        return sum;
    }

    public double substract(Double... operands) {

//   double [] sum = new double[operands.length];
        for (int i = 1; i < operands.length; i++) {
            operands[0] -= operands[i];

        }

        return operands[0];
    }

    public double multiply(Double... operands) {

        double sum = 1;
        for (double op : operands) {
            sum *= op;
        }

        return sum;
    }

    public double division(Double... operands) {

//    double[] sumA =new double[operands.length];
//    double sum=1;
        for (int i = 1; i < operands.length; i++) {
            if (operands[i] == 0 || operands[0] == 0) {
                System.out.println("can't divide by zero");
                break;
            }
//    if(operands.length==i){sumA[i]=operands[i]; break;}
            operands[0] /= operands[i];
        }

//    for (int i=0; i < sumA.length-1;  i++) {
////        if(sumA.length == i){sum=sumA[i-1]/sumA[i]; break;}
//        sum = sumA[i]/sumA[i+1];
//    }
        return operands[0];
    }


    public void calculator(List<Double> data, List<Character> operation) {
       List<Double> sum = new ArrayList<>();
        for(int i =0 ; i< data.size();i++){
            if(operation.get(i) == '*'){
               data.set(i,multiply(data.get(i), data.get(i+1)));
               data.remove(i+1);
               operation.remove(i);
               --i;
            }
            else if (operation.get(i) == '=') {
                System.out.print("sum= ");
//                for (int j = 0; j < data.size(); j++) {
//                    System.out.print(data.get(j)+" ");
//                    System.out.print(operation.get(j)+" ");
//
//                    if (j == data.size() - 1) {
                        System.out.println(data.get(0));

//                    }


            }
            }






        }


    }




    


public void main(String[] args) {
//    int dataSize = 10;
    System.out.println("Welcome to my humble calculator\nDesigened and developed By\\Mohamed Salah ElMorgel\n2025");

    List<Double> data= new ArrayList<>();
    List<Character> operations= new ArrayList<>();
    int i = 1;
do {



    System.out.print("Enter opernad" + i + ": ");
    i++;
    Scanner scan = new Scanner(System.in);
    data.add(scan.nextDouble());
    System.out.print("Enter the operation(\" + - * / = \"): ");
    operations.add(scan.next().charAt(0));

    if (operations.getLast() == '=') {
        scan.close();
            CalculatorV1 calc= new CalculatorV1();
            calc.calculator(data, operations);

//        System.out.print("Equation: ");
//        for (int j = 0; j < data.size(); j++) {
//            System.out.print(data.get(j)+" ");
//            System.out.print(operations.get(j)+" ");
//
//            if (j == data.size() - 1) {
//                System.out.println();
//            }
//        }


    }

}while(operations.getLast() != '=');



    }








