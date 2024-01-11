package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.subsystems.RomiDrivetrain;

public class TurnDegreesPID extends CommandBase {
  // - Initializing Drivetrain, PID controller, and supplier variables
  private RomiDrivetrain drive;
  private PIDController pid;
  private DoubleSupplier measurement;

  /**
   * - Turns robot to the specified angle using a PID feedback loop
   *
   * @param targetAngleDegrees The angle to turn to
   * @param drive The drive subsystem to use
  */
  public TurnDegreesPID(double targetAngle, RomiDrivetrain drive, PIDController pidInput) {
    this.drive = drive;
    measurement = () -> drive.getGyroAngleZ();
    pid = pidInput;

    // - Establishes targetAngle as the setpoint for the PID controller
    pid.setSetpoint(targetAngle);
    // - Enables the controller to be continuous, specifically for angle PIDs
    pid.enableContinuousInput(-180, 180); 
    // - Sets the controller tolerance so the command ends when Romi is within range of targetAngle by 1 degree
    pid.setTolerance(1); 

    SmartDashboard.putNumber("PID Calc", getSpeedCalc());
    SmartDashboard.putNumber("Current Angle", measurement.getAsDouble());
    SmartDashboard.putNumber("Setpoint", pid.getSetpoint());
    SmartDashboard.putData("Turn PID Controller", pid);
  }

  @Override
  public void initialize() {
    pid.reset(); // - Resets previous error (distance from setpoint) in PID controller
    drive.resetGyro(); // - Resets Gyro angle measurements to zero
    drive.arcadeDrive(0, 0);
  }

  @Override
  public void execute() {
    drive.arcadeDrive(0, getSpeedCalc());

    // - Outputting PID loop values to SmartDashboard
    SmartDashboard.putNumber("PID calc", getSpeedCalc());
    SmartDashboard.putNumber("Setpoint", pid.getPositionError());
    SmartDashboard.putNumber("AngleMeas", measurement.getAsDouble());
    SmartDashboard.putNumber("Error", pid.getPositionError()); // Outputs the current difference between measurement & setpoint
    SmartDashboard.putBoolean("Finished", isFinished()); // Outputs true on SmartDashboard when the PID loop ends
  }

  // - PID controller calculates the next speed value based on how close measurement is to the setpoint
  public double getSpeedCalc() {
    // - 'clamp()' limits the calculation to no lower than argument 'low' and no higher than argument 'high'
    return MathUtil.clamp( 
      -pid.calculate(measurement.getAsDouble(), pid.getSetpoint()), -1 /* - Low bound */, 1 /* - High bound */);
  }

  @Override
  public void end(boolean interrupted) {
    drive.arcadeDrive(0, 0);
  }

  // - Ends when the controller is at the reference.
  @Override
  public boolean isFinished() {
    return pid.atSetpoint(); // - Returns true if the calculated angle measurement is within tolerance range of the setpoint
  }
}
