package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Drivetrain;

/* - A SquareDrive autonomous command composition that sequentially runs a list of DriveDistance and TurnDegrees commands to  
 *    make the Romi drive in a square
 */
public class SquareDrive extends SequentialCommandGroup { // - Sequential commands allow execution of multiple commands in a specific sequence
  /**
   * - Creates a new SquareDrive command composition
   * 
   * @param drive The drivetrain subsystem this command will run on.
  */
  public SquareDrive(Drivetrain drive) {
    // - addCommands() groups commands together into one command composition that are scheduled one after the other, top to bottom
    addCommands(
      new DriveDistance(0.5, 12, drive), // - Moves roughly 12 inches at 0.5 motor speed
      new TurnDegrees(0.4, 90, drive), // - Turns roughly 90 degrees at 0.4 motor speed
      new DriveDistance(0.5, 12, drive),
      new TurnDegrees(0.4, 90, drive),
      new DriveDistance(0.5, 12, drive),
      new TurnDegrees(0.4, 90, drive),
      new DriveDistance(0.5, 12, drive),
      new TurnDegrees(0.4, 90, drive)
    );    
  }

}