package sbw.project.cli.parser;

import sbw.project.cli.action.ActionSet;

public class CommandParserStructural extends CommandParser{
    /**
     * Create your parser. The ActionSet and command string are provided to you
     * automatically. Do not do the parsing here.
     *
     * @param actionSet
     * @param text
     */
    public CommandParserStructural(ActionSet actionSet, String text) {
        super(actionSet, text);
    }
}
