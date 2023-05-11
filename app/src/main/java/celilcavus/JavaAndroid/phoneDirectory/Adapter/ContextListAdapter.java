package celilcavus.JavaAndroid.phoneDirectory.Adapter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import celilcavus.JavaAndroid.phoneDirectory.MainActivity;
import celilcavus.JavaAndroid.phoneDirectory.Model.PhoneNumbers;
import celilcavus.JavaAndroid.phoneDirectory.PersonDetails;
import celilcavus.JavaAndroid.phoneDirectory.R;
import celilcavus.JavaAndroid.phoneDirectory.databinding.RecylerViewRowBinding;

public class ContextListAdapter extends RecyclerView.Adapter<ContextListAdapter.ViewHolderAdapter> {

    private ArrayList<PhoneNumbers> numbersArrayList;

    public ContextListAdapter(ArrayList<PhoneNumbers> numbersArrayList) {
        this.numbersArrayList = numbersArrayList;
    }

    @NonNull
    @Override
    public ViewHolderAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecylerViewRowBinding recylerViewRowBinding = RecylerViewRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolderAdapter(recylerViewRowBinding);
    }

    @Override
    public int getItemCount() {
        return numbersArrayList.size();
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull ViewHolderAdapter holder, int position) {
        try {
            holder.binding.txtName.setText(numbersArrayList.get(position).getName() + " "
                    .concat(numbersArrayList.get(position).getLastName()));
            holder.binding.txtNumber.setText(numbersArrayList.get(position).getPhoneNumber());
            holder.binding.imageView.setImageResource(R.drawable.img1);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(holder.itemView.getContext(), PersonDetails.class);
                    intent.putExtra("person",numbersArrayList.get(position));
                    holder.itemView.getContext().startActivity(intent);
                }
            });
        } catch (Exception ex) {
            System.out.println("Context List Adapter Exception : " + ex);
        }
    }

    public class ViewHolderAdapter extends RecyclerView.ViewHolder {
        private RecylerViewRowBinding binding;

        public ViewHolderAdapter(RecylerViewRowBinding bind) {
            super(bind.getRoot());
            binding = bind;
        }
    }
}
