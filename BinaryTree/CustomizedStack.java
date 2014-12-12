public class CustomizedStack{

	private Node top;

	/** Node class for storing elements. */
	private static class Node{

		private BinaryTree tree;
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

	/** Pushes BinaryTree onto the stack. */
	public void push(BinaryTree bt){

		Node oldTop = top;
		top = new Node();
		top.tree = bt;
		top.next = oldTop;

	}

	/** Removes BinaryTree from the stack and returns it . */
	public BinaryTree pop(){

		BinaryTree bt = top.tree;
		top = top.next;
		return bt;
		
	}

}