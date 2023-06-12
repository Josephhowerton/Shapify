package com.fitness.authentication.login

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.fitness.framework.auth.AuthFailure
import com.fitness.framework.extensions.cast
import com.fitness.framework.state.BaseViewState
import com.fitness.shapify.theme.PrimaryBlue
import com.fitness.shapify.theme.ShapifyTheme
import com.fitness.theme.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import views.ElevatedIconButton
import views.ElevatedTextField
import widget.EmptyScreen
import widget.ErrorScreen
import widget.LoadingScreen


@Preview(
    name = "Light",
    showBackground = true
)
@Preview(
    name = "Dark",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun LoginPreview() = ShapifyTheme{
    Surface {
        LoginContent(uiState = LoginState())
    }
}

@Composable
fun LoginWithEmailScreen(
    state: StateFlow<BaseViewState<LoginState>> = MutableStateFlow(BaseViewState.Data(LoginState())),
    onErrorEvent: (AuthFailure) -> Unit = {},
    onLoginCompleteEvent: () -> Unit = {},
    onTriggerEvent: (LoginEvent) -> Unit = {},
    onForgotPasswordEvent: () -> Unit = {},
    onPhoneAuthEvent: () -> Unit = {},
    verifyCredentialsEvent: (LoginEvent) -> Unit = {}
) = ShapifyTheme {

    val uiState by state.collectAsState()

    when (uiState) {
        is BaseViewState.Empty -> {
            EmptyScreen()
        }
        is BaseViewState.Data -> {
            LoginContent(
                uiState = uiState.cast<BaseViewState.Data<LoginState>>().value,
                onTriggerEvent = onTriggerEvent,
                onForgotPassword = onForgotPasswordEvent,
                onPhoneAuth = onPhoneAuthEvent,
                verifyCredentials = verifyCredentialsEvent
            )
        }
        is BaseViewState.Error -> {
            val failure = uiState.cast<BaseViewState.Error>().throwable as AuthFailure

            ErrorScreen(title = failure.title, description = failure.description) {
                onErrorEvent.invoke(failure)
            }
        }
        is BaseViewState.Loading -> {
            LoadingScreen()
        }
        else -> {
            onLoginCompleteEvent()
        }
    }
}

@Composable
private fun LoginContent(
    uiState: LoginState,
    onTriggerEvent: (LoginEvent) -> Unit = {},
    onForgotPassword: () -> Unit = {},
    onPhoneAuth: () -> Unit = {},
    verifyCredentials: (LoginEvent) -> Unit = {}
){
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val topGuideline = createGuidelineFromTop(.1f)
        val mid30Guideline = createGuidelineFromTop(.3f)
        val mid60Guideline = createGuidelineFromTop(.6f)
        val bottomGuideline = createGuidelineFromBottom(.05f)
        val (titleRef,
            subtitleRef,
            emailRef,
            passwordRef,
            forgotPasswordRef,
            createButtonRef,
            otherOptionsTextRef,
            otherOptionsRef
        ) = createRefs()

        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }

        Text(text = stringResource(id = R.string.login),
            fontSize = 24.sp,
            modifier = Modifier.constrainAs(titleRef) {
                top.linkTo(topGuideline, 10.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )

        Text(text = stringResource(id = R.string.continue_your_journey),
            fontSize = 16.sp,
            modifier = Modifier.constrainAs(subtitleRef) {
                bottom.linkTo(mid30Guideline, 25.dp)
                start.linkTo(emailRef.start)
            }
        )

        ElevatedTextField(
            value = email,
            onValueChange = {email = it},
            placeholder = { Text(text = stringResource(id = R.string.email)) },
            defaultElevation = 5.dp,
            pressedElevation = 10.dp,
            modifier = Modifier.constrainAs(emailRef) {
                top.linkTo(mid30Guideline)
                start.linkTo(parent.start, 20.dp)
                end.linkTo(parent.end, 20.dp)
                width = Dimension.fillToConstraints
            }
        )

        ElevatedTextField(
            value = password,
            onValueChange = {password = it},
            placeholder = { Text(text = stringResource(id = R.string.password)) },
            defaultElevation = 5.dp,
            pressedElevation = 10.dp,
            modifier = Modifier.constrainAs(passwordRef) {
                top.linkTo(emailRef.bottom, 10.dp)
                start.linkTo(parent.start, 20.dp)
                end.linkTo(parent.end, 20.dp)
                width = Dimension.fillToConstraints
            }
        )

        Text(
            text = stringResource(id = R.string.forgot_password_question),
            fontWeight = FontWeight.SemiBold,
            color = PrimaryBlue,
            modifier = Modifier
                .clickable(onClick = onForgotPassword)
                .constrainAs(forgotPasswordRef) {
                    top.linkTo(passwordRef.bottom, 25.dp)
                    end.linkTo(passwordRef.end)
                }
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clickable(
                    onClick = {
                        onTriggerEvent(
                            LoginEvent.EmailPasswordAuthData(
                                email = email,
                                password = password
                            )
                        )
                    },
                    enabled = uiState.isVerified
                )
                .constrainAs(createButtonRef) {
                    top.linkTo(mid60Guideline)
                    end.linkTo(forgotPasswordRef.end)
                })
        {

            Text(
                text = stringResource(id = R.string.login),
                color = if(uiState.isVerified) PrimaryBlue else Color.Gray,
            )

            ElevatedIconButton(
                icon = R.drawable.icon_next_arrow,
                iconSize = 24.dp,
                contentDescription = stringResource(id = R.string.content_description_next),
                onClick = {
                    onTriggerEvent(
                        LoginEvent.EmailPasswordAuthData(
                            email = email,
                            password = password
                        )
                    )
                },
                enabled = uiState.isVerified
            )
        }

        Text(
            text = stringResource(id = R.string.login_additional_methods),
            modifier = Modifier.constrainAs(otherOptionsTextRef) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(otherOptionsRef.top, 15.dp)
            }
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(25.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .wrapContentSize()
                .constrainAs(otherOptionsRef) {
                    bottom.linkTo(bottomGuideline)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        ) {

            ElevatedIconButton(
                icon = R.drawable.icon_phone,
                iconSize = 24.dp,
                contentDescription = stringResource(id = R.string.content_description_phone),
                onClick = onPhoneAuth,
                enabled = true,
                color = Color.Gray
            )

            ElevatedIconButton(
                icon = R.drawable.icon_google_logo,
                iconSize = 24.dp,
                contentDescription = stringResource(id = R.string.content_description_google),
                onClick = {},
                enabled = true,
                color = Color.Gray
            )

            ElevatedIconButton(
                icon = R.drawable.icon_twitter_logo,
                iconSize = 24.dp,
                contentDescription = stringResource(id = R.string.content_description_twitter),
                onClick = {},
                enabled = true,
                color = Color.Gray
            )
        }

        LaunchedEffect(email, password) {
            verifyCredentials(LoginEvent.EmailPasswordAuthData(email, password))
        }
    }
}