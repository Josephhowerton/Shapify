package views

import android.content.res.Configuration
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.fitness.shapify.theme.ShapifyTheme
import com.fitness.shapify.theme.properties.buttonShape
import com.fitness.theme.R

@Preview(
    showBackground = true
)
@Composable
private fun ElevatedButtonLightPreview(){
    ShapifyTheme {
        Surface {
            ElevatedIconButton(R.drawable.icon_google_logo, "google logo", color = Color.Gray)
        }
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun ElevatedButtonDarkPreview(){
    ShapifyTheme {
        Surface {
            ElevatedIconButton(R.drawable.icon_google_logo, "google logo", color = Color.DarkGray)
        }
    }
}


@Preview(
    showBackground = true
)
@Composable
private fun DependentElevatedIconButtonLightPreview(){
    ShapifyTheme {
        Surface {
            ElevatedIconButton(R.drawable.icon_next, "google logo")
        }
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun DependentElevatedIconButtonDarkPreview(){
    ShapifyTheme {
        Surface {
            ElevatedIconButton(R.drawable.icon_next, "google logo")
        }
    }
}

@Composable
fun ElevatedIconButton(
    icon: Int,
    contentDescription: String,
    modifier: Modifier = Modifier,
    iconSize: Dp = 48.dp,
    onClick: () -> Unit = {},
    defaultElevation: Dp = 0.dp,
    enabled: Boolean = true,
    color: Color = Color.Unspecified
){
    FilledIconButton(
        onClick = onClick,
        enabled = enabled,
        shape = buttonShape(),
        colors = IconButtonDefaults.filledIconButtonColors(containerColor = color),
        modifier = modifier
            .wrapContentSize()
            .shadow(elevation = defaultElevation, shape = buttonShape())
    ){
        Icon(painter = painterResource(id = icon),
            contentDescription = contentDescription,
            tint = Color.Unspecified,
            modifier = Modifier.size(iconSize)
        )
    }
}

@Composable
fun ElevatedIconButton(
    icon: Int,
    contentDescription: String,
    modifier: Modifier = Modifier,
    iconSize: Dp = 48.dp,
    onClick: () -> Unit = {},
    defaultElevation: Dp = 0.dp,
    enabled: Boolean = true
){
    FilledIconButton(
        onClick = onClick,
        enabled = enabled,
        shape = buttonShape(),
        modifier = modifier
            .wrapContentHeight()
            .width(iconSize*4)
            .shadow(elevation = defaultElevation, shape = buttonShape())
    ){
        Icon(painter = painterResource(id = icon),
            contentDescription = contentDescription,
            tint = Color.Unspecified,
            modifier = Modifier.size(iconSize)
        )
    }
}