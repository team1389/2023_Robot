package frc.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
public class Indexer extends SubsystemBase{
    private CANSparkMax indexerMotor;
    public Indexer() {
        indexerMotor = new CANSparkMax(RobotMap.INDEXER_MOTOR, CANSparkMaxLowLevel.MotorType.kBrushless);
    }
    public void startIndexing(double intakePercent){
        indexerMotor.set(intakePercent);
    }
    public void stopIndexing() {
        indexerMotor.set(0);
    }
}
