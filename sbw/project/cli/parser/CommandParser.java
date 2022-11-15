package sbw.project.cli.parser;

import sbw.project.cli.action.ActionSet;

public class CommandParser {
	/**
	 * Create your parser. The ActionSet and command string are provided to you
	 * automatically. Do not do the parsing here.
	 * 
	 * @param actionSet
	 * @param text
	 */
	public CommandParser(final ActionSet actionSet, final String text) {
		System.out.println("YOUR PARSER: CONSTRUCTOR");
	}

	/**
	 * Do the parsing.
	 */
	public void parse() {
		System.out.println("YOUR PARSER: PARSE");
	}
}
