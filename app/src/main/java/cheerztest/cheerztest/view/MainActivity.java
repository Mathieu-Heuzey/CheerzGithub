package cheerztest.cheerztest.view;

import android.content.Context;
import android.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.loopj.android.http.*;
import org.json.*;

import java.util.List;

import cheerztest.cheerztest.R;
import cheerztest.cheerztest.contract.MainContract;
import cheerztest.cheerztest.presenter.MainPresenter;
import cheerztest.cheerztest.presenter.vo.RepoVO;
import cz.msebera.android.httpclient.Header;

public class MainActivity extends AbstractActivity<MainContract.Presenter> implements MainContract.View, View.OnClickListener {

    @Override
    protected MainContract.Presenter newPresenter() {
        return new MainPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button= (Button) findViewById(R.id.Loader);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        EditText edt = (EditText)findViewById(R.id.userName);
        String user = edt.getText().toString();
        this.presenter.loadRepository(user);
    }

    @Override
    public void displayRepos(List<RepoVO> repos) {
        //TODO la liste avec un recyclerview
        repos.size();
    }
}