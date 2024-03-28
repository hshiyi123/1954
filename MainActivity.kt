package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApplicationTheme {
                        UserCardList()
                    }
                }
            }
        }
    }
}
data class User(var userAvatar: Int, var userName: String, var userBio: String,var userDate: String)
@Composable
fun UserCard (user: User){
    Row (verticalAlignment=Alignment.CenterVertically, modifier = Modifier
        .padding(bottom = 10.dp)
        .fillMaxWidth()
        .size(width = 200.dp, height = 100.dp)
        .background(Color.White)
    ){
        Box {
            Image(painter = painterResource(id = user.userAvatar),contentDescription = null, modifier = Modifier
                .size(100.dp)
                .padding(20.dp)
                .clip(CircleShape)

            )
            Column {
                Text(
                    text = user.userName, style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 18.sp))
                Text(text = user.userBio)
            }
            Text(text = user.userDate, modifier = Modifier.padding(15.dp), color = Color.Gray)
        }
    }
}
@Composable
fun UserCardList(){
    Box {
        Column {
            val users = listOf<User>(

                User(R.drawable.u_3183222127_2597228042_fm_253_fmt_auto_app_138_f_jpeg,"小姐姐" ,"大师赛选手", "1 min ago"),
                User(R.drawable._40d0c5fc2689af0951024f95238c86d,"小黑" ,"简单快乐", "1 min ago"),
                User(R.drawable._67121a26452af8847ffd7b2f59d4c02,"小白" ,"思索未来", "1 min ago"),
                User(R.drawable.a9626d2710268f7adce8781c6ceb1bf5,"小黄" ,"阳光正好", "1 min ago"),
                User(R.drawable.a9626d2710268f7adce8781c6ceb1bf5,"小黄" ,"阳光正好", "1 min ago"),
                User(R.drawable.a9626d2710268f7adce8781c6ceb1bf5,"小黄" ,"阳光正好", "1 min ago"),
            )
            repeat(users.size){ index->
                UserCard(users[index])

            }
        }

    }
}


@Preview(
    showBackground = true, showSystemUi = true
)

@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        UserCardList()
    }
}


