package frc.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
public class Shooter extends SubsystemBase{
    private CANSparkMax shooterMotor;
    public Shooter() {
        shooterMotor = new CANSparkMax(RobotMap.SHOOTER_MOTOR, CANSparkMaxLowLevel.MotorType.kBrushless);
    }
    public void startShooter(double shotPercent){
        shooterMotor.set(shotPercent);
    }
    public void stopShooter() {
        shooterMotor.set(0);
    }
}
