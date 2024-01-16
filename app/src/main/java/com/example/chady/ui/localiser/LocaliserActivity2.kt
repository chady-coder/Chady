package com.example.chady.ui.localiser

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.example.chady.ui.recycler.ActivityRecycle
import com.example.chady.R

class LocaliserActivity2 : AppCompatActivity() {
    companion object {
        public const val PERMISSION_REQUEST_LOCATION = 9999
        fun getStartIntent(context: Context): Intent {
            return Intent(context, LocaliserActivity2::class.java)

        }


    }

    private fun requestPermission() {
        if (!hasPermission()) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                PERMISSION_REQUEST_LOCATION
            )
        } else {
            getLocation()
        }
    }

    private fun hasPermission(): Boolean {
        return ActivityCompat.checkSelfPermission(
            this,
            android.Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_localiser2)

        findViewById<Button>(R.id.activer).setOnClickListener {
            requestPermission()
        }
        findViewById<Button>(R.id.recycle).setOnClickListener {
            startActivity(ActivityRecycle.getStartIntent(this))
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when (requestCode) {
            PERMISSION_REQUEST_LOCATION -> {
                // If request is cancelled, the result arrays are empty.
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    // Permission obtenue, Nous continuons la suite de la logique.
                    getLocation()
                } else {
                    Toast.makeText(
                        this,
                        "Va dans les paramètres accepter localisation",
                        Toast.LENGTH_LONG
                    ).show()

                }
                return
            }
        }
    }

    @SuppressLint("SuspiciousIndentation")
    private fun geoCode(location: Location) {

        val test: String =
            "Tu es présentement\n de latitude :" + location.latitude + ",\nde longitude : " + location.longitude + "\net d'altitude : " + location.altitude;
        findViewById<Button>(R.id.activer).setOnClickListener {
            Toast.makeText(this, test, Toast.LENGTH_LONG).show()
        }
    }

    @SuppressLint("MissingPermission")
    private fun getLocation() {
        if (hasPermission()) {
            val locationManager =
                applicationContext.getSystemService(LOCATION_SERVICE) as LocationManager?
            locationManager?.run {
                locationManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER)?.run {
                    geoCode(this)
                }
            }
        }
    }

}