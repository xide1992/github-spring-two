package com.yy.exercisespring.common.dsaa;

/**
 * @Author: xdz
 * @Descrption: 队列 先进先出
 */
public class MyQueue {

    //用数组来存储
    private int[] elements;

    public MyQueue(int[] elements) {
        this.elements = new int[0];
    }

    //入队
    public void add(int element) {
        int[] newArray = new int[elements.length + 1];
        for (int i = 0; i < elements.length; i++) {
            newArray[i] = elements[i];
        }
        newArray[elements.length] = element;
        elements = newArray;
    }

    //出队列
    public int poll() {
        int element = elements[0];
        int[] newArray = new int[elements.length - 1];
        for (int i = 0; i < elements.length - 1; i++) {
            newArray[i] = elements[i + 1];
        }
        elements = newArray;
        return element;
    }


    //判断栈是否为空
    public boolean isEmpty() {
        return elements.length == 0;
    }
}
