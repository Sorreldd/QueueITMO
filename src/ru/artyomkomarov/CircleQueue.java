package ru.artyomkomarov;

//Зацикленная очередь
public class CircleQueue implements QueueInterface {
	private int end = 0, head = 0, mod = 1000000;
	private Object[] elems = new Object[1000000];

	public void add(Object element) {
		assert element != null;
		elems[end] = element;
		end = (end + 1) % mod;
	}

	public Object first() {
		assert end != head; 
		if(end != head)
			return elems[head];
		return "Очередь пуста";
	}

	public Object poll() {
		assert end != head; 
		Object value = first();
		if(head != end) {
			elems[head] = 0;
			head = (head + 1) % mod;
		}
		return value;
	}
	
	public boolean contains() {
		return end == head;
	}
	
}
