package com.leetcode.l127单词接龙;

import java.util.*;

class Solution2 {
    Map<String, Integer> wordMap = new HashMap<String, Integer>();
    List<List<Integer>> edges = new ArrayList<List<Integer>>();
    int cnt = 0;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        for (String word : wordList) {
            addEdge(word);
        }
        addEdge(beginWord);
        if (!wordMap.containsKey(endWord)) {
            return 0;
        }
        int[] dis = new int[cnt];
        for(int i=0;i<dis.length;i++){
            dis[i] = Integer.MAX_VALUE;
        }
        dis[wordMap.get(beginWord)] = 0;

        Queue<Integer> que = new LinkedList<Integer>();
        que.offer(wordMap.get(beginWord));
        while (!que.isEmpty()) {
            int x = que.poll();
            if (x == wordMap.get(endWord)) {
                return dis[x] / 2 + 1;
            }
            for (int it : edges.get(x)) {
                if (dis[it] == Integer.MAX_VALUE) {
                    dis[it] = dis[x] + 1;
                    que.offer(it);
                }
            }
        }
        return 0;
    }

    public void addEdge(String word){
        addWord(word);
        int wordId = wordMap.get(word);
        char replace = '*';
        for(int i =0;i<word.length();i++){
            String temp;
            if(i == 0) {
                temp = '*' + word.substring(1,word.length());
            }else if (i == word.length()-1) {
                temp =  word.substring(0,word.length()-1) + '*';
            }else {
                temp = word.substring(0,i) + replace + word.substring(i+1,word.length());
            }
            addWord(temp);
            int newWordId = wordMap.get(temp);
            edges.get(newWordId).add(wordId);
            edges.get(wordId).add(newWordId);
        }

    }

    public void addWord(String word) {
        if (!wordMap.containsKey(word)) {
            wordMap.put(word, cnt++);
            edges.add(new ArrayList<Integer>());
        }
    }

    public static void main(String[] args){
        Solution2 solution = new Solution2();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log"));

        int res = solution.ladderLength(beginWord,endWord,wordList);
        System.out.println(res);
    }
}


