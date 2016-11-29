package myproject.bawie.com.myapplication;

/**
 * Created by ZFF on 2016/11/27.
 */

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;

import java.util.Random;

/**
 * Android自定义View 画弧形,文字,并增加动画效果
 * @author ansen
 * @create time 2015-08-07
 */
public class LogicView extends BaseView{
    private Paint paint;//画笔
    private int x=0;
    private RectF rectF=new RectF(150,150,380,380);
    private int sweepAngle=0;//弧的结束度数
    private Random random=new Random();


    public LogicView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LogicView(Context context) {
        super(context);
        init();
    }

    //初始化画笔
    private void  init(){
        paint=new Paint();
        paint.setTextSize(60);
    }

    @Override
    protected final void onDrawSub(Canvas canvas) {
        canvas.drawText("Hello World", x, 100, paint);
        //第一个参数是RectF   左上的x y坐标   右下的x y坐标
        //第二个参数是 弧形的开始角度
        //第三个参数是 弧形的结束角度
        //第四个参数是 true:画扇形   false:画弧线
        //第五个参数是 画笔
        canvas.drawArc(rectF, 0, sweepAngle, true, paint);
    }

    @Override
    protected void logic() {
        x+=20;
    sweepAngle+=3;//每次弧度加3

        //随机设置画笔的颜色
        int r=random.nextInt(255);
        int g=random.nextInt(255);
        int b=random.nextInt(255);
        paint.setARGB(255, r, g, b);

//        if(sweepAngle>=360){//如果弧度大于360°  从头开始
//            sweepAngle=0;
//        }

        if(x>getWidth()){//如果移动到屏幕外,从头开始
            int textWidth=(int) paint.measureText("Hello World");//测量文字宽度
            x=0-textWidth;
        }
    }
}
