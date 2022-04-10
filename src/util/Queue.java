package util;

import util.Interface.IQueue;

//Basado en el codigo del video: https://www.youtube.com/watch?v=V5hK2T898q8&list=WL&index=33
@SuppressWarnings("unchecked")
public class Queue<T> implements IQueue<T>{

	private int last;
	private int size;
	private T queue[];

	public Queue(int m){
		size = m;
		last = 0;
		queue = (T[]) new Object[size];
	}

	@Override
	public boolean add(T element) {
		if(last == size+1){
			return false;
		}else{
			queue[last] = element;
			last++;

			return true;
		}
	}

	@Override
	public T poll() {
		if(last == 0){
			return null;
		}else{
			T aux = queue[0];
			for(int i = 0; i < size-1; i++){
				queue[i] = queue[i+1];
			}
			last--;
			queue[last] = null;
			return aux;
		}
	}

	@Override
	public T peek() {
		if(last == 0){
			return null;
		}else{
			return queue[0];
		}
	}

	public int size(){
		return last;
	}

	public boolean isEmpty(){
		return (queue[0] == null)?true:false;
	}

	public String toString(){
		String s = "[";

		for(int i = 0; i < last; i++){
			s += queue[i] + "|";
		}

		return s + "]";
	}

}
