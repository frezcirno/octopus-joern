package parsing;

import java.util.Observer;
import me.tongfei.progressbar.*;

public class ModuleParser
{
	ANTLRParserDriver parserDriver;
	ProgressBar pb;

	public ModuleParser(ANTLRParserDriver driver)
	{
		parserDriver = driver;

		pb = new ProgressBar("Parsing", 1);
	}

	public void parseFile(String filename)
	{
		// System.out.println(filename);
		pb.step(); // step by 1

		try
		{
			parserDriver.parseAndWalkFile(filename);
		} catch (ParserException ex)
		{
			System.err.println("Error parsing file: " + filename);
		}
	}

	public void addObserver(Observer anObserver)
	{
		parserDriver.addObserver(anObserver);
	}

	/*
	 * Testing
	 **/

	public void parseString(String code)
	{
		try
		{
			parserDriver.parseAndWalkString(code);
		} catch (ParserException ex)
		{
			System.err.println("Error parsing string.");
		}
	}

}
