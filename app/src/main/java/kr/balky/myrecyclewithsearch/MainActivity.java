package kr.balky.myrecyclewithsearch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<ItemVO> itemList;

    private RecyclerView mRecyclerView;
    private MyAdaper mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private ImageButton mDetailButton;
    private TextView mItemIdText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeitems();
        buildRecycleView();

    }

    public void initializeitems() {
        itemList = new ArrayList<>();
        itemList.add(new ItemVO(1,R.drawable.scenary1, "Title1", "내용1입니다~~~!!"));
        itemList.add(new ItemVO(3,R.drawable.scenary2, "Title2", "내용2입니다~~~!!"));
        itemList.add(new ItemVO(3,R.drawable.scenary3, "Title3", "내용3입니다~~~!!"));
        itemList.add(new ItemVO(5,R.drawable.scenary4, "Title4", "내용4입니다~~~!!"));
        itemList.add(new ItemVO(5,R.drawable.scenary5, "Title5", "내용5입니다~~~!!"));
        itemList.add(new ItemVO(11,R.drawable.scenary6, "Title6", "내용6입니다~~~!!"));
        itemList.add(new ItemVO(12,R.drawable.scenary7, "Title7", "내용7입니다~~~!!"));
        itemList.add(new ItemVO(13,R.drawable.scenary8, "Title8", "내용8입니다~~~!!"));
        itemList.add(new ItemVO(15,R.drawable.scenary9, "Title9", "내용9입니다~~~!!"));
        itemList.add(new ItemVO(20,R.drawable.scenary10, "Title10", "내용10입니다~~~!!"));
        itemList.add(new ItemVO(21,R.drawable.scenary11, "Title11", "내용11입니다~~~!!"));
        itemList.add(new ItemVO(32,R.drawable.scenary12, "Title12", "내용12입니다~~~!!"));
        itemList.add(new ItemVO(43,R.drawable.scenary13, "Title13", "내용13입니다~~~!!"));
        itemList.add(new ItemVO(64,R.drawable.scenary14, "Title14", "내용14입니다~~~!!"));
        itemList.add(new ItemVO(85,R.drawable.scenary15, "Title15", "내용15입니다~~~!!"));
        itemList.add(new ItemVO(96,R.drawable.scenary16, "Title16", "내용16입니다~~~!!"));
        itemList.add(new ItemVO(97,R.drawable.scenary17, "Title17", "내용17입니다~~~!!"));
        itemList.add(new ItemVO(98,R.drawable.scenary18, "Title18", "내용18입니다~~~!!"));
        itemList.add(new ItemVO(99,R.drawable.scenary19, "Title19", "내용19입니다~~~!!"));
        itemList.add(new ItemVO(120,R.drawable.scenary20, "Title20", "내용20입니다~~~!!"));
    }

    public void buildRecycleView() {
        mRecyclerView = findViewById(R.id.rc_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new MyAdaper(itemList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new MyAdaper.OnItemClickListener() {
            @Override
            public void onDetailClick(int position, int itemId) {
                openDetailItem(position, itemId);
            }
        });
    }

    public void openDetailItem(int position, int itemId){
        Toast.makeText(getApplicationContext(), "아이디 : "+itemId + ", 포지션값 : " + position, Toast.LENGTH_LONG).show();
    }
}
