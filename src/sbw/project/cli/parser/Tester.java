package sbw.project.cli.parser;
import sbw.project.cli.CommandLineInterface;
import sbw.project.cli.action.ActionSet;


public class Tester {

    public static void main(String[] args) {
        CommandLineInterface commandLineInterface = new CommandLineInterface();

        //Creational commands here:
        commandLineInterface.processInput("CREATE RUDDER rudder1 WITH LIMIT 45 SPEED 10 ACCELERATION 0.1");
        commandLineInterface.processInput("CREATE ELEVATORS elevator1 AND elevator2 WITH LIMIT 30, SPEED 10, AND ACCELERATION 0.1");
        commandLineInterface.processInput("CREATE ELEVATOR elevator3 WITH LIMIT 30, SPEED 10 ACCELERATION 0.15");
        commandLineInterface.processInput("CREATE AILERONS aileron1 AND aileron2 WITH RESPECTIVE UP AND DOWN " +
                "LIMITS 90 AND 40, SPEED 5, AND ACCELERATION 0.1");
        commandLineInterface.processInput("CREATE AILERONS aileron3 AND aileron4 WITH RESPECTIVE UP AND DOWN " +
                "LIMITS 90 AND 30, SPEED 5, AND ACCELERATION 0.15");
        commandLineInterface.processInput("CREATE SPLIT FLAPS flap_split1 AND flap_split2 WITH LIMIT 50, " +
                "SPEED 5, AND ACCELERATION 0.15");
        commandLineInterface.processInput("CREATE FOWLER FLAPS flap_fowler1 AND flap_fowler2 WITH LIMIT 55, " +
                "SPEED 4, AND ACCELERATION 0.1");
        commandLineInterface.processInput("CREATE ENGINES engine1, engine2, AND engine3 WITH SPEED 10 AND " +
                "ACCELERATION 0.2");
        commandLineInterface.processInput("CREATE AN ENGINE engine4 WITH SPEED 10 AND ACCELERATION 0.25");
        commandLineInterface.processInput("CREATE A NOSE GEAR gear-nose1 WITH SPEED 10 AND ACCELERATION 0.1");
        commandLineInterface.processInput("CREATE A MAIN GEAR gear-main3 WITH SPEED 10 AND ACCELERATION 0.2");
    }

}
