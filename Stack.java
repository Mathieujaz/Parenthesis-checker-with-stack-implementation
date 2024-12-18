public class Stack {

	private int size;
	private char[] container;
	private int top;
	
	public Stack() {                  
		top=-1;
		this.size = 2;
		this.container= new char[size];
		
	}
	public void push(char a) {               //adds a new element at the top and if its full, double the size
		if (isFull()) {
			
			int oldSize = size;
			size *= 2;
			char[] newContainer = new char[size];
			
			for(int i=0;i<oldSize;i++) {
				newContainer[i] = container[i];
			}
			container = newContainer;
			
			System.out.println("Stack is full; its current size is "+oldSize);
			
			System.out.println("Will be expanding the size to "+size);
			
			 
			
		}
		container[++top]=a;
		
	}
	
	public char pop() {
		if(isEmpty()) {
			System.out.println("Cannot perform this operation: the stack is empty");
			return ' ';
		}
		char poppedElement = container[top];
		top--;
		
		
		return poppedElement;
	}
	
	public char top() {
		if(isEmpty()) {
			System.out.println("Cannot perform this operation: the stack is empty");
			return ' ';
		}
		char topElement = container[top];
		
		return topElement;
				
				
	}
	
	public int size() {
		
		return size;
	}
	
	public boolean isEmpty() {
		boolean isEmpty = false;
		if(top==-1) {
			isEmpty = true;
		}
		return isEmpty;
	}
	public boolean isFull() {
		boolean isFull = false;
		if(top==size-1) {
			isFull = true;
		}
		return isFull;
	}
	
	
}