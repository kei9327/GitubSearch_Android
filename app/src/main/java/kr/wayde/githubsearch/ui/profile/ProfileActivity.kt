package kr.wayde.githubsearch.ui.profile

import android.content.Context
import android.content.Intent
import android.os.Bundle
import kr.wayde.githubsearch.R
import kr.wayde.githubsearch.ui.BaseActivity

class ProfileActivity :BaseActivity() {

    companion object{
        @JvmStatic
        fun getStartIntent(context : Context, login : String): Intent {
            var intent = Intent(context, ProfileActivity::class.java)
            intent.putExtra("login", login)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
    }
}