package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.RomiDrivetrain;

/* - An TankDrive command that, when toggled, allows you to drive both your left & right motors separately */
public class TankDrive extends CommandBase {
  // - Initializing Drivetrain and supplier values
  private final RomiDrivetrain drive;
  private final Supplier<Double> leftSupplier;
  private final Supplier<Double> rightSupplier;

  /**
   * - Creates a new TankDrive command
   *
   * @param subsystem The drivetrain subsystem used by this command.
   */
  public TankDrive(RomiDrivetrain subsystem, Supplier<Double> left, Supplier<Double> right) {
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
    drive.setLeftMotor(leftSupplier.get()); // - Sets power of left motor from leftSupplier values
    drive.setRightMotor(rightSupplier.get()); // - Sets power of right motor from rightSupplier values
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }

}
