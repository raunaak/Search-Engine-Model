


public class SearchEngine
	{
		/*
		 * Write a Java class SearchEngine. This is the class that we will use
		 * as an interface to the search engine. It should contain following
		 * methods:
		 * 
		 * – SearchEngine(): This is the constructor method. It should create an
		 * empty InvertedPageIndex.
		 * 
		 * – void performAction(String actionMessage): This the main stub method
		 * that you have to implement. It takes an action as a string. The list
		 * of actions, and their format will be described later.
		 */
		
		InvertedPageIndex I;
		
		public SearchEngine()
			{
				I = new InvertedPageIndex();
			}
			
		public void performAction(String actionMessage)
			{
				
				/*
				 * addPage x Add webpage x to the search engine database. The
				 * contents of the webpage are stored in a file named x in the
				 * webpages folder.
				 * 
				 * 
				 * 
				 * • queryFindPagesWhichContainWord x Print the name of the
				 * webpages which contain the word x. The list of webpage names
				 * should be comma separated. If the word is not found in any
				 * webpage, then print “No webpage contains word x”
				 * 
				 * 
				 * • queryFindPositionsOfWordInAPage x y Print the word indice’s
				 * where the word x is found in the document y. The word indices
				 * should be separated by a comma. If the word x is not found in
				 * webpage y, then print “Webpage y does not contain word x”.
				 */
				
				String s1[] = actionMessage.split(" ");
				String a = s1[1].toLowerCase();
				String b = null;
				if (s1.length == 3)
					{
						b = s1[2].toLowerCase();
					}
				if (s1[0].equals("addPage"))
					{
						PageEntry p = new PageEntry(a);
						I.addPage(p);
						
					}
				if (s1[0].equals("queryFindPagesWhichContainWord"))
					{
						
						MyLinkedList<Position> P = I.hm.get(a);
						if(P!=null) {
							MyNode<Position> node=P.head;
							String h = P.head.element.p.pageName;
							System.out.print(h+", ");
							while(node.nextNode!=null) {
								node=node.nextNode;
								String s = node.element.p.pageName;
								if(h!=s) {System.out.print(s+", ");}
								h=s;
								
							}
							
						}
						
						else {
							System.out.print("No webpage contains word "+a);
						}
						System.out.println();
					}
				if (s1[0].equals("queryFindPositionsOfWordInAPage"))
					{
						int j = 0;
						PageEntry P = new PageEntry(b);
						MyNode<WordEntry> node = P.index.wordEntries.head;
						if (node.element.word.equals(a))
							{
								MyNode<Position> node2 = node.element.getAllPositionsForThisWord().head;
								System.out.print(node2.element.wordIndex + ", ");
								j = j + 1;
								while (node2.nextNode != null)
									{
										node2 = node2.nextNode;
										System.out.print(node2.element.wordIndex + ", ");
										j = j + 1;
									}
							}
						else
							{
								while (node.nextNode != null)
									{
										node = node.nextNode;
										if (node.element.word.equals(a))
											{
												MyNode<Position> node2 = node.element.getAllPositionsForThisWord().head;
												System.out.print(node2.element.wordIndex + ", ");
												j = j + 1;
												while (node2.nextNode != null)
													{
														node2 = node2.nextNode;
														System.out.print(node2.element.wordIndex + ", ");
														j = j + 1;
													}
											}
									}
									
							}
						if (j == 0)
							{
								System.out.println("Webpage " + b + " does no contain word " + a);
							}
						System.out.println();
					}
					
			}
			
		
		
	}
