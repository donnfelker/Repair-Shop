package com.agilevent.repairshop;

import java.io.File;
import java.io.FileOutputStream;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class VehicleDamageWaiverFragment extends Fragment implements VehicleSelected {

	private SignatureView waiverView; 
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		 
		
		waiverView = (SignatureView)getView().findViewById(R.id.vehicle);
		waiverView.setDrawingCacheEnabled(true);
		
		Button save = (Button)getView().findViewById(R.id.save);
		 
		
		save.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				
				 Bitmap waiverImage = waiverView.getDrawingCache();

				 try {
					 File file = new File( Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "waiver-" + System.currentTimeMillis() + ".jpg" ); 
					 waiverImage.compress( Bitmap.CompressFormat.JPEG, 100, new FileOutputStream( file ) );
					 
					 new AlertDialog.Builder(getActivity())
					 	.setMessage(String.format(getString(R.string.waiver_saved), file.getAbsolutePath()))
					 	.setPositiveButton(getString(android.R.string.ok),new DialogInterface.OnClickListener() {
							
							public void onClick(DialogInterface dialog, int which) {
								dialog.dismiss(); 
							}
						})
						.create().show();
					 
					 OnVehicleSelected(""); 
					 
					 
				 } catch(Exception e) {
					 Log.e("WaiverApp", "Could not save image", e);
					 throw new RuntimeException(e);
				 }
			}
		});
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.vehicle_damage, container);
	}

	public void OnVehicleSelected(String vehicle) {
		
		// Clear the signature and markings. 
		waiverView.clear();
		
		if(vehicle.toLowerCase().equals("car")) 
			waiverView.setBackgroundResource(R.drawable.car);  
		else if(vehicle.toLowerCase().equals("suv"))
			waiverView.setBackgroundResource(R.drawable.suv);
		else if(vehicle.toLowerCase().equals("truck"))
			waiverView.setBackgroundResource(R.drawable.truck);
		else
			waiverView.setBackgroundColor(Color.TRANSPARENT);
			
		
	}
}
