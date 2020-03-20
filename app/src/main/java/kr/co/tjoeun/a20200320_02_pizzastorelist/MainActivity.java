package kr.co.tjoeun.a20200320_02_pizzastorelist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.List;

import kr.co.tjoeun.a20200320_02_pizzastorelist.adapter.PizzaStoreAdapter;
import kr.co.tjoeun.a20200320_02_pizzastorelist.databinding.ActivityMainBinding;
import kr.co.tjoeun.a20200320_02_pizzastorelist.datas.PizzaStore;

public class MainActivity extends BaseActivity {

    List<PizzaStore>  pizzaStores = new ArrayList<>();
    PizzaStoreAdapter psa = null;
    ActivityMainBinding binding = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupEvents();
        setValues();


    }

    @Override
    public void setupEvents() {

        binding.pizzaListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                PizzaStore clickedStore = pizzaStores.get(position);

                Intent intent = new Intent(mContext, PizzaStoreDetailActivity.class);
                intent.putExtra("store",clickedStore);
                startActivity(intent);

            }
        });

    }

    @Override
    public void setValues() {
        psa = new PizzaStoreAdapter(mContext, R.layout.pizza_stroe_list_item, pizzaStores);
        binding.pizzaListView.setAdapter(psa);


        pizzaStores.add(new PizzaStore("피자헛", "https://img1.daumcdn.net/thumb/R800x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2FnkQca%2FbtqwVT4rrZo%2FymhFqW9uRbzrmZTxUU1QC1%2Fimg.jpg","010-4567-4579"));
        pizzaStores.add(new PizzaStore("ㅇㅇ", "http://mblogthumb2.phinf.naver.net/20160530_65/ppanppane_1464617766007O9b5u_PNG/%C6%C4%C6%C4%C1%B8%BD%BA_%C7%C7%C0%DA_%B7%CE%B0%ED_%284%29.png?type=w800","010-4567-4579"));
        pizzaStores.add(new PizzaStore("도미노", "http://mblogthumb2.phinf.naver.net/20160530_65/ppanppane_1464617766007O9b5u_PNG/%C6%C4%C6%C4%C1%B8%BD%BA_%C7%C7%C0%DA_%B7%CE%B0%ED_%284%29.png?type=w800","010-4567-4579"));
        pizzaStores.add(new PizzaStore("치킨피자", "http://mblogthumb2.phinf.naver.net/20160530_65/ppanppane_1464617766007O9b5u_PNG/%C6%C4%C6%C4%C1%B8%BD%BA_%C7%C7%C0%DA_%B7%CE%B0%ED_%284%29.png?type=w800","010-4567-4579"));

        psa.notifyDataSetChanged();

    }
}
