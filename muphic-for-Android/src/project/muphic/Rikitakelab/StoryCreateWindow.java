package project.muphic.Rikitakelab;


import android.content.res.Resources;
import android.graphics.*;
import android.content.Context;
import android.view.View;
import android.view.MotionEvent;

public class StoryCreateWindow extends View implements Creator {

	private Bitmap bg;
	private Resources r;
	private int touchX;
	private int touchY;
	private int touchAction=-999;

	private Button endbutton;
	private Bitmap endbbutton;
	private Bitmap endabutton;

	private Button startbutton;
	private Bitmap startbbutton;
	private Bitmap startabutton;

	private Muphic activity = (Muphic)getContext();
	private static StoryCreateWindow SCW;


	public static void CreateSCW(Muphic activity){
		SCW= new StoryCreateWindow(activity);
	}

	public static StoryCreateWindow getInstance(){
		return SCW;
	}

	public StoryCreateWindow(Context context){
		super(context);
		r=getResources();
		bg=BitmapFactory.decodeResource(r, R.drawable.nextwindow);
		endbbutton=BitmapFactory.decodeResource(r, R.drawable.end);
		endabutton=BitmapFactory.decodeResource(r, R.drawable.pushend);
		startbbutton=BitmapFactory.decodeResource(r, R.drawable.start);
		startabutton=BitmapFactory.decodeResource(r, R.drawable.pushstart);
	}

	public void onDraw(Canvas canvas){
		Paint paint = new Paint();
		Rect src=new Rect(0,0,bg.getWidth(),bg.getHeight());
		Rect dst=new Rect(0,0,getWidth(),getHeight());
		canvas.drawBitmap(bg,src,dst,paint);
		endbutton=new Button(getWidth()-100,0,endbbutton,endabutton);
		startbutton=new Button(getWidth()-getWidth()/4-50,getHeight()/2,startbbutton,startabutton);

		if(touchAction==MotionEvent.ACTION_DOWN||touchAction==MotionEvent.ACTION_MOVE){
			startbutton.changeflag(touchX, touchY,false);
			endbutton.changeflag(touchX, touchY,false);
		}

		if(touchAction==MotionEvent.ACTION_UP){
			startbutton.changeflag(touchX, touchY,true);
			endbutton.changeflag(touchX, touchY, true);
		}
		startbutton.display(canvas, paint);
		endbutton.display(canvas, paint);
	}

	public boolean onTouchEvent(MotionEvent event){
		touchX=(int)event.getX();
		touchY=(int)event.getY();
		touchAction=event.getAction();


		if(touchAction==MotionEvent.ACTION_UP){
			if(startbutton.changeflag(touchX, touchY,true)){
				exchange();
			}
			if(endbutton.changeflag(touchX, touchY, true)){
				titleBack();
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
		activity.setView(Muphic.viewTitle);

	}

	public void save() {
		// TODO 自動生成されたメソッド・スタブ

	}

	public void exchange() {
		// TODO 自動生成されたメソッド・スタブ
		activity.setView(Muphic.viewMusicCreateWindow);
	}

	public void readFile() {
		// TODO 自動生成されたメソッド・スタブ

	}

	public void help() {
		// TODO 自動生成されたメソッド・スタブ

	}

}
