public class BinaryIterator implements java.util.Iterator{
	
	//private instances
	private BinaryTree tree;
	private BinaryTree[] order;
	private int nodeNumber = 0;

	//public constructor
	public BinaryIterator(BinaryTree tree){

		this.tree = tree;
		this.order = new BinaryTree[tree.size()];
		preOrderIterate();

	}

	public BinaryTree[] getOrder(){
		return this.order;
	}

	public int getNodeNumber(){
		return this.nodeNumber;
	}

	public boolean hasNext(){
		return nodeNumber + 1 <= this.order.length;
	}

	public BinaryTree current(){
		return this.order[nodeNumber];
	}

	public BinaryTree next(){

		int temp = nodeNumber;
		this.nodeNumber++;
		return this.order[temp];

	}

	private void preOrderIterate(){

		CustomizedStack treeStack = new CustomizedStack();

		for(int i = 0; i < this.order.length; i++){
			if(this.tree.hasRootData() && this.tree.hasLeftSubTree() && this.tree.hasRightSubTree()){
				this.order[i] = this.tree;
				treeStack.push(this.tree);
				this.tree = this.tree.getLeftSubTree();
				i++;
			}

			else if(this.tree.hasRootData() && this.tree.hasLeftSubTree() && !this.tree.hasRightSubTree()){
				this.order[i] = this.tree;
				this.tree = this.tree.getLeftSubTree();
				i++;
			}

			else if(this.tree.hasRootData() && !this.tree.hasLeftSubTree() && this.tree.hasRightSubTree()){
				this.order[i] = this.tree;
				this.tree = this.tree.getRightSubTree();
				i++;
			}

			else if(this.tree.hasRootData() && !this.tree.hasLeftSubTree() && !this.tree.hasRightSubTree() && !treeStack.isEmpty()){
				this.order[i] = this.tree;
				this.tree = treeStack.pop().getRightSubTree();
				i++;
			}
			
			else if(this.tree.hasRootData() && !this.tree.hasLeftSubTree() && !this.tree.hasRightSubTree() && treeStack.isEmpty()){
				this.order[i] = this.tree;
				i++;
			}
		}

	}

	public void remove(){
		this.tree.remove(this.order[this.getNodeNumber() - 1].getRootData());
	}

	public void setNodeNumber(int i){
		this.nodeNumber = i;
	}

}