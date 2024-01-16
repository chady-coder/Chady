package com.example.chady.ui.main

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.chady.ui.recycler.ActivityRecycle
import com.example.chady.ui.localiser.LocaliserActivity2
import com.example.chady.R
import com.example.chady.ui.bluetooth.ScanActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    companion object {
        fun getStartIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.clique_ici).setOnClickListener{

            MaterialAlertDialogBuilder(this)
                .setTitle(resources.getString(R.string.title))
                .setMessage(resources.getString(R.string.supporting_text))
                .setNeutralButton(resources.getString(R.string.cancel)) { dialog, which ->
                    Snackbar.make(findViewById(android.R.id.content), "Accepte par pitié !!!", Snackbar.LENGTH_LONG).setAction("J'accepte"){
                        Toast.makeText(this,"bien joué", Toast.LENGTH_LONG).show()
                    }.show()
                }
                .setNegativeButton(resources.getString(R.string.decline)) { dialog, which ->
                    startActivity(ScanActivity.getStartIntent(this));

                }
                .setPositiveButton(resources.getString(R.string.accept)) { dialog, which ->
                    startActivity(ActivityRecycle.getStartIntent(this));
                    Toast.makeText(this,"Accès à toutes les fenêtres", Toast.LENGTH_LONG).show()
                }
                .setPositiveButton(resources.getString(R.string.localisation)) { dialog, which ->
                    startActivity(LocaliserActivity2.getStartIntent(this));
                    Toast.makeText(this,"Accès à la localisation", Toast.LENGTH_LONG).show()
                }
                .show()
        }

    }
}

