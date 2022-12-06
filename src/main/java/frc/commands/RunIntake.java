package frc.commands;

import frc.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class RunIntake extends CommandBase {
    public RunIntake(boolean b, Intake intake) {
        if (b)
            intake.startIntaking(.75);
        else
            intake.stopIntaking();
    }
}
//max eats beans