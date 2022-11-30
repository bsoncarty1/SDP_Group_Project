package sbw.project.cli.parser;

import sbw.architecture.datatype.AileronSlaveMix;
import sbw.architecture.datatype.Identifier;
import sbw.architecture.datatype.Percent;
import sbw.project.cli.action.ActionSet;

import java.util.ArrayList;

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
        }else if(textArr[1].equalsIgnoreCase("ENGINE")) {
            Engine(actionSet, textArr);
        }else if(textArr[1].equalsIgnoreCase("GEAR")) {
            Gear(actionSet, textArr);
        }else{
            System.out.println("Error in CommandParserStructural.");
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


    //TODO: verify changes are correct
    public void Aileron(ActionSet a, String[] textArr){
        Identifier id1 = new Identifier(textArr[3]);

        ArrayList<Identifier> idAilerons = new ArrayList<>();
        int index = 0;
        for(int i = 6; i < textArr.length; i++){
            if(!textArr[i].equalsIgnoreCase("PRIMARY")) {
                idAilerons.add(new Identifier(textArr[i]));
            }else{
                index = i + 1;
                break;
            }
        }

        Identifier idAileronPrimary = new Identifier(textArr[index]);
        index++;

        ArrayList<AileronSlaveMix> slaveMixes = new ArrayList<>();
        for(int i = index; i < textArr.length; i++){
            if(i + 1 < textArr.length){
                Identifier slave = new Identifier(textArr[i + 1]);
                Identifier idMaster = new Identifier(textArr[i + 3]);
                Percent percent = new Percent(Double.parseDouble(textArr[i + 5]));
                slaveMixes.add(new AileronSlaveMix(idMaster,slave,percent));
                i = i + 5;
            }
        }

        a.getActionStructural().doDeclareAileronController(id1,idAilerons,idAileronPrimary,slaveMixes);


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

    public void Engine(ActionSet a, String[] textArr){
        Identifier id = new Identifier(textArr[3]);
        int i = 6;
        ArrayList<Identifier> list = new ArrayList<>();
        while(i < textArr.length){
            Identifier idn = new Identifier(textArr[i]);//TODO: this can have one or more
            list.add(idn);
            i++;
        }
        a.getActionStructural().doDeclareEngineController(id,list);
    }

    public void Gear(ActionSet a, String[] textArr){
        Identifier id1 = new Identifier(textArr[3]);
        Identifier id2 = new Identifier(textArr[7]);
        Identifier id3 = new Identifier(textArr[9]);
        Identifier id4 = new Identifier(textArr[10]);

        a.getActionStructural().doDeclareGearController(id1,id2,id3,id4);
    }


}
