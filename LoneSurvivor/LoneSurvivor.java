public class LoneSurvivor{

	private static CircularList list;
	private static Node gun;
	private static Node previous;
	private static int n;
	private static int k;
	
	/** Prints last integer if every kth integer of a set of n integers was deleted. */
	public static void main(String[] args){
		LoneSurvivor ls = new LoneSurvivor(args);
	}

	public LoneSurvivor(String[] args) throws UnsupportedOperationException{
		list = new CircularList();
		n = Integer.parseInt(args[0]);
		k = Integer.parseInt(args[1]);
		try{
			if(n < 0 || k < 1){
				Exception e = new Exception();
				throw e;
			}
		}
		catch(Exception e){
			UnsupportedOperationException error = new UnsupportedOperationException("\nONLY 2 POSITIVE INTEGERS ALLOWED\n");
			throw error;
		}
		process(n,k);
	}

	/** Passes "gun" from one node to the next. */
	private static void pass(){
		for(int i = 0; i < k; i++){
			previous = gun;
			gun = gun.next;
		}
	}

	/** Goes through list and removes kth node. */
	private static void bang(){
		previous = null;
		gun = list.getStart();
		while(list.size() > 1){
			pass();
			list.remove(gun.integer);
			previous = previous.next;
			gun = gun.next;
			n--;
		}
	}

	/** Fills list, calculates remaining integer, and prints it. */
	public static void process(int n, int k) {
		for(int i = 0; i < n; i++){
			list.add(i);
		}
		bang();
		System.out.println(list.getStart().integer);
	}

}