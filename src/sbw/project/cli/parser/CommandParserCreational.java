package sbw.project.cli.parser;

import sbw.architecture.datatype.Acceleration;
import sbw.architecture.datatype.Angle;
import sbw.architecture.datatype.Identifier;
import sbw.architecture.datatype.Speed;
import sbw.project.cli.action.ActionSet;

public class CommandParserCreational extends CommandParser{

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
            System.out.println("Error in CommandParserCreational.");
        }
    }

    private void CreateGear(ActionSet actionSet, String[] textArr) {

    }

    private void CreateEngine(ActionSet actionSet, String[] textArr) {
        Identifier id = new Identifier(textArr[2]);
        Speed speed = new Speed(Double.parseDouble(textArr[5]));
        Acceleration acceleration = new Acceleration(Double.parseDouble(textArr[7]));
        actionSet.getActionCreational().doCreateEngine(id,speed,acceleration);
    }

    private void CreateFlap(ActionSet actionSet, String[] textArr) {
        Identifier id = new Identifier(textArr[3]);
        Angle angle = new Angle(Double.parseDouble(textArr[6]));
        Speed speed = new Speed(Double.parseDouble(textArr[8]));
        Acceleration acceleration = new Acceleration(Double.parseDouble(textArr[10]));

        boolean fowler = textArr[1].equalsIgnoreCase("FOWLER");

        actionSet.getActionCreational().doCreateFlap(id,fowler,angle,speed,acceleration);
    }

    private void CreateAileron(ActionSet actionSet, String[] textArr) {
        Identifier id = new Identifier(textArr[2]);
        Angle angle1 = new Angle(Double.parseDouble(textArr[6]));
        Angle angle2 = new Angle(Double.parseDouble(textArr[8]));
        Speed speed = new Speed(Double.parseDouble(textArr[10]));
        Acceleration acceleration = new Acceleration(Double.parseDouble(textArr[12]));
        actionSet.getActionCreational().doCreateAileron(id,angle1,angle2,speed,acceleration);
    }

    private void CreateElevator(ActionSet actionSet, String[] textArr) {
        Identifier id1 = new Identifier(textArr[2]);
        Angle angle = new Angle(Double.parseDouble(textArr[5]));
        Speed speed = new Speed(Double.parseDouble(textArr[7]));
        Acceleration acceleration = new Acceleration(Double.parseDouble(textArr[9]));
        actionSet.getActionCreational().doCreateElevator(id1,angle,speed,acceleration);
    }

    private void CreateRudder(ActionSet actionSet, String[] textArr) {
        Identifier id1 = new Identifier(textArr[2]);
        Angle angle = new Angle(Double.parseDouble(textArr[5]));
        Speed speed = new Speed(Double.parseDouble(textArr[7]));
        Acceleration acceleration = new Acceleration(Double.parseDouble(textArr[9]));
        actionSet.getActionCreational().doCreateRudder(id1,angle,speed,acceleration);
    }
}
