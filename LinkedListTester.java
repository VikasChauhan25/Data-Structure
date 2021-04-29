class Node {
	private String data;
	private Node next;
	public Node(String data) {
		this.data=data;
	}
	public String getData() {
		return this.data;
	}
	public Node getNext() {
		return this.next;
	}
	public void setData(String data) {
		this.data=data;
	}
	public void setNext(Node next)
	{
		this.next=next;
	}
}
class LinkedList{
	private Node head;
	private Node tail;
	
	public Node getHead() {
		return this.head;
	}
	public Node getTail() {
		return this.tail;
	}
	public void addAtEnd(String data) {
		Node node=new Node(data);
		if(this.head==null)
		{
			this.head=this.tail=node;
		}else {
			this.tail.setNext(node);
			this.tail=node;
		}
	}
    public void addAtBeginning(String data){
        Node node=new Node(data);
        if(this.head==null)
        {
            this.head=this.tail=node;
        }else{
            node.setNext(this.head);
            this.head=node;
        }
    }
    public Node find(String data){
        Node temp=this.head;
        while(temp!=null){
            if(temp.getData().equals(data)){
                return temp;
            }
            temp=temp.getNext();
        }
        return null;
    }
    public void insert(String data,String begingData){
        Node node=new Node(data);
        if(this.head==null){
            this.head=this.tail=node;
        }else{
            Node nodeBefore=this.find(begingData);
            if(nodeBefore!=null){
                node.setNext(nodeBefore.getNext());
                nodeBefore.setNext(node);
                if(nodeBefore==this.tail)
                {
                    this.tail=node;
                }

            }else{
				System.out.println("Node is not found");
				}

        }
    }
	public void delete(String data){
		if(this.head==null)
		{
			System.out.println("List is empty");
		}
		else{
			Node node=this.find(data);
			if(node==null)
			{
				System.out.println("Node is not found");
			}else if(node==this.head){
					this.head=this.head.getNext();
					node.setNext(null);
					if(node==this.tail){
						this.tail=null;
					}
				}else{
					Node BeforeNode=null;
					Node temp=this.head;
					while(temp!=null){
						if(temp.getNext()==node){
							BeforeNode=temp;
							break;
						}
						temp=temp.getNext();
					}
					BeforeNode.setNext(node.getNext());
					//node.setNext(null);
					if(node==this.tail){
						this.tail=BeforeNode;
						node.setNext(null);
					}
				}
		}
	}
	public void display() {
		Node temp=this.head;
		while(temp!=null) {
			System.out.println(temp.getData());
			temp=temp.getNext();
		}
	}
	
}
class LinkedListTester {
	public static void main(String args[]) {
		LinkedList list=new LinkedList();
		list.addAtEnd("Vikas");
        list.addAtEnd("Vivek");
        list.addAtEnd("Anivesh");
        //list.addAtBeginning("United");
		list.display();
		list.delete("Anivesh");
        System.out.println("------------------------");
        list.addAtBeginning("United");
    	list.insert("Akash", "Vivek");
        list.display();
        //System.out.println(list.find("Vikas"));
	}

}
