package Commands;

import sbw.architecture.datatype.Identifier;
import sbw.project.components.actuator.rudder.A_ActuatorRudder;
import sbw.project.components.controller.ControllerRudder;

public class StructuralCommands {

    public void doDeclareRudderController(Identifier id1, A_ActuatorRudder id2){
        ControllerRudder controllerRudder = new ControllerRudder(id1,id2);

    }


}
