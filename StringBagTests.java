import java.util.Arrays;

public class StringBagTests{
	
	public static void main(String[] args){
		testAdd();
		testClear();
		testContains();
		testIsEmpty();
		testRemove();
		testSize();
		testToArray();
	}

	public static void testAdd(){

		System.out.println("\nTESTING ADD METHOD\n");
		StringBag sb = new StringBag();

		System.out.println(sb.add("Hello"));

		Object o = new Object();
		System.out.println(!sb.add(o));

		System.out.println(!sb.add(null));

		System.out.println(sb.add("There"));

		System.out.println(sb.add("World"));

		StringBag x = new StringBag();
		System.out.println(!sb.add(x));

		System.out.println(sb.add("Hello"));

		System.out.println(!sb.add(15));

		System.out.println(sb.add("Hi"));

	}

	public static void testClear(){

		System.out.println("\nTESTING CLEAR METHOD\n");

		StringBag sb1 = new StringBag();
		sb1.add("Hello");
		sb1.clear();
		System.out.println(sb1.size() == 0);

		sb1.add("Hello");
		sb1.add("There");
		sb1.add("Hello");
		sb1.clear();
		System.out.println(sb1.size() == 0);

		StringBag sb2 = new StringBag();
		sb2.add("Hello");
		sb2.add("World");
		sb2.clear();
		System.out.println(sb2.size() == 0);

		StringBag sb3 = new StringBag();
		sb3.add("Hello");
		sb3.add(5);
		sb3.clear();
		System.out.println(sb3.size() == 0);

	}

	public static void testContains(){

		System.out.println("\nTESTING CONTAINS METHOD\n");

		StringBag sb = new StringBag();
		Object o = new Object();
		int[] intArray = new int[10];
		sb.add("Hello");
		sb.add("There");
		sb.add("World");
		sb.add("Hi");

		System.out.println(sb.contains("Hello"));
		sb.clear();

		sb.add("Hello");
		sb.add("There");
		sb.add("Hi");
		System.out.println(sb.contains("There"));
		sb.clear();

		sb.add("Hello");
		sb.add("There");
		sb.add("World");
		sb.add("Hi");
		System.out.println(sb.contains("World"));
		sb.clear();

		sb.add("Hello");
		sb.add("There");
		sb.add("World");
		sb.add("Hi");
		System.out.println(sb.contains("Hi"));
		sb.clear();

		System.out.println(!sb.contains("People"));

	}

	public static void testIsEmpty(){

		System.out.println("\nTESTING ISEMPTY METHOD\n");

		StringBag sb = new StringBag();
		System.out.println(sb.isEmpty());
		sb.add("Hello");
		System.out.println(!sb.isEmpty());
		sb.clear();
		System.out.println(sb.isEmpty());

	}

	public static void testRemove(){

		System.out.println("\nTESTING REMOVE METHOD\n");

		StringBag sb = new StringBag();

		sb.add("Hello");
		sb.add("Hello");
		sb.add("There");
		sb.add("World");
		sb.add("Hi");

		sb.remove("World");
		System.out.println(!sb.contains("World"));

		sb.remove("There");
		System.out.println(!sb.contains("There"));

		sb.remove("Hi");
		System.out.println(!sb.contains("Hi"));

		sb.remove("Hello");
		System.out.println(sb.contains("Hello"));

		sb.remove("Hello");
		System.out.println(!sb.contains("Hello"));

		System.out.println(sb.isEmpty());

		System.out.println(!sb.remove("Potato"));

	}

	public static void testSize(){

		System.out.println("\nTESTING SIZE METHOD");

		StringBag sb = new StringBag();
		System.out.println(sb.size() == 0);

		sb.add("Hello");
		System.out.println(sb.size() == 1);

		sb.add("There");
		System.out.println(sb.size() == 2);

		sb.clear();
		System.out.println(sb.size() == 0);

		sb.add("Hello");
		sb.add("There");
		sb.add("World");
		System.out.println(sb.size() == 3);

	}

	public static void testToArray(){

		System.out.println("\nTESTING TOARRAY METHOD");

		StringBag bagArray = new StringBag();
		bagArray.add("Hello");
		bagArray.add("There");
		bagArray.add("World");

		Object[] obj = new Object[3];
		obj[0] = "Hello";
		obj[1] = "There";
		obj[2] = "World";

		Object[] objArray = bagArray.toArray();

		System.out.println(Arrays.equals(obj,objArray));
	}

}