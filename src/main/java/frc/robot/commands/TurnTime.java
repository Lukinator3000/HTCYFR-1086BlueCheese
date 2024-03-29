package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.RomiDrivetrain;

/* - A TurnTime autonomous command that instructs your Romi to turn for certain duration of time */
public class TurnTime extends Command {
  // - Initializing Drivetrain, speed and duration variables
  private final RomiDrivetrain drive;
  private final double turnSpeed;
  private final double duration;
  private long startTime;

  /**
   * - Creates a new TurnTime command
   *
   * @param speed The turn speed value given.
   * @param seconds The number of seconds the command will last.
   * @param subsystem The drivetrain subsystem used by this command.
   */
  public TurnTime(double turnSpeed, double seconds, RomiDrivetrain subsystem) {
    this.turnSpeed = turnSpeed; // - 'this' is used to clarify the speed variable from this class and not the constructor argument
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
    drive.arcadeDrive(0, turnSpeed);
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
