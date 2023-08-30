package com.adarsh.newsapp.activity

import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.adarsh.newsapp.R
import com.adarsh.newsapp.fragments.category.*
import com.adarsh.newsapp.fragments.country.*
import com.adarsh.newsapp.fragments.source.*
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var coordinatorLayout: CoordinatorLayout
    private lateinit var toolbar: androidx.appcompat.widget.Toolbar
    private lateinit var frameLayout: FrameLayout
    private lateinit var navigationView: NavigationView


    var previousMenuItem: MenuItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawerLayout)
        coordinatorLayout = findViewById(R.id.coordinatorLayout)
        toolbar = findViewById(R.id.toolbar)
        frameLayout = findViewById(R.id.frame)
        navigationView = findViewById(R.id.navigationView)

        setUpToolBar()

        openIndiaFragment()


        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this@MainActivity,
            drawerLayout,
            R.string.open_drawer,
            R.string.close_drawer
        )

        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()


        navigationView.setNavigationItemSelectedListener {

            if (previousMenuItem != null) {
                previousMenuItem?.isChecked = false
            }

            it.isCheckable = true
            it.isChecked = true
            previousMenuItem = it

            when (it.itemId) {
                R.id.australia -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, AustraliaFragment())
                        .commit()

                    supportActionBar?.title = "News of Australia"
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.canada -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, CanadaFragment())
                        .commit()

                    supportActionBar?.title = "News of Canada"
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.india -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, IndiaFragment())
                        .commit()

                    supportActionBar?.title = "News of India"

                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.ireland -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, IrelandFragment())
                        .commit()

                    supportActionBar?.title = "News of Ireland"
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.malaysia -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, MalaysiaFragment())
                        .commit()

                    supportActionBar?.title = "News of Malaysia"
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.newZealand -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, NewZealandFragment())
                        .commit()

                    supportActionBar?.title = "News of NewZealand"
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.nigeria -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, NigeriaFragment())
                        .commit()

                    supportActionBar?.title = "News of Nigeria"
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.philippines -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, PhilippinesFragment())
                        .commit()

                    supportActionBar?.title = "News of Philippines"
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.saudiArabia -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, SaudiArabiaFragment())
                        .commit()

                    supportActionBar?.title = "News of Saudi-Arabia"
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.singapore -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, SingaporeFragment())
                        .commit()

                    supportActionBar?.title = "News of Singapore"
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.southAfrica -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, SouthAfricaFragment())
                        .commit()

                    supportActionBar?.title = "News of South Africa"
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.uk -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, UnitedKingdomFragment())
                        .commit()

                    supportActionBar?.title = "News of United Kingdom"
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.usa -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, USAFragment())
                        .commit()

                    supportActionBar?.title = "News of U.S.A."
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }


                R.id.business -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, BusinessFragment())
                        .commit()

                    supportActionBar?.title = "Business News"
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.entertainment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, EntertainmentFragment())
                        .commit()

                    supportActionBar?.title = "Entertainment News"
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.general -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, GeneralFragment())
                        .commit()

                    supportActionBar?.title = "General News"
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.health -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, HealthFragment())
                        .commit()

                    supportActionBar?.title = "Health News"
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.science -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, ScienceFragment())
                        .commit()

                    supportActionBar?.title = "Science News"
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.sports -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, SportsFragment())
                        .commit()

                    supportActionBar?.title = "Sports News"
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.technology -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, TechnologyFragment())
                        .commit()

                    supportActionBar?.title = "Technology News"
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }


                R.id.abcNews -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, ABCFragment())
                        .commit()

                    supportActionBar?.title = "ABC News"
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.alJazeera -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, AlJazeeraFragment())
                        .commit()

                    supportActionBar?.title = "Al Jazeera"
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.associatedPress -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, AssociatedPressFragment())
                        .commit()

                    supportActionBar?.title = "Associated Press"
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.bbcNews -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, BBCFragment())
                        .commit()

                    supportActionBar?.title = "BBC News"
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.businessInsider -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, BusinessInsiderFragment())
                        .commit()

                    supportActionBar?.title = "Business Insider"
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.cbsNews -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, CBSNewsFragment())
                        .commit()

                    supportActionBar?.title = "CBS News"
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.cnn -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, CNNFragment())
                        .commit()

                    supportActionBar?.title = "CNN"
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.espn -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, ESPNFragment())
                        .commit()

                    supportActionBar?.title = "ESPN"
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.foxNews -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, FoxNewsFragment())
                        .commit()

                    supportActionBar?.title = "Fox News"
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.googleNews -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, GoogleNewsFragment())
                        .commit()

                    supportActionBar?.title = "Google News"
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.nbcNews -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, NBCNewsFragment())
                        .commit()

                    supportActionBar?.title = "NBC News"
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.politico -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, PoliticoFragment())
                        .commit()

                    supportActionBar?.title = "Politico"
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.theHindu -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, TheHinduFragment())
                        .commit()

                    supportActionBar?.title = "The Hindu"
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.theTimesOfIndia -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, TheTimesOfIndiaFragment())
                        .commit()

                    supportActionBar?.title = "The Times of India"
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.theVerge -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, TheVergeFragment())
                        .commit()

                    supportActionBar?.title = "The Verge"
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.theWallStreetJournal -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, TheWallStreetJournalFragment())
                        .commit()

                    supportActionBar?.title = "The Wall Street Journal"
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.theWashingtonPost -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, TheWashingtonPostFragment())
                        .commit()

                    supportActionBar?.title = "The Washington Post"
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.time -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, TimeFragment())
                        .commit()

                    supportActionBar?.title = "TIME"
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                else -> false
            }

        }


    }

    private fun setUpToolBar() {
        setSupportActionBar(toolbar)
        supportActionBar?.title = "News App"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id = item.itemId

        if (id == android.R.id.home) {
            drawerLayout.openDrawer(GravityCompat.START)
        }
        return super.onOptionsItemSelected(item)
    }

    private fun openIndiaFragment() {

        val fragment = IndiaFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame, fragment)
        transaction.commit()
        supportActionBar?.title = "News of India"
        navigationView.setCheckedItem(R.id.india)
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        val frag = supportFragmentManager.findFragmentById(R.id.frame)

        when (frag) {
            !is IndiaFragment -> openIndiaFragment()

            else -> super.onBackPressed()
        }
    }

}
