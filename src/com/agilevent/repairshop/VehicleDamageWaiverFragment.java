package com.agilevent.repairshop;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class VehicleDamageWaiverFragment extends Fragment implements VehicleSelected {

	private ImageView vehicleView; 
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		 
		
		vehicleView = (ImageView)getView().findViewById(R.id.vehicle);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.vehicle_damage, container);
	}

	public void OnVehicleSelected(String vehicle) {
		if(vehicle.toLowerCase().equals("car")) 
			vehicleView.setBackgroundResource(R.drawable.car); 
		else if(vehicle.toLowerCase().equals("suv"))
			vehicleView.setBackgroundResource(R.drawable.suv);
		else if(vehicle.toLowerCase().equals("truck"))
			vehicleView.setBackgroundResource(R.drawable.truck);
		else
			vehicleView.setBackgroundColor(Color.TRANSPARENT);
			
		
	}
}
