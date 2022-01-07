package com.example.lostark;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class CollectActivity extends AppCompatActivity {
    TextView name;
    String nickname;
    final Bundle bundle = new Bundle();
    TextView textView1, textView2, textView3, textView4, textView5, textView6, textView7, textView8,
            island_1, star_1, heart_1, Art_1, mococo_1, adventure_1, Ignea_1, wtl_1;

    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.collect);

        Button cancel2 = (Button) findViewById(R.id.cancel2); //취소버늩
        Button stat = (Button) findViewById(R.id.stat);//스텟버튼
        name = (TextView) findViewById(R.id.name2);//닉네임

        ////스텟페이지에서 닉네임 받음
        Intent intent = getIntent();
        nickname = intent.getExtras().getString("name");
        name.setText(nickname);

        //취소버튼 ->종료
        cancel2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                finish();
            }
        });

        //스텟버튼 -> 스텟페이지로이동하면서 닉네임 스텟페이지한테 전달
        stat.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent intent = new Intent(getApplicationContext(), StatsActivity.class);
                intent.putExtra("name", nickname);
                startActivity(intent);
            }
        });


        //크롤링 텍스트뷰 선언
        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView4 = (TextView) findViewById(R.id.textView4);
        textView5 = (TextView) findViewById(R.id.textView5);
        textView6 = (TextView) findViewById(R.id.textView6);
        textView7 = (TextView) findViewById(R.id.textView7);
        textView8 = (TextView) findViewById(R.id.textView8);

        island_1 = (TextView) findViewById(R.id.island_1);
        star_1 = (TextView) findViewById(R.id.star_1);
        heart_1 = (TextView) findViewById(R.id.heart_1);
        Art_1 = (TextView) findViewById(R.id.Art_1);
        mococo_1 = (TextView) findViewById(R.id.mococo_1);
        adventure_1 = (TextView) findViewById(R.id.adventure_1);
        Ignea_1 = (TextView) findViewById(R.id.Ignea_1);
        wtl_1 = (TextView) findViewById(R.id.wtl_1);


        // 크롤링
        crawling_send(nickname,"textView1", 0,"body > div:nth-child(8) > div > div.col.col-xl-10.p-0.m-0 > div > div > div.row.p-0.m-0 > div.d-none.d-md-block.col-4.pl-0.pr-2 > div:nth-child(7) > div.media.p-0.m-0.d-flex.justify-content-center > div:nth-child(1) > span");
        crawling_send(nickname,"textView2", 0,"body > div:nth-child(8) > div > div.col.col-xl-10.p-0.m-0 > div > div > div.row.p-0.m-0 > div.d-none.d-md-block.col-4.pl-0.pr-2 > div:nth-child(7) > div.media.p-0.m-0.d-flex.justify-content-center > div:nth-child(2) > span");
        crawling_send(nickname,"textView3", 0,"body > div:nth-child(8) > div > div.col.col-xl-10.p-0.m-0 > div > div > div.row.p-0.m-0 > div.d-none.d-md-block.col-4.pl-0.pr-2 > div:nth-child(7) > div.media.p-0.m-0.d-flex.justify-content-center > div:nth-child(3) > span");
        crawling_send(nickname,"textView4", 0,"body > div:nth-child(8) > div > div.col.col-xl-10.p-0.m-0 > div > div > div.row.p-0.m-0 > div.d-none.d-md-block.col-4.pl-0.pr-2 > div:nth-child(7) > div.media.p-0.m-0.d-flex.justify-content-center > div:nth-child(4) > span");
        crawling_send(nickname,"textView5", 0,"body > div:nth-child(8) > div > div.col.col-xl-10.p-0.m-0 > div > div > div.row.p-0.m-0 > div.d-none.d-md-block.col-4.pl-0.pr-2 > div:nth-child(7) > div.media.p-0.m-0.d-flex.justify-content-center > div:nth-child(5) > span");
        crawling_send(nickname,"textView6", 0,"body > div:nth-child(8) > div > div.col.col-xl-10.p-0.m-0 > div > div > div.row.p-0.m-0 > div.d-none.d-md-block.col-4.pl-0.pr-2 > div:nth-child(7) > div.media.p-0.m-0.d-flex.justify-content-center > div:nth-child(6) > span");
        crawling_send(nickname,"textView7", 0,"body > div:nth-child(8) > div > div.col.col-xl-10.p-0.m-0 > div > div > div.row.p-0.m-0 > div.d-none.d-md-block.col-4.pl-0.pr-2 > div:nth-child(7) > div.media.p-0.m-0.d-flex.justify-content-center > div:nth-child(7) > span");
        crawling_send(nickname,"textView8", 0,"body > div:nth-child(8) > div > div.col.col-xl-10.p-0.m-0 > div > div > div.row.p-0.m-0 > div.d-none.d-md-block.col-4.pl-0.pr-2 > div:nth-child(7) > div.media.p-0.m-0.d-flex.justify-content-center > div:nth-child(8) > span");

        crawling_send(nickname,"island_1", 0,"body > div:nth-child(8) > div > div.col.col-xl-10.p-0.m-0 > div > div > div.row.p-0.m-0 > div.d-none.d-md-block.col-4.pl-0.pr-2 > div:nth-child(7) > div.media.p-0.m-0.d-flex.justify-content-center > div:nth-child(1) > span");
        crawling_send(nickname,"star_1", 0,"body > div:nth-child(8) > div > div.col.col-xl-10.p-0.m-0 > div > div > div.row.p-0.m-0 > div.d-none.d-md-block.col-4.pl-0.pr-2 > div:nth-child(7) > div.media.p-0.m-0.d-flex.justify-content-center > div:nth-child(2) > span");
        crawling_send(nickname,"heart_1", 0,"body > div:nth-child(8) > div > div.col.col-xl-10.p-0.m-0 > div > div > div.row.p-0.m-0 > div.d-none.d-md-block.col-4.pl-0.pr-2 > div:nth-child(7) > div.media.p-0.m-0.d-flex.justify-content-center > div:nth-child(3) > span");
        crawling_send(nickname,"Art_1", 0,"body > div:nth-child(8) > div > div.col.col-xl-10.p-0.m-0 > div > div > div.row.p-0.m-0 > div.d-none.d-md-block.col-4.pl-0.pr-2 > div:nth-child(7) > div.media.p-0.m-0.d-flex.justify-content-center > div:nth-child(4) > span");
        crawling_send(nickname,"mococo_1", 0,"body > div:nth-child(8) > div > div.col.col-xl-10.p-0.m-0 > div > div > div.row.p-0.m-0 > div.d-none.d-md-block.col-4.pl-0.pr-2 > div:nth-child(7) > div.media.p-0.m-0.d-flex.justify-content-center > div:nth-child(5) > span");
        crawling_send(nickname,"adventure_1", 0,"body > div:nth-child(8) > div > div.col.col-xl-10.p-0.m-0 > div > div > div.row.p-0.m-0 > div.d-none.d-md-block.col-4.pl-0.pr-2 > div:nth-child(7) > div.media.p-0.m-0.d-flex.justify-content-center > div:nth-child(6) > span");
        crawling_send(nickname,"Ignea_1", 0,"body > div:nth-child(8) > div > div.col.col-xl-10.p-0.m-0 > div > div > div.row.p-0.m-0 > div.d-none.d-md-block.col-4.pl-0.pr-2 > div:nth-child(7) > div.media.p-0.m-0.d-flex.justify-content-center > div:nth-child(7) > span");
        crawling_send(nickname,"wtl_1", 0,"body > div:nth-child(8) > div > div.col.col-xl-10.p-0.m-0 > div > div > div.row.p-0.m-0 > div.d-none.d-md-block.col-4.pl-0.pr-2 > div:nth-child(7) > div.media.p-0.m-0.d-flex.justify-content-center > div:nth-child(8) > span");




    }

    //헨들러를 통해 받은정보 텍스트뷰에 setText하기
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Bundle bundle = msg.getData();
            textView1.setText(bundle.getString("textView1"));
            textView2.setText(bundle.getString("textView2"));
            textView3.setText(bundle.getString("textView3"));
            textView4.setText(bundle.getString("textView4"));
            textView5.setText(bundle.getString("textView5"));
            textView6.setText(bundle.getString("textView6"));
            textView7.setText(bundle.getString("textView7"));
            textView8.setText(bundle.getString("textView8"));

            island_1.setText("총94개중 "+bundle.getString("island_1")+"개 획득");
            star_1.setText("총7개중 "+bundle.getString("star_1")+"개 획득");
            heart_1.setText("총15개중 "+bundle.getString("heart_1")+"개 획득");
            Art_1.setText("총55개중 "+bundle.getString("Art_1")+"개 획득");
            mococo_1.setText("총1241개중 "+bundle.getString("mococo_1")+"개 획득");
            adventure_1.setText("총47개중 "+bundle.getString("adventure_1")+"개 획득");
            Ignea_1.setText("총14개중 "+bundle.getString("Ignea_1")+"개 획득");
            wtl_1.setText("총61개중 "+bundle.getString("wtl_1")+"개 획득");
        }
    };


    public void crawling_send(String nickname, String key, int num, String address){
        final String[] value = new String[1];
        new Thread(){
            @Override
            public void run(){
                Document doc = null;
                try{
                    doc = (Document) Jsoup.connect("https://loawa.com/char/"+nickname).get();
                    Elements contents = doc.select(address);
                    try{
                        value[0] = contents.get(num).text();
                    }catch (Exception e){
                        value[0] = " -- ";
                        e.printStackTrace();
                    }

                    bundle.putString(key, value[0]);
                    Message msg = handler.obtainMessage();
                    msg.setData(bundle);
                    handler.sendMessage(msg);
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
