package com.example.trackmybusmain.Common.TicketBooking;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trackmybusmain.R;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    Context context;
    ArrayList<TicketModel> tickets;

    RecyclerAdapter(Context context, ArrayList<TicketModel> tickets){
        this.context = context;
        this.tickets = tickets;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.bookings_row,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.fromCityName.setText(tickets.get(position).fromLocName);
        holder.fromCityTime.setText(tickets.get(position).fromLocTime);
        holder.fromCityDate.setText(tickets.get(position).fromLocDate);
        holder.toCityName.setText(tickets.get(position).toLocName);
        holder.toCityTime.setText(tickets.get(position).toLocTime);
        holder.toCityDate.setText(tickets.get(position).toLocDate);
        holder.passengers.setText(tickets.get(position).passengers);

        //onclick listener for cardview
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TicketModel clickedTicket = tickets.get(position);
                Intent intent = new Intent(context, ShowTicket.class);

                intent.putExtra("fromCityName",clickedTicket.fromLocName);
                intent.putExtra("onBoardTime",clickedTicket.fromLocTime);
                intent.putExtra("onBoardDate",clickedTicket.fromLocDate);
                intent.putExtra("toCityName",clickedTicket.toLocName);
                intent.putExtra("busNo",clickedTicket.busNo);
                intent.putExtra("ticketId",clickedTicket.ticketId);

                context.startActivity(intent);




            }
        });
    }

    @Override
    public int getItemCount() {
        return tickets.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView fromCityName,toCityName,fromCityTime,toCityTime,fromCityDate,toCityDate,passengers,busNo,ticketId;
        CardView cardView;
        public ViewHolder(View itemView) {
            super(itemView);
            fromCityName  = itemView.findViewById(R.id.fromcitynameMybookings);
            fromCityTime = itemView.findViewById(R.id.fromcitytimeMybooking);
            fromCityDate = itemView.findViewById(R.id.fromcitydateMybooking);
            toCityName = itemView.findViewById(R.id.TocitynameMybookings);
            toCityTime = itemView.findViewById(R.id.TocitytimeMybooking);
            toCityDate = itemView.findViewById(R.id.TocitydateMybooking);
            cardView = itemView.findViewById(R.id.ticketContainer);
            passengers = itemView.findViewById(R.id.passangersMybooking);
            ticketId = itemView.findViewById(R.id.ticketId);
            busNo = itemView.findViewById(R.id.busNoMybookings);


        }
    }
}
