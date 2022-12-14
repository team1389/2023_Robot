package frc.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
public class Intake extends SubsystemBase{
    private CANSparkMax intakeMotor;
    /*private DoubleSolenoid leftExtender;
    private DoubleSolenoid rightExtender;
    private boolean intakeExtended = false;*/
    public Intake() {
        intakeMotor = new CANSparkMax(RobotMap.INTAKE_MOTOR, CANSparkMaxLowLevel.MotorType.kBrushless);
    }
    public void startIntaking(double intakePercent){
        intakeMotor.set(intakePercent);
    }
    public void stopIntaking() {
        intakeMotor.set(0);
    }
}