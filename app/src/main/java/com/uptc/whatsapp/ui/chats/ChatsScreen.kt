package com.uptc.whatsapp.ui.chats

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.uptc.whatsapp.R

@Composable
fun ChatsScreen() {
    LazyColumn {
        items(15) { index ->
            ChatItem(
                chatName = "Chat Name $index",
                lastMessage = "Last message preview $index",
                timestamp = "${index + 1}/10/2024"
            )
        }
    }
}

@Composable
fun ChatItem(chatName: String, lastMessage: String, timestamp: String) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        val (profileImage, name, message, time) = createRefs()

        Image(
            painter = painterResource(id = R.drawable.profile_placeholder),
            contentDescription = "Profile Image",
            modifier = Modifier
                .size(50.dp)
                .padding(end = 8.dp)  // Añade un espacio entre la imagen y el texto
                .constrainAs(profileImage) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                }
        )
        Text(
            text = chatName,
            modifier = Modifier.constrainAs(name) {
                start.linkTo(profileImage.end, margin = 8.dp)
                top.linkTo(profileImage.top)
            },
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            text = lastMessage,
            modifier = Modifier.constrainAs(message) {
                start.linkTo(name.start)
                top.linkTo(name.bottom, margin = 4.dp)
            },
            style = MaterialTheme.typography.bodySmall,
            maxLines = 1
        )
        Text(
            text = timestamp,
            modifier = Modifier.constrainAs(time) {
                end.linkTo(parent.end, margin = 8.dp)
                top.linkTo(name.top)
            },
            style = MaterialTheme.typography.bodySmall
        )
    }
}