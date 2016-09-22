
public class Node {
	private int key;
	private Node left, right;
	public Node(int key) {
		super();
		this.setKey(key);
		this.left = null;
		this.right = null;
		
	}
	
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	
}
