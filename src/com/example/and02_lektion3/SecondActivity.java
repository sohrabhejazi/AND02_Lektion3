package com.example.and02_lektion3;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends Activity {
	private TextView tvAnzeige;
	private String ausgabe = "";
	@Override
	public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.secong);
	// Referenzen auf View-Objekte:
	tvAnzeige = (TextView)
	this.findViewById(R.id.anzeige2);
	ausgabe += "SecondActivity - \"onCreate\"durchlaufen\n";
			tvAnzeige.setText(ausgabe);
			Button btClick = (Button)
			this.findViewById(R.id.second);
			// Listener anmelden:
			btClick.setOnClickListener(new ButtonOnClickListener());

   }
	@Override
	protected void onStart() {
	super.onStart();
	ausgabe += "2Activity - \"onStart\" durchlaufen  onStart\n";
	tvAnzeige.setText(ausgabe);
	}
	@Override
	protected void onResume(){
	super.onResume();
	ausgabe += "2Activity - \"onResume\" durchlaufen\n RESUME";
	tvAnzeige.setText(ausgabe);
	}
	@Override
	protected void onPause(){
	super.onPause();
	ausgabe += "2Activity - \"onPause\" durchlaufen\n";
	tvAnzeige.setText(ausgabe);
	}
	@Override
	protected void onStop(){
	super.onStop();
	ausgabe += "2Activity - \"onStop\" durchlaufen\n";
	tvAnzeige.setText(ausgabe);
	}
	@Override
	protected void onRestart(){
	super.onRestart();
	ausgabe += "2Activity - \"onRestart\" durchlaufen\n";
	tvAnzeige.setText(ausgabe);
	}
	
	
	class ButtonOnClickListener implements
	OnClickListener {
	@Override
	public void onClick(View view) {
	ausgabe += "Button \"main Activity\" geklickt\n";
	Intent intent = new Intent(
			SecondActivity.this, FirstActivity.class);
			SecondActivity.this.startActivity(intent);
	}
	}
	}
	
	
