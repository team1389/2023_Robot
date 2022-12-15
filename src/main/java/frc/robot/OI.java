package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.commands.*;
import frc.subsystems.*;
import frc.subsystems.Intake;

public class OI {
    private JoystickButton manipXBtn, manipYBtn, manipABtn, manipBBtn, lBumperButton, rBumperButton, manipRTrigger, manipLTrigger;
    private Intake intake = new Intake();
    private Shooter shooter = new Shooter();
    private Indexer indexer = new Indexer();
    public XboxController driveController, manipController;
    private Hopper hopper = new Hopper();
    private Climber climber = new Climber();

    public OI() {
        initControllers();

    }

    /*
     * Initialize JoystickButtons and Controllers
     */
    
    private void initControllers() {
        driveController = new XboxController(0);
        manipController = new XboxController(1);
        manipXBtn = new JoystickButton(manipController, XboxController.Button.kX.value);

        manipYBtn = new JoystickButton(manipController, XboxController.Button.kY.value);
        manipYBtn.whenPressed(new RunHopper(hopper));
        manipYBtn.whenReleased(new RunHopper(hopper));
        manipXBtn.whileHeld(new RunIntake(intake));
        manipABtn = new JoystickButton(manipController, XboxController.Button.kA.value);
        manipABtn.whileHeld(new Shoot(shooter));
        manipABtn.whileHeld(new RunIndexer(indexer));

        lBumperButton = new JoystickButton(manipController, XboxController.Button.kLeftBumper.value);
        lBumperButton.whenPressed(new ExtendLeftClimber(climber));
        lBumperButton.whenReleased(new ExtendLeftClimber(climber));

        rBumperButton = new JoystickButton(manipController, XboxController.Button.kRightBumper.value);
        rBumperButton.whenPressed(new ExtendRightClimber(climber));
        rBumperButton.whenReleased(new ExtendRightClimber(climber));

        manipRTrigger = new JoystickButton(manipController, XboxController.Axis.kRightTrigger.value);
        manipRTrigger.whenPressed(new RetractRightClimber(climber));
        manipRTrigger.whenReleased(new RetractRightClimber(climber));

        manipLTrigger = new JoystickButton(manipController, XboxController.Axis.kLeftTrigger.value);
        manipLTrigger.whenPressed(new RetractLeftClimber(climber));
        manipLTrigger.whenReleased(new RetractLeftClimber(climber));
    }
}