package yanyan.qezlpro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017/7/28 0028.
 */

public class A_BaseAdapter extends BaseAdapter{
    private List<B_qqgj>list;
    private LayoutInflater inflater;

    public A_BaseAdapter(Context  context,List<B_qqgj>list)
    {
        this.list=list;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

//        ViewHolder viewHolder;
//        if(convertView==null)
//        {
//            viewHolder=new ViewHolder();
//            convertView=inflater.inflate(R.layout.ys_zlist,null);
//            viewHolder.tp= (ImageView) convertView.findViewById(R.id.ys_z_tp);
//            viewHolder.bt= (TextView) convertView.findViewById(R.id.ys_z_t1);
//            viewHolder.bt2= (TextView) convertView.findViewById(R.id.ys_z_t2);
//            convertView.setTag(viewHolder);
//        }
//        else {
//            viewHolder= (ViewHolder) convertView.getTag();
//            B_qqgj sj=list.get(position);
//            viewHolder.tp.setImageResource(sj.tp);
//            viewHolder.bt.setText(sj.bt);
//            viewHolder.bt2.setText(sj.bt2);
//        }
//
//        return convertView;
        if(convertView==null)
        {
            convertView=inflater.inflate(R.layout.ys_listtwo,null);

            TextView bt= (TextView) convertView.findViewById(R.id.listtwo_bt);
            TextView bt2= (TextView) convertView.findViewById(R.id.listtwo_xx);
            B_qqgj qqgj=list.get(position);
            bt.setText(qqgj.bt);
            bt2.setText(qqgj.xx);

        }
        return convertView;
    }

}
