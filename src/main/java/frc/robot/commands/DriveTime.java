package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.RomiDrivetrain;

public class DriveTime extends Command {
    private final RomiDrivetrain drive;
    private final double speed;
    private final double time;
    private long startTime;
    
    public DriveTime(RomiDrivetrain d, double s, double t) {
        drive = d;
        speed = s;
        time = t;
        addRequirements(drive);
    }

    @Override
    public void initialize() {
        startTime = System.currentTimeMillis();
        drive.arcadeDrive(0, 0);
    }

    @Override
    public void execute() {
        drive.arcadeDrive(speed, 0);
    }

    @Override
    public boolean isFinished() {
        return (System.currentTimeMillis() - startTime) >= time * 1000;
    }
}
