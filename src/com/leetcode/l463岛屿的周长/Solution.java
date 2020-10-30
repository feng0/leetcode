package com.leetcode.l463岛屿的周长;

public class Solution {

    public static int islandPerimeter(int[][] grid) {
        int sum = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                //每个方框计算 上下左右 累加
                if(grid[i][j] == 1){

                    if(i==0 || grid[i-1][j] == 0){
                        sum ++;
                    }

                    if(i == grid.length-1 || grid[i+1][j] == 0){
                        sum ++;
                    }

                    if(j==0 || grid[i][j-1] == 0){
                        sum ++;
                    }
                    if(j==grid[0].length-1 || grid[i][j+1] == 0){
                        sum ++;
                    }
                }
            }
        }
        return sum;
    }


    public static void main(String[] args){
        int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        System.out.println(islandPerimeter(grid));
    }
}
