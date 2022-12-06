package frc.commands;

import frc.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class RunIntake extends CommandBase {
    private Intake intake;

    public RunIntake(Intake intake) {
        this.intake = intake;

        addRequirements(intake);
    }

    @Override
    public void execute(){
        intake.startIntaking(.5);
    }
    @Override
    public void end(boolean interrupted){
        intake.stopIntaking();
    }
}
//max eats beans