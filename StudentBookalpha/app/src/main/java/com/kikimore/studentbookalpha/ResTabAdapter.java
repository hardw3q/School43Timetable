package com.kikimore.studentbookalpha;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

//import org.apache.xpath.operations.String;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class ResTabAdapter extends RecyclerView.Adapter<ResTabAdapter.ResTabViewHolder>{
    private static int numbersOfItems = 1;
    private Context context;
    private int nun = 0;
    private int numt, numd;
    private static int pagenumber = 1;
    private  Elements getLastRasp;
    private  Elements getLastCab;
    private  Elements getLastYchitel;
    private  Elements getLastTime;
    private  ResTabViewHolder viewHolder;
    public  Document doc;
    public  ResTabViewHolder as;

    public ResTabAdapter(Context context, int pagen, int numo, int numa) {
        this.context = context;
        this.pagenumber = pagen;
        this.numt = numo;
        this.numd = numa;
    }

    @NonNull
    @Override
    public ResTabViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutidforlistitem = R.layout.list_item_view;

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(layoutidforlistitem, parent, false);

        viewHolder = new ResTabViewHolder(view);

        TaskNet net = new TaskNet();
        net.execute(viewHolder);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull ResTabViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return numbersOfItems;
    }


    class ResTabViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_urok;
        private TextView tv_cabid;
        private ProgressBar pb1;

        public ResTabViewHolder(@NonNull View itemView) {
            super(itemView);


            tv_urok = itemView.findViewById(R.id.tv_holder_yrok);
            tv_cabid = itemView.findViewById(R.id.cabid);
            pb1 = itemView.findViewById(R.id.pbofyrok);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int IndexPos = getAdapterPosition();
                    try {

                        Dialog dialog = new Dialog(context);
                        dialog.setContentView(R.layout.fragment_dialog);
                        TextView tv_time = dialog.findViewById(R.id.tv_time);
                        TextView tv_ychitel = dialog.findViewById(R.id.tv_ychitel);
                        TextView tv_urok = dialog.findViewById(R.id.tv_urok);
                        TextView tv_cabinet = dialog.findViewById(R.id.tv_cabinet_entering);

                        tv_time.setText(String.valueOf(getLastTime.get(IndexPos).text()));
                        tv_ychitel.setText(String.valueOf(getLastYchitel.get(IndexPos).text()));
                        tv_urok.setText(String.valueOf(getLastRasp.get(IndexPos).text()));
                        tv_cabinet.setText(String.valueOf(getLastCab.get(IndexPos).text()));

                        dialog.show();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            });
        }
    }
    class TaskNet extends AsyncTask<ResTabViewHolder, Void, Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(ResTabViewHolder... resTabViewHolders) {
            try {
                doc = Jsoup.connect(parsing.URLConstructor(numt, numd))
                        .get();
            } catch (IOException e) {
                e.printStackTrace();
            }
            for(ResTabViewHolder holder : resTabViewHolders){
                as = holder;
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            as.pb1.setVisibility(View.GONE);
           try {
               final Elements getTimetableColumn = doc.select("div.timetable-column");

               getLastRasp = getTimetableColumn.get(pagenumber).select("div.timetable-name");

               as.tv_urok.setText(getLastRasp.get(nun).text());

               numbersOfItems = getLastRasp.size();

               getLastCab = getTimetableColumn.get(pagenumber).select("div.timetable-title-wrap > div.timetable-time");

               as.tv_cabid.setText(getLastCab.get(nun).text());

               getLastYchitel = getTimetableColumn.get(pagenumber).select("div.timetable-desc > p:lt(1)");

               // getLastTime = getTimetableColumn.get(pagenumber).select("div.timetable-desc > p:eq(2)");
               nun++;
           }catch (Exception e){
               e.printStackTrace();
               as.tv_cabid.setText("Чтото произошло... Возможно у вас отсутствует интернет соединение или оно слишком слабое.");
           }
        }
    }
}

