public class ArrayList<T> implements List<T> {
	
	T[] a;
	int size = 0;
	
	public ArrayList() {
		
		a = (T[]) new Object [10];
	}
	
	public int size() {
		
		return size;
	}
	
	//add item behind last element 
	public void add(T item) {
		
		if(size == a.length)
			growArray();
		a[size++] = item;
	}
	
	//add item to the position
	public void add(int pos, T item) throws Exception {
		
		if(size == a.length)
			growArray();
		
		if(pos > size || pos < 0)
			throw new Exception();
		
		for(int i = size; i > pos; i--) {
			
			a[i] = a[i-1];
		}
		
		a[pos] = item;
		size++;
	}
	
	//grow the array if the array is full
	void growArray() {
		
		T[] newArray = (T[]) new Object[a.length * 2];
		//copy from a to newArray
		System.arraycopy(a, 0, newArray, 0, a.length);
		a = newArray;
	}
	
	//get the data from the position
	public T get(int pos) {
		
		if(pos >= size || pos < 0)
			return null;
		return a[pos];
		
	}
	
	//remove data from the position
	public T remove(int pos) {
		
		T temp = a[pos];
		if(pos >= size || pos < 0 || size == 0)
			return null;
		
		for(int i = pos; i < size-1; i++) {
			
			a[i] = a[i+1];
		}
		
		size--;
		return temp;
			
	}

}
