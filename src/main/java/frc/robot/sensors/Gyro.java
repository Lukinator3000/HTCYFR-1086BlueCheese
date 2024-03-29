// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.sensors;

import edu.wpi.first.hal.SimDevice;
import edu.wpi.first.hal.SimDevice.Direction;
import edu.wpi.first.hal.SimDouble;

/* - Gyro sensor class that makes a SimDevice that gets access to Gyro rates & angles during simulation
 *   Disclaimer: this code is directly copied from the WPILib RomiReference example project with some class and variable renaming.
 *    You may receive different gyro values if you don't copy over that code and make this manually.
 */
public class Gyro {
  private final SimDouble m_simRateX;
  private final SimDouble m_simRateY;
  private final SimDouble m_simRateZ;
  private final SimDouble m_simAngleX;
  private final SimDouble m_simAngleY;
  private final SimDouble m_simAngleZ;

  private double XOffset;
  private double YOffset;
  private double ZOffset;

  /** Create a new RomiGyro. */
  public Gyro() {
    SimDevice gyroSimDevice = SimDevice.create("Gyro:RomiGyro"); // - Creating SimDevice
    if (gyroSimDevice != null) {
      gyroSimDevice.createBoolean("init", Direction.kOutput, true);
      m_simRateX = gyroSimDevice.createDouble("rate_x", Direction.kInput, 0.0);
      m_simRateY = gyroSimDevice.createDouble("rate_y", Direction.kInput, 0.0);
      m_simRateZ = gyroSimDevice.createDouble("rate_z", Direction.kInput, 0.0);

      m_simAngleX = gyroSimDevice.createDouble("angle_x", Direction.kInput, 0.0);
      m_simAngleY = gyroSimDevice.createDouble("angle_y", Direction.kInput, 0.0);
      m_simAngleZ = gyroSimDevice.createDouble("angle_z", Direction.kInput, 0.0);
    } else {
      m_simRateX = null;
      m_simRateY = null;
      m_simRateZ = null;

      m_simAngleX = null;
      m_simAngleY = null;
      m_simAngleZ = null;
    }
  }

  /**
   * Get the rate of turn in degrees-per-second around the X-axis.
   *
   * @return rate of turn in degrees-per-second
   */
  public double getRateX() {
    if (m_simRateX != null) {
      return m_simRateX.get();
    }

    return 0.0;
  }

  /**
   * Get the rate of turn in degrees-per-second around the Y-axis.
   *
   * @return rate of turn in degrees-per-second
   */
  public double getRateY() {
    if (m_simRateY != null) {
      return m_simRateY.get();
    }

    return 0.0;
  }

  /**
   * Get the rate of turn in degrees-per-second around the Z-axis.
   *
   * @return rate of turn in degrees-per-second
   */
  public double getRateZ() {
    if (m_simRateZ != null) {
      return m_simRateZ.get();
    }

    return 0.0;
  }

  /**
   * Get the currently reported angle around the X-axis.
   *
   * @return current angle around X-axis in degrees
   */
  public double getAngleX() {
    if (m_simAngleX != null) {
      return m_simAngleX.get() - XOffset;
    }

    return 0.0;
  }

  /**
   * Get the currently reported angle around the X-axis.
   *
   * @return current angle around Y-axis in degrees
   */
  public double getAngleY() {
    if (m_simAngleY != null) {
      return m_simAngleY.get() - YOffset;
    }

    return 0.0;
  }

  /**
   * Get the currently reported angle around the Z-axis.
   *
   * @return current angle around Z-axis in degrees
   */
  public double getAngleZ() {
    if (m_simAngleZ != null) {
      return m_simAngleZ.get() - ZOffset;
    }

    return 0.0;
  }

  /** Reset the gyro angles to 0. */
  public void reset() {
    if (m_simAngleX != null) {
      XOffset = m_simAngleX.get();
      YOffset = m_simAngleY.get();
      ZOffset = m_simAngleZ.get();
    }
  }
}
