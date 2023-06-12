package com.fitness.authentication.forgot

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
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
private fun ForgotPasswordContent() = ShapifyTheme{
    Surface {
        ForgotPasswordContent(uiState = ForgotPasswordState())
    }
}


@Composable
fun ForgotPasswordNumberScreen(
    state: StateFlow<BaseViewState<ForgotPasswordState>> = MutableStateFlow(BaseViewState.Data(ForgotPasswordState())),
    onErrorEvent: (AuthFailure) -> Unit,
    onTriggerEvent: (ForgotPasswordEvent) -> Unit = {},
    verifyCredentialsEvent: (ForgotPasswordEvent) -> Unit = {}
) {

        val uiState by state.collectAsState()

        when (uiState) {
            is BaseViewState.Empty -> {
                EmptyScreen()
            }
            is BaseViewState.Data -> {
                ForgotPasswordContent(
                    uiState = uiState.cast<BaseViewState.Data<ForgotPasswordState>>().value,
                    onTriggerEvent = onTriggerEvent,
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

            is BaseViewState.Complete -> {

            }
        }
    }


@Composable
private fun ForgotPasswordContent(
    uiState: ForgotPasswordState,
    onTriggerEvent: (ForgotPasswordEvent) -> Unit = {},
    verifyCredentials: (ForgotPasswordEvent) -> Unit = {}
) {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val topGuideline = createGuidelineFromTop(.1f)
        val mid30Guideline = createGuidelineFromTop(.4f)
        val bottomGuideline = createGuidelineFromBottom(.05f)
        val (
            titleRef,
            subtitleRef,
            emailRef,
            passwordRef,
            confirmPasswordRef,
            updateButton,
        ) = createRefs()

        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var passwordConfirmation by remember { mutableStateOf("") }


        Text(text = stringResource(id = R.string.forgot_password),
            fontSize = 24.sp,
            modifier = Modifier.constrainAs(titleRef) {
                top.linkTo(topGuideline, 10.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )

        ElevatedTextField(
            value = email,
            onValueChange = { email = it },
            placeholder = { Text(text = stringResource(R.string.email)) },
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
            onValueChange = { password = it },
            placeholder = { Text(text = stringResource(id = R.string.enter_password)) },
            defaultElevation = 5.dp,
            pressedElevation = 10.dp,
            modifier = Modifier.constrainAs(passwordRef) {
                top.linkTo(emailRef.bottom, 10.dp)
                start.linkTo(parent.start, 20.dp)
                end.linkTo(parent.end, 20.dp)
                width = Dimension.fillToConstraints
            }
        )

        ElevatedTextField(
            value = passwordConfirmation,
            onValueChange = { passwordConfirmation = it },
            placeholder = { Text(text = stringResource(id = R.string.confirm_password)) },
            defaultElevation = 5.dp,
            pressedElevation = 10.dp,
            modifier = Modifier.constrainAs(confirmPasswordRef) {
                top.linkTo(passwordRef.bottom, 10.dp)
                start.linkTo(parent.start, 20.dp)
                end.linkTo(parent.end, 20.dp)
                width = Dimension.fillToConstraints
            }
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clickable(
                    onClick = {
                        onTriggerEvent(
                            ForgotPasswordEvent.ForgotPasswordData(
                                email,
                                password,
                                passwordConfirmation
                            )
                        )
                    },
                    enabled = uiState.isVerified
                )
                .constrainAs(updateButton) {
                    end.linkTo(confirmPasswordRef.end)
                    top.linkTo(confirmPasswordRef.bottom)
                    bottom.linkTo(bottomGuideline)

                })
        {

            Text(
                text = stringResource(id = R.string.confirm),
                color = if(uiState.isVerified) PrimaryBlue else Color.Gray,
            )

            ElevatedIconButton(
                icon = R.drawable.icon_next,
                iconSize = 24.dp,
                contentDescription = stringResource(id = R.string.content_description_next),
                onClick = {
                    ForgotPasswordEvent.ForgotPasswordData(
                        email,
                        password,
                        passwordConfirmation
                    )
                },
                enabled = uiState.isVerified
            )
        }

        LaunchedEffect(email, password, passwordConfirmation) {
            verifyCredentials(
                ForgotPasswordEvent.ForgotPasswordData(
                    email,
                    password,
                    passwordConfirmation
                )
            )
        }
    }
}