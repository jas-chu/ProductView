package cursomercadolibre.mercadolibre.com.ar.cursomercadolibre.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import cursomercadolibre.mercadolibre.com.ar.cursomercadolibre.R;
import cursomercadolibre.mercadolibre.com.ar.cursomercadolibre.activities.ProductActivity;
import cursomercadolibre.mercadolibre.com.ar.cursomercadolibre.model.Article;


/**
 * Created by jsella on 12/27/16.
 */
public class ArticlesAdapter extends RecyclerView.Adapter<ArticlesAdapter.ViewHolder> {

    private List<Article> items = new ArrayList<Article>();

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_article, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Article article = this.items.get(position);

        holder.title.setText(article.getTitle());
        holder.priceItem.setText(article.getPrice());
//        Picasso.with(this)
//                .load(article.getThumbnail())
//                .into(holder.productItem);

        holder.view.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, ProductActivity.class);
                context.startActivity(intent);
            }
        });
        if (position % 2 == 0) {
            holder.view.setBackgroundResource(R.color.grey);
        } else {
            holder.view.setBackgroundResource(R.color.white);
        }
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    public void setItems(List<Article> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        View view;

        @Bind(R.id.titleItem)
        TextView title;
        @Bind(R.id.priceItem)
        TextView priceItem;
        @Bind(R.id.productItem)
        ImageView productItem;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            view = itemView;
        }
    }
}