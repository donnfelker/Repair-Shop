package com.agilevent.repairshop;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {
    
	protected VehiclesListFragment vlf;  
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        vlf = (VehiclesListFragment)getSupportFragmentManager().findFragmentById(R.id.vehicles);
        
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	getMenuInflater().inflate(R.menu.main, menu);
    	return true; 
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	switch(item.getItemId()) {
    		case R.id.about: 
    			Toast.makeText(this, getString(R.string.about_content), Toast.LENGTH_LONG).show(); 
    			return true; 
    		case R.id.reset:
    			// To be implemented in this lab. 
    			return true;
    		default: 
    			return super.onOptionsItemSelected(item);
    	}
    	
    }
}