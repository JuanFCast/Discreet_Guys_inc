package model.Interface;

public interface IQueue<T> {
	
	public boolean add(T element);
	
	public T poll();
	
	public T peek();
	
}
