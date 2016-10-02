
public class BinarySearchTree {
	public Node root;
	public BinarySearchTree() {
		this.root = null;
	}
	private static void goTo(Node node, String str) {
		goTo(node.getLeft(), str);
		str+=(char) (node.getKey());
		goTo(node.getRight(), str);
	}
	private static void getMid(int start, int end, String str) {
		if (start == end) {
			str += (char) (start);
			return;
		}
		int mid = (end - start + 1) / 2;
		str+=(char) (mid);
		getMid(start, mid, str);
		getMid(mid + 1, end, str);
	}
	public BinarySearchTree buildAgain() {
		Node node = this.root;
		String str = new String();
		str = "";
		goTo(node, str);
		int n = str.length();
		char a[] = str.toCharArray();
		str = "";
		getMid(1, n, str);
		char b[] = str.toCharArray();
		BinarySearchTree newBST = new BinarySearchTree();
		for (int i = 0; i < n; i++) newBST.add(a[b[i]-1]);
		return new BinarySearchTree();
	}
	private Node find(int key) {
		Node current = this.root;
		while (current != null) {
			if (current.getKey() == key) return current;
			else if (key < current.getKey()) current = current.getLeft();
			else current = current.getRight();
		}
		return null;
	}
	private Node findDad(int key) {
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
	private int searchLeft(Node node) {
		while (node.getRight() != null) {
			node = node.getRight();
		}
		Node dad = findDad(node.getKey());
		if (dad.getKey() > node.getKey()) dad.setLeft(node.getLeft());
		else dad.setRight(node.getLeft());
		return node.getKey();
	}
	private int searchRight(Node node) {
		while (node.getLeft() != null) {
			node = node.getLeft();
		}
		Node dad = findDad(node.getKey());
		if (dad.getKey() > node.getKey()) dad.setLeft(node.getRight());
		else dad.setRight(node.getRight());
		return node.getKey();
	}
	public void delete(int key) {
		Node top = find(key);
		Node current = top;
		if (top == null) return;	
		
		if (current.getLeft() != null) {
			top.setKey(searchLeft(current.getLeft()));
		}
		else if (current.getRight() != null) {
			top.setKey(searchRight(current.getRight()));
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
