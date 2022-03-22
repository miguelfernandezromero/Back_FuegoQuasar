package com.edesafio.quasar.service.impl;

import org.apache.commons.math3.fitting.leastsquares.LevenbergMarquardtOptimizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.edesafio.quasar.dto.PositionDto;
import com.lemmingapex.trilateration.NonLinearLeastSquaresSolver;
import com.lemmingapex.trilateration.TrilaterationFunction;

@Service
public class LocationService {
	
	@Autowired
	Environment env;
	
	private double[] getLocation(double[][] positions, double [] distances) {

        TrilaterationFunction trilaterationFunction = new TrilaterationFunction(positions, distances);
        NonLinearLeastSquaresSolver nSolver = new NonLinearLeastSquaresSolver(trilaterationFunction, new LevenbergMarquardtOptimizer());

        return  nSolver.solve().getPoint().toArray();
    }
	
	public PositionDto postion(String satelliteName) {
		
		String mensajeEjemplo = (env.getProperty("satellite." + satelliteName.toLowerCase()));
		
		return null;
	}

}
