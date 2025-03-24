package ca.dal.cs.csci3130.a4.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ca.dal.cs.csci3130.a4.R;
import ca.dal.cs.csci3130.a4.factory.Item;

public class SearchRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    LayoutInflater inflater;
    ArrayList<Item> items;
    ArrayList<String> headers;
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    ItemClickListener listener;

    public SearchRecyclerViewAdapter(Context context, ArrayList<Item> items, ArrayList<String> headers) {
        this.inflater = LayoutInflater.from(context);
        this.items = items;
        this.headers = headers;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER) {
            View view = this.inflater.inflate(R.layout.recycler_header, parent, false);
            return new VHHeader(view);
        } else if (viewType == TYPE_ITEM) {
            View view = this.inflater.inflate(R.layout.recycler_row, parent, false);
            return new VHItem(view);
        }
        throw new RuntimeException("Unknown item type!");
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof VHHeader) {
            VHHeader header = (VHHeader) holder;
            if (headers.size() == 2) {
                header.itemNameHeader.setText(headers.get(0));
                header.itemPriceHeader.setText(headers.get(1));
            }
        } else if (holder instanceof VHItem) {
            VHItem row = (VHItem) holder;
            Item currentItem = this.items.get(position - 1);
            row.itemNameRCV.setText(currentItem.getName());
            row.itemPriceRCV.setText("$" + currentItem.getPrice());
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (isPositionHeader(position))
            return TYPE_HEADER;
        else return TYPE_ITEM;
    }

    private boolean isPositionHeader(int position) {
        return position == 0;
    }

    @Override
    public int getItemCount() {
        return this.items.size() + 1;
    }

    public Item getItem(int position) {
        return this.items.get(position - 1);
    }

    class VHItem extends RecyclerView.ViewHolder {
        TextView itemNameRCV;
        TextView itemPriceRCV;

        public VHItem(@NonNull View itemView) {
            super(itemView);
            itemNameRCV = itemView.findViewById(R.id.itemNameRV);
            itemPriceRCV = itemView.findViewById(R.id.itemPriceRV);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(view, getAdapterPosition());
                }
            });
        }
    }

    class VHHeader extends RecyclerView.ViewHolder {
        TextView itemNameHeader;
        TextView itemPriceHeader;

        public VHHeader(@NonNull View itemView) {
            super(itemView);
            itemNameHeader = itemView.findViewById(R.id.itemNameHeader);
            itemPriceHeader = itemView.findViewById(R.id.itemPriceHeader);
        }
    }

    public void setItemClickListener(ItemClickListener listener){
        this.listener=listener;
    }

    public interface ItemClickListener {
        public void onItemClick(View view, int position);
    }


}
