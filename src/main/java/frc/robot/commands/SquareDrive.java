package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.RomiDrivetrain;

/* A SquareDrive autonomous command composition that sequentially runs a list of DriveDistance and TurnDegrees commands to  
 * make the Romi drive in a square
 */
public class SquareDrive extends SequentialCommandGroup {
  /**
   * - Creates a new SquareDrive command composition
   * 
   * @param drive The drivetrain subsystem this command will run on
  */
  public SquareDrive(RomiDrivetrain drive) {
    // Function that groups commands together into one command composition
    addCommands(
      new DriveDistance(0.5, 5, drive),
      new TurnDegrees(1, 90, drive),
      new DriveDistance(0.5, 5, drive),
      new TurnDegrees(1, 90, drive),
      new DriveDistance(0.5, 5, drive),
      new TurnDegrees(1, 90, drive),
      new DriveDistance(0.5, 5, drive),
      new TurnDegrees(1, 90, drive)
    );    
  }
  
}