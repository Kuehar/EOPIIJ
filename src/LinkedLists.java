
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
	
	

}
