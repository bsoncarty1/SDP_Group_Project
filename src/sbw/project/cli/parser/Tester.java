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
    }

}
