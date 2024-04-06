package frc.robot.commands; // - Necessary package statement that's automatically written when adding a java file to this commands folder

// - Automatically written imports
import java.util.function.Supplier;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;

/* - A TankDrive command that, when toggled, allows you to drive both your left & right motors separately */
public class TankDrive extends Command {
  // - Initializing Drivetrain and supplier values
  private final Drivetrain drive;
  private final Supplier<Double> leftSupplier;
  private final Supplier<Double> rightSupplier;

  /**
   * - Creates a new TankDrive command
   *
   * @param subsystem The drivetrain subsystem used by this command.
   * @param left The speed value given to the left gearmotor, continually supplied through the command duration.
   * @param right The speed value given to the right gearmotor, continually supplied through the command duration.
   */
  public TankDrive(Drivetrain subsystem, Supplier<Double> left, Supplier<Double> right) {
    drive = subsystem;
    leftSupplier = left;
    rightSupplier = right;
    addRequirements(subsystem);
  }

  @Override
  public void initialize() {
    // - Ensures Romi stops before command starts, in case the Romi was already in movement
    drive.arcadeDrive(0, 0);
  }

  @Override
  public void execute() {
    // - Powers the Romi's left and Right motors separately based on the leftSupplier and rightSupplier given from the parameters
    drive.setLeftMotor(leftSupplier.get()); // - Sets power of left motor from leftSupplier values
    drive.setRightMotor(rightSupplier.get()); // - Sets power of right motor from rightSupplier values

    /*
     * - SmartDashboard is an easy tool to display live data from the sensors (like the Encoders and Gyro) when the Romi 
     *    is running/simulating, mainly needing just a value to be displayed and a title/key to describe the value.
     *    Since these SmartDashboard statements are in TankDrive execute() method, the SmartDashboard outputs are
     *    displayed only when TankDrive is toggled.
     */
    SmartDashboard.putNumber("Left Encoder Distance", drive.getLeftDistanceInch());
    SmartDashboard.putNumber("Right Encoder Distance", drive.getLeftDistanceInch());
    SmartDashboard.putNumber("Gyro Angle", drive.getGyroAngleZ());
  }

  @Override
  public void end(boolean interrupted) {
    // - Ensures Romi stops when the command ends
    drive.arcadeDrive(0, 0);
  }

  // - isFinished() is not included since TankDrive has no special stopping condition, only ending when CommandSceduler stops scheduling it

}