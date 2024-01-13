// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.RomiDrivetrain;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;

/* - An ArcadeDrive command that runs during TeleOp phase for manual driving of your Romi */
public class ArcadeDrive extends CommandBase {  
  // - Initializing Drivetrain and supplier variables
  private final RomiDrivetrain drive;
  private final Supplier<Double> speedSupplier;
  private final Supplier<Double> turnSupplier;

  /**
   * - Creates a new ArcadeDrive command
   *
   * @param subsystem The drivetrain subsystem used by this command.
   * @param speed The speed value continually supplied through the command duration.
   * @param turn The turn speed value continually supplied through the command duration.
   */
  public ArcadeDrive(RomiDrivetrain subsystem, Supplier<Double> speed, Supplier<Double> turn) {
    drive = subsystem;
    speedSupplier = speed;
    turnSupplier = turn;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // - Ensures Romi stops before command starts, in case the Romi was already in movement
    drive.arcadeDrive(0, 0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drive.arcadeDrive(
      speedSupplier.get(), turnSupplier.get()); // - ".get()" returns a Double value given by Supplier<Double>
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drive.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }

}
