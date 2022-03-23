package model;

//Basado en el codigo del video: https://www.youtube.com/watch?v=R0mTivTmFr8&list=WL&index=33

public class Stack<T> {

    private int size;
    private int current;
    private T stack[];

    public Stack(int m){
        size = m;
        current = 0;
        stack = (T[]) new Object[size];
    }

    private void push(T e){
        if(current<size){
            stack[current++] = e;
        }
    }

    private T pop(){
        if(!empty()){
            return stack[--current];
        }else{
            return null;
        }
    }

    private boolean empty(){
        return current==0;
    }

    private T peek(){
        if(empty()){
            return null;
        }else{
            int aux = current;
            return stack[--aux];
        }
    }

}
