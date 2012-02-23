package project.muphic.Rikitakelab;


import android.content.res.Resources;
import android.graphics.*;
import android.content.Context;
import android.view.View;
import android.view.MotionEvent;

public class StoryCreateWindow extends View implements Creator {

	private Resources r;
	private int touchX;
	private int touchY;
	private int touchAction=-999;

	private Button backtitlebutton;
	private Bitmap backtitlebbutton;
	private Bitmap backtitleabutton;

	private Button exchbutton;
	private Bitmap exchbbutton;
	private Bitmap exchabutton;

	private Button editbutton;
	private Bitmap editbbutton;
	private Bitmap editabutton;

	private Button helpbutton;
	private Bitmap helpbbutton;
	private Bitmap helpabutton;

	private Button playbutton;
	private Bitmap playbbutton;
	private Bitmap playabutton;

	private Button titlebutton;
	private Bitmap titlebbutton;
	private Bitmap titleabutton;

	private Button savebutton;
	private Bitmap savebbutton;
	private Bitmap saveabutton;

	private Button textbutton;
	private Bitmap textbbutton;
	private Bitmap textabutton;

	private Bitmap picture;

	private Bitmap titletext;

	private Bitmap texttext;

	private Muphic activity = (Muphic)getContext();
	private static StoryCreateWindow SCW;


	public static void CreateSCW(Muphic activity){
		SCW = new StoryCreateWindow(activity);
	}

	public static StoryCreateWindow getInstance(){
		return SCW;
	}

	public StoryCreateWindow(Context context){
		super(context);
		r=getResources();
		backtitlebbutton=BitmapFactory.decodeResource(r, R.drawable.backtotitle);
		backtitleabutton=BitmapFactory.decodeResource(r, R.drawable.backtotitle_t);
		exchbbutton=BitmapFactory.decodeResource(r, R.drawable.music);
		exchabutton=BitmapFactory.decodeResource(r, R.drawable.music_t);
		editbbutton=BitmapFactory.decodeResource(r, R.drawable.edit);
		editabutton=BitmapFactory.decodeResource(r, R.drawable.edit_t);
		helpbbutton=BitmapFactory.decodeResource(r, R.drawable.help);
		helpabutton=BitmapFactory.decodeResource(r, R.drawable.help_t);
		playbbutton=BitmapFactory.decodeResource(r, R.drawable.play);
		playabutton=BitmapFactory.decodeResource(r, R.drawable.play_t);
		picture=BitmapFactory.decodeResource(r, R.drawable.picture);
		titlebbutton=BitmapFactory.decodeResource(r, R.drawable.title_);
		titleabutton=BitmapFactory.decodeResource(r, R.drawable.title_t);
		savebbutton=BitmapFactory.decodeResource(r, R.drawable.save);
		saveabutton=BitmapFactory.decodeResource(r, R.drawable.save_t);
		textbbutton=BitmapFactory.decodeResource(r, R.drawable.text);
		textabutton=BitmapFactory.decodeResource(r, R.drawable.text_t);
		titletext=BitmapFactory.decodeResource(r, R.drawable.titletext);
		texttext=BitmapFactory.decodeResource(r, R.drawable.texttext);

		setBackgroundColor(Color.WHITE);
	}

	public void onDraw(Canvas canvas){

		Paint paint = new Paint();

		backtitlebutton=new Button(getWidth()-95,40,backtitlebbutton,backtitleabutton);
		exchbutton=new Button(getWidth()-95,230,exchbbutton,exchabutton);
		editbutton=new Button(getWidth()-95,325,editbbutton,editabutton);
		helpbutton=new Button(getWidth()-95,5,helpbbutton,helpabutton);
		playbutton=new Button(getWidth()-95,135,playbbutton,playabutton);
		titlebutton=new Button(5,5,titlebbutton,titleabutton);
		savebutton=new Button(getWidth()-95,420,savebbutton,saveabutton);
		textbutton=new Button(5,getHeight()-35,textbbutton,textabutton);

		if(touchAction==MotionEvent.ACTION_DOWN||touchAction==MotionEvent.ACTION_MOVE){
			if(exchbutton.judge(touchX, touchY,false))exchbutton.pushButton();
			if(backtitlebutton.judge(touchX, touchY,false))backtitlebutton.pushButton();
			if(editbutton.judge(touchX, touchY, false))editbutton.pushButton();
			if(helpbutton.judge(touchX, touchY, false))helpbutton.pushButton();
			if(playbutton.judge(touchX, touchY, false))playbutton.pushButton();
			if(titlebutton.judge(touchX, touchY, false))titlebutton.pushButton();
			if(savebutton.judge(touchX, touchY, false))savebutton.pushButton();
			if(textbutton.judge(touchX, touchY, false))textbutton.pushButton();
		}

		if(touchAction==MotionEvent.ACTION_UP){
			if(exchbutton.judge(touchX, touchY,true))exchbutton.pullButton();
			if(backtitlebutton.judge(touchX, touchY, true))backtitlebutton.pullButton();
			if(editbutton.judge(touchX, touchY, true))editbutton.pullButton();
			if(helpbutton.judge(touchX, touchY, true))helpbutton.pullButton();
			if(playbutton.judge(touchX, touchY, true))playbutton.pullButton();
			if(titlebutton.judge(touchX, touchY, true))titlebutton.pullButton();
			if(savebutton.judge(touchX, touchY, true))savebutton.pullButton();
			if(textbutton.judge(touchX, touchY, true))textbutton.pullButton();
		}

		exchbutton.display(canvas, paint);
		backtitlebutton.display(canvas, paint);
		editbutton.display(canvas, paint);
		helpbutton.display(canvas, paint);
		playbutton.display(canvas,paint);
		savebutton.display(canvas, paint);
		titlebutton.display(canvas, paint);
		textbutton.display(canvas, paint);

		canvas.drawBitmap(picture, 5, 40, paint);
		canvas.drawBitmap(titletext, 100, 5, paint);
		canvas.drawBitmap(texttext, 100, getHeight()-35, paint);
	}

	public boolean onTouchEvent(MotionEvent event){
		touchX=(int)event.getX();
		touchY=(int)event.getY();
		touchAction=event.getAction();

		if(touchAction==MotionEvent.ACTION_UP){
			if(exchbutton.judge(touchX, touchY,true)){
				exchange();
			}

			if(backtitlebutton.judge(touchX, touchY, true)){
				titleBack();
			}

			if(editbutton.judge(touchX, touchY, true)){
				edit();
			}

			if(helpbutton.judge(touchX, touchY, true)){
				help();
			}

			if(playbutton.judge(touchX, touchY, true)){
				play();
			}

			if(savebutton.judge(touchX, touchY, true)){
				save();
			}

			if(titlebutton.judge(touchX, touchY, true)){

			}

			if(textbutton.judge(touchX, touchY, true)){

			}

		}

		return true;
	}

	public void edit() {
		activity.setView(Muphic.viewBackGroundSelect);
	}

	public void play() {

	}

	public void titleBack() {
		activity.setView(Muphic.viewTitle);

	}

	public void save() {

	}

	public void exchange() {
		activity.setView(Muphic.viewMusicCreateWindow);
	}

	public void readFile() {

	}

	public void help() {

	}

}
