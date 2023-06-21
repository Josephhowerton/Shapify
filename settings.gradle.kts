pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "Shapify"
include(":app")
include(":data:cache")
include(":data:model")
include(":data:remote")
include(":data:repository")
include(":core:components")
include(":core:domain")
include(":core:navigation")
include(":core:provider")
include(":core:theme")
include(":core:utility")
include( ":features:account:account")
include (":features:analysis:analysis")
include( ":features:authentication:auth")
include (":features:home:home")
include (":features:planner:planner")
include (":features:profile:profile")
include (":features:settings:settings")
include (":features:tracking:tracking")
include (":features:training:training")
include (":features:onboarding:onboarding")
include(":features:welcome:welcome")
include( ":features:account:account-api")
include (":features:analysis:analysis-api")
include( ":features:authentication:auth-api")
include (":features:home:home-api")
include (":features:planner:planner-api")
include (":features:profile:profile-api")
include (":features:settings:settings-api")
include (":features:tracking:tracking-api")
include (":features:training:training-api")
include (":features:onboarding:onboarding-api")
include (":features:welcome:welcome-api")
include (":libraries:framework")