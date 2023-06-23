package analysis.com.fitness.di

import analysis.com.fitness.navigation.AnalysisEntryImpl
import com.fitness.analysis.AnalysisEntry
import com.fitness.navigation.FeatureEntry
import com.fitness.navigation.di.FeatureEntryKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
interface AnalysisEntryModule {

    @Binds
    @Singleton
    @IntoMap
    @FeatureEntryKey(AnalysisEntry::class)
    fun  analysisEntry(entry: AnalysisEntryImpl) : FeatureEntry
}