package sbw.project.cli.parser;

import sbw.architecture.datatype.Identifier;
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
        String[] textArr = text.split(" ");
        if(textArr[1].equalsIgnoreCase("RUDDER")){
            Rudder(actionSet, textArr);
        }
    }

    public void Rudder(ActionSet a, String[] textArr){
        Identifier id1 = new Identifier(textArr[3]);
        Identifier id2 = new Identifier(textArr[6]);
        a.getActionStructural().doDeclareRudderController(id1,id2);
    }
}
