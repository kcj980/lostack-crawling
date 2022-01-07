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

public class StatsActivity extends AppCompatActivity {
    TextView name;
    String nickname;
    final Bundle bundle = new Bundle();
    //크롤링 텍스트뷰
    TextView server_value, Guild_value, job_value, battle_value, item_value, expedition_value,
            PVP_value, wisdom_value;
    //기본특성 크롤링 텍스트뷰
    TextView power_value, vitality_value;
    //성향 크롤링 텍스트뷰
    TextView Intelligence_value, Charm_value, courage_value, kindness_value;
    //전투특성 크롤링 텍스트뷰
    TextView fatal_value, specialization_value, fast_value, suppress_value, patience_value, proficiency_value;

    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.stats);

        Button cancel1 = (Button) findViewById(R.id.cancel1); //취소버튼
        Button collectibles = (Button) findViewById(R.id.collectibles);//콜렉션 버튼
        name = (TextView) findViewById(R.id.name1);//상단 닉네님 표시

        Intent intent = getIntent();
        nickname = intent.getExtras().getString("name"); //메인에서 닉네임 받음
        name.setText(nickname);

        //취소버튼 -> 페이지 종료
        cancel1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                finish();
            }
        });
        //컬렉션버튼 -> 컬렉션페이지 이동 및 닉네임 전송
        collectibles.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent intent = new Intent(getApplicationContext(), CollectActivity.class);
                intent.putExtra("name", nickname);
                startActivity(intent);
            }
        });

        //크롤링 텍스트뷰 선언
        server_value = (TextView) findViewById(R.id.server_value);
        Guild_value = (TextView) findViewById(R.id.Guild_value);
        job_value = (TextView) findViewById(R.id.job_value);
        battle_value = (TextView) findViewById(R.id.battle_value);
        item_value = (TextView) findViewById(R.id.item_value);
        expedition_value = (TextView) findViewById(R.id.expedition_value);
        PVP_value = (TextView) findViewById(R.id.PVP_value);
        wisdom_value = (TextView) findViewById(R.id.wisdom_value);

        power_value = (TextView) findViewById(R.id.power_value);
        vitality_value = (TextView) findViewById(R.id.vitality_value);

        Intelligence_value = (TextView) findViewById(R.id.Intelligence_value);
        Charm_value = (TextView) findViewById(R.id.Charm_value);
        courage_value = (TextView) findViewById(R.id.courage_value);
        kindness_value = (TextView) findViewById(R.id.kindness_value);

        fatal_value = (TextView) findViewById(R.id.fatal_value);
        specialization_value = (TextView) findViewById(R.id.specialization_value);
        fast_value = (TextView) findViewById(R.id.fast_value);
        suppress_value = (TextView) findViewById(R.id.suppress_value);
        patience_value = (TextView) findViewById(R.id.patience_value);
        proficiency_value = (TextView) findViewById(R.id.proficiency_value);


        // 크롤링
        crawling_send(nickname,"server_value", 0, "body > div:nth-child(8) > div > div.col.col-xl-10.p-0.m-0 > div > div > div.row.p-0.m-0 > div.d-none.d-md-block.col-4.pl-0.pr-2 > div.bg-theme-4.rounded.shadow-sm.pt-2.pb-0.pr-0.pl-0.text-left.bd-theme-8 > div:nth-child(1) > span.text-theme-0.tfs14");
        crawling_send(nickname,"Guild_value", 0,"body > div:nth-child(8) > div > div.col.col-xl-10.p-0.m-0 > div > div > div.row.p-0.m-0 > div.d-none.d-md-block.col-4.pl-0.pr-2 > div.bg-theme-4.rounded.shadow-sm.pt-2.pb-0.pr-0.pl-0.text-left.bd-theme-8 > div.pl-2.pb-1.pr-0.mp > span.text-theme-0.tfs14");
        crawling_send(nickname,"job_value", 0, "body > div:nth-child(8) > div > div.col.col-xl-10.p-0.m-0 > div > div > div.row.p-0.m-0 > div.d-none.d-md-block.col-4.pl-0.pr-2 > div.bg-theme-4.rounded.shadow-sm.pt-2.pb-0.pr-0.pl-0.text-left.bd-theme-8 > div:nth-child(3) > span.text-theme-0.tfs14");
        crawling_send(nickname,"battle_value", 0,"body > div:nth-child(8) > div > div.col.col-xl-10.p-0.m-0 > div > div > div.row.p-0.m-0 > div.d-none.d-md-block.col-4.pl-0.pr-2 > div.bg-theme-4.rounded.shadow-sm.pt-2.pb-0.pr-0.pl-0.text-left.bd-theme-8 > div:nth-child(5) > span.text-theme-0.tfs14");
        crawling_send(nickname,"item_value", 0,"body > div:nth-child(8) > div > div.col.col-xl-10.p-0.m-0 > div > div > div.row.p-0.m-0 > div.d-none.d-md-block.col-4.pl-0.pr-2 > div.bg-theme-4.rounded.shadow-sm.pt-2.pb-0.pr-0.pl-0.text-left.bd-theme-8 > div:nth-child(6) > span.text-theme-0.tfs14");
        crawling_send(nickname,"expedition_value", 0,"body > div:nth-child(8) > div > div.col.col-xl-10.p-0.m-0 > div > div > div.row.p-0.m-0 > div.d-none.d-md-block.col-4.pl-0.pr-2 > div.bg-theme-4.rounded.shadow-sm.pt-2.pb-0.pr-0.pl-0.text-left.bd-theme-8 > div:nth-child(7) > span.text-theme-0.tfs14");
        crawling_send(nickname,"PVP_value", 0,"body > div:nth-child(8) > div > div.col.col-xl-10.p-0.m-0 > div > div > div.row.p-0.m-0 > div.d-none.d-md-block.col-4.pl-0.pr-2 > div.bg-theme-4.rounded.shadow-sm.pt-2.pb-0.pr-0.pl-0.text-left.bd-theme-8 > div:nth-child(8) > span.text-theme-0.tfs14");
        crawling_send(nickname,"wisdom_value", 0,"body > div:nth-child(8) > div > div.col.col-xl-10.p-0.m-0 > div > div > div.row.p-0.m-0 > div.d-none.d-md-block.col-4.pl-0.pr-2 > div.bg-theme-4.rounded.shadow-sm.pt-2.pb-0.pr-0.pl-0.text-left.bd-theme-8 > div.pl-2.pb-2.pr-0 > span.text-theme-0.tfs14");

        crawling_send(nickname,"power_value", 0,"#qulbox1 > div > div.p-0.mp > div:nth-child(3) > div:nth-child(1) > span > span");
        crawling_send(nickname,"vitality_value", 0,"#qulbox1 > div > div.p-0.mp > div:nth-child(3) > div:nth-child(2) > span.text-grade5");

        crawling_send(nickname,"Intelligence_value", 0,"#qulbox1 > div > div.p-0.mp > div:nth-child(12) > div:nth-child(1) > span > span");
        crawling_send(nickname,"Charm_value", 0,"#qulbox1 > div > div.p-0.mp > div:nth-child(13) > div:nth-child(1) > span > span");
        crawling_send(nickname,"courage_value", 0,"#qulbox1 > div > div.p-0.mp > div:nth-child(12) > div:nth-child(2) > span > span");
        crawling_send(nickname,"kindness_value", 0,"#qulbox1 > div > div.p-0.mp > div:nth-child(13) > div:nth-child(2) > span > span");

        crawling_send(nickname,"fatal_value", 0,"#qulbox1 > div > div.p-0.mp > div:nth-child(7) > div:nth-child(1) > span > span");
        crawling_send(nickname,"specialization_value", 0,"#qulbox1 > div > div.p-0.mp > div:nth-child(7) > div:nth-child(2) > span > span");
        crawling_send(nickname,"fast_value", 0,"#qulbox1 > div > div.p-0.mp > div:nth-child(8) > div:nth-child(2) > span > span");
        crawling_send(nickname,"suppress_value", 0,"#qulbox1 > div > div.p-0.mp > div:nth-child(8) > div:nth-child(1) > span > span");
        crawling_send(nickname,"patience_value", 0,"#qulbox1 > div > div.p-0.mp > div:nth-child(9) > div:nth-child(1) > span > span");
        crawling_send(nickname,"proficiency_value", 0,"#qulbox1 > div > div.p-0.mp > div:nth-child(9) > div:nth-child(2) > span > span");

    }
    //헨들러를 통해 받은정보 텍스트뷰에 setText하기
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            Bundle bundle = msg.getData();
            server_value.setText(bundle.getString("server_value"));
            Guild_value.setText(bundle.getString("Guild_value"));
            job_value.setText(bundle.getString("job_value"));
            battle_value.setText(bundle.getString("battle_value"));
            item_value.setText(bundle.getString("item_value"));
            expedition_value.setText(bundle.getString("expedition_value"));
            PVP_value.setText(bundle.getString("PVP_value"));
            wisdom_value.setText(bundle.getString("wisdom_value"));

            power_value.setText(bundle.getString("power_value"));
            vitality_value.setText(bundle.getString("vitality_value"));

            Intelligence_value.setText(bundle.getString("Intelligence_value"));
            Charm_value.setText(bundle.getString("Charm_value"));
            courage_value.setText(bundle.getString("courage_value"));
            kindness_value.setText(bundle.getString("kindness_value"));

            fatal_value.setText(bundle.getString("fatal_value"));
            specialization_value.setText(bundle.getString("specialization_value"));
            fast_value.setText(bundle.getString("fast_value"));
            suppress_value.setText(bundle.getString("suppress_value"));
            patience_value.setText(bundle.getString("patience_value"));
            proficiency_value.setText(bundle.getString("proficiency_value"));
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
                        value[0] = " - ";
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
