import java.util.Scanner;
import java.util.*;
import java.util.Arrays;
import java.util.List;

public class MyClass {
    
    public static void main(String args[]) {
        int input = -1;
        String result = "";
        List<Integer> listNum;
        Scanner in = new Scanner(System.in);
        input = in.nextInt();
        
        while (input!= 0){
            listNum = new ArrayList();
            listNum.add(input);
            result = new MyClass().cubifinitos(input, listNum);
            System.out.println(result + " \n");
            input = in.nextInt();
        }
        
    }
    
    public String cubifinitos(int num, List<Integer> listNum){
        if(num ==1){
            return String.valueOf(num) + " -> cubifinito.";
        }
        else{
            int aux = 0,aux1 =0, aux2 = num;
            while (aux2 >= 10){
                aux1 = aux2%10;
                aux2 = aux2/10;
                aux = aux + aux1*aux1*aux1;
            }
            aux = aux + aux2*aux2*aux2;
            
            if (listNum.contains(aux)) {
                return String.valueOf(num) + " - " + String.valueOf(aux) + " -> no cubifinito.";
            }
            else{
                listNum.add(aux);
                return String.valueOf(num) + " - " +cubifinitos(aux, listNum);
            }
        }
      
    }
}
