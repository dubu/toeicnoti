package com.dubu.toeic;

import android.accounts.AccountManager;
import android.content.Context;

import com.dubu.toeic.authenticator.BootstrapAuthenticatorActivity;
import com.dubu.toeic.authenticator.LogoutService;
import com.dubu.toeic.core.CheckIn;
import com.dubu.toeic.core.TimerService;
import com.dubu.toeic.ui.BootstrapTimerActivity;
import com.dubu.toeic.ui.CarouselActivity;
import com.dubu.toeic.ui.CheckInsListFragment;
import com.dubu.toeic.ui.ItemListFragment;
import com.dubu.toeic.ui.NewsActivity;
import com.dubu.toeic.ui.NewsListFragment;
import com.dubu.toeic.ui.UserActivity;
import com.dubu.toeic.ui.UserListFragment;
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
