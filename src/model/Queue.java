package model;

import Interface.IQueue;

//Basado en el codigo del video: https://www.youtube.com/watch?v=V5hK2T898q8&list=WL&index=33

public class Queue<T> implements IQueue<T>{

	private int last;
	private int size;
	private T queue[];

	@SuppressWarnings("unchecked")
	public Queue(int m){
		size = m;
		last = -1;
		queue = (T[]) new Object[size];
	}

	@Override
	public boolean add(T element) {
		if(last==size-1){
			return false;
		}else{
			last++;
			queue[last] = element;
			return true;
		}
	}

	@Override
	public T poll() {
		if(last==-1){
			return null;
		}else{
			T aux = queue[0];
			for(int i = 0; i < size-1; i++){
				queue[i] = queue[i+1];
			}
			queue[last] = null;
			last--;
			return aux;
		}
	}

	@Override
	public T peek() {
		if(last==-1){
			return null;
		}else{
			return queue[0];
		}
	}

}
