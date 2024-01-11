package frc.robot.sensors;

import edu.wpi.first.hal.SimDevice;
import edu.wpi.first.hal.SimDouble;
import edu.wpi.first.hal.SimDevice.Direction;

public class Gyro {
  private final SimDouble angleX;
  private final SimDouble angleY;
  private final SimDouble angleZ;

  private double angleOffsetX;
  private double angleOffsetY;
  private double angleOffsetZ;

  public Gyro() {
    SimDevice gyroSimDevice = SimDevice.create("Gyro:RomiGyro");
    if (gyroSimDevice != null) {
      gyroSimDevice.createBoolean("init", Direction.kOutput, true);
      angleX = gyroSimDevice.createDouble("angle_x", Direction.kInput, 0.0);
      angleY = gyroSimDevice.createDouble("angle_y", Direction.kInput, 0.0);
      angleZ = gyroSimDevice.createDouble("angle_z", Direction.kInput, 0.0);
    } else {
      angleX = null;
      angleY = null;
      angleZ = null;
    }
  }

  public double getAngleX() {
    if (angleX != null) {
      return angleX.get() - angleOffsetX;
    }
    return 0;
  }
  public double getAngleY() {
    if (angleX != null) {
      return angleY.get() - angleOffsetY;
    }
    return 0;
  }
  public double getAngleZ() {
    if (angleX != null) {
      return angleX.get() - angleOffsetZ;
    }
    return 0;
  }

  public void reset() {
    if (angleX != null) {
        angleOffsetX = angleX.get();
        angleOffsetY = angleY.get();
        angleOffsetZ = angleZ.get();
    }
  }
}
