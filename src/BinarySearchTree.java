
public class BinarySearchTree {
	public Node root;
	public BinarySearchTree() {
		this.root = null;
	}
	public Node find(int key) {
		Node current = this.root;
		while (current != null) {
			if (current.getKey() == key) return current;
			else if (key < current.getKey()) current = current.getLeft();
			else current = current.getRight();
		}
		return null;
	}
	public Node findDad(int key) {
		Node current = this.root;
		Node dad = null;
		while (current != null) {
			if (current.getKey() == key) return dad;
			else if (key < current.getKey()) {
				dad = current;
				current = current.getLeft();
			}
			else {
				dad = current;
				current = current.getRight();
			}
		}
		return null;
	}
	public void add(int key) {
		if (this.root == null) {
			this.root = new Node(key);
			return;
		}
		Node current = this.root;
		while (true) {
			if (current.getKey() >= key) {
				if (current.getLeft() == null) {
					current.setLeft(new Node(key));
					return;
				}
				else current = current.getLeft();
			}
			else {
				if (current.getRight() == null) {
					current.setRight(new Node(key));
					return;
				}
				else current = current.getRight();
			}
		}
	}
	public void delete(int key) {
		Node top = find(key);
		Node current = top;
		if (top == null) return;	
		
		if (current.getLeft() != null) {
			current = current.getLeft();
			while (current.getRight() != null) {
				current = current.getRight();
			}
			Node dad = findDad(current.getKey());
			if (dad.getKey() > current.getKey()) dad.setLeft(current.getLeft());
			else dad.setRight(current.getLeft());
			top.setKey(current.getKey());
		}
		else if (current.getRight() != null) {
			current = current.getRight();
			while (current.getLeft() != null) {
				current = current.getLeft();
			}
			Node dad = findDad(current.getKey());
			if (dad.getKey() > current.getKey()) dad.setLeft(current.getRight());
			else dad.setRight(current.getRight());
			top.setKey(current.getKey());
		}
		else {
			if (key == root.getKey()) {
				this.root = null;
				return;
			}
			Node dad = findDad(key);
			if (dad.getKey() > key) dad.setLeft(null);
			else dad.setRight(null);
		}
	}
	public void print(Node node) {
		if (node != null) {
			print(node.getLeft());
			System.out.print(node.getKey() + " ");
			print(node.getRight());
			if (node == this.root) System.out.println();
		}
	}
}
