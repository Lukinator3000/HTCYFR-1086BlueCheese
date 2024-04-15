package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.RomiDrivetrain;

public class ArcadeDrive extends Command {
    private final RomiDrivetrain drive;
    private final Supplier<Double> speed;
    private final Supplier<Double> turn;

    public ArcadeDrive(RomiDrivetrain d, Supplier<Double> s, Supplier<Double> t) {
        drive = d;
        speed = s;
        turn = t;
        addRequirements(drive);
    }

    @Override
    public void execute() {
        drive.arcadeDrive(speed.get(), turn.get());
    }
}
