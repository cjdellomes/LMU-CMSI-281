public class CircularList{

	private int size;
	private Node start;
	private Node current;
	private Node end;

	public CircularList(){
		size = 0;
		start = null;
		current = null;
		end = null;
	}

	/** Returns the starting node. */
	public Node getStart(){
		return start;
	}

	/** Returns the current size of the list. */
	public int size(){
		return size;
	}

	/** Adds a node with the appropriate integer. */
	public void add(int n){

		Node temp = new Node();
		temp.integer = n;
		temp.next = null;

		if(size == 0){
    		start = temp;
    		current = start;
    	}
    	else{
    		current.next = temp;
    	}

    	temp.next = start;
    	end = temp;
    	current = current.next;
    	size++;
	}

	/** Removes the node with the indicated integer from the list. */
	public void remove(int n){

		Node last = start;
		Node now = start.next;

		while(now.integer != n){
			last = now;
			now = now.next;
		}

		if(size == 1){
			start = null;
		}
		else if(now.equals(start)){
			last.next = now.next;
			start = now.next;
		}
		else{
			last.next = now.next;
		}
		size--;
	}
	
}