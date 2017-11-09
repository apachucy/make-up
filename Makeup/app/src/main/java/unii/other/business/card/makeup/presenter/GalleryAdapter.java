package unii.other.business.card.makeup.presenter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import unii.other.business.card.makeup.R;

public class GalleryAdapter extends BaseAdapter {

    private int[] images;
    private Context context;
    private ViewHolder viewHolder;

    public GalleryAdapter(Context context, int[] images) {
        this.context = context;
        this.images = images;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return images[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // create a ImageView programmatically
        if (convertView == null) {
            // inflate the layout
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            convertView = inflater.inflate(R.layout.item_image, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.photo = (ImageView) convertView.findViewById(R.id.makeup_sample);
        }
        Glide.with(context).load(images[position]).centerCrop().into(viewHolder.photo);
        return viewHolder.photo;
    }

    static class ViewHolder {
        ImageView photo;
    }
}
