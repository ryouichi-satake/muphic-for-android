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
	private int place=0;
	private TickHandler tickHandler;
	public static final int viewTitle = 0;
	public static final int viewStoryCreateWindow = 1;
	public static final int viewMusicCreateWindow = 2;
	public static final int viewBackGroundSelect = 3;
	public static final int viewCharacterSelect = 4;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFormat(PixelFormat.TRANSLUCENT);
        muphiclist=new ArrayList<View>();
        muphiclist.clear();

        Title.CreateTitle(this);
        addContentView(Title.getInstance());

        StoryCreateWindow.CreateSCW(this);
        addContentView(StoryCreateWindow.getInstance());

        MusicCreateWindow.CreateMCW(this);
        addContentView(MusicCreateWindow.getInstance());

        BackGroundSelect.CreateBGS(this);
        addContentView(BackGroundSelect.getInstance());

        CharacterSelect.CreateCS(this);
        addContentView(CharacterSelect.getInstance());

        setView(place);
    }
    public void addContentView(View instance) {
		muphiclist.add(instance);
	}

    public boolean setView(int i) {
    	this.place=i;
    if(muphiclist.size()!=0) {
       super.setContentView(muphiclist.get(this.place));
       return true;
      }
      return false;
     }

    private View getContentView(){
    	if(muphiclist.size()!=0) {
    		return muphiclist.get(this.place);
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