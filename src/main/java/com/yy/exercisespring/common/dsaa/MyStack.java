package com.yy.exercisespring.common.dsaa;

/**
 * @Author: xdz
 * @Descrption: 栈  先进后出
 */
public class MyStack {

    //用数组来存储
    private int[] elements;

    public MyStack(int[] elements) {
        this.elements = new int[0];
    }

    //压入元素
    public void push(int element) {
        int[] newArray = new int[elements.length + 1];
        for (int i = 0; i < elements.length; i++) {
            newArray[i] = elements[i];
        }
        newArray[elements.length] = element;
        elements = newArray;
    }

    //取出栈顶元素
    public int pop() {
        int element = peek();
        int[] newArray = new int[elements.length - 1];
        for (int i = 0; i < elements.length - 1; i++) {
            newArray[i] = elements[i];
        }
        elements = newArray;
        return element;
    }

    //查看栈顶元素peek
    public int peek() {
        return elements[elements.length - 1];
    }

    //判断栈是否为空
    public boolean isEmpty() {
        return elements.length == 0;
    }

}
