package com.co.tempcal.modelo;

public class TemperatureCalculations {
	
	public final float ERROR_RANGE_CELCIUS = (float) 0.2;
	
	public final float ERROR_RANGE_FAHRENHEIT = (float) 0.5;
	
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
	
	
	public boolean evaluateCalibration(String coldBathTemp2, String coldSensorTemp, String temperatureType){
		
		float coldBath=Float.parseFloat(coldBathTemp2);
		float coldSensor=Float.parseFloat(coldSensorTemp);
		float errorRange = 0;
		boolean resultProcess = false;
		
		// Celsius or Fahrenheit
		if (temperatureType.equals("C")) {
			errorRange = ERROR_RANGE_CELCIUS;
		} else {
			if (temperatureType.equals("F")) {
				errorRange = ERROR_RANGE_FAHRENHEIT;
			}
		}
		
		if(coldSensor>(coldBath+errorRange)){
			resultProcess=false;
		}else{
			if(coldSensor<(coldBath-errorRange)){
				resultProcess=false;
			}else{
				resultProcess=true;
			}
		}
		
		return resultProcess;
		
		
	}

}
