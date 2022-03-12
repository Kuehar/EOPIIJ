
public class LinkedLists {
	class ListNode<T>{
		public T data;
		public ListNode<T> next;
	}
	
	// Search
	public static ListNode<Integer> search(ListNode<Integer> L,int key){
		while(L != null && L.data != key) {
			L = L.next;
		}
		return L;
	}
	
	// Insert
	public static void insert(ListNode<Integer> node,ListNode<Integer> newNode) {
		newNode.next = node.next;
		node.next = newNode;
	}
	
	// Delete
	public static void delete(ListNode<Integer> node) {
		node.next = node.next.next;
	}
}
	
	

