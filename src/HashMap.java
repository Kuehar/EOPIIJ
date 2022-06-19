

class HashMap {
	
	// Implementation of HashMap using Binary Search Tree.
	public class MapNode<K extends Comparable<K>,V>{
		private K key;
		private V value;
		private MapNode<K,V> left;
		private MapNode<K,V> right;
		
		
		public MapNode(K key,V value) {
			this.key = key;
			this.value = value;
		}
		
		public V  put(K key,V value) {
			if(this.key.compareTo(key) == 0) {
				V oldValue = this.value;
				this.value = value;
				return oldValue;
			}else if(this.key.compareTo(key)<0) {
				if(right==null) {
					right = new MapNode(key, value);
					return null;
				}else {
					return right.put(key, value);
				}
			}else {
				if(left==null) {
					left = new MapNode(key, value);
					return null;
				}else {
					return left.put(key, value); 
				}
			}
		}
		
		public V get(K key) {
			if(this.key.compareTo(key)==0) {
				return this.value;
			}else if(this.key.compareTo(key)<0) {
				return right == null?null:right.get(key);
			}else {
				return left == null?null:left.get(key);
			}
			
		}
		
	}
}
