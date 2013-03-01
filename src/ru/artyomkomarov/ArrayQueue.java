package ru.artyomkomarov;
//Очередь на массиве, при переполнении массив расширяется
public class ArrayQueue implements QueueInterface {
	private int end = 0, head = 0, size = 5;
	private Object[] elems = new Object[5];

	public void add(Object element) {
		assert element != null;
		if(end == size) {
			size *= 2;
			Object[] newElems = new Object[size];
			for(int i = 0; i < end; i++) {
				newElems[i] = elems[i];
			}
			elems = newElems;
		}
		elems[end++] = element;
	}

	public Object first() {
		assert end != head; 
		if(end != head)
			return elems[head];
		return "Очередь пуста";
	}

	public Object poll() {
		assert end != head; // assert не работает сразу в java 7, нужно использовать ключ -ea 
		Object value = first();
		if(head != end) elems[head++] = 0;
		return value;
	}

	public boolean contains() {
		return end == head;
	}
	
}
