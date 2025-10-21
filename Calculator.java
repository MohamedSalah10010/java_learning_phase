import java.util.Scanner;

public class Calculator{

    public int add(int... operands) {
        
        int sum =0;
   for (int op : operands) {
        sum += op;}

       return sum;
   }
   public double add(Double... operands) {
       
       double sum =0;
  for (double op : operands) {
       sum += op;}

      return sum;
  }
  
  public int substract(int... operands) {
        
    int sum =0;
for (int op : operands) {
    sum -= op;}

   return sum;
}
public double substract(Double... operands) {
   
   double sum =0;
for (double op : operands) {
   sum -= op;}

  return sum;
}
public int multiply(int... operands) {
        
    int sum =0;
for (int op : operands) {
    sum *= op;}

   return sum;
}
public double multiply(Double... operands) {
   
   double sum =0;
for (double op : operands) {
   sum *= op;}

  return sum;
}
public int division(int... operands) {
        
    int sum =0;
for (int op : operands) {
    if(op==0){ System.out.println("can't divide by zero"); break;}

    sum /= op;}

   return sum;
}
public double division(Double... operands) {
   
   double sum =0;
for (double op : operands) {
    if(op==0){ System.out.println("can't divide by zero"); break;}
   sum /= op;}

  return sum;
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
    int dataSize = 10;
    System.out.println("Welcome to my humble calculator\nDesigened and developed By\\Mohamed Salah ElMorgel\n2025");
    
    // System.out.println("please enter the equation as following:  2 + 5 + 6 .....");
    
    // do{
    // System.err.println("Enter your first operand: ");
    double[] data= new double[dataSize] ;
    char[] operations= new char[dataSize] ;
    for (int i =1; i<dataSize;i++){


        System.out.println("Enter opernad"+i+": ");
        Scanner scan = new Scanner(System.in);
         data[i-1]= scan.nextDouble();
        System.out.print("Enter the operation(\" + - * / = \"): ");
        operations[i-1]=scan.next().charAt(0);
        if(operations[i-1] == '=') {
            scan.close();
            Calculator calculator=new Calculator();
            calculator.calculator(data, operations);



        }

    }


}




}
