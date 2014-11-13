public class CustomizedStack{

	private Node top;

	/** Node class for storing elements. */
	private static class Node{

		private int integer;
		private Node next;

        public Node(){
            next = null;
        }

	}

	//public cosntructor
	public CustomizedStack(){
		top = null;
	}

	/** Checks if stack is empty */
	public boolean isEmpty(){
		return top == null;
	}

	/** Pushes string onto the stack. */
	public void push(int i){
		Node oldTop = top;
		top = new Node();
		top.integer = i;
		top.next = oldTop;
	}

	/** Removes node from the stack and returns it's string. */
	public int pop(){
		int i = top.integer;
		top = top.next;
		return i;
	}

}