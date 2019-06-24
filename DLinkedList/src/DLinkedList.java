import java.util.NoSuchElementException;

public class DLinkedList<T> {
	protected Node<T> head;
	protected Node<T> tail;
	protected long size;
	
	
	public DLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}
	
	
	/**
	* Adiciona um elemento no head da lista
	**/
	public void addFirst(T value) {
		Node<T> first = new Node<T>();
		first.setValue(value);
		first.setNext(head);
		if(head == null) {
			tail = first;
		}
		head = first;
		size++;
	}
	
	/**
	* Adiciona um elemento no tail da lista
	**/
	public void addLast(T value) {
		if(head == null) {
			addFirst(value);
		}else {
			Node<T> last = new Node<T>();
			last.setValue(value);
			tail.setNext(last);
			last.setPrevious(tail);
			tail = last;
			size++;
		}
	}
	
	/**
	 * Remove todos os elementos da lista.
	 **/
	public void clear() {
		head = null;
		tail = null;
		size = 0;
	}
	
	/**
	* Verifica se a lista contém o valor
	**/
	public boolean contains(T value) {
		Node<T> temp = head;
		while(temp != null) {
		if(temp.getValue().equals(value)) {
			return true;
		}
			temp = temp.getNext();
		}
		return false;
	}
	
	/**
	* Retorna o primeiro elemento da lista
	**/
	public T getFirst() {
		if(isEmpty()) throw new NoSuchElementException("List is empty");
		return head.getValue();
	}
	
	/**
	* Retorna o último elemento da lista.
	**/
	public T getLast() {
		if(isEmpty()) throw new NoSuchElementException("List is empty");
		return tail.getValue();
	}
	
	/**
	 * Verifica se a lista está vazia.
	 **/
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	* Remove e retorna o primeiro elemento da lista
	**/
	public T removeFirst() {
		if(isEmpty()) throw new NoSuchElementException("List is empty");
		T value = head.getValue();
		head = head.getNext();
		size--;
		return value;
	}
	
	/**
	* Remove e retorna o último elemento da lista
	**/
	public T removeLast() {
		if(isEmpty()) throw new NoSuchElementException("List is empty");
		T value = tail.getValue();
		Node<T> temp = null;
		
		if (tail.getPrevious() != null) {
			temp = tail.getPrevious();
		}

		temp.setNext(null);
		tail.setPrevious(null);
		tail = temp;
		tail.setNext(null);
		size--;
		return value;
	}
	
	/**
	 * Verifica o tamanho da lista.
	 **/
	public long size() {
		return size;
	}
	
	/**
	* Retorna uma lista de objetos com todos os elementos da lista
	**/
	public Object[] toArray() {
		Object[] array = new Object[(int) size];
		Node<T> temp = head;
		for(int i = 0; i < size; i++) {
			array[i] = temp.getValue();
			temp = temp.getNext();
		}
		return array;
	}
	
	/**
	 * Retorna o elemento da posição index
	**/
	public T get(int index) {
		if(index >= size || index < 0) throw new IndexOutOfBoundsException("index "+index);
		Node<T> temp = head;
		for(int i = 0; i < index; i++) {
			temp = temp.getNext();
		}
		return temp.getValue();
	}	
	
	/**
	 * Remove o elemento da posição index e remove da lista
	 **/
	public T remove(int index) {
		if(index >= size  || index < 0) throw new IndexOutOfBoundsException("index "+index);
		Node<T> temp = head;
		Node<T> before = null;
		for(int i = 0; i < index; i++) {
			before = temp;
			temp = temp.getNext();
		}
		if(before == null) {
			head = temp.getNext();
		}else {
			before.setNext(temp.getNext());
			if(temp == tail) {
				tail = before;
			}
		}
		size--;
		return temp.getValue();
	}
	
	/**
	 * Adiciona um novo elemento na posição index
	 **/
	public void add(int index, T value) {
		if(index > size || index < 0) throw new IndexOutOfBoundsException("index "+index);
		Node<T> temp = head;
		Node<T> before = null;
		for(int i = 0; i < index; i++) {
			before = temp;
			temp = temp.getNext();
		}
		Node<T> newNode = new Node<T>();
		newNode.setValue(value);
		newNode.setNext(temp);
		newNode.setPrevious(before);
		if(before == null) {
			head = newNode;
		}else {	
			before.setNext(newNode);
			if(temp == tail) {
				tail = newNode;
			}
		}
		size++;
	}
	
	/**
	 * Atualiza o elemento da posição index
	 **/
	public void set(int index, T value) {
		if(index >= size || index < 0) throw new IndexOutOfBoundsException("index "+index);
		Node<T> temp = head;
		for(int i = 0; i < index; i++) {
			temp = temp.getNext();
		}
		temp.setValue(value);
	}
	
}
