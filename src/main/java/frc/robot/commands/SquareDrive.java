package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.RomiDrivetrain;

public class SquareDrive extends SequentialCommandGroup {
  public SquareDrive(RomiDrivetrain drive) {
    addCommands(
      new DriveTime(1, 2, drive),
      new TurnDegrees(1, 90, drive),
      new DriveTime(1, 2, drive),
      new TurnDegrees(1, 90, drive),
      new DriveTime(1, 2, drive),
      new TurnDegrees(1, 90, drive),
      new DriveTime(1, 2, drive),
      new TurnDegrees(1, 90, drive)
    );    
  }
}