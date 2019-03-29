package kr.balky.myrecyclewithsearch;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Cheetah.Park on 2019-03-29.
 */
public class MyAdaper extends RecyclerView.Adapter<MyAdaper.MyViewHolder> {
    private ArrayList<ItemVO> mItemList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onDetailClick(int position, int itemId);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.mListener = listener;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public ImageView mImageView;
        public TextView mTextId;
        public TextView mTextTitle;
        public TextView mTextContent;
        public ImageButton mDetailImg;

        public MyViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imgView);
            mTextId = itemView.findViewById(R.id.item_id);
            mTextTitle = itemView.findViewById(R.id.tx_title);
            mTextContent = itemView.findViewById(R.id.tx_content);
            mDetailImg = itemView.findViewById(R.id.img_detail);

            mDetailImg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        int itemId = Integer.parseInt(mTextId.getText().toString());
                        if(position != RecyclerView.NO_POSITION){
                            listener.onDetailClick(position, itemId);
                        }
                    }
                }
            });
        }
    }

    public MyAdaper(ArrayList<ItemVO> mItemList) {
        this.mItemList = mItemList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.main_item, viewGroup, false);
        MyViewHolder viewHolder = new MyViewHolder(v, mListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, int i) {
        ItemVO item = mItemList.get(i);
        viewHolder.mImageView.setImageResource(item.getImgId());
        viewHolder.mTextId.setText(String.valueOf(item.getId()));
        viewHolder.mTextTitle.setText(item.getTitle());
        viewHolder.mTextContent.setText(item.getContent());

    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }
}
