
public class binaryTree {
	
	public static class BinaryTreeNode<T>{
		public T data;
		public BinaryTreeNode<T> left,right;
	}
	
	public static void treeTraversal(BinaryTreeNode<Integer> root) {
		if(root != null) {
			System.out.println("Preorder: " + root.data);
			treeTraversal(root.left);
			
			System.out.println("Inorder: " + root.data);
			treeTraversal(root.right);
			
			System.out.println("Postorder: " + root.data);
		}
	}
	
	
	
	public static boolean isSymmetric(BinaryTreeNode<Integer> tree) {
		return tree == null || checkSymmetric(tree.left,tree.right);
	}
	
	private static class BalanceStatusWithHeight{
		public boolean balanced;
		public int height;
		// constructor
		public BalanceStatusWithHeight(boolean balanced,int height) {
			this.balanced = balanced;
			this.height = height;
		}
	}
	
	public static boolean isBalanced(BinaryTreeNode<Integer> tree) {
		return checkBalanced(tree).balanced;
	}
	
	private static BalanceStatusWithHeight checkBalanced(BinaryTreeNode<Integer> tree) {
		// Base case.
		if(tree == null) return new BalanceStatusWithHeight(true, -1);
		
		BalanceStatusWithHeight leftResult = checkBalanced(tree.left);
		if(!leftResult.balanced) return leftResult;
		
		BalanceStatusWithHeight rightResult = checkBalanced(tree.right);
		if(!rightResult.balanced) return rightResult;
		
		boolean isBalanced = Math.abs(leftResult.height - rightResult.height) <= 1;
		int height = Math.max(leftResult.height, rightResult.height)+1;
		return new BalanceStatusWithHeight(isBalanced, height);
	}
	
	private static boolean checkSymmetric(BinaryTreeNode<Integer> subtree0,BinaryTreeNode<Integer> subtree1){
		if(subtree0 == null &&  subtree1 == null) {
			return true;
		}else if(subtree0 != null &&  subtree1 != null) {
			return subtree0.data == subtree1.data
					&& checkSymmetric(subtree0.left, subtree1.right)
					&& checkSymmetric(subtree0.right, subtree1.left);
		}
		return false;
	}
}
