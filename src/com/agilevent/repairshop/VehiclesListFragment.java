package com.agilevent.repairshop;

import android.os.Bundle;
import android.support.v4.app.ListFragment;

import android.widget.ArrayAdapter;
import android.widget.Toast;


public class VehiclesListFragment extends ListFragment {

	private static final String CAR = "Car";
	private static final String SUV = "SUV";
	private static final String TRUCK = "Truck";
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		
		String[] vehicles = new String[] { CAR, SUV, TRUCK};
		
		ArrayAdapter<String> vehiclesAdapter = new ArrayAdapter<String>( getActivity(), android.R.layout.simple_list_item_1, vehicles );
	    
		setListAdapter(vehiclesAdapter);
		
		
	}

	
	
	
	

}
