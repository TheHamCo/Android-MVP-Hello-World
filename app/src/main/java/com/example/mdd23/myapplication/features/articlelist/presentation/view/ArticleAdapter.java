package com.example.mdd23.myapplication.features.articlelist.presentation.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.mdd23.myapplication.R;
import com.example.mdd23.myapplication.features.articlelist.domain.ArticleSummary;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by mdd23 on 9/2/2016.
 */
public class ArticleAdapter extends ArrayAdapter<ArticleSummary> {

    public ArticleAdapter(Context context, List<ArticleSummary> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ArticleSummary articleSummary = getItem(position);
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.article, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        viewHolder = (ViewHolder) convertView.getTag();

        setViews(articleSummary, viewHolder);

        return convertView;
    }

    private void setViews(ArticleSummary articleSummary, ViewHolder viewHolder) {
        viewHolder.title.setText(articleSummary.title);
        viewHolder.shortDescription.setText(articleSummary.shortDescription);
    }

    static class ViewHolder {
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.shortDescription)
        TextView shortDescription;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
