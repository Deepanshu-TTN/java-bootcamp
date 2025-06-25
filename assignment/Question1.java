package assignment;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Question1 {
    public static void main(String[] args) {
        List<Float> floatList = new ArrayList<>();
        floatList.add(1.9f);
        floatList.add(2.8f);
        floatList.addAll(0, List.of(1.2f, 3.1f, 3.5f)); //adding elements at start

        System.out.println("Sum of the elemts of " + floatList + " is " + getSum(floatList));
    }

    static float getSum(List<Float> floatList) {
        Iterator<Float> myIterator = floatList.iterator();
        float sum = 0;
        while (myIterator.hasNext()) {
            sum+= myIterator.next();
        }
        return sum;
    }

    void something(){
        StringBuilder sb = new StringBuilder();
        sb.append("hello ");
        sb.append("there");
        String myString = sb.toString();
        System.out.println(myString);
    }
}
