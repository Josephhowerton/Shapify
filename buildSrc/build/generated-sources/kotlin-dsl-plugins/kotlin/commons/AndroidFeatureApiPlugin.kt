package commons


/**
 * Precompiled [android-feature-api.gradle.kts][commons.Android_feature_api_gradle] script plugin.
 *
 * @see commons.Android_feature_api_gradle
 */
public
class AndroidFeatureApiPlugin : org.gradle.api.Plugin<org.gradle.api.Project> {
    override fun apply(target: org.gradle.api.Project) {
        try {
            Class
                .forName("commons.Android_feature_api_gradle")
                .getDeclaredConstructor(org.gradle.api.Project::class.java, org.gradle.api.Project::class.java)
                .newInstance(target, target)
        } catch (e: java.lang.reflect.InvocationTargetException) {
            throw e.targetException
        }
    }
}
