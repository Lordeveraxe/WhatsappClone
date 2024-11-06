package com.uptc.whatsapp.ui.status

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import com.uptc.whatsapp.R

@Composable
fun StatusScreen() {
    LazyRow(
        modifier = Modifier.padding(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(10) { index ->
            StatusItem(statusName = "Status $index")
        }
    }
}

@Composable
fun StatusItem(statusName: String) {
    ConstraintLayout(modifier = Modifier.size(80.dp)) {
        val (profileImage, name) = createRefs()

        Image(
            painter = painterResource(id = R.drawable.profile_placeholder),
            contentDescription = "Status Image",
            modifier = Modifier
                .size(50.dp)
                .constrainAs(profileImage) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                }
        )
        Text(
            text = statusName,
            modifier = Modifier.constrainAs(name) {
                start.linkTo(parent.start)
                top.linkTo(profileImage.bottom, margin = 4.dp)
            },
            style = MaterialTheme.typography.bodySmall
        )
    }
}
