package kmp;

public class Main {
    public static void main(String[] args){
        String pat = "aaab";
        KMP kmp = new KMP(pat);
        int pos = kmp.search("aaacaaab");
        System.out.println(pos);

    }
}
