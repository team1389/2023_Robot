package frc.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.subsystems.Climber;

public class RetractRightClimber extends CommandBase{
    private final Climber climber;
    public RetractRightClimber(Climber climber){
        this.climber = climber;
        addRequirements(climber);
    }

    @Override
    public void execute(){
        climber.controlArm(Climber.Position.Right, Climber.Action.Retract);
    }

    @Override
    public void end(boolean interupted){
        climber.endSwing();
    }
}
