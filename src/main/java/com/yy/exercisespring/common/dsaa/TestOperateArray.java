package com.yy.exercisespring.common.dsaa;

import java.util.Arrays;

/**
 * @Author: xdz
 * @Descrption: 数组的添加和删除
 * @Date: 2021/2/11 16:13
 */
public class TestOperateArray {

    public static void main(String[] args) {

        //int[] arr = new int[3];

        int[] arr = new int[]{1, 2, 3, 4};

        System.out.println(Arrays.toString(arr));

        arr = add(7, arr.length, arr);
        System.out.println(Arrays.toString(arr));

        arr = remove(2, arr);
        System.out.println(Arrays.toString(arr));

    }

    /**
     * 添加元素
     * @param value
     * @param index
     * @param oldArr
     * @return
     */
    private static int[] add(int value, int index, int[] oldArr) {
        int[] newArr = new int[oldArr.length + 1];
        for (int i = 0; i < newArr.length; i++) {
            if (i < index) {
                newArr[i] = oldArr[i];
            } else if (i == index) {
                newArr[i] = value;
            } else {
                newArr[i] = oldArr[i - 1];
            }
        }

        return newArr;
    }

    /**
     * 删除元素
     * @param index
     * @param oldArr
     * @return
     */
    private static int[] remove(int index, int[] oldArr) {
        int[] newArr = new int[oldArr.length - 1];
        for (int i = 0; i < newArr.length; i++) {
            if (i < index) {
                newArr[i] = oldArr[i];
            } else {
                newArr[i] = oldArr[i + 1];
            }
        }

        return newArr;
    }
}
