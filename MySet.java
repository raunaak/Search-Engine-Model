


public class MySet<X>
	{
		
		MyLinkedList<X> l;
		
		MySet()
			{
			l=new MyLinkedList<X>();
			}
			
		// Add element to the set.
		
		public void addElement(X element)
			{
				
				try
					{
						if (l.IsMember(element) == true)
							{
								throw new Exception("This element already exists in the set");
							}
					}
				catch (Exception e)
					{
						System.out.println(e);
					}
				l.addElement(element);
			}
			
		
		//Return MySet which represents a union of the current set and the otherSet.
		public MySet<X> union(MySet<X> otherSet)
			{
				
				MySet<X> temp = otherSet;
				if (l.head == null)
					{
						return temp;
					}
				MyNode<X> node = l.head;
				temp.addElement(l.head.element);
				while (node.nextNode != null)
					{
						node = node.nextNode;
						temp.addElement(node.element);
					}
				return temp;
			}
			
		
		//Return MySet which represents an intersection of the current set and the otherSet
		public MySet<X> intersection(MySet<X> otherSet)
			{
				
				MySet<X> temp = new MySet<X>();
				if (l.head == null)
					{
						return otherSet;
					}
				MyNode<X> node = l.head;
				if (otherSet.l.IsMember(l.head.element) == true)
					{
						temp.addElement(l.head.element);
					}
				while (node.nextNode != null)
					{
						node = node.nextNode;
						if (otherSet.l.IsMember(node.element) == true)
							{
								temp.addElement(node.element);
							}
							
					}
					
				return temp;
			}
	}
