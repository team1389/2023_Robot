package frc.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.subsystems.Climber;

public class ExtendLeftClimber extends CommandBase{
    private final Climber climber;
    public ExtendLeftClimber(Climber climber){
        this.climber = climber;
        addRequirements(climber);
    }

    @Override
    public void execute(){
        climber.controlArm(Climber.Position.Left, Climber.Action.Extend);
    }

    @Override
    public void end(boolean interupted){
        climber.endControl();
    }
}
