package com.micode.出现频率最高的前K个元素;
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine().trim();
            // please write your code here
            if("".equals(line)){
                break;
            }
            String[] arr = line.split(" ");

             System.out.println(findDigit(arr[0].split(","),Integer.parseInt(arr[1])));
        }
    }

    public static String findDigit(String[] arr,int k){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int temp = Integer.parseInt(arr[i]);
            if(map.containsKey(temp)){
                map.put(temp,map.get(temp) + 1);
            }else{
                map.put(temp,1);
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.value-o1.value;
            }
        });
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            pq.offer(new Node(entry.getKey(),entry.getValue()));
        }
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<k-1;i++){
            sb.append(pq.poll().key).append(",");
        }
        sb.append(pq.poll().key);
        return sb.toString();
    }

    private static class Node {
        public int key;
        public int value;

        public Node(int key,int value){
            this.key = key;
            this.value = value;
        }
    }
}
