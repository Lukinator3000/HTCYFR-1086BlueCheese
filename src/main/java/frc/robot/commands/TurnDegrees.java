package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.RomiDrivetrain;

/* - A TurnDegrees autonomous command that instructs your Romi to turn until it reaches a certain number of degrees rotated */
public class TurnDegrees extends CommandBase {
  // - Initializing Drivetrain, turn speed and desired degrees variables
  private final RomiDrivetrain drive;
  private final double turnSpeed;
  private final double degrees;

  /**
   * - Creates a new TurnTime command
   *
   * @param subsystem The drivetrain subsystem used by this command.
   */
  public TurnDegrees(double turnSpeed, double degrees, RomiDrivetrain subsystem) {
    this.turnSpeed = turnSpeed; // - 'this' is used to clarify the speed variable from this class and not the constructor argument
    this.degrees = degrees; // - - Likewise, 'this' signifies the degrees variable from this class
    drive = subsystem;
    addRequirements(subsystem);
  }

  @Override
  public void initialize() {
    drive.resetGyro(); // - Resets drivetrain gyro measurements back to 0
    drive.arcadeDrive(0, 0);
  }

  @Override
  public void execute() {
    drive.arcadeDrive(0, turnSpeed);
  }

  @Override
  public void end(boolean interrupted) {
    drive.arcadeDrive(0, 0);
  }

  @Override
  public boolean isFinished() {
    // - Returns true if the amount of rotational difference (in Z axis) since the start reaches the desired number of degrees
    return Math.abs(drive.getGyroAngleZ()) >= degrees;
  }

}
