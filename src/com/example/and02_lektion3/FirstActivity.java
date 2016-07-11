package com.example.and02_lektion3;

import android.os.Bundle;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import junit.framework.*;

public class FirstActivity extends Activity {

	private static final String TAG =
			FirstActivity.class.getSimpleName();
	private final int tvAnzeigeMaxHeight = 400;
	private String ausgabe="";
	public TextView tvAnzeige;
	@Override
	public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_first);
	// Referenzen auf View-Objekte per find-Methode:
	Button btClick = (Button)this.findViewById(R.id.click);
	btClick.setOnClickListener(new ButtonOnClickListener());
	tvAnzeige =(TextView) this.findViewById(R.id.anzeige);
	ausgabe += "FirstActivity - \"onCreate\"durchlaufen\n";
	tvAnzeige.setText(ausgabe);
	}
	@Override
	protected void onStart() {
	super.onStart();
	ausgabe += "FirstActivity - \"onStart\" durchlaufen  onStart\n";
	tvAnzeige.setText(ausgabe);
	}
	@Override
	protected void onResume(){
	super.onResume();
	ausgabe += "FirstActivity - \"onResume\" durchlaufen\n RESUME";
	tvAnzeige.setText(ausgabe);
	}
	@Override
	protected void onPause(){
	super.onPause();
	ausgabe += "FirstActivity - \"onPause\" durchlaufen\n";
	tvAnzeige.setText(ausgabe);
	}
	@Override
	protected void onStop(){
	super.onStop();
	ausgabe += "FirstActivity - \"onStop\" durchlaufen\n";
	tvAnzeige.setText(ausgabe);
	}
	@Override
	protected void onRestart(){
	super.onRestart();
	ausgabe += "FirstActivity - \"onRestart\" durchlaufen\n";
	tvAnzeige.setText(ausgabe);
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.first, menu);
		return true;
	}

	class ButtonOnClickListener implements
	OnClickListener {

		@Override
		public void onClick(View view) {
			// TODO Auto-generated method stub
			if(Constants.DEBUG)
			Log.d(TAG, this.getClass().getSimpleName()
					+ ".onClick erreicht");
			
			Intent intent = new Intent(
					FirstActivity.this, SecondActivity.class);
					//FirstActivity.this.startActivity(intent);
					try {
						
						if (this.checkSize()){
						FirstActivity.this.startActivity(intent);
						ausgabe += "Button \"second Activity\" geklickt\n";
						tvAnzeige.setText(ausgabe);
						}
						else
							tvAnzeige.setText(ausgabe
							+ "\n *** Anzeigehöhe ausgeschöpft ***\n");
						} catch (ActivityNotFoundException anfe) {
							if(Constants.DEBUG)
							Log.e(TAG, anfe.getMessage());
						ausgabe += anfe.toString() + "\n";
						tvAnzeige.setText(ausgabe);
						}
			
		}
		private boolean checkSize() {
			//assertTrue(TextView.getHeight()<=200);
			if (tvAnzeige.getHeight() > tvAnzeigeMaxHeight)
			return false;
			else
			return true;
			}
	}
}
