package com.agilevent.repairshop;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import com.google.inject.Inject;
import roboguice.activity.RoboFragmentActivity;
import roboguice.event.EventManager;
import roboguice.inject.InjectFragment;

public class MainActivity extends RoboFragmentActivity {

    @Inject protected EventManager eventManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
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
                eventManager.fire(new ResetEvent());
    			return true;
    		default: 
    			return super.onOptionsItemSelected(item);
    	}
    	
    }
}