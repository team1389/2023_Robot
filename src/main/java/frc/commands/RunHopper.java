
package frc.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.subsystems.Hopper;

public class RunHopper extends CommandBase{
    private final Hopper hopper;
    public RunHopper(Hopper hopper){
        this.hopper = hopper;
        addRequirements(hopper);
    }

    @Override
    public void execute(){
        hopper.setSpeed(0.5);
    }

    @Override
    public void end(boolean interupted){
        hopper.setSpeed(0.0);
    }
}
