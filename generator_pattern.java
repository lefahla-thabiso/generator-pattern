import java.util.ArrayList;
import java.util.stream.Stream;
import java.io.InputStream;
import java.util.*;

public class generator_pattern {

    public static ArrayList<Integer> getNumbers() {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        Integer num1, num2, num3, num4, num5, num6, num7;

        System.out.print("\n");

        System.out.print("Number 1: ");
        num1 = input.nextInt();
        list.add(0, num1);

        System.out.print("Number 2: ");
        num2 = input.nextInt();
        list.add(1, num2);

        System.out.print("Number 3: ");
        num3 = input.nextInt();
        list.add(2, num3);

        System.out.print("Number 4: ");
        num4 = input.nextInt();
        list.add(3, num4);

        System.out.print("Number 5: ");
        num5 = input.nextInt();
        list.add(4, num5);

        System.out.print("Number 6: ");
        num6 = input.nextInt();
        list.add(5, num6);
       
        System.out.print("_________________________\n");

        System.out.print("Bonus : ");
        num7 = input.nextInt();
        list.add(6, num7);
       
        return list;
    }

    // Patten one

    public static ArrayList<Integer> pattern_one(ArrayList<Integer> alist){
        ArrayList<Integer> newList = new ArrayList<>();
        ArrayList<Integer> list_No_Duplicates = new ArrayList<>();
        //ArrayList<Integer> alist = getNumbers();

        Integer sum =  0;

        sum = sum + alist.get(0) + alist.get(1);
        if (sum > 49)
        {
            newList.add(0, Math.abs(alist.get(0) - alist.get(1)));
        } else {
            newList.add(0, sum);
        }
        
        for (Integer index = 2; index < alist.size()-1; index++) {
            //sum = sum + alist.get(index);
            sum = newList.get(newList.size() - 1) + alist.get(index);

            if (sum > 49) {
                newList.add(index - 1, Math.abs(newList.get(newList.size() - 1) - alist.get(index)));
            } else {
                newList.add(index - 1, sum);
            }
        }
        
        //remove duplicates from new created list
        for (Integer numbers : newList) {
            if (!list_No_Duplicates.contains(numbers)) {
                list_No_Duplicates.add(numbers);
            }
        }
        Collections.sort(list_No_Duplicates);
        return list_No_Duplicates;
    }
    
    // pattern two
    public static ArrayList<Integer> pattern_two(ArrayList<Integer> alist) {
        ArrayList<Integer> newList = new ArrayList<>();
        ArrayList<Integer> inputList = alist;
        int bonus = inputList.get(inputList.size() - 1);
        
        for (Integer index = 0; index < inputList.size() - 1; index++) {
            newList.add(Math.abs(bonus - inputList.get(index)));
        }

        Collections.sort(newList);
        
        return newList;
    }
    public static void main(String[] args) {
        ArrayList<Integer> alist = getNumbers();
        System.out.println("\nPattern one : " + pattern_one(alist));
        System.out.println("Pattern two : " + pattern_two(alist));        
    }
}