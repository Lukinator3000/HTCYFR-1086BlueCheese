// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.DriveTime;
import frc.robot.commands.TankDrive;
import frc.robot.commands.TurnTime;
import frc.robot.subsystems.RomiDrivetrain;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined (- and initialized) here...
  private final RomiDrivetrain romiDrivetrain = new RomiDrivetrain();

  // - Depending on which port your designated controller is connected to, change the port number to it in the parentheses
  private final Joystick controller = new Joystick(0);
  private final CommandXboxController xbox = new CommandXboxController(0);

  private final SendableChooser<Command> chooser = new SendableChooser<>();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link edu.wpi.first.wpilibj.GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // - Set ArcadeDrive as the default command, which runs automatically unless another command is scheduled before it
    romiDrivetrain.setDefaultCommand(
      new ArcadeDrive(
        romiDrivetrain, () -> -controller.getRawAxis(1), () -> -controller.getRawAxis(0))
        // - Empty parentheses followed by a lambda or "() -> ..." allow the controller function return value to act as a Supplier
    );
    
    // - When the 'a' button of the Xbox controller is pressed, this code toggles on (or off) the TankDrive command
    xbox.a().toggleOnTrue(
      new TankDrive(romiDrivetrain, () -> xbox.getHID().getLeftTriggerAxis(), () -> xbox.getHID().getRightTriggerAxis()));
    /*
    // - If you don't have a Xbox controller, comment out "xbox.a()..." part above and delete the multi-line comments for this code
    new JoystickButton(controller, 1).toggleOnTrue(
      new TankDrive(romiDrivetrain, () -> controller.getRawAxis(2), () -> controller.getRawAxis(3)));
    */

    // - Adding the command options to select from in SendableChooser, DriveTime being the default that's already selected
    chooser.setDefaultOption("Drive Time Auto", new DriveTime(0.5, 2, romiDrivetrain));
    chooser.addOption("Turn Time Auto", new TurnTime(0.5, 2, romiDrivetrain));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // - The command selected by the SendableChooser on SmartDashboard will run in autonomous
    return chooser.getSelected();
  }
}
