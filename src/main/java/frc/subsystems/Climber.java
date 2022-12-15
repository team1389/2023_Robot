package frc.subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class Climber extends SubsystemBase {
    private TalonSRX rightClimberMotor;
    private TalonSRX leftClimberMotor;
    private DoubleSolenoid leftSolenoid;
    private DoubleSolenoid rightSolenoid;

    public enum Position {
        Left,
        Right
    }

    public enum Action {
        Extend,
        Retract
    }

    public Climber() {
        rightClimberMotor = new TalonSRX(RobotMap.RIGHT_CLIMB_MOTOR);
        leftClimberMotor = new TalonSRX(RobotMap.LEFT_CLIMB_MOTOR);
        leftSolenoid = new DoubleSolenoid(PneumaticsModuleType.REVPH, RobotMap.LEFT_CLIMBER_FORWARD_SOLENOID,
                RobotMap.LEFT_CLIMBER_REVERSE_SOLENOID);
        rightSolenoid = new DoubleSolenoid(PneumaticsModuleType.REVPH, RobotMap.RIGHT_CLIMBER_FORWARD_SOLENOID,
                RobotMap.RIGHT_CLIMBER_REVERSE_SOLENOID);
    }

    public void controlArm(Position pos, Action act) {
        TalonSRX motor;
        switch (pos) {
            case Left:
                motor = leftClimberMotor;
                break;
            case Right:
            default:
                motor = rightClimberMotor;
        }
        switch (act) {
            case Extend:
                motor.set(TalonSRXControlMode.Position, 0.3);
            case Retract:
                motor.set(TalonSRXControlMode.Position, -0.3);
        }
    }

    public void swingArm(Position pos, Action act) {
        DoubleSolenoid solenoid;
        switch (pos) {
            case Left:
                solenoid = leftSolenoid;
                break;
            case Right:
            default:
                solenoid = rightSolenoid;
        }
        switch (act) {
            case Extend:
                solenoid.set(Value.kForward);
            case Retract:
                solenoid.set(Value.kReverse);
        }
    }
    
    public void endControl(){
        leftClimberMotor.set(TalonSRXControlMode.Position, 0.0);
        rightClimberMotor.set(TalonSRXControlMode.Position, 0.0);
    }
    public void endSwing(){
        leftSolenoid.set(Value.kOff);
        rightSolenoid.set(Value.kOff);
    }
}