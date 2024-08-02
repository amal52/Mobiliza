package com.first.mobiliza
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {
    //Déclare des variables avec lateinit pour initialiser ces variables mn ba3ed

    private lateinit var tabLayout: TabLayout
    private lateinit var viewP: ViewPager2
    private lateinit var adapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tabLayout = findViewById(R.id.tab_layout)
// creation de 2 ongles dans tablayout  : newtab()  taamel instance jdyd ll tab layout
        tabLayout.addTab(tabLayout.newTab().setText("Login"))
        tabLayout.addTab(tabLayout.newTab().setText("Signup"))

        viewP = findViewById(R.id.view_pager)

        val fragmentManager: FragmentManager = supportFragmentManager
//crée une instance de ViewPagerAdapter en utilisant le fragmentManager et le lifecycle de l'activité
        adapter = ViewPagerAdapter(fragmentManager, lifecycle)
        viewP.adapter = adapter

//ajouter un ecoteur pour écouter les événements de sélection d'onglets.

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewP.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })

        viewP.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                tabLayout.selectTab(tabLayout.getTabAt(position))
            }
        })

        //fragmentManager : Utilisé par l'adaptateur pour gérer les fragments.
        //pagerAdapter : Instance de ViewPagerAdapter qui fournit les fragments.
        //viewPager.adapter : Associe l'adaptateur au ViewPager2, permettant ainsi au ViewPager2 de demander des fragments à afficher pour chaque page.
    }
}
