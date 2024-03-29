package project.muphic.Rikitakelab;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;

public class CharacterSelect extends View implements Editor {

	private Resources r;
	private int touchX;
	private int touchY;
	private int touchAction=-999;

	private Button backbutton;
	private Bitmap backbbutton;
	private Bitmap backabutton;

	private Button backgroundbutton;
	private Bitmap backgroundbbutton;
	private Bitmap backgroundabutton;

	private Button boybutton;
	private Bitmap boybbutton;
	private Bitmap boyabutton;

	private boolean firstselect=false;

	private Bitmap selftab;

	private Muphic activity = (Muphic)getContext();
	private static CharacterSelect CS;


	public static void CreateCS(Muphic activity){
		CS = new CharacterSelect(activity);
	}

	public static CharacterSelect getInstance(){
		return CS;
	}

	public CharacterSelect(Context context) {
		super(context);
		r=getResources();
		backbbutton=BitmapFactory.decodeResource(r, R.drawable.tab_close);
		backabutton=BitmapFactory.decodeResource(r, R.drawable.tab_close_t);
		backgroundbbutton=BitmapFactory.decodeResource(r, R.drawable.tab_background);
		backgroundabutton=BitmapFactory.decodeResource(r, R.drawable.tab_background_t);
		boybbutton=BitmapFactory.decodeResource(r, R.drawable.character_boy);
		boyabutton=BitmapFactory.decodeResource(r, R.drawable.character_boy_t);
		selftab=BitmapFactory.decodeResource(r, R.drawable.tab_character_t);
		setBackgroundColor(Color.WHITE);
	}

	public void onDraw(Canvas canvas){
		Paint paint = new Paint();
		backbutton=new Button(getWidth()-163,5,backbbutton,backabutton);
		backgroundbutton=new Button(11,5,backgroundbbutton,backgroundabutton);
		boybutton=new Button(16,45,boybbutton,boyabutton);

		if(touchAction==MotionEvent.ACTION_DOWN||touchAction==MotionEvent.ACTION_MOVE){
			if(backbutton.judge(touchX, touchY,false))backbutton.pushButton();
			if(backgroundbutton.judge(touchX, touchY,false))backgroundbutton.pushButton();
			if(boybutton.judge(touchX, touchY, false))boybutton.pushButton();
		}

		if(touchAction==MotionEvent.ACTION_UP){
			if(backbutton.judge(touchX, touchY, true))backbutton.pullButton();
			if(backgroundbutton.judge(touchX, touchY,true))backgroundbutton.pullButton();
			if(boybutton.judge(touchX, touchY, true))boybutton.pullButton();
		}

		if(firstselect){
			boybutton.pushButton();
		}

		paint.setStyle(Paint.Style.STROKE);
		canvas.drawRect(new Rect(5, 34, 1019, getHeight()-5), paint);
		backbutton.display(canvas, paint);
		backgroundbutton.display(canvas, paint);
		boybutton.display(canvas, paint);
		canvas.drawBitmap(selftab, 186, 5, paint);
	}

	public boolean onTouchEvent(MotionEvent event){
		touchX=(int)event.getX();
		touchY=(int)event.getY();
		touchAction=event.getAction();

		if(touchAction==MotionEvent.ACTION_UP){

			if(backbutton.judge(touchX, touchY, true)){
				close();
			}
			if(backgroundbutton.judge(touchX, touchY,true)){
				activity.setView(Muphic.viewBackGroundSelect);
			}
			if(boybutton.judge(touchX, touchY, true)){
				firstSelect();
			}
		}

		return true;
	}

	public void close() {
		activity.setView(Muphic.viewStoryCreateWindow);

	}

	public void firstSelect() {
		if(!firstselect)firstselect=true;
		else firstselect=false;
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
