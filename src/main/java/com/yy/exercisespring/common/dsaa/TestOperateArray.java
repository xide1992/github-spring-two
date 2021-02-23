package com.yy.exercisespring.common.dsaa;

import java.util.Arrays;

/**
 * @Author: xdz
 * @Descrption: 数组的添加和删除
 * @Date: 2021/2/11 16:13
 */
public class TestOperateArray {

    public static void main(String[] args) throws Exception {

        MyArray array = new MyArray();
        System.out.println(array.size());
        array.addSuffix(11);
        array.addSuffix(31);
        array.addSuffix(41);
        array.addSuffix(51);
        array.addSuffix(61);
        array.addSuffix(71);
        array.add(3, 33);
        //array.delete(5);
        System.out.println(array.size());
        System.out.println(array.getElement(3));

        System.out.println("search:" + array.searchIndex(61));

        System.out.println("binarySearch:" + array.binarySearchIndex(61, 0, array.size() - 1));
        array.print();

//        int[] arr = new int[3];

//        int[] arr = new int[]{1, 2, 3, 4, 6, 8, 9, 11, 23};
//
//        System.out.println(Arrays.toString(arr));

//        arr = add(7, arr.length, arr);
//        System.out.println(Arrays.toString(arr));
//
//        arr = remove(2, arr);
//        System.out.println(Arrays.toString(arr));

//        System.out.println("index:"+searchIndex(9,arr));
//        System.out.println("index:"+searchIndex(4,arr));

//        System.out.println("index:" + binarySearchIndex(24, arr, 0, arr.length - 1));

    }

    /**
     * 添加元素
     *
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
     *
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


    /**
     * 线性查找
     *
     * @param value
     * @param arr
     * @return
     */
    private static int searchIndex(int value, int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            if (value == arr[i]) {
                return i;
            }
        }
        return -1;
    }


    /**
     * 二分查找  要求数组必须是有序的
     *
     * @param value
     * @param arr
     * @return
     */
    private static int binarySearchIndex(int value, int[] arr, int indexStart, int indexEnd) {
        //当开始下标与结束下标重合,说明没有查找到
        if (indexStart >= indexEnd) {
            return -1;
        }

        int middle = (indexStart + indexEnd) / 2;

        if (value == arr[middle]) {
            return middle;
        } else if (value < arr[middle]) {
            //把结束位置调整到中间位置的前一个位置
            return binarySearchIndex(value, arr, indexStart, middle - 1);
        } else {
            //把开始位置调整到中间位置的下一个位置
            return binarySearchIndex(value, arr, middle + 1, indexEnd);
        }

    }
}
