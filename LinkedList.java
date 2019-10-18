public class LinkedList<T> implements List<T>  {

	
	int size = 0;
	Node head;
	
	public LinkedList() {
	
		head = null;
	}
	
	public class Node{
		
		T data;
		Node next;
		
		public Node(T item) {
			data = item;
		}
	}
	
	public int size() {
		
		return size;
	}
	
	//add item behind the last node
	public void add(T item) {
		
		if(head == null) {
			
			head = new Node(item);
			size++;
		}
		else {
			
			Node node = new Node(item);
			Node prev = head;
			while(prev.next != null) 				
				prev = prev.next;
						
			prev.next = node;
			size++;
		}
			

	}
	
	//add data to the position node
	public void add(int pos, T item) throws Exception {
		
		if(pos < 0 || pos > size)
			throw new Exception();
		
		if(pos == 0) {
			Node node = new Node(item);
			node.next = head;
			head = node;
			size++;
		}else{
			Node node = new Node(item);
			Node prev = head;
			for(int i = 0; i < pos-1; i++) 
				prev = prev.next;
		
			node.next = prev.next;
			prev.next = node;
			size++;	
		}	
	}
	
	//get data from the position node
	public T get(int pos) {
		
		if(pos < 0 || pos+1 > size)
			return null;
		
		Node node = head;
		for(int i = 0; i < pos; i++)
			node = node.next;
		
		return node.data;
		
		
		
	}
	
	//remove the data from the position node
	public T remove(int pos) {
		
		if(pos < 0 || pos+1 > size)
			return null;
		
		if(pos == 0) {
			Node node = head;
			head = head.next;
			size--;
			return node.data;
		}
		
		Node prev = head;
		for(int i = 0; i < pos-1; i++) 
			prev = prev.next;
		
		Node node = prev.next;
		prev.next = node.next;
		size--;
		return node.data;
			
	}

}

