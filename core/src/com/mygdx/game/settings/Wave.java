package com.mygdx.game.settings;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.mygdx.game.Main;
import com.mygdx.game.entety.EnemyWithBow;
import java.util.Random;

public class Wave {
    private int Delay,WaveNumber, minEnemy;
   private long StartTimer;
   private String k= "WAVE -";
   BitmapFont font;

   public Wave(int Delay,int WaveNumber,int minEnemy){
       //FreeTypeGenerator

       this.Delay=Delay;
       this.WaveNumber=WaveNumber;
       this.minEnemy=minEnemy;


   }
   public void update(){
       if(Main.enemyWithBows.size==0 && StartTimer==0)StartTimer=System.currentTimeMillis();
       int Seconds=0;
       if(StartTimer>0)Seconds= (int) ((System.currentTimeMillis()-StartTimer)/1000);
       if(Seconds>=Delay){setWave();
           WaveNumber+=1;
           StartTimer=0;
           Seconds=0;
       }
   }
   public void setWave(){
       Random random=new Random();
       float x;
       float y;
       int Enem=minEnemy+WaveNumber;
       int maxRank=1;
       if(WaveNumber>1){maxRank=2;}
       if(WaveNumber>2){maxRank=3;}
       if(WaveNumber>3){maxRank=4;}

       for (int i=0;i<Enem;i++){
           x = MathUtils.random(64,Main.Widith);
           y=MathUtils.random(64,Main.Height);
           Main.enemyWithBows.add(new EnemyWithBow(new Point2D(x,y), (int) (Math.random()*maxRank+1)));
       }

   }
   public void draw(SpriteBatch batch){
       //GlyphLayout glyphLayout=new GlyphLayout();
       //glyphLayout.setText()
       //String s=k + WaveNumber;
       //font.draw(batch.s);
   }
}
