package frc.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.subsystems.Shooter;


public class Shoot extends CommandBase{
    private Shooter shooter;

    public Shoot(Shooter shooter) {
        this.shooter = shooter;

        addRequirements(shooter);
    }

    @Override
    public void execute(){
        shooter.startShooter(.8);
    }
    @Override
    public void end(boolean interrupted){
        shooter.stopShooter();
    }
}
