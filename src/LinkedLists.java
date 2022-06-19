
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
	
	// Merge two sorted linked lists.
	public static ListNode<Integer> mergeTwoSortedLists(ListNode<Integer> l1,ListNode<Integer> l2){
		ListNode<Integer> dummy = new ListNode();
		ListNode<Integer> current = dummy;
		ListNode<Integer> p1 = l1, p2 = l2;
		
		// p1かp2の要素がなくなるまでループをする
		while(p1 != null && p2 != null) {
			// 小さい要素をcurrentの次に指定する。各ループの終わりにはcurrentを次の要素に移す
			if(p1.data <= p2.data) {
				current.next = p1;
				p1 = p1.next; 
			}else{
				current.next = p2;
				p2 = p2.next; 
			}
			current = current.next;
		}
		// 残った要素にポインタを繋げる
		current.next = p1.next != null ? p1:p2;
		return dummy.next;
	}
}
	
	

