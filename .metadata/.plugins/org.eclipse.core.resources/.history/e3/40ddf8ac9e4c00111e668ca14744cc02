package project.muphic.Rikitakelab;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.*;

public class Muphic extends Activity {
    /** Called when the activity is first created. */

	private View view=new Title(this);;
	private TickHandler tickHandler;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(view);
    }
    @Override
    public void onResume(){
    	super.onResume();
    	tickHandler=new TickHandler();
    	tickHandler.sleep(0);
    }

    @Override
    public void onPause(){
    	super.onPause();
    	tickHandler=null;
    }

    public class TickHandler extends Handler{
    	//handler message
    	@Override
    	public void handleMessage(Message msg){
    		title.invalidate();
    		if(tickHandler!=null)tickHandler.sleep(100);
    	}

    	//sleep
    	public void sleep(long delayMills){
    		removeMessages(0);
    		sendMessageDelayed(obtainMessage(0),delayMills);
    	}
    }
}