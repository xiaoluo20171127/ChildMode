package com.swaiotos.launcher.kidsmode.common.view;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.swaiotos.common.log.Logger;
import com.swaiotos.common.ui.UiUtil;
import com.swaiotos.launcher.kidsmode.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @ Created on: 2020/1/8
 * @Author: LEGION XiaoLuo
 * @ Description:
 */
public class ParentModeView extends FrameLayout {
    private static final String TAG = "ChildModeCalculation";
    private List<Integer> num;
    private NumberView mAnswerView;
    private int mRandomA, mRandomB, mResult, mDigit;
    private Button mTextView1, mTextView2, mTextView3, mTextView4;
    private StringBuffer mAnswerStr = new StringBuffer();
    private NumberView  questionView;
    private ImageView mTitleView;
    private IParentModeCallBack mIParentModeCallBack;
    private String mQusetionColor = "#D07B2E";
    private String mCircleTextColor = "#B17035";

    public ParentModeView(Context context) {
        super(context);
        setLayoutParams(new ViewGroup.LayoutParams(UiUtil.div(996), UiUtil.div(596)));
        setBackgroundResource(R.drawable.dialog_bg);
        initView();
    }

    public ParentModeView(Context context, int width, int height) {
        super(context);
        setLayoutParams(new ViewGroup.LayoutParams(width, height));
        initView();
    }

    private void initView() {
        mTitleView = new ImageView(getContext());
        LayoutParams titleParams = new LayoutParams(UiUtil.div(687), UiUtil.div(49));
        titleParams.leftMargin = UiUtil.div(180);
        titleParams.topMargin = UiUtil.div(108);
        mTitleView.setLayoutParams(titleParams);
        addView(mTitleView);

        questionView = new NumberView(getContext());
        questionView.setSizeAndColor(60,"#D07B2E");
        LayoutParams questionParams = new LayoutParams(UiUtil.div(231), UiUtil.div(58));
        questionParams.leftMargin = UiUtil.div(319);
        questionParams.topMargin = UiUtil.div(209);
        addView(questionView, questionParams);


        View lineView = new View(getContext());
        lineView.setBackgroundColor(Color.parseColor(mQusetionColor));
        LayoutParams lineParams = new LayoutParams(UiUtil.div(190), UiUtil.div(4));
        lineParams.leftMargin = UiUtil.div(550);
        lineParams.topMargin = UiUtil.div(275);
        addView(lineView, lineParams);

        mAnswerView = new NumberView(getContext());
        mAnswerView.setSizeAndColor(60,"#D45B35");
        LayoutParams answerParams = new LayoutParams(UiUtil.div(134), UiUtil.div(58));
        answerParams.leftMargin = UiUtil.div(578);
        answerParams.topMargin = UiUtil.div(209);
        addView(mAnswerView, answerParams);

        mTextView1 = new Button(getContext());
        mTextView1.setBackgroundResource(R.drawable.dialog_circle);
        mTextView1.setTextSize(TypedValue.COMPLEX_UNIT_PX,UiUtil.dpi(66));
        mTextView1.setTextColor(Color.parseColor("#D07B2E"));
        mTextView1.setOnClickListener(clickListener);
        LayoutParams params1 = new LayoutParams(UiUtil.div(130), UiUtil.div(130));
        params1.leftMargin = UiUtil.div(221);
        params1.topMargin = UiUtil.div(317);
        addView(mTextView1, params1);

        mTextView2 = new Button(getContext());
        mTextView2.setOnClickListener(clickListener);
        mTextView2.setBackgroundResource(R.drawable.dialog_circle);
        mTextView2.setTextSize(TypedValue.COMPLEX_UNIT_PX,UiUtil.dpi(66));
        mTextView2.setTextColor(Color.parseColor("#D07B2E"));
        LayoutParams params2 = new LayoutParams(UiUtil.div(117), UiUtil.div(117));
        params2.leftMargin = UiUtil.div(383);
        params2.topMargin = UiUtil.div(323);
        addView(mTextView2, params2);

        mTextView3 = new Button(getContext());
        mTextView3.setOnClickListener(clickListener);
        mTextView3.setBackgroundResource(R.drawable.dialog_circle);
        mTextView3.setTextSize(TypedValue.COMPLEX_UNIT_PX,UiUtil.dpi(66));
        mTextView3.setTextColor(Color.parseColor("#D07B2E"));
        LayoutParams params3 = new LayoutParams(UiUtil.div(117), UiUtil.div(117));
        params3.leftMargin = UiUtil.div(536);
        params3.topMargin = UiUtil.div(323);
        addView(mTextView3, params3);

        mTextView4 = new Button(getContext());
        mTextView4.setOnClickListener(clickListener);
        mTextView4.setBackgroundResource(R.drawable.dialog_circle);
        mTextView4.setTextSize(TypedValue.COMPLEX_UNIT_PX,UiUtil.dpi(66));
        mTextView4.setTextColor(Color.parseColor("#D07B2E"));
        LayoutParams params4 = new LayoutParams(UiUtil.div(117), UiUtil.div(117));
        params4.leftMargin = UiUtil.div(689);
        params4.topMargin = UiUtil.div(323);
        addView(mTextView4, params4);


        updateQuestion();
    }

