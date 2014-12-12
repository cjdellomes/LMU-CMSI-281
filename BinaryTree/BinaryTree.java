public class BinaryTree implements java.util.Collection{

	//private instances
	private Object rootData;
	private BinaryTree leftSubTree;
	private BinaryTree rightSubTree;
	private BinaryTree father;
	private BinaryIterator iterator;
	private int size;
	
	//public constructor
	public BinaryTree(){
		this.rootData = null;
		this.leftSubTree = null;
		this.rightSubTree = null;
		this.father = null;
		this.size = 0;
		this.iterator = new BinaryIterator(this);
	}

	/** Adds a new subtree to the binary tree. New subtree appears first in inorder traversal. */
	public boolean add(Object o){
		BinaryTree bt = createFromData(this.getRootData(), this.leftSubTree, this.rightSubTree);
        setSubTrees(bt, null);
        setRootData(o);
        setSize(size + 1);
        this.iterator = new BinaryIterator(this);
        return true;
	}

	/** Returns true each object in the collection was added to the collection. */
	public boolean addAll(java.util.Collection collection){
		for(Object o: collection){
			if(!add(o)){
				return false;
			}
		}
		return true;
	}

	/** Removes all elements from the binary tree. */
	public void clear(){
		setSubTrees(null,null);
		setRootData(null);
		setFather(null);
		setSize(0);
	}

	/** Returns true if the binary tree contains the object. */
	public boolean contains(Object o){
		this.iterator.setNodeNumber(0);
        while (this.iterator.hasNext()){
            if (this.iterator.next().equals(o)){
            	return true;
            }
        }
        return false;
	}

	/** Returns true if every element of the collection is in the binary tree. */
	public boolean containsAll(java.util.Collection collection){
		for(Object o: collection){
			if(!contains(o)){
				return false;
			}
		}
		return true;
	}

	/** Creates a new tree from its three arguments in the obvious way. */
	public static BinaryTree createFromData(Object rootData, BinaryTree leftSubTree, BinaryTree rightSubTree){
		BinaryTree tree = new BinaryTree();
		tree.setRootData(rootData);
		tree.setSubTrees(leftSubTree,rightSubTree);
		tree.setFather(null);
		tree.setSize(1);
		if(leftSubTree != null){
			tree.setSize(tree.size() + leftSubTree.size());
		}
		if(rightSubTree != null){
			tree.setSize(tree.size() + leftSubTree.size());
		}
		tree.iterator = new BinaryIterator(tree);
		return tree;
	}

	/** Returns the tree with root data equal to the object o. */
	public BinaryTree find(Object o){
		this.iterator.setNodeNumber(0);
        while(this.iterator.hasNext()){
            if(this.iterator.current().equals(o)){
            	return this.iterator.next();
            }
        }
        return null;
	}

	/** Returns this tree's father. */
	public BinaryTree getFather(){
		return this.father;
	}

	/** Returns this tree's left sub tree. */
	public BinaryTree getLeftSubTree(){
		return this.leftSubTree;
	}

	/** Returns this tree's right sub tree. */
	public BinaryTree getRightSubTree(){
		return this.rightSubTree;
	}

	/** Returns this tree's root data. */
	public Object getRootData(){
		return this.rootData;
	}

	public String getRootDataStringed(){
		return this.rootData.toString();
	}

	/** Returns this tree's size. */
	public int getSize(){
		return this.size;
	}

	/** Returns true if this tree has a father. */
	public boolean hasFather(){
		return this.father != null;
	}

	/** Returns true if this tree has a left sub tree. */
	public boolean hasLeftSubTree(){
		return this.leftSubTree != null;
	}

	/** Returns true if this tree has no sub trees. */
	public boolean hasNoSubTree(){
		return this.leftSubTree == null && this.rightSubTree == null;
	}

	/** Returns true if this tree has no right sub tre. */
	public boolean hasRightSubTree(){
		return this.rightSubTree != null;
	}

	/** Returns true if this tree has no root data. */
	public boolean hasRootData(){
		return this.rootData != null;
	}

	/** Returns true if this tree is empty. */
	public boolean isEmpty(){
		return this.size == 0;
	}

	/** Returns true if given tree is a left son and false if right son. */
	public boolean isLeftSon(Object o){
		if(this.leftSubTree.getRootData().equals(o)){
			return true;
		}
		else{
			return false;
		}
	}

	/** Returns a preorder iterator over the tree. */
	public BinaryIterator iterator(){
		return new BinaryIterator(this);
	}

	/** Returns true if all the elements in the collection were retained. */
	public boolean retainAll(java.util.Collection collection){
		throw new UnsupportedOperationException();
	}

	/** Returns true if the node with the object was removed. */
	public boolean remove(Object o) {
        iterator.setNodeNumber(0);
        BinaryTree toRemove;
        boolean isLeft;
        if(contains(o)) {
            toRemove = find(o);
            if (toRemove.hasNoSubTree()) {
                isLeft = toRemove.getFather().isLeftSon(toRemove);
                if (isLeft == true) {
                    toRemove.getFather().setSubTrees(null,toRemove.getFather().getRightSubTree());
                    return true;
                }
                else if (isLeft == false) {
                    toRemove.getFather().setSubTrees(toRemove.getFather().getRightSubTree(), null);
                    return true;
                }
            }
            else{
            	isLeft = toRemove.getFather().isLeftSon(toRemove);
            	if(toRemove.hasLeftSubTree() && toRemove.hasRightSubTree()){
            		if(isLeft == true){
            			toRemove.getFather().setSubTrees(toRemove.getLeftSubTree(), toRemove.getFather().getRightSubTree());
            			return true;
            		}
            		else{
            			toRemove.getFather().setSubTrees(toRemove.getFather().getRightSubTree(), toRemove.getRightSubTree());
            			return true;
            		}
            	}
            	else if(toRemove.hasLeftSubTree() && !toRemove.hasRightSubTree()){
            		if(isLeft == true){
            			toRemove.getFather().setSubTrees(toRemove.getLeftSubTree(), toRemove.getFather().getRightSubTree());
            			return true;
            		}
            		else{
            			toRemove.getFather().setSubTrees(toRemove.getFather().getLeftSubTree(), toRemove.getLeftSubTree());
            		}
            	}
            	else if(!toRemove.hasLeftSubTree() && toRemove.hasRightSubTree()){
            		if(isLeft == true){
            			toRemove.getFather().setSubTrees(toRemove.getRightSubTree(), toRemove.getFather().getRightSubTree());
            		}
            		else{
            			toRemove.getFather().setSubTrees(toRemove.getFather().getLeftSubTree(), toRemove.getRightSubTree());
            			return true;
            		}
            	}
            }
        }
        return false;
    }

	/** Returns true if all elements in the collection were removed. */
	public boolean removeAll(java.util.Collection collection){
		for(Object o: collection){
			if(!remove(o)){
				return false;
			}
		}
		return true;
	}

	/** Sets this tree's father to the specified tree. */
	public void setFather(BinaryTree f){
		this.father = f;
	}

	public void setSubTrees(BinaryTree left, BinaryTree right){
		this.leftSubTree = left;
        this.rightSubTree = right;
        setSize(0);
        if (left != null) setSize(left.getSize());
        if (right != null) setSize(right.getSize());
        this.iterator.setNodeNumber(0);
	}

	/** Sets this tree's root data to the specified object. */
	public void setRootData(Object o){
		this.rootData = o;
	}

	/** Sets this tree's size to the specified amount. */
	public void setSize(int s){
		this.size = s;
	}

	/** Returns this tree's size. */
	public int size(){
		return this.size;
	}

	/** Returns an object array containing all the elements of the binary tree. */
	public Object[] toArray(){
		return this.iterator.getOrder();
	}

	/** Returns an object array containing all the elements of the binary tree. */
	public Object[] toArray(Object[] bt){
		return this.iterator.getOrder();
	}

}