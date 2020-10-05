package br.com.example.githubrepositories.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.example.githubrepositories.R;
import br.com.example.githubrepositories.models.Repository;

public class RepositoryAdapter extends RecyclerView.Adapter<RepositoryAdapter.RepositoryViewHolder> {
    private List<Repository> repositoryList;
    private int index;
    private Context context;

    public RepositoryAdapter(List<Repository> repositoryList, int index, Context context) {
        this.repositoryList = repositoryList;
        this.index = index;
        this.context = context;
    }

    public List<Repository> getRepositoryList() {
        return repositoryList;
    }

    public void setRepositoryList(List<Repository> repositoryList) {
        this.repositoryList = repositoryList;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RepositoryAdapter.RepositoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(index, parent, false);

        return new RepositoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RepositoryAdapter.RepositoryViewHolder holder, int position) {
        holder.repName.setText(repositoryList.get(position).getName());
        holder.repDesc.setText(repositoryList.get(position).getDescription());
        holder.repLang.setText(repositoryList.get(position).getLanguage());
    }

    @Override
    public int getItemCount() {
        return repositoryList.size();
    }

    public class RepositoryViewHolder extends  RecyclerView.ViewHolder {

        //Mudando o padrão de definir as variáveis para facilitar, já que em outras partes está bem descripto quem é cada uma e o que faz;
        LinearLayout repLayout;
        TextView repName, repDesc, repLang;

        public RepositoryViewHolder(@NonNull View itemView) {
            super(itemView);
            repLayout = itemView.findViewById(R.id.repository_item_layout);
            repName = itemView.findViewById(R.id.repository_name);
            repDesc = itemView.findViewById(R.id.repository_description);
            repLang = itemView.findViewById(R.id.repository_language);
        }
    }
}
