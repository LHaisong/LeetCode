package com.prac.bytedance.array;

/**
 * 求岛屿最大面积，数组中最多有多少个1相连(对角线不算相连)
 * 用一个boolean数组seen标记是否已经计算过
 */
public class MaxAreaIsland {
    int area[][];
    boolean seen[][];

    public static void main(String[]args){
        int area[][]={{0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        int res=new MaxAreaIsland().maxAreaOfIsland(area);
        System.out.println(res);
    }
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for(int i = 0;i < grid.length;i++){
            for(int j = 0;j < grid[0].length;j++){
                if(grid[i][j] == 1){
                    int num = deepSearch(grid,i,j);
                    max = Math.max(num,max);
                }
            }
        }
        return max;
    }
    public int deepSearch(int[][] grid,int i,int j){
        if(i>=0&&i<grid.length&&j>=0&&j<grid[0].length&&grid[i][j] == 1){
            //将搜索过的节点置为0，减少搜索次数
            grid[i][j]=0;
            int num = 1 + deepSearch(grid,i-1,j) + deepSearch(grid,i+1,j) +
                    deepSearch(grid,i,j-1) + deepSearch(grid,i,j+1);
            return num;
        }else
            return 0;
    }

}
