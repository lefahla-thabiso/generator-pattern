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

        System.out.print("last : ");
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
    // pattern 3
    public static Character homeConversion(Character digit) {
        if (digit.equals('1')) {
            return '6';
        }else  if (digit.equals('2')) {
            return '7';
        }else  if (digit.equals('3')) {
            return '8';
        }else  if (digit.equals('4')) {
            return '9';
        }else if (digit.equals('6')) {
            return '1';
        }else  if (digit.equals('7')) {
            return '2';
        }else  if (digit.equals('8')) {
            return '3';
        }else  if (digit.equals('9')) {
            return '4';
        }else  if (digit.equals('5')) {
            return '0';
        } else {
            return '5';
        }
    }

    public static Integer getCharIndex(Integer digit) {
        if (digit.equals(1)) {
            return 6;
        }else  if (digit.equals(2)) {
            return 7;
        }else  if (digit.equals(3)) {
            return 8;
        } else if (digit.equals(4)) {
            return 9;
        } else if (digit.equals(5)) {
            return 0;
        } else if (digit.equals(6)) {
            return 1;
        } else if (digit.equals(7)) {
            return 2;
        } else if (digit.equals(8)) {
            return 3;
        }  else if (digit.equals(9)) {
            return 4;
        } else {
            return 5;
        }  
    }
    public static  Integer homeValue(int Number, int first_digit_or_second) {
        Integer homeNumber = 0;
        Character homeDigit = ' ';// = 0;
        String homeString;
        Character digitChar;
        
        homeString = String.valueOf(Number);

        StringBuilder stringBuilder = new StringBuilder(homeString);
       // if (homeString.length() > 2) {
            if (first_digit_or_second == 1) {
            digitChar = homeString.charAt(0);
            homeDigit = homeConversion(digitChar);
            stringBuilder.setCharAt(0,(char) homeDigit);
        } else {
            //System.out.println(homeString);
            // if (homeString.length() == 1) {
                digitChar = homeString.charAt(1);
            // } else {
            //     digitChar = homeString.charAt(0);
            // }
            
            homeDigit = homeConversion(digitChar);
            stringBuilder.setCharAt(1,(char) homeDigit);
        }
               
        homeNumber = Integer.parseInt(stringBuilder.toString());
        //}
         
        
        return homeNumber;
    }
    
    public static ArrayList<Integer> pattern_three(ArrayList<Integer> aList) {
        ArrayList<Integer> newList = new ArrayList<>();
        ArrayList<Integer> inputeList = aList;
         
       // Integer indexList = 0;
        for (Integer index = 0; index < inputeList.size() - 1; index++) {
            newList.add(inputeList.get(index) * 2);
        }

        for (Integer index = 0; index < newList.size(); index++) {
            if (newList.get(index) > 49) {
                newList.set(index, homeValue(newList.get(index), 1));
            }
        }

        
        for (Integer index = 0; index < newList.size(); index++) {
            for (Integer indexj = index + 1; indexj < newList.size() - 1; indexj++) {
                if (newList.get(index) == newList.get(indexj)) {
                    if (newList.get(indexj) < 10) {
                         newList.set(indexj, getCharIndex(newList.get(indexj)));
                        
                    } else {
                    newList.set(indexj, homeValue(newList.get(indexj), 2));
                        
                    }

                }
            }
        }
        //Collections.sort(newList);
        return newList;
    }
    public static void main(String[] args) {
        ArrayList<Integer> alist = getNumbers();
        System.out.println("\nPattern one : " + pattern_one(alist));
        System.out.println("Pattern two : " + pattern_two(alist));
        System.out.println("Pattern three : " + pattern_three(alist));              
    }
}