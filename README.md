# HTCYFR Episode 8: PID Controllers

## Code Updates

Please check out the code files shown in this branch's episode for updated code and documentation.

### Changed Files

- **TurnDegreesPID.java (ADDED)**: created command file that uses a PIDController to make the Romi turn to a specific target angle using Gyro sensor data.
- **RobotContainer.java**: added new button binding, assigning the "b" button to the new TurnDegreesPID command.