public class ExpressionEvaluator{

	private static CustomizedStack cs;

	public static void main(String[]args){
		ExpressionEvaluator ee = new ExpressionEvaluator(args);
	}

	public ExpressionEvaluator(String[] args){
		cs = new CustomizedStack();
		for(int i = 0; i < args.length; i++){
			process(args[i]);
		}
		System.out.println(cs.pop());
	}

	public static void process(String s) throws UnsupportedOperationException{
		try{
			int integer = Integer.parseInt(s);
			cs.push(integer);
		}
		catch(Exception e){
			if(s.equals("+")){
				add();
			}
			else if(s.equals("-")){
				subtract();
			}
			else if(s.equals("x")){
				multiply();
			}
			else if(s.equals("/")){
				divide();
			}
			else if(s.equals("%")){
				remainder();
			}
			else{
				UnsupportedOperationException error = new UnsupportedOperationException("\nOnly integers and operations allowed\n");
				throw error;
			}
		}
	}

	/** Adds top two values in stack and pushes result. */
	public static void add(){
		int x = cs.pop();
		int y = cs.pop();
		int z = y + x;
		cs.push(z);
	}

	/** Subtracts top two values in stack and pushes result. */
	public static void subtract(){
		int x = cs.pop();
		int y = cs.pop();
		int z = y - x;
		cs.push(z);
	}

	/** Multiplies top two values in stack and pushes result. */
	public static void multiply(){
		int x = cs.pop();
		int y = cs.pop();
		int z = y * x;
		cs.push(z);
	}

	/** Divides top two values in stack and pushes result. */
	public static void divide(){
		int x = cs.pop();
		int y = cs.pop();
		int z = y / x;
		cs.push(z);
	}

	/** Mod divides top two values in stack and pushes result. */
	public static void remainder(){
		int x = cs.pop();
		int y = cs.pop();
		int z = y % x;
		cs.push(z);
	}

}