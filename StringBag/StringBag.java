import java.util.ArrayList;

public class StringBag implements SimpleCollection{

    //private instances
    private ArrayList list;

	/** Initializes an empty StringBag. */
	public StringBag(){

        list = new ArrayList();

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
            String s = o.toString();
            list.add(s);
            return true;
    	   }
    	
    	   catch (Exception e){
    		  return false;
    	   }

        }

    }
    
    /** Removes all of the elements from this collection (optional operation). */
    public void clear(){

    	list = new ArrayList();

    }
    
    /** Returns true if this collection contains the specified element. */
    public boolean contains ( Object o ){

    	boolean doesContain = false;

    	for(int i = 0; i < list.size(); i++){

            if(list.get(i).equals(o)){
                doesContain = true;
            }

        }

    	return doesContain;

    }
    
    /** Returns true if this collection contains no elements. */
    public boolean isEmpty(){

    	return list.size() == 0;

    }
    
    /** Removes a single instance of the specified element from this collection, if it is present. */
    public boolean remove ( Object o ){

    	try{

            if(contains(o)){

    		    for(int i = 0; i < list.size(); i++){

                    if(list.get(i).equals(o)){
                        list.remove(i);
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

    	return list.size();

    }
    
    /** Returns an array containing all of the elements in this collection. */
    public Object[] toArray(){

    	Object[] o = new Object[list.size()];

        o = list.toArray();

    	return o;

    }

}