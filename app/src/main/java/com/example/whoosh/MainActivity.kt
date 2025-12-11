package com.example.whoosh

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView

    // Peta yang menyimpan instance Fragment untuk menghindari re-create
    private val fragments: Map<Int, Fragment> = mapOf(
        R.id.nav_home to HistoryFragment(), //  kita Anggap HistoryFragment sebagai 'Home' sementara
        R.id.nav_history to HistoryFragment(),
        R.id.nav_chat to HistoryFragment(), //  boleh kita Ganti ini jika sudah ada ChatFragment
        R.id.nav_settings to SettingFragment()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // kita hilangkan  ViewCompat Insets karena BottomNavigationView sudah handle
        // ViewCompat.setOnApplyWindowInsetsListener(...) -> Kita abaikan ini agar tidak mengganggu bottom nav

        bottomNavigationView = findViewById(R.id.bottom_navigation)

        // 1. Setup yang harus kita siapkan untuk Listener untuk Bottom Navigation
        bottomNavigationView.setOnItemSelectedListener { item ->
            val selectedFragment = fragments[item.itemId]
            if (selectedFragment != null) {
                // kita panggil fungsi pengganti fragement
                replaceFragment(selectedFragment)
                true //item sudah kita  di-handle
            } else {
                false
            }
        }

        if (savedInstanceState == null) {
            bottomNavigationView.selectedItemId = R.id.nav_settings // kita bisa memilih  Setting sebagai default
        }
    }

    // saya gunakan untuk mengganti Fragment
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}