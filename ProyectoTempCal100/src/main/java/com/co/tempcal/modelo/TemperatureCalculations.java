package com.co.tempcal.modelo;

public class TemperatureCalculations {

	/**
	 * This method calculate the temperature factor
	 * 
	 * @param coldBath
	 * @param hotUncalibSensor
	 * @param temperatureType
	 * @return
	 */
	public float calculateFactor(String coldBathTemp, String hotUncalibSensorTemp, String temperatureType) {

		float factor = 0;
		float temperature = 0;
		float coldBath = Float.parseFloat(coldBathTemp);
		float hotUncalibSensor = Float.parseFloat(hotUncalibSensorTemp);

		// Celsius or Fahrenheit
		if (temperatureType.equals("C")) {
			temperature = (float) 70.0;
		} else {
			if (temperatureType.equals("F")) {
				temperature = (float) 158.0;
			}
		}

		factor = (float) (hotUncalibSensor * ((temperature - coldBath) / (hotUncalibSensor - coldBath)));

		return factor;
	}

}
