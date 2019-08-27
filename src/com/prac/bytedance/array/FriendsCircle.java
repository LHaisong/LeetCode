package com.prac.bytedance.array;

public class FriendsCircle {
    /**
     * 班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。
     * 如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。
     * 所谓的朋友圈，是指所有朋友的集合。
     * <p>
     * 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。
     * 如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。
     * 你必须输出所有学生中的已知的朋友圈总数。
     * <p>
     * <p>
     * 输入:
     * [[0,0,0],
     * [0,0,0],
     * [0,0,1]]
     * 输出: 2
     * 说明：已知学生0和学生1互为朋友，他们在一个朋友圈。
     * 第2个学生自己在一个朋友圈。所以返回2。
     */
    public static void main(String[] args) throws Exception {
        int[][] arr = {{1, 1, 0},
                       {1, 0, 0},
                       {0, 0, 1}};
        getFriendsCircleCount(arr);
    }

    private static void getFriendsCircleCount(int[][] arr) throws Exception {
        if (arr == null || arr.length == 0) {
            throw new Exception("非法输入");
        }
        int max = 0;
        for (int i = 0; i < arr.length; ++i) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 1) {
                    search(arr, i, j);
                    max++;
                }
            }
        }
        System.out.println(max);
    }

    private static void search(int[][] arr, int i, int j) {// 0
        if(i>=0&&i<arr.length&&j>=0&&j<arr[0].length&&arr[i][j] == 1) {
            arr[i][j]=0;
            search(arr,i+1,j);
            search(arr,i-1,j);
            search(arr,i,j+1);
            search(arr,i,j-1);
        }else {
            return;
        }
    }
}
