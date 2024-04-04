# HTCYFR Episode 2: Assembly

This GitHub page will go over information from parts of the Assembly episode. If you haven't watched or seen this or the previous HTCYFR episode or GitHub branch, I recommend you do so before reading this page.

## Required Parts

### Romi Parts

Information on what parts you must buy to make a Romi can be found on the [FRC Control System Documentation website](https://docs.wpilib.org/en/stable/docs/romi-robot/hardware.html), which is talked about in the previous Episode-1-Introduction GitHub branch. Here's a list of what things you need specifically for assembly.

- [Romi Robot Kit for FIRST](https://www.pololu.com/product/4022)
- Raspberry Pi 3B+ or 4
- Six Double-A batteries, especially [rechargeable ones](https://www.amazon.com/gp/product/B07TW9T8JW/?th=1)
- A mini-screwdriver

The [microSD card and adapter](https://www.amazon.com/dp/B073K14CVB/) will be needed later for imaging the Romi in the next episode.

### Romi Robot Kit for FIRST

When your Romi Robot Kit finally delivers, you should see a Polulu box with all the parts for the base Romi. The box should contain:

- The Romi Chassis with a pre-soldered 32U4 Control Board
- 2 Motor Clips
- 2 Mini Plastic Gearmotors with encoders
- 2 Wheel Hubs and Tires
- 2 Ball Casters with rollers and caster chassis
- USB A to micro-B Adapter Cable (for imaging next episode)

### Part Purposes

- Romi Chassis: Acts as the Romi's main body and frame holding all the parts together.
- 32U4 Control Board: Sends power to and directly operates the Romi's gearmotors, sensors, lights and buttons to make them programmable.
  - Inertial Measurement Unit (IMU): Contains sensors like the Gyro, which detects rotation, and the accelerometer, that detect driving acceleration.
- Motor Clips: Hold and secure the Mini Plastic Gearmotors.
- Mini Plastic Gearmotors: Spins the wheels when powered (also have encoders).
  - Encoders: detects and calculates the Romi position displacement by counting the number of times a wheel has spun.
- Wheels (Hubs and Tires): Moves the Romi when spun.
- Ball Casters: Allow the Romi to stand and drive upright.
  - Caster Rollers and Chassis: Allow the ball casters to roll while staying in place at the bottom of the Romi.
- Rapberry Pi: Enables communication between the 32U4 Control Board and the computer so the Romi can be given code.
- Batteries: Give power to the Romi.

## Steps to Assembly

1. Pull out and open up the circular-ish Romi chassis with the pre-soldered 32U4 control board.
2. Take out the 2 motor clips and firmly press them into the Romi chassis on both sides until their bottoms become even with the bottom of the chassis, the open clip-y side facing away from the chassis and the upper handles pointed up. You’ll likely have to click in the motor clips a couple times before they get into the correct place.
3. Get out the 2 Mini plastic gearmotors and insert them into the motor clips, making sure the little spikes seamlessly go inside the little holes without bending. Open up the wheel parts and try your best to get the tires onto the wheel hubs (it may take a few tries). Align and press the wheels’ protruding center slot into the gearmotors until fully in.
4. Take out the ball caster materials. Flip the chassis over and put three rollers into the crevices of each of the 2 roller slots. Then, place the ball casters on top of the roller slots and press in the caster chassis on top of them until everything snaps in.
5. Place and screw in the Raspberry Pi above the control board using standoffs:
Open the battery compartment and place two washers in the middle row of the long battery compartment, each two columns away from the ends. Insert two standouts inside those specific holes in the Romi board and with your hands, screw the standouts into the washers. Parallel to the standout are another set of holes to screw in the standouts (the holes make corners of a rectangle). Carefully hold up a washer at the bottom of the holes with a finger and screw in the two other standouts (you may want another person to help with this). Get out the Raspberry pi you bought from its box. Align the corners of the Pi to the standouts and the other pin slots, and carefully slide in the pointy row of the Raspberry pi to those slots until snug.
Place screws in the holes of the Raspberry Pi where the standouts are and start screwing them in until the Pi is secured.
6. Open up the battery compartment on the bottom of the Romi and insert your 6 Double-A batteries that will give the Romi power. Ensure that the negative (flat) side of each battery is placed on the spring ends of the battery slots.
7. To check if the Romi’s assembled properly, press the little on-button at the bottom-left corner of the control board. You should hear a beep and lights come on, telling us that it works. To turn off the Romi, move the little switch adjacent to the power button to ‘off’ and press the power button again.

