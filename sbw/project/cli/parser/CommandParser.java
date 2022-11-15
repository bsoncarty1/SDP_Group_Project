package sbw.project.cli.parser;

import sbw.project.cli.action.ActionSet;

/**
 * Defines the parser that interprets and processes the commands according to
 * Project Part 1.
 * 
 */
public class CommandParser implements CommandParserConstants {

	/**
	 * Next token.
	 */
	private Token jj_nt;

	/**
	 * Current token.
	 */
	private Token token;

	/**
	 * Generated Token Manager.
	 */
	private CommandParserTokenManager token_source;

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
