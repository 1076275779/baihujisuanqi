package com.mrzhushuai.baihu;

import com.mrwang.baihu.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


public class MainActivity extends Activity {
	
	 //radio
    private RadioButton radio_san;
    private RadioButton radio_si;

    //EditText
    private EditText edit_alive1;
    private EditText edit_drag1;
    private EditText edit_hu1;
    private EditText edit_alive2;
    private EditText edit_drag2;
    private EditText edit_hu2;
    private EditText edit_alive3;
    private EditText edit_drag3;
    private EditText edit_hu3;
    private EditText edit_alive4;
    private EditText edit_drag4;
    private EditText edit_hu4;
    private EditText beilv;

    //TextView
    private TextView text_4;
    private TextView settlement1;
    private TextView settlement2;
    private TextView settlement3;
    private TextView settlement4;

    //button
    private Button btn12;

    //
    int[] A = new int[4];
    int[] B = new int[4];
    int[] C = new int[4];
    int[] mw = new int[4];
    int[] WW = new int[4];
    int[] cong = new int[4];
    //int

    private  int check = 0;
    private double beilvzhi;


    private void qingling(){

    }


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//定义变量

        //radio
        radio_san = (RadioButton) findViewById(R.id.radio_san);
        radio_si = (RadioButton) findViewById(R.id.radio_si);

        //EditText
        edit_alive1 = (EditText)findViewById(R.id.edit_alive1);
        edit_drag1 = (EditText)findViewById(R.id.edit_drag1);
        edit_hu1 = (EditText)findViewById(R.id.edit_hu1);
        edit_alive2 = (EditText)findViewById(R.id.edit_alive2);
        edit_drag2 = (EditText)findViewById(R.id.edit_drag2);
        edit_hu2 = (EditText)findViewById(R.id.edit_hu2);
        edit_alive3 = (EditText)findViewById(R.id.edit_alive3);
        edit_drag3 = (EditText)findViewById(R.id.edit_drag3);
        edit_hu3 = (EditText)findViewById(R.id.edit_hu3);
        edit_alive4 = (EditText)findViewById(R.id.edit_alive4);
        edit_drag4 = (EditText)findViewById(R.id.edit_drag4);
        edit_hu4 = (EditText)findViewById(R.id.edit_hu4);
        beilv = (EditText)findViewById(R.id.edit_beilv);

        //TextView
        text_4 = (TextView)findViewById(R.id.text_4);
        settlement1 = (TextView)findViewById(R.id.text_settlement1);
        settlement2 = (TextView)findViewById(R.id.text_settlement2);
        settlement3 = (TextView)findViewById(R.id.text_settlement3);
        settlement4 = (TextView)findViewById(R.id.text_settlement4);

        //button
        btn12 = (Button)findViewById(R.id.buttondy);



        //处理按钮点击事件
        radio_san.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_4.setEnabled(false);
                edit_alive4.setEnabled(false);
                edit_drag4.setEnabled(false);
                edit_hu4.setEnabled(false);
                settlement4.setEnabled(false);
                check = 1;

            }
        });

        radio_si.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_4.setEnabled(true);
                edit_alive4.setEnabled(true);
                edit_drag4.setEnabled(true);
                edit_hu4.setEnabled(true);
                settlement4.setEnabled(true);
                check = 0;
            }
        });



        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //强转为整形
                A[0] = Integer.parseInt(edit_alive1.getText().toString()) ;
                B[0] = Integer.parseInt(edit_drag1.getText().toString()) ;
                C[0] = Integer.parseInt(edit_hu1.getText().toString()) ;
                A[1] = Integer.parseInt(edit_alive2.getText().toString()) ;
                B[1] = Integer.parseInt(edit_drag2.getText().toString()) ;
                C[1] = Integer.parseInt(edit_hu2.getText().toString()) ;
                A[2] = Integer.parseInt(edit_alive3.getText().toString()) ;
                B[2] = Integer.parseInt(edit_drag3.getText().toString()) ;
                C[2] = Integer.parseInt(edit_hu3.getText().toString()) ;
                beilvzhi = Double.parseDouble( beilv.getText().toString());
                if(check !=1)
                {
                    A[3] = Integer.parseInt(edit_alive4.getText().toString());
                    B[3] = Integer.parseInt(edit_drag4.getText().toString());
                    C[3] = Integer.parseInt(edit_hu4.getText().toString());
                    for(int s=0;s<4;s++)
                        if(C[s]%10 != 0){
                            if(C[s]%10>=5){
                                C[s]+=(10-C[s]%10);
                            }
                            else C[s]-=C[s]%10;
                        }
                    for(int i=0;i<4;i++)
                    {
                        for(int j=0;j<4;j++)
                        {
                            if(i!=j)
                            {
                                if(B[i]>B[j])
                                {
                                    mw[i]+=B[i]+B[j];
                                }
                                else  if(B[i]<B[j])
                                {
                                    mw[i]-=B[i]+B[j];
                                }
                                else mw[i]=mw[i];
                            }
                        }

                    }

                    for(int i=0;i<4;i++)
                    {
                        for(int j=0;j<4;j++)
                        {
                            if(i!=j)
                            {
                                if(C[i]>C[j])
                                {
                                    WW[i]+=(C[i]-C[j])*beilvzhi*(A[i]+1)*(A[j]+1);


                                }
                                else if(C[i]<C[j])
                                {
                                    WW[i]-=(C[j]-C[i])*beilvzhi*(A[i]+1)*(A[j]+1);
                                }
                                else WW[i]=WW[i];
                            }
                        }

                    }
                    for(int i=0;i<4;i++)
                    {
                        cong[i]=mw[i]+WW[i];
                    }
                    settlement1.setText(cong[0]+"");
                    settlement2.setText(cong[1]+"");
                    settlement3.setText(cong[2]+"");
                    settlement4.setText(cong[3]+"");
                    for(int i=0;i<4;i++)
                    {
                        mw[i]=0;
                        WW[i]=0;
                    }
                }
                else
                {
                    for(int s=0;s<4;s++)
                        if(C[s]%10 != 0){
                            if(C[s]%10>=5){
                                C[s]+=(10-C[s]%10);
                            }
                            else C[s]-=C[s]%10;
                        }
                    for(int i=0;i<3;i++)
                    {
                        for(int j=0;j<3;j++)
                        {
                            if(i!=j)
                            {
                                if(B[i]>B[j])
                                {
                                    mw[i]+=B[i]+B[j];

                                }
                                else  if(B[i]<B[j])
                                {
                                    mw[i]-=B[i]+B[j];
                                }
                                else mw[i]=mw[i];
                            }
                        }

                    }

                    for(int i=0;i<3;i++)
                    {
                        for(int j=0;j<3;j++)
                        {
                            if(i!=j)
                            {
                                if(C[i]>C[j])
                                {
                                    WW[i]+=(C[i]-C[j])*beilvzhi*(A[i]+1)*(A[j]+1);
                                }
                                else if(C[i]<C[j])
                                {
                                    WW[i]-=(C[j]-C[i])*beilvzhi*(A[i]+1)*(A[j]+1);
                                }
                                else WW[i]=WW[i];
                            }
                        }

                    }
                    for(int i=0;i<3;i++)
                    {
                        cong[i]=mw[i]+WW[i];
                    }
                    settlement1.setText(cong[0]+"");
                    settlement2.setText(cong[1]+"");
                    settlement3.setText(cong[2]+"");
                    for(int i=0;i<3;i++)
                    {
                        mw[i]=0;
                        WW[i]=0;
                    }
                }
            }
        });
	}
}