package sbw.project.cli.parser;

import sbw.architecture.datatype.Identifier;
import sbw.project.cli.action.ActionSet;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

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
        }else if(textArr[1].equalsIgnoreCase("ELEVATOR")){
            Elevator(actionSet, textArr);
        }else if(textArr[1].equalsIgnoreCase("AILERON")) {
            Aileron(actionSet, textArr);
        }else if(textArr[1].equalsIgnoreCase("FLAP")) {
            Flap(actionSet, textArr);
        }
    }

    public void Rudder(ActionSet a, String[] textArr){
        Identifier id1 = new Identifier(textArr[3]);
        Identifier id2 = new Identifier(textArr[6]);
        a.getActionStructural().doDeclareRudderController(id1,id2);
    }

    public void Elevator(ActionSet a, String[] textArr){
        Identifier id1 = new Identifier(textArr[3]);
        Identifier id2 = new Identifier(textArr[6]);
        Identifier id3 = new Identifier(textArr[7]);
        a.getActionStructural().doDeclareElevatorController(id1,id2,id3);
    }


    //TODO: adapt code, can be multiple ailerons
    public void Aileron(ActionSet a, String[] textArr){
        Identifier id1 = new Identifier(textArr[3]);
        Identifier idn = new Identifier(textArr[6]); //This can have one or more
        Identifier idx = new Identifier(textArr[7]); //This can have 0 or more
        /**TODO: Instructions:
         //Creates a ControllerAileron with identifier id1 containing n ailerons idn, where n is even. The first half of n in order are on the left wing, and the second half on the right. idx specifies which of idn is the primary one that is directly
         //commanded by a request to this controller. It must be on the left wing. The others respond based on it: all ailerons on the same side deflect in the same direction, and all on the opposite side deflect in the opposite direction (except when used as a speed brake; see III.3.b). idslave optionally bases its deflection (and likewise its opposite's) on idmaster by percent percent. Any chain of mixing is possible, but there are no cyclical relationships. Aileron configurations must be symmetrically identical.
         //This calls two variants of doDeclareAileronController(), which creates and registers an instance of ControllerAileron.
         **/

    }

    public void Flap(ActionSet a, String[] textArr){
        Identifier id = new Identifier(textArr[3]);
        int i = 6;
        ArrayList<Identifier> list = new ArrayList<>();
        while(i < textArr.length){
            Identifier idn = new Identifier(textArr[i]);//TODO: this can have one or more
            list.add(idn);
            i++;
        }
        a.getActionStructural().doDeclareFlapController(id,list);
    }




}
