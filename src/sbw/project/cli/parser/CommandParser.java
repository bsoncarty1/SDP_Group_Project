package sbw.project.cli.parser;

import sbw.project.cli.action.ActionSet;

/**
 * Defines the parser that interprets and processes the commands according to
 * Project Part 1.
 * 
 */
public class CommandParser {


	private ActionSet actionSet;

	private String text;
	/**
	 * Create your parser. The ActionSet and command string are provided to you
	 * automatically. Do not do the parsing here.
	 * 
	 * @param actionSet
	 * @param text
	 */
	public CommandParser(final ActionSet actionSet, final String text) {
		System.out.println("YOUR PARSER: CONSTRUCTOR");
		this.actionSet = actionSet;
		this.text = text;
		this.parse();
	}

	/**
	 * Do the parsing.
	 */
	public void parse() {

		System.out.println("YOUR PARSER: PARSE");

		CommandParser c;

		String[] textArr = text.split(" ");
		String actionWord = textArr[0].toUpperCase();
		switch(actionWord) {
			case "CREATE":
				new CommandParserCreational(actionSet, text);
				break;
			case "DECLARE":
				new CommandParserStructural(actionSet, text);
				break;
			case "DO":
				new CommandParserBehavioral(actionSet, text);
				break;
			case "@":
				new CommandParserMiscellaneous(actionSet, text);
				break;
		}

	}
}
