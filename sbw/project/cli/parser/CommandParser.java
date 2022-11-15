package sbw.project.cli.parser;

import sbw.project.cli.action.ActionSet;

public class CommandParser {
	
	/**
	 * A nonnegative real in appropriate units per clock tick
	 */
	private Acceleration acceleration;
	
	/**
	 * A nonnegative real in degrees
	 */
	private Angle angle;
	
	/**
	 * An arbitrary alphanumeric identifier, like Java variables
	 */
	private Identifier id;
	
	/**
	 * A real in percent [0,100]
	 */
	private Percent percent;
	
	/**
	 * A closed set of flap positions [up,1,2,3,4]
	 */
	private Position position;
	
	/**
	 * A real in percent [0,100]
	 */
	private Power power;
	
	/**
	 * A positive integer clock rate
	 */
	private Rate rate;
	
	/**
	 * A positive real in appropriate units per clock tick
	 */
	private Speed speed;
	
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
