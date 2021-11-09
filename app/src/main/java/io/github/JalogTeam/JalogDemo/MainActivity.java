/*  Minimal Jalog Android demo  1.0  2021-11-09  By Mikko Levanto, Ari Okkonen

    This demonstrates setting variable for Jalog program, recovering values from Jalog variables,
    and preparing for fail and exit.

*/

package io.github.JalogTeam.JalogDemo;

import android.os.Bundle;
import android.widget.TextView;
import android.view.View;

import io.github.JalogTeam.jalog.Jalog;
import android.content.res.AssetManager;
import androidx.appcompat.app.AppCompatActivity;
import java.io.*;

public class MainActivity extends AppCompatActivity {

  static Jalog myJalog;  // Jalog engine

  class MyResourceManager extends Jalog.ResourceManager {
    public InputStream getResourceAsStream(String fileName) throws IOException {
      return getResources().getAssets().open(fileName);
    }
  }

  static TextView message_view;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    message_view = (TextView) findViewById(R.id.textView);

    Jalog myJalog = new Jalog() ;  // Creates a Jalog engine
    myJalog.setResourceManager(new MyResourceManager()); 
        // Use Android resource system
    myJalog.consult_file("res:experiment.pro"); // Consult a Jalog program

  }

  public void button_click(View view) {
    String A = ((TextView)view).getText().toString();
    String ans = solve_problem(A, "Success");
    message_view.setText(ans);
  }

  String solve_problem(String A, String B) {
          
    // Preparation of the problem
 
    Jalog.Term stringvar = Jalog.string(A);
    Jalog.Term result = Jalog.string(B);
    String retval = "*none";
   
    // Finding the solution

    try {
      if (myJalog.call("experiment", stringvar, result)) {
              
        // Here if success
        
        retval = result.getStringValue();
        if (retval == null) retval = "*null";
        
      } else {
      
        // Here if fail

        retval = "*fail";

      }
    } catch (Jalog.Exit e) {
    
      // Here if exit
      
      retval = "*exit " + e.status;
      
    }
    
    return retval;
  }        
}