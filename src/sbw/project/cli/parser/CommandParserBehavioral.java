package sbw.project.cli.parser;

import sbw.architecture.datatype.Identifier;
import sbw.project.cli.action.ActionSet;

public class CommandParserBehavioral extends CommandParser{
    /**
     * Create your parser. The ActionSet and command string are provided to you
     * automatically. Do not do the parsing here.
     *
     * @param actionSet
     * @param text
     */
    public CommandParserBehavioral(ActionSet actionSet, String text) {
        super(actionSet, text);
        String[] textArr = text.split(" ");
        switch(textArr){
            case textArr[3].equalsIgnoreCase("RUDDER") :
                rudder(actionSet, textArr);
                break;
            case textArr[3].equalsIgnoreCase("ELEVATOR") :
                elevator(actionSet, textArr);
                break;
            case textArr[3].equalsIgnoreCase("AILERONS") :
                aileron(actionSet, textArr);
                break;
            case textArr[3].equalsIgnoreCase("FLAP") :
                flap(actionSet, textArr);
                break;
            case textArr[3].equalsIgnoreCase("POWER") :
                engine(actionSet, textArr);
                break;
            case textArr[3].equalsIgnoreCase("GEAR") :
                gear(actionSet, textArr);
                break;
        }
    }
    /*
     * DO <id> DEFLECT RUDDER <angle> LEFT|RIGHT
     * requests that rudder controller id deflects its rudder respectively left or right to angle angle
     * this calls submitCommand() with an instance of CommandDoDeflectRudder.
     */
    public void rudder(ActionSet ac, String[] textArr) {
        Identifier id = new Identifier(textArr[1]);
        double angle = Double.parseDouble(textArr[4]); /////////////////Might need to adjust to int or float. Also assuming the angle is already integer.parsed
        String dir = textArr[5];
        //True if right
        if(dir.equalsIgnoreCase("RIGHT")){
            ac.submitCommand().CommandDoDeflectRudder(id,angle,true);
        }
        else{
            ac.submitCommand().CommandDoDeflectRudder(id,angle,false);
        }
    }
    
    /*
     * DO <id> DEFLECT ELEVATOR <angle> UP|DOWN
     * Requests that elevator controller id deflect its elevators respectively up or down to angle angle
     * this calls submitCommand() with an instance of CommandDoDeflectElevator.
     */
    public void elevator(ActionSet ac, String[] textArr) {
        Identifier id = new Identifier(textArr[1]);
        double angle = Double.parseDouble(textArr[4]); //////////////////Might need to adjust to make int or float. Also assuming the angle is already integer.parsed
        String dir = textArr[5];
        //True if down
        if(dir.equalsIgnoreCase("UP")){
            ac.submitCommand().CommandDoDeflectElevator(id,angle,false);
        }
        else{
            ac.submitCommand().CommandDoDeflectElevator(id,angle,true);
        }
    }

    /*
     * DO <id> DEFLECT AILERONS <angle> UP|DOWN
     * Requests that aileron controller id deflect its primary aileron respectively up or down to angle angle. The opposite ailerons 
       will deflect in the other direction. The slave ailerons will derive their angles as specified in the slave clause in II.3.a, if one was
       given; otherwise, the relationship is 100%.
       this calls submitCommand() with an instance of CommandDoDeflectAilerons.
     */
    public void aileron(ActionSet ac, String[] textArr) {
        Identifier id = new Identifier(textArr[1]);
        double angle = Double.parseDouble(textArr[4]); //////////////////Might need to adjust to make int or float. Also assuming the angle is already integer.parsed
        String dir = textArr[5];
        //True if down
        if(dir.equalsIgnoreCase("UP")){
            ac.submitCommand().CommandDoDeflectAilerons(id,angle,false);
        }
        else{
            ac.submitCommand().CommandDoDeflectAilerons(id,angle,true);
        }
    }

    /*
     * DO <id> DEFLECT FLAP <position>
     * Requests that flap controller id deflect its flaps to position position, which is correspondingly 0, 25, 50, 75, or 100% of 
       the deflection range.
       this calls submitCommand() with an instance of CommandDoSetFlaps.
     */
    public void flap(ActionSet ac, String[] textArr) {
        Identifier id = new Identifier(textArr[1]);
        double pos = Double.parseDouble(textArr[4]); //Might need to adjust if percent is dif
        ac.submitCommand().CommandDoSetFlaps(id,pos);
    }

    /*
     * DO <id> SET POWER <power>
     * Requests that the engine controller id set the power of all engines to power.
     * this calls submitCommand() with an instance of CommandDoSetEnginePowerAll.
     */
    public void engine(ActionSet ac, String[] textArr){
        Identifier id = new Identifier(textArr[1]);
        double pow = Double.parseDouble(textArr[4]); //////Might need to adjust
        ac.submitCommand().CommandDoSetEnginePowerAll(id,pow);
    }

    /*
     * DO <id> GEAR UP|DOWN
     * Requests that gear controller id respectively raise or lower its gear.
     */
    public void gear(ActionSet ac, String[] textArr) {
        Identifier id = new Identifier(textArr[1]);
        String dir = textArr[3];
        //True if down
        if(dir.equalsIgnoreCase("UP")){
            ac.submitCommand().CommandDoSelectGear(id,false);
        }
        else {
            ac.submitCommand().CommandDoSelectGear(id,true);
        }
    }
}
