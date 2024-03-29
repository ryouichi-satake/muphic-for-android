package project.muphic.Rikitakelab;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class MusicCreateWindow extends View implements Creator {

	private Resources r;
	private int touchX;
	private int touchY;
	private int touchAction=-999;

	private Button endbutton;
	private Bitmap endbbutton;
	private Bitmap endabutton;

	private Muphic activity = (Muphic)getContext();
	private static MusicCreateWindow MCW;

	public static void CreateMCW(Muphic activity){
		MCW = new MusicCreateWindow(activity);
	}

	public static MusicCreateWindow getInstance(){
		return MCW;
	}

	public MusicCreateWindow(Context context) {
		super(context);
		r=getResources();
		endbbutton=BitmapFactory.decodeResource(r, R.drawable.end);
		endabutton=BitmapFactory.decodeResource(r, R.drawable.pushend);
		setBackgroundColor(Color.CYAN);
	}

	public void onDraw(Canvas canvas){
		Paint paint = new Paint();
		endbutton=new Button(getWidth()-100,0,endbbutton,endabutton);

		if(touchAction==MotionEvent.ACTION_DOWN||touchAction==MotionEvent.ACTION_MOVE){
			if(endbutton.judge(touchX, touchY,false))endbutton.pushButton();
		}

		if(touchAction==MotionEvent.ACTION_UP){
			if(endbutton.judge(touchX, touchY, true))endbutton.pushButton();
		}
		endbutton.display(canvas, paint);
	}

	public boolean onTouchEvent(MotionEvent event){
		touchX=(int)event.getX();
		touchY=(int)event.getY();
		touchAction=event.getAction();


		if(touchAction==MotionEvent.ACTION_UP){
			if(endbutton.judge(touchX, touchY, true)){
				exchange();
			}
		}

		return true;
	}

	public void edit() {

	}

	public void play() {

	}

	public void titleBack() {

	}

	public void save() {

	}

	public void exchange() {
		activity.setView(Muphic.viewStoryCreateWindow);
	}

	public void readFile() {

	}

	public void help() {

	}

}
