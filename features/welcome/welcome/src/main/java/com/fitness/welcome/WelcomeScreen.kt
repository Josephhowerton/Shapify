package com.fitness.welcome

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.fitness.shapify.theme.ShapifyTheme
import com.fitness.theme.R

@Preview(showBackground = true)
@Composable
private fun LightPreview() {
    ShapifyTheme {
        Surface {
            WelcomeScreen()
        }
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun DarkPreview() {
    ShapifyTheme {
        Surface {
            WelcomeScreen()
        }
    }
}


@Composable
fun WelcomeScreen(onLoginTap: () -> Unit = {}, onCreateTap: () -> Unit = {}) = ConstraintLayout(modifier = Modifier.fillMaxSize()) {
    val (logoRef, titleRef, subtitleRef, loginButtonRef, createButtonRef) = createRefs()

    val topGuideline = createGuidelineFromTop(.1f)
    val bottomGuideline = createGuidelineFromTop(.85f)

    Icon(painter = painterResource(id = R.drawable.icon_training),
        contentDescription = "",
        modifier = Modifier
            .size(96.dp)
            .constrainAs(logoRef) {
                top.linkTo(topGuideline)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
    )

    Text(text = stringResource(R.string.your_journey_begins_here),
        modifier = Modifier
            .padding(5.dp)
            .constrainAs(titleRef) {
                bottom.linkTo(subtitleRef.top)
                end.linkTo(parent.end)
                start.linkTo(parent.start)
            }
    )

    Text(text = stringResource(id = R.string.welcome_screen_quote),
        textAlign = TextAlign.Center,
        modifier = Modifier
            .padding(15.dp)
            .fillMaxWidth()
            .constrainAs(subtitleRef) {
                bottom.linkTo(loginButtonRef.top)
            }
    )

    Button(onClick = onLoginTap,
        modifier = Modifier
            .padding(15.dp)
            .constrainAs(loginButtonRef) {
                top.linkTo(bottomGuideline)
                end.linkTo(createButtonRef.start)
                start.linkTo(parent.start)
                width = Dimension.fillToConstraints
            }
    ) {
        Text(text = stringResource(id = R.string.login),
            modifier = Modifier.padding(5.dp),
            maxLines = 1
        )
    }

    Button(onClick = onCreateTap, modifier = Modifier
        .padding(15.dp)
        .constrainAs(createButtonRef) {
            top.linkTo(bottomGuideline)
            start.linkTo(loginButtonRef.end)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
        }
    )  {
        Text(text = stringResource(id = R.string.create_account),
            modifier = Modifier.padding(5.dp),
            maxLines = 1
        )
    }
}