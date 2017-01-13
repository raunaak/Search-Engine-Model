

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class InvertedPageIndex
	{
		
		/*
		 * Write a Java class InvertedPageIndex which contains the following
		 * methods:
		 * 
		 * – void addPage(PageEntry p): Add a new page entry p to the inverted
		 * page index.
		 * 
		 * – MySet<PageEntry> getPagesWhichContainWord(String str): Return a set
		 * of page-entries of webpages which contain the word str.
		 */
		HashMap<String, MyLinkedList<Position>> hm;
		
		public InvertedPageIndex()
			{
				hm = new HashMap<String, MyLinkedList<Position>>();
			}
			
		public void addPage(PageEntry p)
			{
				
				MyNode<WordEntry> node = p.index.wordEntries.head;
				String s = node.element.word;
				if (hm.get(s) == null)
					{
						
						hm.put(s, node.element.PositionLinkedList);
						while (node.nextNode != null)
							{
								node = node.nextNode;
								String s2 = node.element.word;
								if (hm.get(s2) == null)
									{
										hm.put(s2, node.element.PositionLinkedList);
									}
								else
									{
										hm.get(s2).addLinkedList(node.element.PositionLinkedList);
									}
									
							}
					}
				else
					{
						hm.get(s).addLinkedList(node.element.PositionLinkedList);
						while (node.nextNode != null)
							{
								node = node.nextNode;
								String s2 = node.element.word;
								if (hm.get(s2) == null)
									{
										hm.put(s2, node.element.PositionLinkedList);
									}
								else
									{
										hm.get(s2).addLinkedList(node.element.PositionLinkedList);
									}
									
							}
					}
			}
			
		public MyLinkedList<Position> getPositions(String str)
			{
				
				return hm.get(str);
			}
			
		public MySet<PageEntry> getPagesWhichContainWord(String str)
			{
				
				MySet<PageEntry> S = new MySet<PageEntry>();
				MyLinkedList<Position> P = getPositions(str);
				if (P == null)
					{
						return null;
					}
				MyNode<Position> node = P.head;
				S.addElement(node.element.p);
				while (node.nextNode != null)
					{
						S.addElement(node.element.p);
					}
				return S;
			}
			
		/*
		 * – MySet<PageEntry> getPagesWhichContainPhrase(String str[]): Return a
		 * set of page-entries for webpages which contain a sequence of
		 * non-connector words (str[0] str[1] ... str[str.len-1]).
		 */
		public int findArray(String[] array, String[] subArray)
			{
			    return Collections.indexOfSubList(Arrays.asList(array), Arrays.asList(subArray));
			}
			
		public MySet<PageEntry> getPagesWhichContainPhrase(String str[])
			{
				
				MySet<PageEntry> S = new MySet<PageEntry>();
				MyNode<Position> node = hm.get(str[0]).head;
				if (findArray( node.element.p.WithoutConnectors, str)>-1)
					{
						S.addElement(node.element.p);
					}
				while (node.nextNode != null)
					{
						node = node.nextNode;
						if (findArray( node.element.p.WithoutConnectors, str)>-1)
							{
								S.addElement(node.element.p);
							}
							
					}
				return S;
			}
			
			}
