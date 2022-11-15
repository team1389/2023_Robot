package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.commands.RunIntake;
import frc.subsystems.Intake;

public class OI {
    private JoystickButton manipXBtn, manipYBtn, manipABtn, manipBBtn;
    private Intake intake =  new Intake();
    public XboxController driveController, manipController;

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
        manipXBtn.whenPressed(new RunIntake(true,intake));
        manipXBtn.whenReleased(new RunIntake(false,intake));
    }



}