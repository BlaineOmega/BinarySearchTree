package bst;

public class BinarySearchTree {
	
	
	public Node rootNode = null; 
	public int treeSize; 
	public int[] numbers = new int[] {5,3,2,6,8,9,7,6,4,1,10}; 
	
	//constructor 
	public BinarySearchTree(){
		for(int number : numbers){
			Node newNode = new Node(number); 
			insertNode(newNode, rootNode); 
		}
	}
	
	//get root node
	public Node getRoot(){
		return this.rootNode; 
	}
	
	//insert Node
	private void insertNode(Node newNode, Node rootNode){
		if(rootNode == null){
			this.rootNode = newNode;
			this.treeSize++; 
			System.out.println("RootNode: "+newNode.value); 
		}else{
			if(newNode.value > rootNode.value){
				if(rootNode.rightNode != null){
					insertNode(newNode, rootNode.rightNode); 
				}else{
					newNode.parentNode = rootNode; 
					rootNode.rightNode = newNode;
					this.treeSize++; 
					System.out.println("Right Node: "+ newNode.value); 
					System.out.println("parentNode Node: "+ newNode.parentNode.value);
				}
			}else if(newNode.value < rootNode.value){
				if(rootNode.leftNode != null){
					insertNode(newNode, rootNode.leftNode);
				}else{
					newNode.parentNode = rootNode; 
					rootNode.leftNode = newNode; 
					this.treeSize++; 
					System.out.println("Left Node: "+ newNode.value);
					System.out.println("parentNode Node: "+ newNode.parentNode.value);
				}
			}
		}
		
	}
	
	//find Node
	public Node findNode(Node currentNode, int seekValue){
		Node sNode=null; 
		if(currentNode != null){
			if(seekValue > currentNode.value){
				findNode(currentNode.rightNode, seekValue);
			}else if(seekValue < currentNode.value){
				findNode(currentNode.leftNode, seekValue); 
			}else if(seekValue == currentNode.value){
				sNode = currentNode; 
				System.out.println("Node " + seekValue + " found!"); 
			
			}
		}else{	
			System.out.println("Node " + seekValue + " not found."); 
			sNode = null;
		}
		return sNode; 
	}
	
	//delete Node
	public void deleteNode(Node currentNode, int deleteValue){
		if(currentNode != null){
			if(deleteValue > currentNode.value){
				deleteNode(currentNode.rightNode, deleteValue);
			}else if(deleteValue < currentNode.value){
				deleteNode(currentNode.leftNode, deleteValue); 
			}else{
				if(!Node.hasLeafs(currentNode)){
					System.out.println("Deleting node: " + deleteValue); 
					if(deleteValue > currentNode.parentNode.value){
						currentNode.parentNode.rightNode = currentNode.rightNode; 
						this.treeSize--; 
					}else if(deleteValue < currentNode.parentNode.value){
						currentNode.parentNode.leftNode = currentNode.leftNode; 
						this.treeSize--; 
					}
				}else{
					if(Node.hasLeafs(currentNode)){
						int repValue = this.getMinValue(currentNode.leftNode); 
						currentNode.value = repValue;
						if(repValue < deleteValue){
							deleteNode(currentNode.leftNode, repValue); 
						}else if(repValue > deleteValue){
							deleteNode(currentNode.rightNode, repValue); 
						}
					}
				}
			}
		}else{
			System.out.println("Node not found in tree."); 
		}
	}
	
	//print tree values
	public void printTreeNodes(Node rootNode){
		if(rootNode != null){
			System.out.println("Node Value: " + rootNode.value); 
			if(rootNode.rightNode != null){
				printTreeNodes(rootNode.rightNode); 
			}
			if(rootNode.leftNode != null){
				printTreeNodes(rootNode.leftNode); 
			}
		}else{
			System.out.println("Tree is empty."); 
		}
	}
	//get minimum node value
	public int getMinValue(Node rootNode){
		int nValue=0; 
		if(rootNode != null){
			if(rootNode.leftNode != null){
				getMinValue(rootNode.leftNode); 
			}else{
				nValue = rootNode.value; 
				System.out.println("Min Value: " + nValue); 
			}
		}
		 return nValue; 
	}
	
	//get tree size
	public int getTreeSize(){
		System.out.println("Tree has " + this.treeSize + " nodes."); 
		return this.treeSize; 
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int toDel = 10; 
		BinarySearchTree bst = new BinarySearchTree(); 
		Node rootNode = bst.getRoot(); 
		bst.getTreeSize(); 
		bst.deleteNode(rootNode, toDel);
		//bst.findNode(rootNode, toDel); 
		bst.printTreeNodes(rootNode); 
		bst.getTreeSize(); 
	}

}
