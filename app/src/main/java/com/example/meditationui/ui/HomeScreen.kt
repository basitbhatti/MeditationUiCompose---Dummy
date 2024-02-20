package com.example.meditationui.ui

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.meditationui.BottomMenuItem
import com.example.meditationui.Feature
import com.example.meditationui.R
import com.example.meditationui.ui.theme.AquaBlue
import com.example.meditationui.ui.theme.Beige1
import com.example.meditationui.ui.theme.Beige2
import com.example.meditationui.ui.theme.Beige3
import com.example.meditationui.ui.theme.BlueViolet1
import com.example.meditationui.ui.theme.BlueViolet2
import com.example.meditationui.ui.theme.BlueViolet3
import com.example.meditationui.ui.theme.ButtonBlue
import com.example.meditationui.ui.theme.DarkerButtonBlue
import com.example.meditationui.ui.theme.DeepBlue
import com.example.meditationui.ui.theme.LightGreen1
import com.example.meditationui.ui.theme.LightGreen2
import com.example.meditationui.ui.theme.LightGreen3
import com.example.meditationui.ui.theme.LightRed
import com.example.meditationui.ui.theme.OrangeYellow1
import com.example.meditationui.ui.theme.OrangeYellow2
import com.example.meditationui.ui.theme.OrangeYellow3
import com.example.meditationui.ui.theme.TextWhite

@Composable
fun HomeScreen() {

    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize()
    ) {

        Column {

            GreetingSection("Sajjad")

            ChipSection(chips = listOf("Sweet Sleep", "Insomnia", "Depression", "Meditation"))

            DailyThoughtSection()

            FeatureSection(
                features = listOf(
                    Feature(
                        "Sleep\nMeditation",
                        R.drawable.ic_headphone,
                        BlueViolet3,
                        BlueViolet2,
                        BlueViolet1
                    ),
                    Feature(
                        "Tips for\nSleeping",
                        R.drawable.ic_videocam,
                        LightGreen3,
                        LightGreen2,
                        LightGreen1
                    ),
                    Feature(
                        "Night\nIsland",
                        R.drawable.ic_moon,
                        OrangeYellow3,
                        OrangeYellow2,
                        OrangeYellow1
                    ),
                    Feature(
                        "Calming\nSounds",
                        R.drawable.ic_bubble,
                        Beige3,
                        Beige2,
                        Beige1
                    )
                )
            )

        }

        BottomMenu(items = listOf(
            BottomMenuItem("Home", R.drawable.ic_home),
            BottomMenuItem("Meditate", R.drawable.ic_bubble),
            BottomMenuItem("Sleep", R.drawable.ic_moon),
            BottomMenuItem("Music", R.drawable.ic_music),
            BottomMenuItem("Profile", R.drawable.ic_profile)
        ), modifier = Modifier.align(Alignment.BottomCenter))

    }


}

@Composable
fun GreetingSection(
    name: String = "Philipp"
) {

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {

        Column(verticalArrangement = Arrangement.Center) {

            Text(
                text = "Hello $name", style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = "We wish you have a good day!", style = MaterialTheme.typography.bodyLarge
            )

        }

        Icon(
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = "Search",
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )


    }
}


@Composable
fun ChipSection(
    chips: List<String>
) {

    var selectedChipIndex by remember {
        mutableStateOf(0)
    }

    LazyRow {
        items(chips.size) {

            Box(modifier = Modifier
                .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                .clickable { selectedChipIndex = it }
                .clip(RoundedCornerShape(10.dp))
                .background(if (selectedChipIndex == it) ButtonBlue else DarkerButtonBlue)
                .padding(15.dp)) {
                Text(text = chips[it], color = TextWhite)
            }
        }
    }

}


@Composable
fun DailyThoughtSection(
    color: Color = LightRed
) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .height(130.dp)
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color)
            .padding(horizontal = 15.dp)
    ) {
        Column {
            Text(
                text = "Daily Thought", style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = "Meditation * 3.5 minutes",
                style = MaterialTheme.typography.bodyLarge,
                color = TextWhite
            )
        }

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(ButtonBlue)
                .padding(15.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_play),
                contentDescription = "Play",
                tint = Color.White,
                modifier = Modifier.size(16.dp)
            )

        }
    }

}

@Composable
fun FeatureSection(features: List<Feature>) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Features",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(15.dp)
        )

        LazyVerticalGrid(
            columns = GridCells.Adaptive(150.dp),
            contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp),
            modifier = Modifier.fillMaxHeight()
        ) {
            items(features.size) {
                FeatureItem(feature = features[it])
            }
        }


    }
}

@Composable
fun FeatureItem(
    context: Context = LocalContext.current,
    feature: Feature
) {

    Box(
        modifier = Modifier
            .padding(7.5.dp)
            .fillMaxSize(0.5f)
            .height(150.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(feature.darkColor)
            .padding(15.dp)
    ) {
        Text(
            text = feature.title,
            style = MaterialTheme.typography.headlineMedium,
            lineHeight = 26.sp,
            modifier = Modifier.align(Alignment.TopStart)
        )

        Icon(
            painter = painterResource(id = feature.iconId),
            contentDescription = null,
            modifier = Modifier.align(
                Alignment.BottomStart
            ),
            tint = Color.White
        )

        Text(
            text = "Start",
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .clip(RoundedCornerShape(10.dp))
                .background(ButtonBlue)
                .padding(horizontal = 15.dp, vertical = 5.dp)
                .clickable {
                    Toast
                        .makeText(context, feature.title, Toast.LENGTH_SHORT)
                        .show()
                },

            style = MaterialTheme.typography.headlineMedium,
            color = TextWhite
        )
    }

}


@Composable
fun BottomMenu(
    items: List<BottomMenuItem>,
    modifier: Modifier = Modifier,
    backgroundColor: Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    initialSelectedItemIndex: Int = 0
) {

    var selectedItemIndex by remember {
        mutableStateOf(initialSelectedItemIndex)
    }

    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(DeepBlue)
            .padding(15.dp)
    ) {

        items.forEachIndexed { index, item ->
            BottomItem(
                item = item,
                isSelected = index == selectedItemIndex,
                backgroundColor = backgroundColor,
                activeTextColor = activeTextColor,
                inactiveTextColor = inactiveTextColor,
                onItemClick = {
                    selectedItemIndex = index
                }
            )
        }

    }

}

@Composable
fun BottomItem(
    item: BottomMenuItem,
    isSelected: Boolean = false,
    backgroundColor: Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    onItemClick: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable {
            onItemClick()
        }
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(if (isSelected) backgroundColor else Color.Transparent)
                .padding(10.dp)
        ) {
            Icon(
                painter = painterResource(id = item.iconId),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(20.dp),
                tint = if (isSelected) activeTextColor else inactiveTextColor,
            )

        }
        Text(text = item.title, color = if (isSelected) activeTextColor else inactiveTextColor)

    }
}
