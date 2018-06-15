package com.maxot.mytest.ui.main.tasks.newTask;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.maxot.mytest.R;
import com.maxot.mytest.data.db.model.CustomTask;
import com.maxot.mytest.di.component.ActivityComponent;
import com.maxot.mytest.ui.basic.BaseDialog;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NewTaskDialog extends BaseDialog implements NewTaskDialogMvpView{

    public static final String TAG = "NewTaskDialog";

    @Inject
    NewTaskDialogMvpPresenter<NewTaskDialogMvpView> mPresenter;

    @BindView(R.id.et_task_name)
    EditText etTaskName;

    @BindView(R.id.et_task_subject)
    EditText etTaskSubject;

    @BindView(R.id.et_task_text)
    EditText etTaskText;



    public static NewTaskDialog newInstance() {
        NewTaskDialog fragment = new NewTaskDialog();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_new_task, container, false);

        ActivityComponent component = getActivityComponent();
        if (component != null) {

            component.inject(this);

            setUnBinder(ButterKnife.bind(this, view));

            mPresenter.onAttach(this);
        }

        return view;
    }

    public void show(FragmentManager fragmentManager) {
        super.show(fragmentManager, TAG);
    }

    @Override
    protected void setUp(View view) {

    }

    @OnClick(R.id.btn_save)
    void onSaveClick(){
        if (etTaskName.getText().length() != 0 &&
                etTaskSubject.getText().length() != 0 &&
                etTaskText.getText().length() != 0){

            CustomTask task = new CustomTask(etTaskName.getText().toString(),
                    etTaskSubject.getText().toString(),
                    etTaskText.getText().toString());
            mPresenter.addNewTask(task);
            Toast toast = Toast.makeText(getContext(),
                    etTaskName.getText().toString() + " added to db", Toast.LENGTH_SHORT);
            toast.show();
            dismissDialog(TAG);
        } else{
            Toast toast = Toast.makeText(getContext(),
                    "fill all fields!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    @OnClick(R.id.btn_close)
    void onCloseClick(){
        dismissDialog(TAG);
    }
}
