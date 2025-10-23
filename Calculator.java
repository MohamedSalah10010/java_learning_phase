import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator{

    public double add(Double... operands) {
       
       double sum =0;
  for (double op : operands) {
       sum += op;}

      return sum;
  }

    public double substract(Double... operands) {
   
//   double [] sum = new double[operands.length];
for (int i=1;i<operands.length;i++) {
    operands[0]-= operands[i];

}

  return operands[0];
}

    public double multiply(Double... operands) {
   
   double sum =1;
for (double op : operands) {
   sum *= op;}

  return sum;
}

    public double division(Double... operands) {

//    double[] sumA =new double[operands.length];
//    double sum=1;
    for (int i=1; i < operands.length;  i++) {
        if(operands[i]==0 || operands[0]==0){ System.out.println("can't divide by zero"); break;}
//    if(operands.length==i){sumA[i]=operands[i]; break;}
        operands[0] /= operands[i];
    }

//    for (int i=0; i < sumA.length-1;  i++) {
////        if(sumA.length == i){sum=sumA[i-1]/sumA[i]; break;}
//        sum = sumA[i]/sumA[i+1];
//    }
    return  operands[0];
}





public void calculator(double[] data , char[] operation) {
    int index=0;
    for (var op : operation){
        if(op == '*')
        {
            data[index] = multiply(data[index],data[index+1]);
            index++;
        }
    }
    index=0;
    for (var op : operation){
             if(op == '/')
        {

            data[index] = division(data[index],data[index+1]);
            index++;
        }
    } 
    
    index=0;
    
    for (var op : operation){
        if(op=='+')
        {
            data[index] = add(data[index],data[index+1]);
            index++;
        }
    } 
    index=0;
    
    for (var op : operation){
        if(op=='-')
        {
            data[index] = substract(data[index],data[index+1]);
            index++;
        }
    }
if (operation[index]=='='){
    System.out.println("sum = " + data[0]);
}
    
}

public static void main(String[] args) {
//    int dataSize = 10;
    System.out.println("Welcome to my humble calculator\nDesigened and developed By\\Mohamed Salah ElMorgel\n2025");

    List<Double> data= new ArrayList<>();
    List<Character> operations= new ArrayList<>();
do {
    int i = 1;


    System.out.print("Enter opernad" + i + ": ");
    Scanner scan = new Scanner(System.in);
    data.add(scan.nextDouble());
    System.out.print("Enter the operation(\" + - * / = \"): ");
    operations.add(scan.next().charAt(0));
    i++;
    if (operations.getLast() == '=') {
        scan.close();
//            Calculator calculator=new Calculator();
//            calculator.calculator(data, operations);

        System.out.print("Equation: ");
        for (int j = 0; j < data.size(); j++) {
            System.out.print(data.get(j)+" ");
            System.out.print(operations.get(j)+" ");

            if (j == data.size() - 1) {
                System.out.println();
            }
        }


    }

}while(operations.getLast() != '=');



    }


}





