package com.yy.exercisespring.common.dsaa;

import java.util.Arrays;

/**
 * @Author: xdz
 * @Descrption: 面向对象的数组
 * @Date: 2021/2/11 17:44
 */
public class MyArray {

    private int[] elements;

    /**
     * 构造方法
     */
    public MyArray() {
        elements = new int[0];
    }

    /**
     * 获取数组长度
     */
    public int size() {
        return elements.length;
    }

    /**
     * 往数组末尾添加一个元素
     *
     * @param element
     */
    public void addSuffix(int element) {
        int[] newArray = new int[elements.length + 1];
        for (int i = 0; i < elements.length; i++) {
            newArray[i] = elements[i];
        }
        newArray[elements.length] = element;
        elements = newArray;
    }

    /**
     * 打印所有元素到控制台
     */
    public void print() {
        System.out.println(Arrays.toString(elements));
    }

    /**
     * 删除数组中的元素
     *
     * @param index
     * @throws Exception
     */
    public void delete(int index) throws Exception {
        if (index >= elements.length) {
            throw new Exception("数组下标越界");
        }
        int[] newArray = new int[elements.length - 1];
        for (int i = 0; i < elements.length; i++) {
            if (i < index) {
                newArray[i] = elements[i];
            } else if (i > index) {
                newArray[i - 1] = elements[i];
            }
        }
        elements = newArray;
    }

    /**
     * 获取元素
     *
     * @param index
     * @return
     * @throws Exception
     */
    public int getElement(int index) throws Exception {
        if (index >= elements.length) {
            throw new Exception("数组下标越界");
        }
        return elements[index];
    }

    /**
     * 插入一个元素到指定位置
     *
     * @param index
     * @param element
     * @throws Exception
     */
    public void add(int index, int element) throws Exception {
        if (index >= elements.length) {
            throw new Exception("数组下标越界");
        }

        int[] newArray = new int[elements.length + 1];
        for (int i = 0; i < elements.length + 1; i++) {
            if (i < index) {
                newArray[i] = elements[i];
            } else if (i == index) {
                newArray[i] = element;
            } else {
                newArray[i] = elements[i - 1];
            }
        }
        elements = newArray;
    }

    //替换指定位置的元素

    public void replace(int index, int element) throws Exception {
        if (index >= elements.length) {
            throw new Exception("数组下标越界");
        }

        elements[index] = element;
    }

    /**
     * 查找  线性查找
     *
     * @param element
     * @return
     */
    public int searchIndex(int element) {
        for (int i = 0; i < elements.length; i++) {
            if (element == elements[i]) {
                return i;
            }
        }
        return -1;
    }


    /**
     * 二分查找  要求数组必须是有序的
     *
     * @param element
     * @param indexStart
     * @param indexEnd
     * @return
     */
    public int binarySearchIndex(int element, int indexStart, int indexEnd) {
        //当开始下标与结束下标重合,说明没有查找到
        if (indexStart >= indexEnd) {
            return -1;
        }

        int middle = (indexStart + indexEnd) / 2;

        if (element == elements[middle]) {
            return middle;
        } else if (element < elements[middle]) {
            //把结束位置调整到中间位置的前一个位置
            return binarySearchIndex(element, indexStart, middle - 1);
        } else {
            //把开始位置调整到中间位置的下一个位置
            return binarySearchIndex(element, middle + 1, indexEnd);
        }

    }
}
