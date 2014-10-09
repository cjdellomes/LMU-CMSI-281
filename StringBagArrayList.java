import java.util.ArrayList;

public class StringBagArrayList extends java.util.ArrayList implements SimpleCollection{

	//private instances
	private int capacity;
	private Object[] objArray;

	/** Initializes an empty StringBag. */
	public StringBagArrayList(){

		capacity = 0;
		objArray = new Object[capacity];

	}

	/** Classwide method for removing an element. */
	public static void removeElt(Object[] arr, int remIndex ){

   		for (int i = remIndex; i < arr.length - 1; i++){
    		arr[i] = arr[i + 1] ; 
   		}

	}

	/** Ensures that this collection contains the specified element (optional operation). */
    public boolean add ( Object o ){

        try{

            String check = o.toString();

            if(!check.equals(o)){
                return false;
            }

        }

        catch(Exception e){
            return false;
        }

        if(o == null){
            return false;
        }

        else{

    	   try{

    	   	Object[] placeHolder = objArray;

    	   	capacity++;
    	   	objArray = new Object[capacity];

    	   	for(int i = 0; i < capacity-1; i++){
    	   		objArray[i] = placeHolder[i];
    	   	}

    	   	objArray[capacity-1] = o;

    	   	return true;

    	   }
    	
    	   catch (Exception e){
    		  return false;
    	   }

        }

    }
    
    /** Removes all of the elements from this collection (optional operation). */
    public void clear(){

    	objArray = null;
    	capacity = 0;

    }
    
    /** Returns true if this collection contains the specified element. */
    public boolean contains ( Object o ){

    	boolean doesContain = false;

    	for(int i = 0; i < capacity; i++){

            if(objArray[i].equals(o)){
                doesContain = true;
            }

        }
    	
    	return doesContain;

    }
    
    /** Returns true if this collection contains no elements. */
    public boolean isEmpty(){

    	return capacity == 0;

    }
    
    /** Removes a single instance of the specified element from this collection, if it is present. */
    public boolean remove ( Object o ){


    	try{

            if(contains(o)){

    		    for(int i = 0; i < capacity; i++){

                    if(objArray[i].equals(o)){

                    	removeElt(objArray, i);
                    	Object[] placeHolder = new Object[capacity-1];

                    	for(int j = 0; j < placeHolder.length; j++){
                    		placeHolder[j] = objArray[j];
                    	}

                    	objArray = placeHolder;
                    	capacity--;

                    }

                }

                return true;

            }

            else{
                return false;
            }

    	}

    	catch (Exception e){
    		return false;
    	}

    }
    
    /** Returns the number of elements in this collection. */
    public int size(){

    	return capacity;

    }
    
    /** Returns an array containing all of the elements in this collection. */
    public Object[] toArray(){

    	return objArray;

    }

}