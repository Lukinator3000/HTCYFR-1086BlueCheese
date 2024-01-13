// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.sensors.Gyro;

/* - Romi Drivetrain subsystem class that initializes and contains functions to interact with the motors, wheel measurements, 
 *    and sensors for other project files to utilize
*/
public class RomiDrivetrain extends SubsystemBase {
  private static final double kCountsPerRevolution = 1440.0;
  private static final double kWheelDiameterInch = 2.75591; // 70 mm

  // The Romi has the left and right motors set to
  // PWM channels 0 and 1 respectively
  private final Spark m_leftMotor = new Spark(0);
  private final Spark m_rightMotor = new Spark(1);

  // The Romi has onboard encoders that are hardcoded
  // to use DIO pins 4/5 and 6/7 for the left and right
  private final Encoder m_leftEncoder = new Encoder(4, 5);
  private final Encoder m_rightEncoder = new Encoder(6, 7);

  // Set up the differential drive controller
  private final DifferentialDrive m_diffDrive = new DifferentialDrive(m_leftMotor, m_rightMotor);

  private final Gyro gyro = new Gyro();

  /** Creates a new RomiDrivetrain. */
  public RomiDrivetrain() {
    // Use inches as unit for encoder distances
    m_leftEncoder.setDistancePerPulse((Math.PI * kWheelDiameterInch) / kCountsPerRevolution);
    m_rightEncoder.setDistancePerPulse((Math.PI * kWheelDiameterInch) / kCountsPerRevolution);
    resetEncoders();

    // Invert right side since motor is flipped
    m_rightMotor.setInverted(true);
  }

  public void arcadeDrive(double xaxisSpeed, double zaxisRotate) {
    m_diffDrive.arcadeDrive(xaxisSpeed, zaxisRotate);
  }

  public void resetEncoders() {
    m_leftEncoder.reset();
    m_rightEncoder.reset();
  }

  public double getLeftDistanceInch() {
    return m_leftEncoder.getDistance();
  }

  public double getRightDistanceInch() {
    return m_rightEncoder.getDistance();
  }

  // - Finds the mean of the distances (in inches) measured by both left and right encoders
  public double getAverageDistanceInch() {
    return (getLeftDistanceInch() + getRightDistanceInch()) / 2;
  }

  // - Methods to set speed on specific wheel motors to allow tank drivea
  public void setLeftMotor(double value) {
    m_leftMotor.set(value);
  }
  public void setRightMotor(double value) {
    m_rightMotor.set(value);
  }

  // - Getter methods for retrieving Romi angle measurements from the gyro object
  public double getGyroAngleX() {
    return gyro.getAngleX();
  }
  public double getGyroAngleY() {
    return gyro.getAngleY();
  }
  public double getGyroAngleZ() {
    return gyro.getAngleZ();
  }

  // - Function to reset Gyro measurements to 0
  public void resetGyro() {
    gyro.reset();
  }

  // This method will be called once per scheduler run
  @Override
  public void periodic() {
    // - Outputting Encoder distance measurements to SmartDashboard
    SmartDashboard.putNumber("Left Encoder Distance", getLeftDistanceInch());
    SmartDashboard.putNumber("Right Encoder Distance", getRightDistanceInch());

    // - Outputting Gyro angle measurements to SmartDashboard
    SmartDashboard.putNumber("Angle X", gyro.getAngleX());
    SmartDashboard.putNumber("Angle Y", gyro.getAngleY());
    SmartDashboard.putNumber("Angle Z", gyro.getAngleZ());
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
