
public class LinkedList {

	private Node head;
	private Node tail;
	
	public void add(String item) {
		
		Node newItem = new Node(item);
		
		// handles the case where the new item 
		// is the only thing in the list
		if (head == null) {
			head = newItem;
			tail = newItem;
			return;
		}
		
		tail.next = newItem;
		tail = newItem;
	}
	
	
	public void print() {
		Node current = head;
		while (current != null) {
			System.out.println(current.item);
			current = current.next;
		}
	}
	
	public String getFirst(){
		if(head == null){
			return null;
		}
		return head.item;
	}
	
	public String getLast(){
		if(tail == null){
			return null;
		}
		return tail.item;
	}

	public String getPenultimate() {
		if(head == tail || head ==null){
			return null;
		}
		Node follow = head;
		while(head != tail){
			follow = head;
			head = head.next;
		}
		return follow.item;
	}

	
	class Node {
		String item;
		Node next;
		
		public Node(String item) {
			this.item = item;
			this.next = null;
		}
	}
}
