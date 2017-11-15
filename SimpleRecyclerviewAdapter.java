package your-packagename-here;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

 

import java.util.ArrayList;

import static android.support.v7.widget.RecyclerView.ViewHolder;

public class SimpleRecyclerviewAdapter extends RecyclerView.Adapter<SimpleRecyclerviewAdapter.MyViewHolder> {

    private int selectedPosition = 0;
    private ArrayList<YourModelClass> dataList;
    private ArrayList<Integer> selectCheck;
    Context context;

    public SimpleRecyclerviewAdapter(Context context, ArrayList<YourModelClass> dataList, ArrayList<Integer> selectCheck) {
        this.dataList = dataList;
        this.selectCheck = selectCheck;
        this.context = context;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.your_layout, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final YourModelClass data = dataList.get(position);

        if (selectCheck.get(position) == 1) {
            holder.checkBox.setChecked(true);
        } else {
            holder.checkBox.setChecked(false);
        }

        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int k=0; k<selectCheck.size(); k++) {
                    if(k==position) {
                        selectCheck.set(k,1);
                    } else {
                        selectCheck.set(k,0);
                    }
                }
                notifyDataSetChanged();

            }
        });
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                
                if(isChecked==true){
                    //Do whatever you want to do with selected value
                }
            }
        });
        

    }

    @Override
    public int getItemCount() {
        return pricingList.size();
    }

    public class MyViewHolder extends ViewHolder {
       
        CheckBox checkBox;

        public MyViewHolder(View itemView) {
            super(itemView);
 

           
            checkBox = (CheckBox) itemView.findViewById(R.id.checkBox);
         

            
            
        }
    }
}
