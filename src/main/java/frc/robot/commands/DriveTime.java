package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.RomiDrivetrain;

/* - An DriveTime autonomous command that instructs your Romi to drive for certain duration of time */
public class DriveTime extends CommandBase {
  // - Initializing Drivetrain, speed and duration variables
  private final RomiDrivetrain drive;
  private final double speed;
  private final double duration;
  private long startTime;

  /**
   * - Creates a new ArcadeDrive command
   *
   * @param subsystem The drivetrain subsystem used by this command.
   */
  public DriveTime(double speed, double seconds, RomiDrivetrain subsystem) {
    this.speed = speed; // - 'this' is used to clarify the speed variable from this class and not the constructor argument
    duration = seconds * 1000; // - The duration is measured in milliseconds, so seconds is multiplied by 1000
    drive = subsystem;
    addRequirements(subsystem);
  }

  @Override
  public void initialize() {
    startTime = System.currentTimeMillis(); // - Initializes the current time (in milliseconds) from the System clock to startTime
    drive.arcadeDrive(0, 0);
  }

  @Override
  public void execute() {
    drive.arcadeDrive(speed, 0);
  }

  @Override
  public void end(boolean interrupted) {}

  // - When the time inputted has elapsed, 'isFinished()' returns true and ends the command
  @Override
  public boolean isFinished() {
    // - When the difference between the current time and start time reaches duration, it returns true
    return (System.currentTimeMillis() - startTime) >= duration;
  }

}
