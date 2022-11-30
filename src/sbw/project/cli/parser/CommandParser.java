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

	   //must make all letters uppercase before, or else add a-z
	public static boolean isCommand(String command){
		ArrayList<Pattern> list = new ArrayList<>();
		//Creational REGEX
		//need to fix some if angle is string
		list.add(Pattern.compile("CREATE[\\s]+RUDDER[\\s]+WITH[\\s]+LIMIT[\\s]+[0-9A-Z]+[\\s]+SPEED[\\s]+[0-9]+[\\s]+ACCELERATION[\\s]+[0-9]+"));
		list.add(Pattern.compile("CREATE[\\s]+ELEVATOR[\\s]+WITH[\\s]+LIMIT[\\s]+[0-9]+[\\s]+SPEED[\\s]+[0-9]+[\\s]+ACCELERATION[\\s]+[0-9]+"));
		list.add(Pattern.compile("CREATE[\\s]+AILERON[\\s]+[0-9A-Z]+[\\s]+WITH[\\s]+LIMIT[\\s]+UP[\\s]+[0-9]+[\\s]+DOWN[\\s]+[0-9]+[\\s]+SPEED[\\s]+[0-9]+[\\s]+ACCELERATION[\\s]+[0-9]+"));
		//Might have to change if not FOWLER
		list.add(Pattern.compile("CREATE[\\s]+FOWLER[\\s]+FLAP[\\s]+[0-9A-Z]+[\\s]+WITH[\\s]+LIMIT[\\s]+[0-9]+[\\s]+SPEED[\\s]+[0-9]+[\\s]+ACCELERATION[\\s]+[0-9]+"));
		//Might have to adjust
		list.add(Pattern.compile("CREATE[\\s]+ENGINE[\\s]+[0-9A-Z]+[\\s]+WITH[\\s]+SPEED[\\s]+[0-9]+[\\s]+ACCELERATION[\\s]+[0-9]+"));
		list.add(Pattern.compile("CREATE[\\s]+NOSE[\\s]+GEAR[\\s]+[0-9A-Z]+[\\s]+WITH[\\s]+SPEED[\\s]+[0-9]+[\\]s+ACCELERATION[\\s]+[0-9]+"));
		//Structural REGEX
		list.add(Pattern.compile("DECLARE[\\s]+RUDDER[\\s]+CONTROLLER[\\s]+[0-9A-Z]+[\\s]+WITH[\\s]+RUDDER[0-9A-Z]+"));
		list.add(Pattern.compile("DECLARE[\\s]+ELEVATOR[\\s]+CONTROLLER[\\s]+[0-9A-Z]+[\\s]+WITH[\\s]+ELEVATORS[\\s]+[0-9A-Z]+[\\s]+[0-9A-Z]+"));
		//must check for n number of id's confused on how
		list.add(Pattern.compile("DECLARE[\\s]+AILERON[\\s]+CONTROLLER[\\s]+[0-9A-Z]+[\\s]+WITH[\\s]+AILERONS[\\s]+[0-9A-Z]+[\\s]+PRIMARY[0-9A-Z]+"));
		list.add(Pattern.compile("DECLARE[\\s]+FLAP[\\s]+CONTROLLER[\\s]+[0-9A-Z]+[\\s]+WITH[\\s]+FLAPS[\\s]+[0-9A-Z]+"));
		list.add(Pattern.compile("DECLARE[\\s]+ENGINE[\\s]+CONTROLLER[\\s]+[0-9A-Z]+[\\s]+WITH[\\s]+[ENGINE|ENGINES][\\s]+[0-9A-Z]+"));
		list.add(Pattern.compile("DECLARE[\\s]+GEAR[\\s]+CONTROLLER[\\s]+[0-9A-Z]+[\\s]+WITH[\\s]+GEAR[\\s]+NOSE[\\s]+[0-9A-Z]+[\\s]+MAIN[\\s]+[0-9A-Z]+[\\s]+[0-9A-Z]+"));
		//Behavioral REGEX
		list.add(Pattern.compile("DO[\\s]+[0-9A-Z]+[\\s]+DEFLECT[\\s]+RUDDER[\\s]+[UP|DOWN]"));
		list.add(Pattern.compile("DO[\\s]+[0-9A-Z]+[\\s]+DEFLECT[\\s]+ELEVATOR[\\s]+[0-9A-Z]+[\\s]+[UP|DOWN]"));
		list.add(Pattern.compile("DO[\\s]+[0-9A-Z]+[\\s]+DEFLECT[\\s]+AILERONS[\\s]+[0-9A-Z]+[\\s]+[UP|DOWN]"));
		list.add(Pattern.compile("DO[\\s]+[0-9A-Z]+[\\s]+SPEED[\\s]+BRAKE[\\s]+[ON|OFF]"));
		list.add(Pattern.compile("DO[\\s]+[0-9A-Z]+[\\s]+DEFLECT[\\s]+FLAP[\\s]+[0-9A-Z]+"));
		list.add(Pattern.compile("DO[\\s]+[0-9A-Z]+[\\s]+SET[\\s]+POWER[\\s]+[0-9]+"));
		list.add(Pattern.compile("DO[\\s]+[0-9A-Z]+[\\s]+GEAR[\\s]+[UP|DOWN]"));
		//Misc. REGEX
		list.add(Pattern.compile("@[0-9A-Z]+"));
		list.add(Pattern.compile("@[0-9A-Z]+[\\s]+[0-9A-Z]+"));
		for(Pattern pattern: list){
		   Matcher matcher = pattern.matcher(command);
		   if(matcher.find())
			  return true;
		}
		return false;
	}

	/**
	 * Do the parsing.
	 */
	public void parse() {
		String actionWord = this.text.split()[0].toUpperCase().trim();
		CommandParser parser;
		boolean action = isCommand(actionWord);
		if(actionWord) {
		
		if (actionWord.equals("CREATE")) 
			parser = new CommandParserCreational(actionSet, text);
		
		else if (actionWord.equals("DECLARE") || actionWord.equals("COMMIT"))
			parser = new CommandParserStructural(actionSet, text);
		
		else if (actionWord.equals("DO") || actionWord.equals("HALT"))
			parser = new CommandParserBehavioral(actionSet, text);
		
		else if (actionWord.equals("@CLOCK") || actionWord.equals("@EXIT")|| actionWord.equals("@WAIT"))
			parser =  new CommandParserMiscellaneous(actionSet, text);
		
		else
			throw new IllegalArgumentException("Parser was not given a correct action word");					
		}
		else{
			System.out.println("Error in command input");
		}

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
	 * @param
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
	 * @param
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
