package com.example.speedrecords.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.speedrecords.R;
import com.example.speedrecords.model.User;
import com.example.speedrecords.util.DateFormatter;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {

  private Context mContext;
  private User[] mUsers;

  public UserAdapter(Context context, User[] users) {
    this.mContext = context;
    this.mUsers = users;
  }

  @NonNull
  @Override
  public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View v = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.item_user, parent, false);
    return new MyViewHolder(v);
  }

  @Override
  public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
    User user = mUsers[position];

    holder.distanceTextView.setText(user.firstName);
    holder.durationTextView.setText(user.lastName);
    String distanceText = user.firstName;
    int numdistance = Integer.parseInt(distanceText);
    String durationText = user.lastName;
    int numduration = Integer.parseInt(durationText);
    double speed = (numdistance*numduration) * 3.6;
    String str = String.valueOf(speed);
    holder.speedTextView.setText(str);
    //holder.singleTextView.setBackgroundColor(user.single ? Color.RED : Color.WHITE);
    holder.genderImageView.setImageResource(
        speed > 180 ? R.drawable.red_cow : Color.WHITE
    );
  }

  @Override
  public int getItemCount() {
    return mUsers.length;
  }

  static class MyViewHolder extends RecyclerView.ViewHolder {
    TextView fullNameTextView;
    TextView birthDateTextView;
    ImageView genderImageView;
    TextView singleTextView;
    ImageView fastImageView;
    TextView speedTextView;
    TextView distanceTextView;
    TextView durationTextView;
    public MyViewHolder(@NonNull View itemView) {
      super(itemView);
      //this.fastImageView = itemView.findViewById(R.id.speed_text_view);
      this.speedTextView = itemView.findViewById(R.id.speed_text_view);
      this.distanceTextView = itemView.findViewById(R.id.distance_text_view);
      this.durationTextView = itemView.findViewById(R.id.duration_text_view);
      this.fastImageView = itemView.findViewById(R.id.fast_image_view);
      //this.singleTextView = itemView.findViewById(R.id.single_text_view);
    }
  }
}
