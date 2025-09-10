package com.example.galleryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.galleryapp.ui.theme.GalleryAppTheme


data class ImageData(
	@DrawableRes val imageResId: Int,
	@StringRes val description: Int
)

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContent {
			GalleryAppTheme {
				AppGallery()
			}
		}
	}
}

@Composable
fun AppGallery(modifier: Modifier = Modifier) {

	val imageInfoList = listOf(
		ImageData(R.drawable.city, R.string.city),
		ImageData(R.drawable.flower, R.string.flower),
		ImageData(R.drawable.girl, R.string.girl),
		ImageData(R.drawable.house, R.string.house),
		ImageData(R.drawable.love, R.string.love),
		ImageData(R.drawable.milky_way, R.string.milky_way),
		ImageData(R.drawable.mirror, R.string.mirror),
		ImageData(R.drawable.mountain, R.string.mountain),
		ImageData(R.drawable.the_bridge, R.string.the_bridge),
		ImageData(R.drawable.the_moon, R.string.the_moon)
	)

	var imageIndex by remember { mutableIntStateOf(0) }
	var nextButtonIsActive by remember { mutableStateOf(imageIndex <= imageInfoList.size - 1) }
	var previousButtonIsActive by remember { mutableStateOf(imageIndex > 0)}

	Column(
		verticalArrangement = Arrangement.SpaceBetween,
		modifier = modifier
			.fillMaxSize()
			.padding(start = 16.dp, end = 16.dp)
	) {
		ImageContent(imageObject = imageInfoList[imageIndex])

		BottomContent(
			prevBtnIsActive = previousButtonIsActive,
			nextBtnIsActive = nextButtonIsActive,
			nextImage = {
				imageIndex++
				previousButtonIsActive = true
				if(imageIndex == imageInfoList.size - 1)
					nextButtonIsActive = false
			},
			previousImage = {
				imageIndex--
				nextButtonIsActive = true
				if(imageIndex == 0)
					previousButtonIsActive = false
			}
		)
	}
}

@Composable
fun ImageContent(
	imageObject: ImageData,
	modifier: Modifier = Modifier
) {
	Column(
		verticalArrangement = Arrangement.Top,
		modifier = modifier
			.padding(top = 150.dp)
			.fillMaxWidth()
			.height(450.dp)
	) {
		Image(
			contentScale = ContentScale.Crop,
			painter = painterResource(imageObject.imageResId),
			contentDescription = null,
			modifier = Modifier
				.border(width = 28.dp, Color(247, 245, 245))
				.shadow(10.dp)
				.weight(1f)
		)
		Spacer(modifier = Modifier.height(16.dp))
		Text(
			fontSize = 25.sp,
			fontFamily = FontFamily.Cursive,
			fontWeight = FontWeight.SemiBold,
			text = stringResource(imageObject.description)
		)
	}
}

@Composable
fun BottomContent(
	prevBtnIsActive: Boolean,
	nextBtnIsActive: Boolean,
	nextImage: () -> Unit,
	previousImage: () -> Unit,
	modifier: Modifier = Modifier
) {
	Row(
		horizontalArrangement = Arrangement.SpaceEvenly,
		modifier = modifier
			.fillMaxWidth()
			.padding(bottom = 35.dp)
	) {
		Button(
			enabled = prevBtnIsActive,
			modifier = Modifier.weight(1f),
			onClick = { previousImage() }
		) {
			Text(stringResource(R.string.previous_btn_text))
		}
		Spacer(modifier = Modifier.weight(0.7f))
		Button(
			enabled = nextBtnIsActive,
			modifier = Modifier.weight(1f),
			onClick = { nextImage() }
		) {
			Text(stringResource(R.string.next_btn_text))
		}
	}
}

@Preview(showBackground = true)
@Composable
fun AppGalleryPreview() {
	GalleryAppTheme {
		AppGallery()
	}
}

