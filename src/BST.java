import java.util.*;
public class BST {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		BinarySearchTree BST = new BinarySearchTree();
		int numberOfNode = 4;
		BST.add(2);
		BST.add(6);
		BST.add(5);
		BST.add(4);
		BST.delete(5);
		BST.print(BST.root);
		BST.delete(6);
		BST.print(BST.root);
		//System.out.println(BST.findDad(5).getKey());
		input.close();
	}
	
}
