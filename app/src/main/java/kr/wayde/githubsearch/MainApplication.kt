package kr.wayde.githubsearch

import androidx.multidex.MultiDexApplication
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.stetho.Stetho
import kr.wayde.githubsearch.di.appModule
import kr.wayde.githubsearch.di.dataModule
import kr.wayde.githubsearch.di.domainModule
import kr.wayde.githubsearch.di.viewModelModule
import kr.wayde.githubsearch.util.AndroidContext
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin

/**
 * Created by Wayde.k(Jnaghyok Park) on 2019.11.10
 */
class MainApplication: MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        AndroidContext.initialize(this)
        Stetho.initializeWithDefaults(this)
        Fresco.initialize(this)
        startKoin {
            androidContext(this@MainApplication)
            loadKoinModules(appModule, viewModelModule, domainModule, dataModule)
        }
    }
}