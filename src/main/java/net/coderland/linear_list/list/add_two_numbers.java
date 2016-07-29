package net.coderland.linear_list.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * User: zhangxin
 * Date: 2016-07-22
 * Time: 12:54:00
 */
public class add_two_numbers {

    public List<Integer> addTwoNumbers(List<Integer> firstList, List<Integer> secondList) {
        int carry = 0;
        List<Integer> results = new ArrayList<Integer>();
        Iterator<Integer> firstIterator = firstList.iterator();
        Iterator<Integer> secondIterator = secondList.iterator();
        while(firstIterator.hasNext() || secondIterator.hasNext()) {
            int first = firstIterator.hasNext() ? firstIterator.next() : 0;
            int second = secondIterator.hasNext() ? secondIterator.next() : 0;
            int value = (first + second + carry) % 10;
            results.add(value);
            carry = (first + second + carry) / 10;
        }

        if(carry > 0)
            results.add(carry);

        return results;
    }

    public static void main(String[] args) {
        List<Integer> firstList = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> secondList = Arrays.asList(6, 7, 8, 9, 10);
        List<Integer> result = new add_two_numbers().addTwoNumbers(firstList, secondList);
        for(Integer item: result) {
            System.out.println(item);
        }
    }
}
