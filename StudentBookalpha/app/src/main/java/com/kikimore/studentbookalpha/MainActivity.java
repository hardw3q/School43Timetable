package com.kikimore.studentbookalpha;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceControl;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import com.kikimore.studentbookalpha.tabs.*;

import org.greenrobot.eventbus.EventBus;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class MainActivity extends AppCompatActivity implements tab_saturday.OnFragmentInteractionListener,tab_friday.OnFragmentInteractionListener,tab_monday.OnFragmentInteractionListener,tab_thursday.OnFragmentInteractionListener,tab_tuesday.OnFragmentInteractionListener,tab_wednesday.OnFragmentInteractionListener{
    private ViewPager pager;
    private Spinner sp_rasp1;
    private Spinner sp_rasp2;
    private static int positionOf2;
    private static int positionOf1;
    private pageadapter adapter;
    static final int PAGE_COUNT = 6;
    private Date yourDate;
    private TextView tvtest;
    private ProgressBar pb1;
    private FragmentTransaction transaction;
    private FragmentManager manager;
    private Button bta;
    private Context context;
    private int identifier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp_rasp1 = findViewById(R.id.sp_rasp1);
        sp_rasp2 = findViewById(R.id.sp_rasp2);
        pager = findViewById(R.id.pager);
        tvtest = findViewById(R.id.testTextView);
        pb1 = findViewById(R.id.pbs);
        context = getBaseContext();

        yourDate = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(yourDate);
        final int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);

        final ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(context, R.array.list_rasp2, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        final ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(context, R.array.list_ychitel, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        final ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(context, R.array.list_classroom, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        NetworkTask networkTask = new NetworkTask();
        networkTask.execute();

        sp_rasp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case(0):
                        sp_rasp2.setAdapter(adapter1);
                        positionOf1 = 0;
                        break;
                    case(1):
                        sp_rasp2.setAdapter(adapter2);
                        positionOf1 = 1;
                        break;
                    case(2):
                        sp_rasp2.setAdapter(adapter3);
                        positionOf1 = 2;
                        break;
                }

                NetworkTask networkTask = new NetworkTask();
                networkTask.execute();
            }

            public void onNothingSelected(AdapterView<?> parent) {
                NetworkTask networkTask = new NetworkTask();
                networkTask.execute();
            }
        });
        sp_rasp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                final pageadapter pageAdapter = new pageadapter(getSupportFragmentManager(), this);
                pager.setAdapter(pageAdapter);
                pager.setCurrentItem(dayOfWeek-2);

                NetworkTask networkTask = new NetworkTask();
                networkTask.execute();
                if(positionOf1 == 0) {
                    switch (position) {
                        case (0):
                            positionOf2 = 33;
                            break;
                        case (1):
                            positionOf2 = 34;
                            break;
                        case (2):
                            positionOf2 = 35;
                            break;
                        case (3):
                            positionOf2 = 32;
                            break;
                        case (4):
                            positionOf2 = 31;
                            break;
                        case (5):
                            positionOf2 = 30;
                            break;
                        case (6):
                            positionOf2 = 25;
                            break;
                        case (7):
                            positionOf2 = 26;
                            break;
                        case (8):
                            positionOf2 = 27;
                            break;
                        case (9):
                            positionOf2 = 28;
                            break;
                        case (10):
                            positionOf2 = 24;
                            break;
                        case (11):
                            positionOf2 = 23;
                            break;
                        case (12):
                            positionOf2 = 22;
                            break;
                        case (13):
                            positionOf2 = 21;
                            break;
                        case (14):
                            positionOf2 = 17;
                            break;
                        case (15):
                            positionOf2 = 18;
                            break;
                        case (16):
                            positionOf2 = 19;
                            break;
                        case (17):
                            positionOf2 = 16;
                            break;
                        case (18):
                            positionOf2 = 15;
                            break;
                        case (19):
                            positionOf2 = 14;
                            break;
                        case (20):
                            positionOf2 = 8;
                            break;
                        case (21):
                            positionOf2 = 9;
                            break;
                        case (22):
                            positionOf2 = 10;
                            break;
                        case (23):
                            positionOf2 = 4;
                            break;
                        case (24):
                            positionOf2 = 5;
                            break;
                        case (25):
                            positionOf2 = 6;
                            break;
                        case (26):
                            positionOf2 = 7;
                            break;
                        case (27):
                            positionOf2 = 37;
                            break;
                        case (28):
                            positionOf2 = 38;
                            break;
                        case (29):
                            positionOf2 = 39;
                            break;
                        case (30):
                            positionOf2 = 40;
                            break;
                        case (31):
                            positionOf2 = 1;
                            break;
                        case (32):
                            positionOf2 = 2;
                            break;
                        case (33):
                            positionOf2 = 3;
                            break;
                    }
                }
                if(positionOf1 == 1){
                    switch(position){
                        case(0):
                            positionOf2 = 28;
                            break;
                        case(1):
                            positionOf2 = 26;
                            break;
                        case(2):
                            positionOf2 = 71;
                            break;
                        case(3):
                            positionOf2 = 29;
                            break;
                        case(4):
                            positionOf2 = 40;
                            break;
                        case(5):
                            positionOf2 = 27;
                            break;
                        case(6):
                            positionOf2 = 73;
                            break;
                        case(7):
                            positionOf2 = 42;
                            break;
                        case(8):
                            positionOf2 = 21;
                            break;
                        case(9):
                            positionOf2 = 36;
                            break;
                        case(10):
                            positionOf2 = 7;
                            break;
                        case(11):
                            positionOf2 = 39;
                            break;
                        case(12):
                            positionOf2 = 48;
                            break;
                        case(13):
                            positionOf2 = 4;
                            break;
                        case(14):
                            positionOf2 = 49;
                            break;
                        case(15):
                            positionOf2 = 37;
                            break;
                        case(16):
                            positionOf2 = 43;
                            break;
                        case(17):
                            positionOf2 = 52;
                            break;
                        case(18):
                            positionOf2 = 25;
                            break;
                        case(19):
                            positionOf2 = 30;
                            break;
                        case(20):
                            positionOf2 = 6;
                            break;
                        case(21):
                            positionOf2 = 69;
                            break;
                        case(22):
                            positionOf2 = 31;
                            break;
                        case(23):
                            positionOf2 = 3;
                            break;
                        case(24):
                            positionOf2 = 44;
                            break;
                        case(25):
                            positionOf2 = 35;
                            break;
                        case(26):
                            positionOf2 = 38;
                            break;
                        case(27):
                            positionOf2 = 1;
                            break;
                        case(28):
                            positionOf2 = 24;
                            break;
                        case(29):
                            positionOf2 = 47;
                            break;
                        case(30):
                            positionOf2 = 70;
                            break;
                        case(31):
                            positionOf2 = 32;
                            break;
                        case(32):
                            positionOf2 = 45;
                            break;
                    }
                }
                if(positionOf1 == 2){
                  switch(position){
                      case(0):
                          positionOf2 = 13;
                          break;
                      case(1):
                          positionOf2 = 14;
                          break;
                      case(2):
                          positionOf2 = 15;
                          break;
                      case(3):
                          positionOf2 = 16;
                          break;
                      case(4):
                          positionOf2 = 17;
                          break;
                      case(5):
                          positionOf2 = 4;
                          break;
                      case(6):
                          positionOf2 = 18;
                          break;
                      case(7):
                          positionOf2 = 19;
                          break;
                      case(8):
                          positionOf2 = 20;
                          break;
                      case(9):
                          positionOf2 = 21;
                          break;
                      case(10):
                          positionOf2 = 25;
                          break;
                      case(11):
                          positionOf2 = 26;
                          break;
                      case(12):
                          positionOf2 = 27;
                          break;
                      case(13):
                          positionOf2 = 28;
                          break;
                      case(14):
                          positionOf2 = 67;
                          break;
                      case(15):
                          positionOf2 = 30;
                          break;
                      case(16):
                          positionOf2 = 31;
                          break;
                      case(17):
                          positionOf2 = 32;
                          break;
                      case(18):
                          positionOf2 = 7;
                          break;
                      case(19):
                          positionOf2 = 33;
                          break;
                      case(20):
                          positionOf2 = 34;
                          break;
                      case(21):
                          positionOf2 = 35;
                          break;
                      case(22):
                          positionOf2 = 36;
                          break;
                      case(23):
                          positionOf2 = 37;
                          break;
                      case(24):
                          positionOf2 = 38;
                          break;
                      case(25):
                          positionOf2 = 39;
                          break;
                      case(26):
                          positionOf2 = 43;
                          break;
                      case(27):
                          positionOf2 = 44;
                          break;
                      case(28):
                          positionOf2 = 45;
                          break;
                      case(29):
                          positionOf2 = 46;
                          break;
                      case(30):
                          positionOf2 = 47;
                          break;
                      case(31):
                          positionOf2 = 2;
                          break;
                      case(32):
                          positionOf2 = 9;
                          break;
                      case(33):
                          positionOf2 = 10;
                          break;
                      case(34):
                          positionOf2 = 11;
                          break;
                      case(35):
                          positionOf2 = 12;
                          break;
                      case(36):
                          positionOf2 = 66;
                          break;
                      case(37):
                          positionOf2 = 65;
                          break;
                      case(38):
                          positionOf2 = 64;
                          break;
                  }
                }
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case(R.id.action_settings4):
                Dialog dialog = new Dialog(this);
                dialog.setContentView(R.layout.program_report);
                dialog.show();
                break;
            case(R.id.action_settings3):
                Dialog dialog1 = new Dialog(this);
                dialog1.setContentView(R.layout.program_inload);
                dialog1.show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    public static int nums(){
        return positionOf1;
    }
    public static int nums2(){
        return positionOf2;
    }
     class NetworkTask extends AsyncTask<Void, Void, Void> {

         @Override
         protected void onPreExecute() {
             super.onPreExecute();
             pb1.setVisibility(View.VISIBLE);
         }

         @SuppressLint("WrongThread")
         @Override
         protected Void doInBackground(Void... Void) {
             try {
                 final Document doc = Jsoup.connect(parsing.URLConstructor(positionOf1, positionOf2))
                         .userAgent("Chrome/4.0.249.0 Safari/532.5")
                         .referrer("http://www.google.com")
                         .get();
                 final Elements getLastRasp = doc.select("section,h5");

                 runOnUiThread(new Runnable() {
                     @Override
                         public void run() {
                         tvtest.setText(getLastRasp.text());
                     }
                 });
             } catch (IOException e) {
                 e.printStackTrace();
             }
             return null;
         }

         @Override
         protected void onPostExecute(Void aVoid) {
             super.onPostExecute(aVoid);
             pb1.setVisibility(View.GONE);
             tvtest.setVisibility(View.VISIBLE);
         }
     }
}


