# HTCYFR Episode 7: Auto Commands and Choosers

## Code Updates

Please check out the code files shown in this branch's episode for updated code and documentation.

### Changed Files

- **SquareDrive.java (ADDED)**: created sequential command to make Romi drive roughly in a square.
- **TurnDegrees.java**: added an alternate return statement for isFinished that uses the Gyro to measure current angle distance instead of the calculation.
- **RobotContainer.java**: added "Drive in a Square Auto" option for m_chooser to allow the SquareDrive sequential command to be scheduled during autonomous.
