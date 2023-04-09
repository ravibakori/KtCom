package com.webako.ktcom


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.webako.ktcom.ui.theme.KtComTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KtComTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingOn()
                }
            }
        }
    }
}

@Composable
fun GreetingOn(){


    val empList = listOf<Employe>(
        Employe("John Sinha1", "89700000001","500001"),
        Employe("John Sinha2", "89700000002","500002"),
        Employe("John Sinha3", "89700000003","500003"),
        Employe("John Sinha4", "89700000004","500005"),
        Employe("John Sinha5", "89700000005","500006"),
        Employe("John Sinha6", "89700000006","500007"),
        Employe("John Sinha7", "89700000007","5000034"),
        Employe("John Sinha8", "89700000008","5000032"),
        Employe("John Sinha9", "89700000009","5000056"),
        Employe("John Sinha10", "89700000010","5000023"),
        Employe("John Sinha11", "89700000011","5000013"),
        Employe("John Sinha12", "89700000012","5000017"),
        Employe("John Sinha13", "89700000013","5000010"),
        Employe("John Sinha14", "89700000014","5000012"),
        Employe("John Sinha15", "89700000015","5000014"),
        Employe("John Sinha16", "89700000016","5000041"),
        Employe("John Sinha17", "89700000017","5000061"),
    )
    Greeting(UserList = empList)
}




@Composable
fun Greeting(UserList: List<Employe>) {

 LazyColumn(){
     items(UserList){
         EmpCard(emp = it)
     }
 }
    
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmpCard(emp:Employe)
{
    ElevatedCard(modifier = Modifier
        .padding(6.dp)
        .fillMaxWidth()
        .animateContentSize(
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioMediumBouncy,
                stiffness = Spring.StiffnessLow
            )
        )



    ) { var expanded by remember {
        mutableStateOf( false)

    }

        Row {
            ProfileImage()
            Column {
                TextDetails(tag = "name", name = emp.employeName)
                TextDetails(tag = "contact", name = emp.employeContact)
                TextDetails(tag = "Empid", name = emp.employeID)
                if(expanded)
                {
                    TextDetails(tag = "Nickname", name = "Babu")
                }
            }
            Spacer(modifier = Modifier.padding(start= 20.dp))
            ExpIcon(onClick = { expanded = !expanded}, expanded = expanded)

        }
    }


}




@Composable
fun ExpIcon(onClick:()->Unit ,expanded:Boolean)
{
    IconButton(onClick = onClick) {
        Icon(imageVector = Icons.Filled.Info, contentDescription = "" )
    }

}
@Composable
fun ProfileImage(){
    Image(painter = painterResource(id = R.drawable.profile_pic_1),
            contentDescription = "",
        modifier = Modifier
            .size(70.dp)
            .padding(8.dp)

    )
}
@Composable
fun TextDetails(tag:String, name:String){
    Text(text = "$tag : $name", modifier = Modifier.padding(4.dp)
    )
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    KtComTheme {
        GreetingOn()
    }
}