package com.liba.android;

import android.accounts.AccountManager;
import android.content.Context;

import com.liba.android.authenticator.BootstrapAuthenticatorActivity;
import com.liba.android.authenticator.LogoutService;
import com.liba.android.core.CheckIn;
import com.liba.android.core.TimerService;
import com.liba.android.ui.BootstrapTimerActivity;
import com.liba.android.ui.CarouselActivity;
import com.liba.android.ui.CheckInsListFragment;
import com.liba.android.ui.ItemListFragment;
import com.liba.android.ui.NewsActivity;
import com.liba.android.ui.NewsListFragment;
import com.liba.android.ui.UserActivity;
import com.liba.android.ui.UserListFragment;
import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger module for setting up provides statements.
 * Register all of your entry points below.
 */
@Module
(
        complete = false,

        injects = {
                BootstrapApplication.class,
                BootstrapAuthenticatorActivity.class,
                CarouselActivity.class,
                BootstrapTimerActivity.class,
                CheckInsListFragment.class,
                NewsActivity.class,
                NewsListFragment.class,
                UserActivity.class,
                UserListFragment.class,
                TimerService.class
        }

)
public class BootstrapModule  {

    @Singleton
    @Provides
    Bus provideOttoBus() {
        return new Bus();
    }

    @Provides
    @Singleton
    LogoutService provideLogoutService(final Context context, final AccountManager accountManager) {
        return new LogoutService(context, accountManager);
    }

}
