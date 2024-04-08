# HTCYFR Episode 6: Controller Configuration, Sensors, and SmartDashboard

## Code Updates

Please check out the code files shown in this branch's episode for updated code and documentation.

### Changed Files

- **TankDrive.java (ADDED)**: created TankDrive command file to control left and right motor speed separately and output sensor data onto SmartDashboard.
- **Drivetrain.java**: added setLeftMotor(double) and setRightMotor(double) methods that sets the power of the left and right Romi gearmotor respectively to the inputted double value.
- **RobotContainer.java**: added CommandXboxController xbox to assign the 'a' button the job of toggling the TankDrive command on and off.
