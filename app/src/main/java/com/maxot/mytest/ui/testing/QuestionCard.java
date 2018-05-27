package com.maxot.mytest.ui.testing;

import android.graphics.Color;
import android.widget.Button;
import android.widget.TextView;

import com.maxot.mytest.R;
import com.maxot.mytest.data.db.model.Option;
import com.maxot.mytest.data.db.model.Question;
import com.mindorks.placeholderview.annotations.Click;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.NonReusable;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

@NonReusable
@Layout(R.layout.card_layout)
public class QuestionCard {

    public static final String TAG = "QuestionCard";

    @View(R.id.tv_question_txt)
    private TextView mQuestionTextView;

    @View(R.id.btn_option_1)
    private Button mOption1Button;

    @View(R.id.btn_option_2)
    private Button mOption2Button;

    @View(R.id.btn_option_3)
    private Button mOption3Button;



    private Question mQuestion;

    public QuestionCard(Question question) {
        mQuestion = question;
    }

    @Resolve
    private void omResolved(){

        mQuestionTextView.setText(mQuestion.getQuestionText());

        for (int i = 0; i < 3; i++){
            Button button = null;
            switch (i) {
                case 0:
                    button = mOption1Button;
                    break;
                case 1:
                    button = mOption2Button;
                    break;
                case 2:
                    button = mOption3Button;
                    break;
            }

            if (button != null)
                button.setText(mQuestion.getOptionList().get(i).getOptionText());
        }
    }

    private void showCorrectOptions(){
        for (int i = 0; i < 3; i++){
            Option option = mQuestion.getOptionList().get(i);
            Button button = null;
            switch (i) {
                case 0:
                    button = mOption1Button;
                    break;
                case 1:
                    button = mOption1Button;
                    break;
                case 2:
                    button = mOption1Button;
                    break;
            }
            if (button != null){
                if (option.isCorrect()) {
                    button.setBackgroundColor(Color.GREEN);
                } else {
                    button.setBackgroundColor(Color.RED);
                }
            }
        }
    }

    @Click(R.id.btn_option_1)
    private void onOptionClick1(){
        showCorrectOptions();
    }

    @Click(R.id.btn_option_2)
    private void onOptionClick2(){
        showCorrectOptions();
    }

    @Click(R.id.btn_option_3)
    private void onOptionClick3(){
        showCorrectOptions();
    }

}
