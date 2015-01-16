import java.util.ArrayList;

public class StringBagArrayList extends ArrayList implements SimpleCollection{

    ArrayList list;

	public StringBagArrayList() {

        ArrayList list = new ArrayList();
        this.list = list;

	}


    public boolean add ( Object  o ) {

        try {
            if(! (o instanceof String)){
                return false;
            }
            return this.list.add(o);
        }
        catch(Exception e) {
            return false;
        }

    }
    
    public void clear() {

    	this.list = new ArrayList();

    }
    
    public boolean contains ( Object o ) {

    	return this.list.contains(o);

    }
    
    public boolean isEmpty() {

    	return this.list.size() == 0;

    }
    
    public boolean remove ( Object o ) {


    	try {
            return this.list.remove(o);    
    	}

    	catch (Exception e) {
    		return false;
    	}

    }
    
    public int size() {

    	return this.list.size();

    }
    
    public Object[] toArray() {

    	return this.list.toArray();

    }

}