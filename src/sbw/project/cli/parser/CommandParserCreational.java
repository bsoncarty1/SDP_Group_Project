package sbw.project.cli.parser;

import sbw.project.cli.action.ActionSet;

public class CommandParserCreational extends CommandParser{
    /**
     * Create your parser. The ActionSet and command string are provided to you
     * automatically. Do not do the parsing here.
     *
     * @param actionSet
     * @param text
     */
    public CommandParserCreational(ActionSet actionSet, String text) {
        super(actionSet, text);
        String[] textArr = text.split(" ");
        if(textArr[1].equalsIgnoreCase("RUDDER")){
            CreateRudder(actionSet, textArr);
        }else if(textArr[1].equalsIgnoreCase("ELEVATOR")){
            CreateElevator(actionSet, textArr);
        }else if(textArr[1].equalsIgnoreCase("AILERON")) {
            CreateAileron(actionSet, textArr);
        }else if(textArr[1].equalsIgnoreCase("FLAP")) {
            CreateFlap(actionSet, textArr);
        }else if(textArr[1].equalsIgnoreCase("ENGINE")) {
            CreateEngine(actionSet, textArr);
        }else if(textArr[1].equalsIgnoreCase("GEAR")) {
            CreateGear(actionSet, textArr);
        }else{
            System.out.println("Error in CommandParserStructural.");
        }
    }

    private void CreateGear(ActionSet actionSet, String[] textArr) {
    }

    private void CreateEngine(ActionSet actionSet, String[] textArr) {
    }

    private void CreateFlap(ActionSet actionSet, String[] textArr) {
    }

    private void CreateAileron(ActionSet actionSet, String[] textArr) {
    }

    private void CreateElevator(ActionSet actionSet, String[] textArr) {
    }

    private void CreateRudder(ActionSet actionSet, String[] textArr) {
    }
}
