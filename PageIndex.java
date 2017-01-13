


public class PageIndex
	{
		
		// WordEntry is element of this linked list
		MyLinkedList<WordEntry> wordEntries;
		public PageIndex() {
			wordEntries=new MyLinkedList<WordEntry>();
		}
		public WordEntry find(String str)
			{
				
				MyNode<WordEntry> node = this.wordEntries.head;
				if(this.wordEntries.IsEmpty()==false) {
						if (node.element.word.equals(str))
							{
								return node.element;
							}
						while (node.nextNode != null)
							{
								node = node.nextNode;
								if (node.element.word.equals(str))
									{
										return node.element;
									}
							}
						return null;}
				return null;
					
			}
			
		public void addPositionForWord(String str, Position p)
			{
				if(str.length()>0) {
				if (str.charAt(str.length() - 1) == 's')
					{
						StringBuilder sb = new StringBuilder(str);
						sb.deleteCharAt(str.length() - 1);
						String resultString = sb.toString();
						WordEntry singular = find(resultString);
						if (singular != null)
							{
								singular.addPosition(p);
							}
					}
				WordEntry wordEntry = this.find(str);
				if (wordEntry != null)
					{
						wordEntry.addPosition(p);
					}
					
				else {WordEntry wordEntry2 = new WordEntry(str);
				wordEntry2.addPosition(p);
				this.wordEntries.addElement(wordEntry2);}
			}
			}
			
		public MyLinkedList<WordEntry> getWordEntries()
			{
				
				return wordEntries;
			}
	}
