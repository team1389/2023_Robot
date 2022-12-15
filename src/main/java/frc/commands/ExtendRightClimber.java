package frc.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.subsystems.Climber;

public class ExtendRightClimber extends CommandBase{
    private final Climber climber;
    public ExtendRightClimber(Climber climber){
        this.climber = climber;
        addRequirements(climber);
    }

    @Override
    public void execute(){
        climber.controlArm(Climber.Position.Right, Climber.Action.Extend);
    }

    @Override
    public void end(boolean interupted){
        climber.endControl();
    }
}
