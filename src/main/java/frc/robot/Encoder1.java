package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.Encoder;

public class Encoder1 extends TimedRobot {
  TalonSRX talon = new TalonSRX(0);
  Encoder encoder = new Encoder(0, 1, false, Encoder.EncodingType.k2X);

  @Override
  public void robotInit() {
  
  }

  @Override
  public void teleopInit() {
    encoder.reset();
    encoder.setDistancePerPulse(4./256.);

    // Configures the encoder to consider itself stopped after .1 seconds
    encoder.setMaxPeriod(.1);

    // Configures the encoder to consider itself stopped when its rate is below 10
    encoder.setMinRate(10);

    // Reverses the direction of the encoder
    encoder.setReverseDirection(true);

    // Configures an encoder to average its period measurement over 5 samples
    // Can be between 1 and 127 samples
    encoder.setSamplesToAverage(5);
  }

  @Override
  public void teleopPeriodic() {
    SmartDashboard.putNumber("Encoder_Rate", encoder.getRate());
    SmartDashboard.putBoolean("Encoder_Stopped", encoder.getStopped());
    SmartDashboard.putBoolean("Encoder_Direction", encoder.getDirection());
  }

}
