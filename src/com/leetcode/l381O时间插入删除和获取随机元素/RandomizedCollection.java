package com.leetcode.l381O时间插入删除和获取随机元素;

import java.util.*;

class RandomizedCollection {
    List<Integer> list;
    Map<Integer, Set<Integer>> map;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        list.add(val);
        Set<Integer> set = map.getOrDefault(val,new HashSet<>());
        set.add(list.size()-1);
        map.put(val,set);
        return set.size() == 1;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }

        Iterator<Integer> it = map.get(val).iterator();
        int valIndex = it.next();
        //最后一个元素处理
        int lastNum = list.get(list.size()-1);
        list.set(valIndex,lastNum);
        //该元素处理
        map.get(val).remove(valIndex);
        map.get(lastNum).remove(list.size()-1);
        if(valIndex < list.size() -1 ){
            map.get(lastNum).add(valIndex);
        }


        if(map.get(val).size() == 0){
            map.remove(val);
        }
        list.remove(list.size() -1 );
        return true;

    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get((int)(Math.random()*list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
