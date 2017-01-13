


//For a string str, this class stores the list of word indice’s where str is present in the document(s).
public class WordEntry
	{
		
		String					word;
		
		MyLinkedList<Position>	PositionLinkedList;
		
		// The argument is the word for which we are creating the word entry.
		
		public WordEntry(String word)
			{
				this.word = word;
				PositionLinkedList=new MyLinkedList<Position>();
			}
			
		void addPosition(Position position)
			{
				
				PositionLinkedList.addElement(position);
			}
			
		public void addPositions(MyLinkedList<Position> positions)
			{
				
				PositionLinkedList.addLinkedList(positions);
				
			}
			
		public MyLinkedList<Position> getAllPositionsForThisWord()
			{
				
				return PositionLinkedList;
			}
	}
