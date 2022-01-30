package com.example.calculator8;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    private TextView tvResult;
    private Button btn_share;
    private Integer firstVar;
    private Integer secondVar;
    private Boolean isOperationClick;
    private String operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResult = findViewById(R.id.tv_result);
        btn_share = findViewById(R.id.share_btn);
        btn_share.setVisibility(View.GONE);
    }


    public void onNumberClick(View view) {
        switch (view.getId()) {
            case R.id.btn_zero:
                setNumber("0");
                break;

            case R.id.btn_one:
                setNumber("1");
                break;
            case R.id.btn_two:
                setNumber("2");
                break;

            case R.id.btn_tree:
                setNumber("3");
                break;

            case R.id.btn_four:
                setNumber("4");
                break;
            case R.id.btn_five:
                setNumber("5");
                break;

            case R.id.btn_six:
                setNumber("6");
                break;

            case R.id.btn_seven:
                setNumber("7");
                break;

            case R.id.btn_eight:
                setNumber("8");
                break;

            case R.id.btn_nine:
                setNumber("9");
                break;

            case R.id.btn_tochka:
                setNumber(".");
                break;

            case R.id.btn_otris:
                setNumber("-");
                break;

            case R.id.btn_clear:
                tvResult.setText("0");
                firstVar = 0;
                secondVar = 0;
                break;
        }
    }


    private void setNumber(String number) {
        if (tvResult.getText().toString().equals("0")) {
            tvResult.setText(number);
        } else if (isOperationClick) {
            tvResult.setText(number);
        } else {
            tvResult.append(number);
        }
        isOperationClick = false;
    }

    public void onOperationClick(View view) {
        switch (view.getId()) {
            case R.id.btn_plus:
                //11
                firstVar = Integer.parseInt(tvResult.getText().toString());
                isOperationClick = true;
                operation = "+";
                break;

            case R.id.minus:
                firstVar = Integer.parseInt(tvResult.getText().toString());
                isOperationClick = true;
                operation = "-";
                break;


            case R.id.umnojenie:
                firstVar = Integer.parseInt(tvResult.getText().toString());
                isOperationClick = true;
                operation = "X";
                break;

            case R.id.delenie:
                firstVar = Integer.parseInt(tvResult.getText().toString());
                isOperationClick = true;
                operation = "/";
                break;

            case R.id.btn_prosent:
                firstVar = Integer.parseInt(tvResult.getText().toString());
                isOperationClick = true;
                operation = "%";
                break;


            case R.id.btn_equal:
                secondVar = Integer.parseInt(tvResult.getText().toString());
                Integer result = 0;
                if (isOperationClick = true) {
                    btn_share.setVisibility(View.VISIBLE);


                    btn_share.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(MainActivity.this, Secondactivity.class);
                            String text = tvResult.getText().toString();
                            intent.putExtra("key", text);
                            startActivity(intent);
                            finishActivity(123);
                        }
                    });

                }


                switch (operation) {
                    case "+":
                        result = firstVar + secondVar;
                        break;

                    case "-":
                        result = firstVar - secondVar;
                        break;

                    case "X":
                        result = firstVar * secondVar;
                        break;

                    case "/":
                        result = firstVar / secondVar;
                        break;

                    case "%":
                        result = (secondVar * 100) / firstVar;
                        break;
                }

                tvResult.setText(result.toString());
                break;


        }
    }
}