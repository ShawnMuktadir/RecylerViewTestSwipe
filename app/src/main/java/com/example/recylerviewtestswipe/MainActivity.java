package com.example.recylerviewtestswipe;

import android.content.ClipData;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Book> bookList = new ArrayList<>();
    private RecyclerView recyclerView;

    private BookAdapter mAdapter;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mAdapter = new BookAdapter(bookList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(context,
                DividerItemDecoration.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        initBookData();
        final SwipeHelper swipeHelper = new SwipeHelper(this, recyclerView) {
            @Override
            public void instantiateUnderlayButton(RecyclerView.ViewHolder viewHolder, List<UnderlayButton> underlayButtons) {
                underlayButtons.add(new SwipeHelper.UnderlayButton(
                        "Delete",
                         0,
                        Color.parseColor("#FF3C30"),
                        new SwipeHelper.UnderlayButtonClickListener() {
                            @Override
                            public void onClick(int pos) {
                                // TODO: onDelete
                                Toast.makeText(context, "Item Delete " + pos, Toast.LENGTH_SHORT).show();
                            }
                        }
                ));

                underlayButtons.add(new SwipeHelper.UnderlayButton(
                        "Transfer",
                        0,
                        Color.parseColor("#FF9502"),
                        new SwipeHelper.UnderlayButtonClickListener() {
                            @Override
                            public void onClick(int pos) {
                                // TODO: OnTransfer
                                Toast.makeText(context, "Item Transfer " + pos, Toast.LENGTH_SHORT).show();
                            }
                        }
                ));
//                underlayButtons.add(new SwipeHelper.UnderlayButton(
//                        "Unshare",
//                        0,
//                        Color.parseColor("#C7C7CB"),
//                        new SwipeHelper.UnderlayButtonClickListener() {
//                            @Override
//                            public void onClick(int pos) {
//                                // TODO: OnUnshare
//                                Toast.makeText(context, "Item " + pos, Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                ));
            }
        };
        swipeHelper.attachSwipe();
    }

    private void initBookData() {
        Book book = new Book("Hello Android", "Ed Burnette");
        bookList.add(book);

        book = new Book("Beginning Android 3", "Mark Murphy");
        bookList.add(book);

        book = new Book("Unlocking Android", " W. Frank Ableson");
        bookList.add(book);

        book = new Book("Android Tablet Development", "Wei Meng Lee");
        bookList.add(book);

        book = new Book("Android Apps Security", "Sheran Gunasekera");
        bookList.add(book);

        book = new Book("Hello Android", "Ed Burnette");
        bookList.add(book);

        book = new Book("Beginning Android 3", "Mark Murphy");
        bookList.add(book);

        book = new Book("Unlocking Android", " W. Frank Ableson");
        bookList.add(book);

        book = new Book("Android Tablet Development", "Wei Meng Lee");
        bookList.add(book);

        book = new Book("Android Apps Security", "Sheran Gunasekera");
        bookList.add(book);

        book = new Book("Beginning Android 3", "Mark Murphy");
        bookList.add(book);

        book = new Book("Unlocking Android", " W. Frank Ableson");
        bookList.add(book);

        book = new Book("Android Tablet Development", "Wei Meng Lee");
        bookList.add(book);

        book = new Book("Android Apps Security", "Sheran Gunasekera");
        bookList.add(book);

        mAdapter.notifyDataSetChanged();
    }
}
