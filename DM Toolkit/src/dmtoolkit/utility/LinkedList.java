package dmtoolkit.utility;

public class LinkedList<T, U> {
	private Node<T, U> head;
	private Node<T, U> tail;	
	private int size;
	
	public LinkedList(){
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	public void add(Node<T, U> node) {
		if(this.size == 0) {
			this.head = node;
			this.tail = node;
			this.head.next(this.tail);
		}else {
			node.prev(this.tail);
			this.tail.next(node);
			this.tail = node;
		}
		this.size++;
	}
	
	public Node<T, U> remove() {
		if(this.size == 0)
			return null;
		
		Node<T, U> deleted;
		if(this.size == 1) {
			deleted = this.head;
			this.head = null;
			this.tail = null;
			deleted.next(null);
			deleted.prev(null);			
		}else {
			deleted = this.tail;
			this.tail = tail.prev();
			deleted.next(null);
			deleted.prev(null);
		}
		this.size--;
		return deleted;
	}
	
	public Node<T, U> head(){
		return this.head;
	}
	
	public int size() {
		return this.size;
	}

}
