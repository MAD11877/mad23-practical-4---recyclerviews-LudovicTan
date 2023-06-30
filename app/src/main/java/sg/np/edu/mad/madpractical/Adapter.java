package sg.np.edu.mad.madpractical;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<ViewHolder> {
    private ArrayList<User> users;
    private Context context;
    private AlertDialog.Builder builder;

    public Adapter(Context context, ArrayList<User> users) {
        this.context = context;
        this.users = users;
        builder = new AlertDialog.Builder(context);
    }

    @Override
    public int getItemViewType(int position) {
        User user = users.get(position);
        if (user.getName().endsWith("7")) {
            return 0;
        } else {
            return 1;
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView;
        if (viewType == 0) {
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_user, parent, false);
        } else {
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler, parent, false);
        }
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User user = users.get(position);
        Log.i("ONBINDVIEWHOLDER", user.getName());
        Log.i("ONBINDVIEWHOLDER", user.getDescription());

        holder.text.setText(user.getName());
        holder.textid.setText(user.getDescription());

        holder.imgview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setTitle("Profile");
                builder.setMessage(user.getName());
                builder.setPositiveButton("VIEW",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent gvIntent = new Intent(context, MainActivity.class);
                                gvIntent.putExtra("key", (CharSequence) user);
                                Log.i("Adapter", user.getName());
                                context.startActivity(gvIntent);
                            }
                        });
                builder.setNegativeButton("Close",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                builder.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}
