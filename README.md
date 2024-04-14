# HTCYFR Episode 5: Command-Based Programming and Simulating Drive

## Code Updates

Please check out the code files shown in this branch's episode for updated code and documentation.

### Changed Files

- **RobotContainer.java**: switched the turn supplier axis from 2 to 0 in the third argument of new ArcadeDrive() command at the bottom of the file.

## Extra Topics

### Suppliers

Suppliers are objects that can send continuous streams of updating data without needing to be contantly initialized. Supplier objects allows the robot to see a particular pieces of data, like joystick movements or sensor fluctuations, updating in real time so they can to change what a function or command does; in this case, the ArcadeDrive.java file has two Supplier attributes that both take in double values depicting the current position/value of the joystick/controller on a certain axis, thus allowing us to move, stop, and turn our Romi with the joystick/controller throughout TeleOp phase. Supplier objects are usually set as parameters to objects or commands that run periodically and can implement changes in data from the Suppliers into their code quickly.

Suppliers are assigned shorthand methods that can be made adding the syntax "() ->" right before an updating variable (for instance, "() -> drivetrain.getEncoderDistance()"). To summarize, the lambda "->" sends in a parameter, the variable to the left of it, to a piece of executable code, on the right side of it, that should return data of the type specified inside "<>" of the Supplier declaration. If given an empty parentheses "()" as its parameter on the left of it, the lambda executes the righthand code with no parameter inserted, essentially functioning as a no-parameter shorthand method. [More information about lambdas can be found in this W3Schools page.](https://www.w3schools.com/java/java_lambda.asp).

Once a Supplier is initalized with a shorthand method, it seemingly executes that method continuously to update the changing data sent to the Supplier. An instance of that changing data held within the Supplier can then be retrieved using the Supplier's ".get()" method.
