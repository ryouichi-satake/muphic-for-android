package project.muphic.Rikitakelab;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.*;

public class Muphic extends Activity {
    /** Called when the activity is first created. */

	private ArrayList<View> muphiclist;
	private int i=0;
	private TickHandler tickHandler;
	public static final int viewTitle = 0;
	public static final int viewStoryCriateWindow = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFormat(PixelFormat.TRANSLUCENT);
        muphiclist=new ArrayList<View>();
        muphiclist.clear();
        Title.CreateTitle(this);
        StoryCriateWindow.CreateSCW(this);
        addContentView(Title.getInstance());
        addContentView(StoryCriateWindow.getInstance());
        setView(i);
    }
    public void addContentView(View instance) {
		// TODO 自動生成されたメソッド・スタブ
		muphiclist.add(instance);
	}

    public boolean setView(int i) {
    	this.i=i;
    if(muphiclist.size()!=0) {
       super.setContentView(muphiclist.get(this.i));
       return true;
      }
      return false;
     }

    private View getContentView(){
    	if(muphiclist.size()!=0) {
    		return muphiclist.get(this.i);
    	}
    	else return null;
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
    		getContentView().invalidate();
    		if(tickHandler!=null)tickHandler.sleep(100);
    	}

    	//sleep
    	public void sleep(long delayMills){
    		removeMessages(0);
    		sendMessageDelayed(obtainMessage(0),delayMills);
    	}
    }
}