package com.example.bugdroid.riotapi;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.constant.Region;
import net.rithms.riot.dto.Summoner.Summoner;


public class MainActivity extends AppCompatActivity {

    TextView teste1;
    TextView teste2;
    TextView teste3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);

        setContentView(R.layout.activity_main);


        teste1 = (TextView) findViewById(R.id.nome);
        teste2 = (TextView) findViewById(R.id.id);
        teste3 = (TextView) findViewById(R.id.lvl);


        try {
            teste1.setText(getSummoner().getName());
            teste2.setText(String.valueOf(getSummoner().getId()));
            teste3.setText(String.valueOf(getSummoner().getSummonerLevel()));
        } catch (RiotApiException e) {
            e.printStackTrace();
        }
    }

    public Summoner getSummoner () throws RiotApiException {
        RiotApi api = new RiotApi("RGAPI-06d9fe30-edbf-4d8b-a025-1c0a5de907a9\n");

        Summoner summoner = (Summoner) api.getSummonerByName(Region.EUW, "xGatts");

        return summoner;
    }
}