    public void setTitleView(final int resId) {
        post(new Runnable() {
            @Override
            public void run() {
                mTitleView.setImageResource(resId);
            }
        });
    }


    public void setCallBack(IParentModeCallBack callBack) {
        mIParentModeCallBack = callBack;
    }

    private void updateQuestion() {
        mRandomA = randomNum(10, 50);
        mRandomB = randomNum(2, 9);
        mResult = mRandomA * mRandomB;
        if (mResult > 99) {
            mDigit = 3;
        } else {
            mDigit = 2;
        }

        final StringBuffer sb = new StringBuffer();
        sb.append(mRandomA);
        sb.append(" X ");
        sb.append(mRandomB);
        sb.append(" = ");
        post(new Runnable() {
            @Override
            public void run() {
                questionView.setText(sb.toString());
            }
        });
        clearAnswer();
        setAnswerButtonText();
    }

    private void clearAnswer() {
        mAnswerStr.setLength(0);
        mAnswerView.setText(mAnswerStr.toString());
    }

    private void setAnswerButtonText() {
        num = getInt();
        Collections.shuffle(num);
        post(new Runnable() {
            @Override
            public void run() {
                mTextView1.setText(String.valueOf(num.get(0)));
                mTextView2.setText(String.valueOf(num.get(1)));
                mTextView3.setText(String.valueOf(num.get(2)));
                mTextView4.setText(String.valueOf(num.get(3)));
            }
        });
    }

    private List<Integer> getInt() {
        int product = mRandomA * mRandomB;
        List<Integer> num = new ArrayList<>();
        int a, b, c, d;
        if (product > 99) {
            a = product / 100;
            b = (product - (a * 100)) / 10;
            while (b == a) {
                b = new Random().nextInt(10);
            }
            c = product % 10;
            while (c == a || c == b) {
                c = new Random().nextInt(10);
            }
            d = new Random().nextInt(10);
            while (d == a || d == b || d == c) {
                d = new Random().nextInt(10);
            }
        } else {
            a = product / 10;
            b = product % 10;
            while (b == a) {
                b = new Random().nextInt(10);
            }
            c = new Random().nextInt(10);
            while (c == a || c == b) {
                c = new Random().nextInt(10);
            }
            d = new Random().nextInt(10);
            while (d == a || d == b || d == c) {
                d = new Random().nextInt(10);
            }
        }
        num.add(a);
        num.add(b);
        num.add(c);
        num.add(d);
        return num;
    }


    private OnClickListener clickListener = new OnClickListener() {
        @Override
        public void onClick(View view) {
            final String s = ((Button) view).getText().toString();
            appendAndCheck(s);
        }
    };


    private void appendAndCheck(String s) {
        //拒绝首位输0
        if (mAnswerStr.length() == 0 && s.equals("0")) {
            post(new Runnable() {
                @Override
                public void run() {
                    mAnswerView.setText("0");
                }
            });
            answerWrong();
            return;
        }
        //限制长度并显示
        if (mAnswerStr.length() < mDigit) {
            mAnswerStr.append(s);
            checkAnswer();
            post(new Runnable() {
                @Override
                public void run() {
                    mAnswerView.setText(mAnswerStr.toString());
                }
            });
        }
    }

    /**
     * 生成 [min,max]之间的数字
     */
    private int randomNum(int min, int max) {
        Random random = new Random();
        return min + random.nextInt(max + 1 - min);
    }

    private void checkAnswer() {
        int temp = Integer.valueOf(mAnswerStr.toString().trim());
        Log.e(TAG, "tmpResult = " + temp + ", mResult = " + mResult);
        if (mAnswerStr.length() == 1) {
            //输入一位 答案是两位
            if (mDigit == 2) {
                if (mResult / 10 != temp) {
                    answerWrong();
                }
            } else {//输入一位 答案是三位
                if (mResult / 100 != temp) {
                    answerWrong();
                }
            }

        } else if (mAnswerStr.length() == 2) {
            //输入两位 答案是两位
            if (mDigit == 2) {
                if (mResult == temp) {
                    answerRight();
                } else {
                    answerWrong();
                }
            } else {//输入两位 答案是三位
                if (mResult / 10 != temp) {
                    answerWrong();
                }
            }
        } else if (mAnswerStr.length() == 3) {
            //输入三位 答案是三位
            if (mDigit == 3) {
                if (mResult == temp) {
                    answerRight();
                } else {
                    answerWrong();
                }
            }
        }
    }

    private void answerRight() {
        postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mIParentModeCallBack != null) {
                    mIParentModeCallBack.rightAnswer();
                }
            }
        }, 200);
    }

    private void answerWrong() {
        post(new Runnable() {
            @Override
            public void run() {
                mAnswerView.setTextColor("#FF0000");
                postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        clearAnswer();
                        mAnswerView.setTextColor("#D45B35");
                        updateQuestion();
                        if (mIParentModeCallBack != null) {
                            mIParentModeCallBack.wrongAnswer();
                        }
                        Logger.e(TAG, "mAnswerStr wrong, updateQuestion");
                    }
                }, 500);
            }
        });
    }
}
