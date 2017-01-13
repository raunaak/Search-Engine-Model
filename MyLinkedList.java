


public class MyLinkedList<X>
	{
		
		int			size;
		
		MyNode<X>	head;
		
		MyNode<X>	tail;
		
		public MyLinkedList()
			{
				size = 0;
				head = null;
				tail = null;
			}
		public MyLinkedList(X o)
			{  this.addElement(o);
				size = 1;
				
			}
			
		public void addNode(MyNode<X> n)
			{
				
				if (this.head == null)
					{
						this.head = n;
						this.tail = n;
					}
				else
					{
						this.tail.nextNode = n;
						this.tail = n;
					}
				this.size++;
			}
			
		public void addElement(X o)
			{
				
				MyNode<X> node = new MyNode<X>(o);
				this.addNode(node);
				this.size++;
				
			}
			
		public void addLinkedList(MyLinkedList<X> otherLinkedList)
			{
				
				
				if (otherLinkedList.head != null)
					{
						
						MyNode<X> node = otherLinkedList.head;
						this.addElement(node.element);this.size++;
						while (node.nextNode != null)
							{
								node = node.nextNode;
								this.addElement(node.element);
								this.size++;
							}
					}
			}
			
		public Boolean IsEmpty()
			{
				
				return head == null;
			}
			
		public MyNode<X> find(X o)
			{
				
				if (head == null)
					return null;
				if (head.element == o)
					return head;
				MyNode<X> node = head;
				while (node.nextNode != null)
					{
						node = node.nextNode;
						if (node.element == o)
							return node;
					}
				return null;
			}
			
		public Boolean IsMember(X o)
			{
				
				if (find(o) == null)
					{
						return false;
					}
				else
					{
						return true;
					}
			}
			
		public MyNode<X> findNodeBefore(X o)
			{
				
				if (head.element == o)
					return new MyNode<X>();
				MyNode<X> node = head;
				while (node.nextNode != null)
					{
						if (node.nextNode.element == o)
							return node;
						node = node.nextNode;
					}
				return null;
			}
			
		public void delete(X o)
			{
				
				MyNode<X> nodeBeforeNodetoDelete = findNodeBefore(o);
				if (nodeBeforeNodetoDelete.element == null)
					{
						head = head.nextNode;
						size--;
						
					}
				else
					{
						if (tail.element == o)
							{
								nodeBeforeNodetoDelete.nextNode = null;
								tail = nodeBeforeNodetoDelete;
							}
						else
							{
								nodeBeforeNodetoDelete.nextNode = nodeBeforeNodetoDelete.nextNode.nextNode;
							}
						size--;
						
					}
			}
			
		public void traverse()
			{
				
				if (head != null)
					{
						MyNode<X> node = head;
						System.out.println(node);
						while (node.nextNode != null)
							{
								node = node.nextNode;
								System.out.println(node);
							}
					}
			}
			
	}
