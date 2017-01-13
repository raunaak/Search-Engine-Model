


public class Position
	{
		
		Integer		wordIndex;
		
		PageEntry	p;
		
		// Constructor method.
		Position(PageEntry p, int wordIndex)
			{
				this.wordIndex = wordIndex;
				this.p = p;
			}
			
		public Integer getWordIndex()
			{
				
				return wordIndex;
			}
			
		// return p
		public PageEntry getPageEntry()
			{
				
				return p;
			}
			
	}
