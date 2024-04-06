package frc.robot.commands;

// - Automatically written imports
import java.util.function.Supplier;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;

/* - A TurnDegrees autonomous command that instructs your Romi to turn until it reaches a certain number of degrees rotated */
public class TurnDegreesPID extends Command {
  // - Initializing Drivetrain, PID controller, and supplier variables
  private final Drivetrain drive;
  private final Supplier<Double> measurement;
  private final PIDController pid = new PIDController(0, 0, 0);

  /**
   * - Turns robot to the specified angle using a PID feedback loop
   *
   * @param targetAngle The angle to turn to.
   * @param drive The drive subsystem to use.
   * @param pidInput The PID Controller to calculate turn speed based on the relationship between current and target angle. 
  */
  public TurnDegreesPID(double targetAngle, Drivetrain drive) {
    this.drive = drive;
    measurement = () -> drive.getGyroAngleZ();

    // - Establishes targetAngle as the setpoint for the PID controller
    pid.setSetpoint(targetAngle);
    // - Enables the controller to be continuous, specifically for angle PIDs
    pid.enableContinuousInput(-180, 180); 
    // - Sets the controller tolerance so the command ends when Romi is within range of targetAngle by 2 degree
    pid.setTolerance(2); 

    // - Puts these values into SmartDashboard at the start of simulation, before the command is even scheduled
    SmartDashboard.putNumber("PID - Calc", getSpeedCalc());
    SmartDashboard.putNumber("PID - AngleMeas", measurement.get());
    SmartDashboard.putNumber("PID - Setpoint", pid.getSetpoint());
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
    SmartDashboard.putNumber("PID - Calc", getSpeedCalc());
    SmartDashboard.putNumber("PID - AngleMeas", measurement.get());
    SmartDashboard.putNumber("PID - Setpoint", pid.getPositionError());
    SmartDashboard.putNumber("PID - Error", pid.getPositionError()); // Outputs the current difference between measurement & setpoint
    SmartDashboard.putBoolean("Finished", isFinished()); // Outputs true on SmartDashboard when the PID loop ends
  }

  // - PID controller calculates the next speed value based on how close measurement is to the setpoint
  public double getSpeedCalc() {
    // - 'clamp()' limits the calculation to no lower than argument 'low' and no higher than argument 'high'
    return MathUtil.clamp( 
      -pid.calculate(measurement.get(), pid.getSetpoint()), -1 /* - Low bound */, 1 /* - High bound */);
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