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
		MCW= new MusicCreateWindow(activity);
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
		// TODO 自動生成されたコンストラクター・スタブ

	}

	public void onDraw(Canvas canvas){
		Paint paint = new Paint();
		endbutton=new Button(getWidth()-100,0,endbbutton,endabutton);

		if(touchAction==MotionEvent.ACTION_DOWN||touchAction==MotionEvent.ACTION_MOVE){
			endbutton.changeflag(touchX, touchY,false);
		}

		if(touchAction==MotionEvent.ACTION_UP){
			endbutton.changeflag(touchX, touchY, true);
		}
		endbutton.display(canvas, paint);
	}

	public boolean onTouchEvent(MotionEvent event){
		touchX=(int)event.getX();
		touchY=(int)event.getY();
		touchAction=event.getAction();


		if(touchAction==MotionEvent.ACTION_UP){
			if(endbutton.changeflag(touchX, touchY, true)){
				exchange();
			}
		}

		return true;
	}

	public void edit() {
		// TODO 自動生成されたメソッド・スタブ

	}

	public void play() {
		// TODO 自動生成されたメソッド・スタブ

	}

	public void titleBack() {
		// TODO 自動生成されたメソッド・スタブ

	}

	public void save() {
		// TODO 自動生成されたメソッド・スタブ

	}

	public void exchange() {
		// TODO 自動生成されたメソッド・スタブ
		activity.setView(Muphic.viewStoryCreateWindow);
	}

	public void readFile() {
		// TODO 自動生成されたメソッド・スタブ

	}

	public void help() {
		// TODO 自動生成されたメソッド・スタブ

	}

}
