package com.company;

public class Queue {

    private int size;
    private int capacity;
    private int[]   elements;
    private int[]   newelements;

    private int index=0;

    public Queue(){
        size=8;
        elements=new int[size];
    }
    public Queue(int size){
        this.size = size;
        elements=new int[size];
    }
    public void enqueue(int v)
    {
        elements[index]=v;
        index++;
        if(index>=elements.length)
        {
            size=size*2;
            newelements= new int[size];
            for(int i=0;i<elements.length;i++)
            {
                newelements[i]=elements[i];
            }
            elements=newelements;
        }
    }
    public int[] dequeue()
    {
       newelements=new int[elements.length];
       int index=0;
       for(int i=1;i<elements.length;i++)
       {
           newelements[index]=elements[i];
           index++;

       }
        elements=newelements;
       index--;
       return   elements;
    }
    public  int[]   getQueue()
    {
        return elements;
    }
    public  boolean empty(){
        for(int i=0;i<elements.length;i++)
        {
            if(elements[i]!=0)
            {
                return  false;
            }
        }
        return  true;
    }

    public int getSize(){
        return size;
    }
}
