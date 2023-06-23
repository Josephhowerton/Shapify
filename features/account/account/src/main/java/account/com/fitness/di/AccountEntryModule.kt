package account.com.fitness.di

import account.com.fitness.navigation.AccountEntryImpl
import com.fitness.account.AccountEntry
import com.fitness.navigation.FeatureEntry
import com.fitness.navigation.di.FeatureEntryKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
interface AccountEntryModule {

    @Binds
    @IntoMap
    @Singleton
    @FeatureEntryKey(AccountEntry::class)
    fun  accountEntry(entry: AccountEntryImpl) : FeatureEntry
}