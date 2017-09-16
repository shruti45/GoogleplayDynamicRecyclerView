package com.example.user.googleplaydynamicrecyclerview;

/**
 * Created by user on 3/30/2016.
 */
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by user on 3/21/2016.
 */
public class RecyclerAdapter2 extends RecyclerView.Adapter<RecyclerAdapter2.Holder> {
    private final Context tab1;
    String [] text={"Android","Ios","BlackBerry","Windows"};
    private static final Integer[] IMAGES= {R.drawable.flower,R.drawable.header,R.drawable.flower,R.drawable.header};


    public RecyclerAdapter2(Context context){
        this.tab1=context;

    }
    @Override
    public RecyclerAdapter2.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,null,false);
        return new Holder(row);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.tv1.setText(text[position]);
        holder.tv2.setText(text[position]);
        holder.img1.setImageResource(IMAGES[position]);

    }



    @Override
    public int getItemCount() {
        return text.length;
    }
   /* @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {

    }*/

    public class Holder extends RecyclerView.ViewHolder {
        //ImageView image1,img2,img3,img4,img5;
        @Bind(R.id.slidingimage)ImageView img1;
        @Bind(R.id.text1)TextView tv1;
        @Bind(R.id.text2)TextView tv2;
        public Holder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}