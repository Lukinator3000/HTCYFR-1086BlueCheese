// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.Command;

/* - A TurnDegrees autonomous command that instructs your Romi to turn until it reaches a certain number of degrees rotated */
public class TurnDegrees extends Command {
  private final Drivetrain m_drive;
  private final double m_degrees;
  private final double m_speed;

  /**
   * Creates a new TurnDegrees. This command will turn your robot for a desired rotation (in
   * degrees) and rotational speed.
   *
   * @param speed The speed which the robot will drive. Negative is in reverse.
   * @param degrees Degrees to turn. Leverages encoders to compare distance.
   * @param drive The drive subsystem on which this command will run
   */
  public TurnDegrees(double speed, double degrees, Drivetrain drive) {
    m_degrees = degrees;
    m_speed = speed;
    m_drive = drive;
    addRequirements(drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // Set motors to stop, read encoder values for starting point
    m_drive.arcadeDrive(0, 0);
    m_drive.resetEncoders(); // - Resets drivetrain encoder measurements back to 0
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drive.arcadeDrive(0, m_speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drive.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    /* Need to convert distance travelled to degrees. The Standard
       Romi Chassis found here, https://www.pololu.com/category/203/romi-chassis-kits,
       has a wheel placement diameter (149 mm) - width of the wheel (8 mm) = 141 mm
       or 5.551 inches. We then take into consideration the width of the tires.
    */
    double inchPerDegree = Math.PI * 5.551 / 360;
    
    // Compare distance travelled from start to distance based on degree turn
    // - Returns true if the amount of rotational difference (in Z axis) since the start reaches the desired number of degrees
    return getAverageTurningDistance() >= (inchPerDegree * m_degrees);

    /*
     * - You also use the Romi gyro angle measurements to return true if the rotational displacement (in Z axis) 
     *    reaches the desired number of degrees. Here's a statement to do so:
     *    
     *    return Math.abs(drive.getGyroAngleZ()) >= degrees - 5;
     * 
     *    (Note: I added the "- 5" to act as an offset to negate my Romi's gyro measurement drift. You can edit/remove it if your
     *            Romi's Gyro doesn't have drift or has it at a different amount of it than mine.)
     */
  }

  private double getAverageTurningDistance() {
    double leftDistance = Math.abs(m_drive.getLeftDistanceInch());
    double rightDistance = Math.abs(m_drive.getRightDistanceInch());
    return (leftDistance + rightDistance) / 2.0;
  }
}
