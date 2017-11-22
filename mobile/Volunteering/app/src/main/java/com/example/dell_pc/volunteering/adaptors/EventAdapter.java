package com.example.dell_pc.volunteering.adaptors;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dell_pc.volunteering.R;
import com.example.dell_pc.volunteering.models.Event;

import java.util.List;

/**
 * Created by DELL-PC on 19/11/2017.
 */

public class EventAdapter extends ArrayAdapter<Event> {

    Context context;
    int resource;

    public EventAdapter(@NonNull Context context, int resource, @NonNull List<Event> events) {
        super(context, resource, events);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view =convertView;
                EventsHolder holder =new EventsHolder();
            if (view==null){
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(resource, parent, false);

                holder.tvName = (TextView) view.findViewById(R.id.tv_event_name);
                holder.tvType = (TextView) view.findViewById(R.id.tv_event_type);
                holder.tvDuration = (TextView) view.findViewById(R.id.tv_event_duration);
                holder.imgEvent = (ImageView) view.findViewById(R.id.img_event);
                view.setTag(holder);
            }
            else
            {
                holder=(EventsHolder)view.getTag();
            }
        holder.tvName.setText(getItem(position).getNameEvent());
        holder.tvType.setText(getItem(position).getType());
        holder.tvDuration.setText(getItem(position).getDuration());
        holder.imgEvent.setBackgroundResource(getItem(position).getImageRes());

        return view;
    }

    class EventsHolder {
        TextView tvName;
        TextView tvType;
        TextView tvDuration;
        ImageView imgEvent;

    }
}
