package sbw.project.cli.parser;

import sbw.project.cli.CommandLineInterface;
import sbw.project.cli.action.ActionSet;

public class Tester {

    public static void main(String[] args) {
	CommandLineInterface commandLineInterface = new CommandLineInterface();

	// I. CREATIONAL
	// For each creational test, show the corresponding command(s). Teams of three
	// do the test in each group with only one test and choose twotests from each
	// other group; teams of two choose one from each group. Think about your
	// choices here with respect to (II) and (III).
	/********************
	 * A. Rudder
	 ********************/
	// 1. Create a rudder rudder1 with limit 45, speed 10, and acceleration 0.1.
	commandLineInterface.processInput("CREATE RUDDER rudder1 WITH LIMIT 45 SPEED 10 ACCELERATION 0.1");

	/********************
	 * B. Elevator
	 ********************/
	// 1. Create elevators elevator1 and elevator2 with limit 30, speed 10, and
	// acceleration 0.1.
	commandLineInterface
		.processInput("CREATE ELEVATORS elevator1 AND elevator2 WITH LIMIT 30, SPEED 10, AND ACCELERATION 0.1");
	// 2. Create an elevator elevator3 with limit 30, speed 10, and acceleration
	// 0.15.
	commandLineInterface.processInput("CREATE ELEVATOR elevator3 WITH LIMIT 30, SPEED 10 ACCELERATION 0.15");

	/********************
	 * C. Aileron
	 ********************/
	// 1. Create ailerons aileron1 and aileron2 with respective up and down limits
	// 90 and 40, speed 5, and acceleration 0.1.
	commandLineInterface.processInput(
		"CREATE AILERONS aileron1 AND aileron2 WITH RESPECTIVE UP AND DOWN LIMITS 90 AND 40, SPEED 5, AND ACCELERATION 0.1");
	// 2. Create ailerons aileron3 and aileron4 with respective up and down limits
	// 90 and 30, speed 5, and acceleration 0.15.
	commandLineInterface.processInput(
		"CREATE AILERONS aileron3 AND aileron4 WITH RESPECTIVE UP AND DOWN LIMITS 90 AND 30, SPEED 5, AND ACCELERATION 0.15");
	// 3. Create ailerons aileron5 and aileron6 with respective up and down limits
	// 90 and 35, speed 5, and acceleration 0.2.
	// 4. Create ailerons aileron7 and aileron8 with respective up and down limits
	// 90 and 45, speed 6, and acceleration 0.25.

	/********************
	 * D. Flap
	 ********************/
	// 1. Create split flaps flap_split1 and flap_split2 with limit 50, speed 5, and
	// acceleration 0.15.
	commandLineInterface.processInput(
		"CREATE SPLIT FLAPS flap_split1 AND flap_split2 WITH LIMIT 50, SPEED 5, AND ACCELERATION 0.15");
	// 2. Create a split flap flap_split3 with limit 50, speed 4, and acceleration
	// 0.15.
	commandLineInterface.processInput(
		"CREATE FOWLER FLAPS flap_fowler1 AND flap_fowler2 WITH LIMIT 55, SPEED 4, AND ACCELERATION 0.1");
	// 3. Create Fowler flaps flap_fowler1 and flap_fowler2 with limit 55, speed 4,
	// and acceleration 0.1.
	// 4. Create a Fowler flap flap_fowler3 with limit 50, speed 4, and acceleration
	// 0.1.

	/********************
	 * E. Engine
	 ********************/
	// 1. Create engines engine1, engine2, and engine3 with speed 10 and
	// acceleration 0.2.
	commandLineInterface
		.processInput("CREATE ENGINES engine1, engine2, AND engine3 WITH SPEED 10 AND ACCELERATION 0.2");
	// 2. Create an engine engine4 with speed 10 and acceleration 0.25.
	commandLineInterface.processInput("CREATE AN ENGINE engine4 WITH SPEED 10 AND ACCELERATION 0.25");

	/********************
	 * F. Gear
	 ********************/
	// 1. Create a nose gear gear_nose1 with speed 10 and acceleration 0.1.
	commandLineInterface.processInput("CREATE A NOSE GEAR gear-nose1 WITH SPEED 10 AND ACCELERATION 0.1");
	// 2. Create a nose gear gear_nose2 with speed 10 and acceleration 0.15.
	// 3. Create main gear gear_main1 and gear_main2 with speed 10 and acceleration
	// 0.1.
	// 4. Create a main gear gear_main3 with speed 10 and acceleration 0.2.
	commandLineInterface.processInput("CREATE A MAIN GEAR gear-main3 WITH SPEED 10 AND ACCELERATION 0.2");

	// II. STRUCTURAL
	// For each structural test, show the corresponding command(s) and any error
	// message. Run each separately with the
	// appropriate creational setup from Section I, but do not repeat the setup
	// commands in the report.
	// Teams of three do the test in each group with only one test and choose two
	// tests from each other group; teams of two
	// choose one from each group. Think about your choices here with respect to
	// (III).
	/********************
	 * A. Rudder
	 ********************/
	// Declare a rudder controller rudder_controller1 with rudder1.
	commandLineInterface.processInput("DECLARE RUDDER CONTROLLER rudder_controller1 WITH RUDDER rudder1");

	/********************
	 * B. Elevator
	 ********************/
	// Declare an elevator controller elevator_controller1 with elevator1 and
	// elevator2.
	commandLineInterface
		.processInput("DECLARE ELEVATOR CONTROLLER elevator_controller1 WITH ELEVATORS elevator1 elevator2");
	// Declare an invalid elevator controller elevator_controller2 with elevator1
	// and elevator3.
	commandLineInterface
		.processInput("DECLARE ELEVATOR CONTROLLER elevator_controller2 WITH ELEVATORS elevator1 elevator3");

	/********************
	 * C. Aileron
	 ********************/
	// Declare an aileron controller aileron_controller1 with ailerons aileron1
	// (primary) and aileron2.
	commandLineInterface.processInput(
		"DECLARE AILERON CONTROLLER aileron_controller1 WITH AILERONS aileron1 aileron2 PRIMARY aileron1");
	// Declare an aileron controller aileron_controller2 with ailerons aileron1
	// (primary), 3, 5, 7, then 8, 6, 4, 2.
	commandLineInterface.processInput(
		"DECLARE AILERON CONTROLLER aileron_controller2 WITH AILERONS aileron1 aileron2 PRIMARY aileron1");
	// Declare an aileron controller aileron_controller4 with ailerons aileron1, 3
	// (primary), 5, 7, then 8, 6, 4, 2, with 7 mixed at 80% of 3, 5 at 50% of 7,
	// and 1 at 75% of 5.
	// Declare an invalid (?) aileron controller aileron_controller5 with ailerons
	// aileron1 and aileron2 (primary).
	// Declare an invalid aileron controller aileron_controller6 with ailerons
	// aileron1 (primary) and 3, then 2 and 5.

	/********************
	 * D. Flap
	 ********************/
	// Declare a flap controller flap_controller1 with flap_split1 and flap_split2.
	commandLineInterface
		.processInput("DECLARE FLAP CONTROLLER flap_controller1 WITH FLAPS flap_split1 flap_split2");
	// Declare an invalid flap controller flap_controller2 with flap_split1 and
	// flap_split3.
	// Declare a flap controller flap_controller4 with flap_fowler1 and flap_fowler2
	// inboard and flap_split1 and flap_split2 outboard.
	// Declare an invalid flap controller flap_controller5 with flap_fowler1 and
	// flap_split2 inboard and flap_split1 and flap_fowler2 outboard

	/********************
	 * E. Engine
	 ********************/
	// Declare an engine controller engine_controller1 with engine1.
	commandLineInterface.processInput("DECLARE ENGINE CONTROLLER engine_controller1 WITH ENGINE engine1");
	// Declare an engine controller engine_controller2 with engine1 and engine2.
	// Declare an engine controller engine_controller3 with engine1, engine2, and
	// engine3.

	/********************
	 * F. Gear
	 ********************/
	// Declare a gear controller gear_controller1 with nose gear gear_nose2 and main
	// gear gear_main1 and gear_main2.
	commandLineInterface.processInput(
		"DECLARE GEAR CONTROLLER gear_controller1 WITH GEAR NOSE gear_nose2 MAIN gear_main1 gear_main2");

// III. BEHAVIORAL
// For each behavioral test (number), show the corresponding creational, structural, and behavioral commands and any error
// message. Restart between actuator sections (capital letters). Each test must be done sequentially to completion, unless
// otherwise indicated (e.g., III.A.4), and no delay between tests should appear in the graph. Use the @WAIT command to adjust
// the timing, and consider using @EXIT temporarily to establish when events occur.
// Use the values in columns A, F, and O in log.csv (hint: sort ascending by M and I, and consider using filters) to generate a
// single labeled line graph for the results of each section, with individual actuators as separate, continuous lines of different
// color and the point where each test started clearly identified. Mention if lines obscure one another. For example:
// 1. At initial position 0° neutral; command to 45° left
// 2. Arrives; command to 45° right
// 3. Arrives; command to 0°
// 4. Arrives; command to 30° left
// 5. At 15° left preemptively command to 45° right
// 6. Arrives
// For which a corresponding behavioral performance graph may look like this:
// You may find that some creativity in Excel makes your life easier. The structure of log.csv facilitates extracting relevant
// data, but you still need to fuse it and format it appropriately for professional presentation.
// Identify and discuss any deviation from the expected results. If there is no deviation, indicate that the test was successful.
// Clearly indicate if your implementation is incomplete or does not work.
// Teams of three choose 12 tests in total, but not more than one from each group; teams of two choose 8 the same way.

	/********************
	 * A. Rudder
	 ********************/
	// 1. Deflect rudder_controller1 left full.
	commandLineInterface.processInput("DO rudder_controller1 DEFLECT RUDDER " + Angle.MAX.getValue() + " LEFT");
	// 2. Deflect rudder_controller1 right full.
	// commandLineInterface.processInput("DO rudder_controller1 DEFLECT RUDDER " +
	// Angle.MAX.getValue() + " RIGHT");
	// 3. Deflect rudder_controller1 neutral.
	// 4. (a) Deflect rudder_controller1 left 30, but at close to –15 degrees, (b)
	// deflect right full.

	/********************
	 * B. Elevator I
	 ********************/
	// 1. Deflect elevator_controller1 up full.
	commandLineInterface.processInput("DO elevator_controller1 DEFLECT ELEVATOR " + Angle.MAX.getValue() + " UP");
	// 2. Deflect elevator_controller1 down full.

	/********************
	 * C. Elevator II
	 ********************/
	// 1. Deflect elevator_controller2 up full.
	// commandLineInterface.processInput("DO elevator_controller2 DEFLECT ELEVATOR "
	// + Angle.MAX.getValue() + " UP");
	// 2. Deflect elevator_controller2 down full.

	/********************
	 * D. Aileron I
	 ********************/
	// 1. Deflect aileron_controller2 up 45.
	commandLineInterface.processInput("DO aileron_controller2 DEFLECT AILERONS 45 UP");

	// 2. Deflect aileron_controller2 down 30.

	/********************
	 * E. Aileron II
	 ********************/
	// 1. Deflect aileron_controller4 up 45.
	commandLineInterface.processInput("DO aileron_controller4 DEFLECT AILERONS 45 UP");

	// 2. Deflect aileron_controller4 down 30.

	/********************
	 * F. Aileron III
	 ********************/
	// 1. Deflect aileron_controller5 up 45.
	commandLineInterface.processInput("DO aileron_controller5 DEFLECT AILERONS 45 UP");

	// 2. Deflect aileron_controller5 down 30.
	// 3. Deflect aileron_controller5 to 0.

	/********************
	 * G. Aileron IV
	 ********************/
	// 1. Deflect aileron_controller6 up 45.
	commandLineInterface.processInput("DO aileron_controller6 DEFLECT AILERONS 45 UP");

	// 2. Deflect aileron_controller6 down 30.
	// 3. Deflect aileron_controller6 to 0.

	/********************
	 * H. Speed Brake
	 ********************/
	// 1. Extend the speed brakes on aileron_controller4.
	commandLineInterface.processInput("DO aileron_controller4 SPEED BRAKE ON");

	// 2. Deflect aileron_controller4 down 0.

	/********************
	 * I. Flap I
	 ********************/
	// 1. Deflect flap_controller4 position 4.
	commandLineInterface.processInput("DO flap_controller4 DEFLECT FLAP 4");

	// 2. Deflect flap_controller4 position 3.
	// 3. Deflect flap_controller4 position up.

	/********************
	 * J. Flap II
	 ********************/
	// 1. Deflect flap_controller2 position 3.
	commandLineInterface.processInput("DO flap_controller2 DEFLECT FLAP 3");

	// 2. Deflect flap_controller2 position up.

	/********************
	 * K. Flap III
	 ********************/
	// 1. Deflect flap_controller5 position 4.
	commandLineInterface.processInput("DO flap_controller5 DEFLECT FLAP 4");

	// 2. Deflect flap_controller5 position up.

	/********************
	 * L. Engine
	 ********************/
	// 1. Set engine_controller3 all engines to 70% power.
	commandLineInterface.processInput("DO engine_controller3 SET POWER 70");

	// 2. Set engine_controller3 only engine2 to 40% power.
//		commandLineInterface.processInput("DO engine_controller3 SET POWER 40 ENGINE engine2");

	// 3. Set engine_controller3 to 100% power.
//     commandLineInterface.processInput("DO engine_controller3 SET POWER 100");

	/********************
	 * M. Gear
	 ********************/
	// 1. Lower gear_controller1.
	commandLineInterface.processInput("DO gear_controller1 GEAR DOWN");
	// 2. (a) Raise gear_controller1, but at close to 50% on the main gear, (b)
	// submit a halt
	// (a) #TODO: not sure on this
//     commandLineInterface.processInput("DO gear_controller1 GEAR UP");

	// (b) #TODO: not sure on this
//     commandLineInterface.processInput("HALT gear_controller1");

    }

}
