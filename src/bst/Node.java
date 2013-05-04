package bst;


public class Node {
	
	 
	public Node leftNode; 
	public Node rightNode;
	public Node parentNode; 
	public int value; 
	
	public Node(int value){
		this.leftNode = null; 
		this.rightNode = null; 
		this.value = value; 
	}


	public static boolean hasLeafs(Node currentNode){
		if((currentNode.leftNode != null) && (currentNode.rightNode != null)){
			return true; 
		}else{
			return false; 
		}
			
	}
	
}
