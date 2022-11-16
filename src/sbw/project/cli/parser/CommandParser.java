package sbw.project.cli.parser;

import sbw.project.cli.action.ActionSet;

/**
 * Defines the parser that interprets and processes the commands according to
 * Project Part 1.
 * 
 */
public class CommandParser {

/**
	 * The ActionSet passed in
	 */
	private ActionSet actionSet;

	/**
	 * The full command String that was passed in
	 */
	private String text;

	/**
	 * The specific parser based on the first word
	 */
	private CommandParser parser;

	/**
	 * Create your parser. The ActionSet and command string are provided to you
	 * automatically. Do not do the parsing here.
	 * 
	 * @param actionSet
	 * @param text
	 */
	public CommandParser(final ActionSet actionSet, final String text) {
		this.actionSet = actionSet;
		this.text = text;
		this.parse();
	}

	/**
	 * Do the parsing.
	 */
	public void parse() {
		String actionWord = this.text.split()[0].toUpperCase().trim();
		CommandParser parser;
		
		if (actionWord.equals("CREATE")) 
			parser = new CommandParserCreational(actionSet, text);
		
		else if (actionWord.equals("DECLARE") || actionWord.equals("COMMIT"))
			parser = new CommandParserStructural(actionSet, text);
		
		else if (actionWord.equals("DO") || actionWord.equals("HALT"))
			parser = new CommandParserBehavioral(actionSet, text);
		
		else if (actionWord.equals("@CLOCK") || actionWord.equals("@RUN")|| actionWord.equals("@EXIT")|| actionWord.equals("@WAIT")
			parser =  new CommandParserMiscellaneous(actionSet, text);
		
		else
			throw new IllegalArgumentException("Parser was not given a correct action word");					
		

		parser.parse();

	}

	protected ActionSet getActionSet() {
		return this.actionSet;
	}

	protected String getText() {
		return this.text;
	}

	/**
	 * Given a full command string and an attribute String, will return the string
	 * after the first occurance of "attribute".
	 * 
	 * @param text
	 * @return
	 */
	protected String getAttributeAfter(final String command, final String attribute) {
		if (command.indexOf(attribute) > -1) {
			String[] s = command.substring(command.indexOf(attribute)).split();
			return s[1].trim();
		}
		return "NOT FOUND";
	}

	/**
	 * Given a full command string and an attribute String, will return the string
	 * before the first occurance of "attribute".
	 * 
	 * @param text
	 * @return
	 */
	protected String getAttributeBefore(final String command, final String attribute) {
		if (command.indexOf(attribute) > -1) {
			String[] s = command.substring(0, command.indexOf(attribute)).split();
			return s[s.length].trim();
		}
		return "NOT FOUND";
	}
}
