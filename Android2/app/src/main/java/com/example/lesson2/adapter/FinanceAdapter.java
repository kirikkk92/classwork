package com.example.lesson2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lesson2.R;
import com.example.lesson2.model.Finance;

public class FinanceAdapter extends BaseAdapter {
    private Finance[] finances;
    private Context context;

    public FinanceAdapter(Context context, Finance[] finances){
        this.finances = finances;
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.finances.length;
    }

    @Override
    public Object getItem(int position) {
        return this.finances[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Finance f = this.finances[position];
        View view = convertView;
        //если элемент списка отображается впервые, то
        //convertView == null, и нам необходимо загрузить
        //макет элемента списка самостоятельно
        if (view == null){//отображается впервые
            view = LayoutInflater.from(this.context).inflate(R.layout.finance_item,parent,false);
        }
        TextView sum = view.findViewById(R.id.sum);
        TextView name = view.findViewById(R.id.name);
        TextView date = view.findViewById(R.id.date);
        TextView creditLable = view.findViewById(R.id.creditLable);

        sum.setText(String.valueOf(f.sum));
        date.setText(f.date);
        name.setText(f.name);
        creditLable.setText(f.creditLabel);
        return view;
    }
}
