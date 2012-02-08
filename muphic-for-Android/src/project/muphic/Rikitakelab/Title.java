package project.muphic.Rikitakelab;


import android.content.res.Resources;
import android.content.*;
import android.graphics.*;
import android.view.View;
import android.view.MotionEvent;

public class Title extends View{

	private int touchX;
	private int touchY;
	private int touchAction=-999;
	private Bitmap endbbutton;
	private Bitmap endabutton;
	private Bitmap startbbutton;
	private Bitmap startabutton;
	private Bitmap contbbutton;
	private Bitmap contabutton;
	private Bitmap bg;
	private Button startbutton,endbutton,contbutton;
	private Resources r;
	private Muphic activity = (Muphic)getContext();
	private static Title title;


	public static void CreateTitle(Muphic activity){
		title= new Title(activity);
	}

	public static Title getInstance(){
		return title;
	}

	public Title(Context context) {
		super(context);
		r=getResources();
		setBackgroundColor(Color.WHITE);
		endbbutton=BitmapFactory.decodeResource(r, R.drawable.end);
		endabutton=BitmapFactory.decodeResource(r, R.drawable.pushend);
		startbbutton=BitmapFactory.decodeResource(r, R.drawable.start);
		startabutton=BitmapFactory.decodeResource(r, R.drawable.pushstart);
		contbbutton=BitmapFactory.decodeResource(r, R.drawable.contenue);
		contabutton=BitmapFactory.decodeResource(r, R.drawable.pushcontenue);
		bg=BitmapFactory.decodeResource(r, R.drawable.title);

		setFocusable(true);
	}

	protected void onDraw(Canvas canvas){
		Paint paint=new Paint();
		paint.setAntiAlias(true);
		endbutton=new Button(getWidth()-100,0,endbbutton,endabutton);
		startbutton=new Button(getWidth()-getWidth()/4-50,getHeight()/2,startbbutton,startabutton);
		contbutton=new Button(getWidth()/4-75,getHeight()/2,contbbutton,contabutton);
		if(touchAction==MotionEvent.ACTION_DOWN||touchAction==MotionEvent.ACTION_MOVE){
			startbutton.changeflag(touchX, touchY,false);
			endbutton.changeflag(touchX, touchY,false);
			contbutton.changeflag(touchX, touchY,false);
		}

		if(touchAction==MotionEvent.ACTION_UP){
			startbutton.changeflag(touchX, touchY,true);
			endbutton.changeflag(touchX, touchY,true);
			contbutton.changeflag(touchX, touchY,true);

		}
		Rect src=new Rect(0,0,bg.getWidth(),bg.getHeight());
		Rect dst=new Rect(0,0,getWidth(),getHeight());
		canvas.drawBitmap(bg,src,dst,paint);
		startbutton.display(canvas, paint);
		endbutton.display(canvas, paint);
		contbutton.display(canvas, paint);
		}

	public boolean onTouchEvent(MotionEvent event){
		touchX=(int)event.getX();
		touchY=(int)event.getY();
		touchAction=event.getAction();

		if(touchAction==MotionEvent.ACTION_UP){
			if(startbutton.changeflag(touchX, touchY,true)){
				activity.setView(Muphic.viewStoryCreateWindow);
			}
			if(endbutton.changeflag(touchX, touchY, true)){
				activity.finish();
			}
		}

		return true;
	}

}
