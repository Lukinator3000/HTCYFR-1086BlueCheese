package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.RomiDrivetrain;

/* - A DriveDistance autonomous command that instructs your Romi to drive until it reaches a certain distance (in inches) */
public class DriveDistance extends CommandBase {
  // - Initializing Drivetrain, turn speed and desired degrees variables
  private final RomiDrivetrain drive;
  private final double speed;
  private final double distance;

  /**
   * - Creates a new DriveDistance command
   *
   * @param speed The speed value given.
   * @param inches The number of inches the Romi is intended to travel.
   * @param subsystem The drivetrain subsystem used by this command.
   */
  public DriveDistance(double speed, double inches, RomiDrivetrain subsystem) {
    this.speed = speed; // - 'this' is used to clarify the speed variable from this class and not the constructor argument
    distance = inches;
    drive = subsystem;
    addRequirements(subsystem);
  }

  @Override
  public void initialize() {
    drive.resetEncoders(); // Resets drivetrain encoder measurements back to 0
    drive.arcadeDrive(0, 0);
  }

  @Override
  public void execute() {
    drive.arcadeDrive(speed, 0);
  }

  @Override
  public void end(boolean interrupted) {
    drive.arcadeDrive(0, 0);
  }

  @Override
  public boolean isFinished() {
    // - Returns true if the distance travelled since the start reaches the desired distance (in inches)
    return Math.abs(drive.getAverageDistanceInch()) >= distance;
  }

}
