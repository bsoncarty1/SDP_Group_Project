package sbw.project.cli.parser;
import sbw.project.cli.CommandLineInterface;
import sbw.project.cli.action.ActionSet;


public class Tester {

    public static void main(String[] args) {
        CommandLineInterface commandLineInterface = new CommandLineInterface();

        //Creational commands here:
        commandLineInterface.processInput("CREATE RUDDER id1 WITH LIMIT 10 SPEED 10 ACCELERATION 10");
    }

}
