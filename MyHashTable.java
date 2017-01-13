


/*
		 * Write a Java class MyHashTable that implements the hashtable used by
		 * the InvertedPageIndex. It maps a word to its word-entry.
		 * 
		 * – private int getHashIndex(String str): Create a hash function which
		 * maps a string to the index of its word-entry in the hashtable. The
		 * implementation of hashtable should support chaining.
		 * 
		 * – void addPositionsForWord(WordEntry w): This adds an entry to the
		 * hashtable: stringName(w) − > positionList(w). If no wordentry exists,
		 * then create a new word entry. However, if a wordentry exists, then
		 * merge w with the existing word-entry.
		 */

public class MyHashTable
	{
		
		public int					TABLE_SIZE;
		
		public MyLinkedList<WordEntry>[]	table;
		
		
			
		@SuppressWarnings("unchecked")
		MyHashTable()
			{
				TABLE_SIZE = 128;
				table=(MyLinkedList<WordEntry>[]) new MyLinkedList[128];
			}
		public int getHashIndex(String str)
			{
				
				int mod = str.hashCode() % TABLE_SIZE;
				return mod < 0 ? mod + TABLE_SIZE : mod;
			}
			
		public MyLinkedList<WordEntry> get(int hash)
			{
				
				return table[hash];
			}
			
		public void put(WordEntry w)
			{
				
				int hash = getHashIndex(w.word);
				MyLinkedList<WordEntry> h= table[hash];
				if(h!=null)
				h.addElement(w);
			}
		
	}
