package components.cards

import android.media.Image
import androidx.compose.foundation.layout.*
//noinspection UsingMaterialAndMaterial3Libraries

import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ui.theme.appTypography

@Composable
fun CardPrimary(
    headline: String,
    subhead: String? = null,
    supportingText: String? = null,
    image: Image? = null,
    actions: MutableList<@Composable()() -> Unit>? = null,
    modifier: Modifier = Modifier.fillMaxWidth()
        .padding(8.dp),
    ){
    Card(

        modifier = modifier
    ) {
        Row (
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ){
            Column(
                modifier = Modifier.padding(8.dp),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.Start
            ){
                Text(
                    text = headline,
                    style = appTypography.headlineSmall
                )
                if (subhead != null){
                    Text(
                        modifier = Modifier.padding(4.dp),
                        text = subhead,
                        style = appTypography.bodyLarge
                    )
                }
                if (supportingText != null){
                    Text(
                        modifier = Modifier.padding(4.dp),
                        text = supportingText,
                        style = appTypography.bodySmall
                    )
                }
            }
            if (actions != null) {
                for (composable in actions){
                    Row (
                        modifier = Modifier.padding(8.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)

                    ){
                        composable.invoke()
                    }
                }
            }
        }
    }


}
