package widget

import android.content.res.Configuration
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fitness.shapify.theme.DarkerBlack
import com.fitness.shapify.theme.PrimaryWhiteVariant
import com.fitness.shapify.theme.Red
import com.fitness.shapify.theme.ShapifyTheme
import com.fitness.theme.R

@Preview(showBackground = true, name = "Light")
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, name = "Dark")
@Composable
private fun ErrorScreenPreview() {
    ShapifyTheme {
        Surface {
            ErrorScreen(R.string.we_are_sorry_title, R.string.default_error_desc)
        }
    }
}

@Composable
fun ErrorScreen(
    title: Int,
    description: Int,
    onClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .padding(50.dp)
            .fillMaxSize()
            .wrapContentHeight(Alignment.CenterVertically)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.icon_error),
            contentDescription = null,
            tint = Red,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
        )

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(12.dp))

        Text(
            text = stringResource(id = title),
            style = MaterialTheme.typography.displaySmall,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(12.dp))

        Text(
            text = stringResource(id = description),
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(12.dp))

        ErrorButton(onClick, if(isSystemInDarkTheme()) DarkerBlack else PrimaryWhiteVariant)
    }
}

@Composable
private fun ErrorButton(onClick: () -> Unit = {}, color: Color){
    Button(
        colors = ButtonDefaults.buttonColors(containerColor = color),
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center),
        onClick = { onClick() }
    ) {
        Text(text = stringResource(id = R.string.retry))
    }
}