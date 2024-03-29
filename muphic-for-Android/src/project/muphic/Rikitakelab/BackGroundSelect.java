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

public class BackGroundSelect extends View implements Editor {
	private Resources r;
	private int touchX;
	private int touchY;
	private int touchAction=-999;

	private Button backbutton;
	private Bitmap backbbutton;
	private Bitmap backabutton;

	private Button characterbutton;
	private Bitmap characterbbutton;
	private Bitmap characterabutton;


	private Bitmap selftab;

	private Muphic activity = (Muphic)getContext();
	private static BackGroundSelect BGS;


	public static void CreateBGS(Muphic activity){
		BGS = new BackGroundSelect(activity);
	}

	public static BackGroundSelect getInstance(){
		return BGS;
	}
	public BackGroundSelect(Context context) {
		super(context);
		r=getResources();
		backbbutton=BitmapFactory.decodeResource(r, R.drawable.tab_close);
		backabutton=BitmapFactory.decodeResource(r, R.drawable.tab_close_t);
		characterbbutton=BitmapFactory.decodeResource(r, R.drawable.tab_character);
		characterabutton=BitmapFactory.decodeResource(r, R.drawable.tab_character_t);
		selftab=BitmapFactory.decodeResource(r, R.drawable.tab_background_t);
		setBackgroundColor(Color.WHITE);
	}

	public void onDraw(Canvas canvas){
		Paint paint = new Paint();

		backbutton=new Button(getWidth()-163,5,backbbutton,backabutton);
		characterbutton=new Button(186,5,characterbbutton,characterabutton);

		if(touchAction==MotionEvent.ACTION_DOWN||touchAction==MotionEvent.ACTION_MOVE){
			if(backbutton.judge(touchX, touchY,false))backbutton.pushButton();
			if(characterbutton.judge(touchX, touchY,false))characterbutton.pushButton();
		}

		if(touchAction==MotionEvent.ACTION_UP){
			if(backbutton.judge(touchX, touchY, true))backbutton.pullButton();
			if(characterbutton.judge(touchX, touchY, true))characterbutton.pullButton();
		}
		characterbutton.display(canvas, paint);
		backbutton.display(canvas, paint);
		canvas.drawBitmap(selftab,11,5,paint);
	}

	public boolean onTouchEvent(MotionEvent event){
		touchX=(int)event.getX();
		touchY=(int)event.getY();
		touchAction=event.getAction();

		if(touchAction==MotionEvent.ACTION_UP){

			if(characterbutton.judge(touchX, touchY, true)){
				activity.setView(Muphic.viewCharacterSelect);
			}
			if(backbutton.judge(touchX, touchY, true)){
				close();
			}
		}
		return true;
	}

	public void close() {
		activity.setView(Muphic.viewStoryCreateWindow);
	}

	public void firstSelect() {

	}

	public void secondSelect() {

	}

	public void thirdSelect() {

	}

	public void delete() {

	}

	public void deleteAll() {

	}

}
