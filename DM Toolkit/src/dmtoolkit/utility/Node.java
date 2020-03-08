package dmtoolkit.utility;

public class Node<T, U> {
	
	private Node<T, U> next;
	private Node<T, U> prev;
	private T element;
	private U object;
	
	public Node()
	{
		this.next = null;
		this.prev = null;
		this.element = null;
		this.object = null;
	}
	
	public Node(T element)
	{
		this.next = null;
		this.prev = null;
		this.element = element;
		this.object = null;
	}
	
	public Node(T element, U object)
	{
		this.next = null;
		this.prev = null;
		this.element = element;
		this.object = object;
	}
	
	public Node(T element, U object, Node<T, U> next, Node<T, U> prev)
	{
		this.next = next;
		this.prev = prev;
		this.element = element;
		this.object = object;
	}
	
	public void next(Node<T, U> next) {this.next = next;}
	public void prev(Node<T, U> prev) {this.prev = prev;}
	public void element(T element) {this.element = element;}
	public Node<T, U> next(){return this.next;}
	public Node<T, U> prev(){return this.prev;}
	public T element(){return this.element;}
	public U object() {return this.object;}
	
}
