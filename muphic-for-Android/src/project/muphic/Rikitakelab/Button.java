package project.muphic.Rikitakelab;

import android.graphics.*;

public class Button {
	private int x;
	private int y;
	private Bitmap bbotton;
	private Bitmap abotton;
	private boolean flag=false;

	public Button(int posx,int posy,Bitmap Bbotton,Bitmap Abotton){
		x=posx;
		y=posy;
		bbotton=Bbotton;
		abotton=Abotton;
	}

	public void display(Canvas canvas,Paint paint){
		if(flag==false){
			Rect src=new Rect(0,0,bbotton.getWidth(),bbotton.getHeight());
			Rect dst=new Rect(x,y,x+bbotton.getWidth(),y+bbotton.getHeight());
			canvas.drawBitmap(bbotton,src,dst,paint);
		}
		else{
			Rect src=new Rect(0,0,abotton.getWidth(),abotton.getHeight());
			Rect dst=new Rect(x,y,x+abotton.getWidth(),y+abotton.getHeight());
			canvas.drawBitmap(abotton,src,dst,paint);

		}
	}

	public boolean judge(int touchX,int touchY,boolean select){
		if(select==false&&flag==false&&touchX>x&&touchY>y&&touchX<x+bbotton.getWidth()&&touchY<y+bbotton.getHeight())
		{
			return true;
		}
		else if(select==true&&flag==true&&touchX>x&&touchY>y&&touchX<x+abotton.getWidth()&&touchY<y+abotton.getHeight())
		{
			return true;
		}
		return false;
	}

	public void pullButton(){
		flag=false;
	}

	public void pushButton(){
		flag=true;
	}


}
