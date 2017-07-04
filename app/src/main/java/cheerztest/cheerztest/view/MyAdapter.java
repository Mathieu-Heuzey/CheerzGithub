package cheerztest.cheerztest.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import cheerztest.cheerztest.R;
import cheerztest.cheerztest.model.Repo;
import cheerztest.cheerztest.presenter.vo.RepoVO;

/**
 * Created by Mateo on 04/07/2017.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<RepoVO> listRepo;
    private Context context;

    public MyAdapter(List<RepoVO> listRepo, Context context)
    {
        this.listRepo = listRepo;
        this.context = context;
   }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.repo_list, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
    RepoVO listRepo = this.listRepo.get(position);
    holder.repoName.setText(listRepo.getName());
     //   holder.repoName.setText((listRepo.getId());
    }

    @Override
    public int getItemCount() {
        return listRepo.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView repoName;

        public ViewHolder(View itemView) {
            super(itemView);
            repoName = (TextView) itemView.findViewById(R.id.repoName);

        }
    }
}
