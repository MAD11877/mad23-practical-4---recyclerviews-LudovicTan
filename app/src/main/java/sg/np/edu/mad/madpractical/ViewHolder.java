package sg.np.edu.mad.madpractical;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder{
    ImageView imgview;
    TextView text;
    TextView textid;

    public ViewHolder(View itemView){
        super(itemView);
        imgview = itemView.findViewById(R.id.imgView_r);
        text = itemView.findViewById(R.id.nameview_r);
        textid = itemView.findViewById(R.id.idview_r);
    }
}
