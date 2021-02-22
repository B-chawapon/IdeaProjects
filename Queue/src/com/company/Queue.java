package com.company;

public class Queue {
    private int size;
    private int[] elements;
    private int index=0;

    public Queue() {
        size=8;
        elements=new int[size];

    }

    public void enqueue(int v) {
        index++;
        if (index >= elements.length) {
            int[] newElement = new int[elements.length*2];
            for(int i = 0; i < elements.length; i++) {
                newElement[i] = elements[i];
            }
            elements = new int[elements.length*2];

            for(int i = 0; i < newElement.length; ++i) {
                elements[i] = newElement[i];
            }
        }
        elements[index - 1] = v;
    }



    public void dequeue() {
        index--;

        for(int i = 0; i < elements.length - 1; i++) {
            elements[i] = elements[i + 1];
        }

        int[] newElement = new int[elements.length];
        for(int i = 0; i < newElement.length; ++i) {
            newElement[i] = elements[i];
        }

       elements = new int[elements.length - 1];
        for(int i = 0; i < newElement.length - 1; ++i) {
            elements[i] = newElement[i];
        }

    }
    public int getSize() {

        return index;
    }
    public int[] getElements() {
        return elements;
    }

    public boolean empty() {
        if(index<1)
        {
            return true;
        }
        else
            {
            return false;
        }



    }
}
