package com.jarics.methodref;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;

public class Numbers {
    public static boolean isMoreThanFifty(int i1, int i2){
        return (i1+i2)>50;
    }
    public static List<Integer> findNumbers(List<Integer> pList, BiPredicate<Integer, Integer> pPredicate){
        List<Integer> retList = new ArrayList<Integer>();
        for (Integer i : pList) {  //that is cool....
            if (pPredicate.test(i, i+10)){
                retList.add(i);
            }
        }
        return retList;
    }
}
