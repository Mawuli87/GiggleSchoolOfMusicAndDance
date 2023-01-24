package com.messieyawo.gigglemusicpiano.activities

import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.IntentSender
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.snackbar.Snackbar
import com.google.android.play.core.appupdate.AppUpdateManager
import com.google.android.play.core.appupdate.AppUpdateManagerFactory
import com.google.android.play.core.install.InstallStateUpdatedListener
import com.google.android.play.core.install.model.AppUpdateType
import com.google.android.play.core.install.model.InstallStatus
import com.google.android.play.core.install.model.UpdateAvailability
import com.google.firebase.database.*
import com.messieyawo.gigglemusicpiano.R
import com.messieyawo.gigglemusicpiano.databinding.ActivityHomeBinding
import com.messieyawo.gigglemusicpiano.fragments.stream.notification.Notification
import com.messieyawo.gigglemusicpiano.fragments.stream.notification.channelID
import com.messieyawo.gigglemusicpiano.fragments.stream.upload.model.Teacher
import com.messieyawo.gigglemusicpiano.utils.RC_APP_UPDATE
import guy4444.smartrate.SmartRate


class HomeActivity : AppCompatActivity() {

    private lateinit var homeBinding: ActivityHomeBinding
    private lateinit var mNavController: NavController
    private lateinit var toolbar: Toolbar
    private var title: String? = ""
    private var descript: String? = ""

    lateinit var mAppUpdateManager: AppUpdateManager
    private var mAlarmManager: AlarmManager? = null

//    private var alarmMgr: AlarmManager? = null
//    private lateinit var alarmIntent: PendingIntent

    private val database: FirebaseDatabase = FirebaseDatabase.getInstance()
    private val myReference: DatabaseReference = database.reference.child("MyUsers")
    private val CheckForNewData: Boolean = false

    private var dataValue: String = ""

    


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(homeBinding.root)
        toolbar = homeBinding.toolbar
        toolbar.setTitleTextColor(ContextCompat.getColor(applicationContext, R.color.white))
        setSupportActionBar(toolbar)
        //get title name from upload page
        title = intent.getStringExtra("title").toString()
        descript = intent.getStringExtra("description").toString()

        //show rate us
        showRateus()
        mNavController = findNavController(R.id.nav_host_fragment)

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment, R.id.streamFragment, R.id.searchFragment
            )
        )
        setupActionBarWithNavController(mNavController, appBarConfiguration)
        homeBinding.bottomNavigationView.setupWithNavController(mNavController)

        //check for announcements
        checkIfData()


        //in app update initialization
        mAppUpdateManager = AppUpdateManagerFactory.create(this)
        // Before starting an update, register a listener for updates in onCreate() method
        mAppUpdateManager.registerListener(installStateUpdatedListener)

        //in app update

        mAppUpdateManager.appUpdateInfo.addOnSuccessListener { result ->
            if (result.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE
                && result.isUpdateTypeAllowed(AppUpdateType.IMMEDIATE)
            ) {
                try {
                    mAppUpdateManager.startUpdateFlowForResult(
                        result,
                        AppUpdateType.IMMEDIATE,
                        this@HomeActivity,
                        RC_APP_UPDATE
                    )
                } catch (e: IntentSender.SendIntentException) {
                    e.printStackTrace()
                }
            }
        }





    }



    override fun onSupportNavigateUp(): Boolean {
        return mNavController.navigateUp() || super.onSupportNavigateUp()
    }

    private val installStateUpdatedListener =
        InstallStateUpdatedListener { state ->
            if (state.installStatus() == InstallStatus.DOWNLOADED) {
                showCompletedUpdate()
            }
        }

    private fun showCompletedUpdate() {
        val snackbar = Snackbar.make(
            findViewById(android.R.id.content), "Giggle App update with new features is ready!",
            Snackbar.LENGTH_INDEFINITE
        )
        snackbar.setAction(
            "Update it"
        ) { mAppUpdateManager.completeUpdate() }
        snackbar.show()
    }

    override fun onResume() {
        super.onResume()
        mAppUpdateManager.appUpdateInfo.addOnSuccessListener { result ->
            if (result.updateAvailability() == UpdateAvailability.DEVELOPER_TRIGGERED_UPDATE_IN_PROGRESS) {
                try {
                    mAppUpdateManager.startUpdateFlowForResult(
                        result,
                        AppUpdateType.IMMEDIATE,
                        this@HomeActivity,
                        RC_APP_UPDATE
                    )
                } catch (e: IntentSender.SendIntentException) {
                    e.printStackTrace()
                }
            }
        }
    }

    override fun onStop() {
        mAppUpdateManager.unregisterListener(
            installStateUpdatedListener
        )
        super.onStop()
    }

        fun hideToolbar(){
            homeBinding.hideActionBar?.visibility = View.GONE
        }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_home, menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            // START
            R.id.homeTopMenu -> {
                val intent = Intent(this, SettingsActivity::class.java)

                startActivity(intent)
                return true
            }

        }
        return super.onOptionsItemSelected(item)
    }


    fun showRateus() {
        // For continual calls -
        SmartRate.Rate(
            this, "Rate Us" // title - optional
            , "Tell others what you think about this Giggle app" // content - optional
            , "Continue" // OK button text - optional
            , "Ask me later" // later button text - optional
            , "Never ask again" // stop asking button text - optional
            , "Thanks for the feedback" // thanks message to low star users - optional
            , Color.parseColor("#2196F3") // dialog theme color
            , 4 // open google play from _ stars  1..5 - optional
            , 78 // time between calls (unit: Hours) - default is 6 days
            ,
            48 // Time to wait until you start asking for the first time (unit: Hours) - default is 3 days
        )
    }

//    private fun fireNotificationIntent(dataValue: String) {
//        alarmMgr = getSystemService(Context.ALARM_SERVICE) as AlarmManager
//        alarmIntent = Intent(this, Notification::class.java).let { intent ->
//            PendingIntent.getBroadcast(this, 0, intent, 0)
//        }
//
//        alarmMgr?.set(
//            AlarmManager.ELAPSED_REALTIME_WAKEUP,
//            SystemClock.elapsedRealtime() + 60 * 1000,
//            alarmIntent
//        )
//    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun launChNotificationRequest() {
        val mIntent = Intent(this, Notification::class.java)
        val mPendingIntent = PendingIntent.getBroadcast(
            this, 0, mIntent,
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
        )
        mAlarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        mAlarmManager!!.setRepeating(
            AlarmManager.RTC_WAKEUP, System.currentTimeMillis(),
            60000, mPendingIntent
        )
    }


    fun checkIfData() {
        myReference.addValueEventListener(object : ValueEventListener {
            @RequiresApi(Build.VERSION_CODES.M)
            override fun onDataChange(snapshot: DataSnapshot) {

                for (eachUser in snapshot.children) {

                    val user = eachUser.getValue(Teacher::class.java)
                    // val user2 = eachUser.getValue(Users::class.java)

                    if (user != null) {
                        dataValue = user.name.toString()
                        createNotificationChannel()
                        launChNotificationRequest()
                        // fireNotificationIntent(dataValue)

                    }
                }


            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }


    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Notif Channel"
            val desc = "A Description of the Channel"
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel(channelID, name, importance)
            channel.description = desc
            channel.enableLights(true)
            channel.lightColor = Color.RED
            channel.enableVibration(true)
            channel.vibrationPattern = longArrayOf(100, 200, 300, 400, 500, 400, 300, 200, 400)
            val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }




}