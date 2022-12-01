package sbw.project.cli.parser;

import sbw.project.cli.action.ActionSet;

public class CommandParserMiscellaneous extends CommandParser{
    /**
     * Create your parser. The ActionSet and command string are provided to you
     * automatically. Do not do the parsing here.
     *
     * @param actionSet
     * @param text
     */
    public CommandParserMiscellaneous(ActionSet actionSet, String text) {
        super(actionSet, text);
        String[] textArr = text.split(" ");
        switch(textArr){
            case textArr[0].equalsIgnoreCase("@CLOCK") :
                clock(actionSet, textArr);
                break;
            case textArr[0].equalsIgnoreCase("@EXIT") :
                exit(actionSet);
                break;
            case textArr[0].equalsIgnoreCase("@WAIT") :
                wait(actionSet, textArr);
                break;
        }
    }

    /*
     * @Clock <rate>
     * Sets  the system clock speed to rate ticks per second.
     * This calls submitCommand() with an instance of CommandDoSetClockRate(Rate rate)
     */
    //@?
    public void clock (ActionSet as, String[] textArr){
        double rate = Double.parseDouble(textArr[1]); //might need to adjust, also not entirely sure what Rate rate is asking for
        as.submitCommand().CommandDoSetClockRate(rate);
    }

    /*
     * @EXIT
     * Exits the system
     * This calls submitCommand() with an instance of CommandDoExit().
     */
    public void exit (ActionSet as) {
        as.submitCommand().CommandDoExit();
    }

    /*
     * @WAIT <rate>
     * Waits rate milliseconds before executing the next behavioral command. This command is not valid until after @commit.
     * This calls submitCommand() with an instance of CommandDoWait(Rate rate).
     */
    public void wait(ActionSet as, String[] textArr) {
        double rate = Double.parseDouble(textArr[1]); //Might need to adjust
        as.submitCommand().CommandDoWait(rate);
    }
}
