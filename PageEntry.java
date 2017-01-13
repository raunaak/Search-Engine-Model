


import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class PageEntry
	{
		/*
		 * Write a Java class PageEntry to store the the information related to
		 * a webpage. It should contain following methods:
		 * 
		 * – PageEntry(String pageName): Constructor method. The argument is the
		 * name of the document. Read this file, and create the page index.
		 * 
		 * – PageIndex getPageIndex(): This method returns the page index of
		 * this web-page.
		 */
		
		PageIndex	index;
		
		String		pageName;
		String[] WithoutConnectors;
		public PageEntry(String pageName)
			{
				index = new PageIndex();
				this.pageName = pageName;
				
				String fileName = "C:\\Users\\Vishavjeet Singh\\workspace\\dataStructure\\src\\search\\webpages\\"
				        + pageName;
				try
					{
						List<String> lines = Files.readAllLines(Paths.get(fileName));
						Charset.defaultCharset();
						
						String[] strarray = lines.toArray(new String[0]);
						String stringAll = Arrays.toString(strarray);
						stringAll = stringAll.replace("{", " ");
						stringAll = stringAll.replace("}", " ");
						stringAll = stringAll.replace("[", " ");
						stringAll = stringAll.replace("]", " ");
						stringAll = stringAll.replace("<", " ");
						stringAll = stringAll.replace(">", " ");
						stringAll = stringAll.replace("=", " ");
						stringAll = stringAll.replace("(", " ");
						stringAll = stringAll.replace(")", " ");
						stringAll = stringAll.replace(".", " ");
						stringAll = stringAll.replace(",", " ");
						stringAll = stringAll.replace(";", " ");
						stringAll = stringAll.replace("'", " ");
						stringAll = stringAll.replace("\"", " ");
						stringAll = stringAll.replace("?", " ");
						stringAll = stringAll.replace("#", " ");
						stringAll = stringAll.replace("!", " ");
						stringAll = stringAll.replace("-", " ");
						stringAll = stringAll.replace(":", " ");
						stringAll = stringAll.toLowerCase();
						StringBuilder sb =new StringBuilder(stringAll);
						
                        String resultString = sb.toString();
						String[] stringArray = resultString.split("\\s+");						
						for (int i = 0; i < stringArray.length; ++i)
							{
								if (stringArray[i] != "a" || stringArray[i] != "an" || stringArray[i] != "the"
								        || stringArray[i] != "they" || stringArray[i] != "these"
								        || stringArray[i] != "this" || stringArray[i] != "for" || stringArray[i] != "is"
								        || stringArray[i] != "are" || stringArray[i] != "was" || stringArray[i] != "of"
								        || stringArray[i] != "or" || stringArray[i] != "and" || stringArray[i] != "does"
								        || stringArray[i] != "will" || stringArray[i] != "whose")
									{Position position = new Position(this, i);
										
										
										index.addPositionForWord(stringArray[i], position);
										
									}
								
							}
						stringAll=stringAll.replace("a"," ");
						stringAll=stringAll.replace("an"," ");
						stringAll=stringAll.replace("the"," ");
						stringAll=stringAll.replace("they"," ");
						stringAll=stringAll.replace("these"," ");
						stringAll=stringAll.replace("this"," ");
						stringAll=stringAll.replace("for"," ");
						stringAll=stringAll.replace("is"," ");
						stringAll=stringAll.replace("are"," ");
						stringAll=stringAll.replace("was"," ");
						stringAll=stringAll.replace("of"," ");
						stringAll=stringAll.replace("or"," ");
						stringAll=stringAll.replace("and"," ");
						stringAll=stringAll.replace("does"," ");
						stringAll=stringAll.replace("will"," ");
						stringAll=stringAll.replace("whose"," ");


	StringBuilder sb2=new StringBuilder(stringAll);
						
                        String resultString2 = sb2.toString();
						WithoutConnectors = resultString2.split("\\s+");
						
							
					}
				catch (IOException e)
					{
						e.printStackTrace();
					}
				
					
			}
		
			
	}
