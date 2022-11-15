package frc.subsystems;

import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import com.revrobotics.CANSparkMaxLowLevel;


public class Hopper extends SubsystemBase{
    private CANSparkMax hopperMotor;

    public Hopper(){
        hopperMotor = new CANSparkMax(RobotMap.HOPPER_MOTOR, CANSparkMaxLowLevel.MotorType.kBrushless);
    }
    
    //power is from -1 to 1
    public void setSpeed(double power){
        hopperMotor.set(power);
    }
}