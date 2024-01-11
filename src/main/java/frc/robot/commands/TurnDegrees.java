package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.RomiDrivetrain;

/* - An TurnTime autonomous command that instructs your Romi to turn for certain duration of time */
public class TurnDegrees extends CommandBase {
  // - Initializing Drivetrain, speed and duration variables
  private final RomiDrivetrain drive;
  private final double turnSpeed;
  private final double degrees;
  private long startTime;

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
    drive.arcadeDrive(0, 0);
  }

  @Override
  public void execute() {
    drive.arcadeDrive(0, turnSpeed);
  }

  @Override
  public void end(boolean interrupted) {}

  // - Following code copied from Example Romi project TurnDegrees command
  @Override
  public boolean isFinished() {
    /* Need to convert distance travelled to degrees. The Standard
       Romi Chassis found here, https://www.pololu.com/category/203/romi-chassis-kits,
       has a wheel placement diameter (149 mm) - width of the wheel (8 mm) = 141 mm
       or 5.551 inches. We then take into consideration the width of the tires.
    */
    double inchPerDegree = Math.PI * 5.551 / 360;
    // Compare distance travelled from start to distance based on degree turn
    return getAverageTurningDistance() >= (inchPerDegree * degrees);
  }

  private double getAverageTurningDistance() {
    double leftDistance = Math.abs(drive.getLeftDistanceInch());
    double rightDistance = Math.abs(drive.getRightDistanceInch());
    return (leftDistance + rightDistance) / 2.0;
  }

}
