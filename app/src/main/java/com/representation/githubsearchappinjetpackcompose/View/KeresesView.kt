package com.representation.githubsearchappinjetpackcompose.View

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.representation.githubsearchappinjetpackcompose.Model.KeresesStatusz
import com.representation.githubsearchappinjetpackcompose.R
import com.representation.githubsearchappinjetpackcompose.View.KeresesViewElemek.KeresoMezo
import com.representation.githubsearchappinjetpackcompose.View.KeresesViewElemek.TalalatiLista
import com.representation.githubsearchappinjetpackcompose.View.SharedViews.BetoltesAlatt
import com.representation.githubsearchappinjetpackcompose.ViewModel.KeresesViewModel
import com.representation.githubsearchappinjetpackcompose.ui.theme.feher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Composable
fun KeresesView(navController: NavController) {

    val kvm = remember { KeresesViewModel() }
    val keresesStatusz by kvm.keresesStatusz.collectAsState()
    var width: Float by remember { mutableStateOf(0.0F) }
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
            .padding(20.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.githublogo),
            contentDescription = "háttér logó",
            modifier = Modifier
                .height(150.dp)
                .align(Alignment.Center),
            contentScale = ContentScale.Fit,
        )

        BoxWithConstraints() {
            width = with(LocalDensity.current) { maxWidth.value }
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Top
            ) {
                Text(
                    text = "Keresés a GitHubon",
                    color = feher,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 20.dp, bottom = 20.dp)
                )
                //keresőmező
                KeresoMezo(kvm, width)

                //találatilista
                when(keresesStatusz){
                    KeresesStatusz.KERES -> BetoltesAlatt()
                    KeresesStatusz.HIBA -> Text("Hiba történt...", color = feher)
                    KeresesStatusz.VEGZETT -> {
                        if (!kvm.talalatiLista.items.isEmpty()) {
                            if (kvm.talalatiLista.items[0].name != "gyk_ures"
                            ) {
                                TalalatiLista(navController, kvm, width)
                            }
                        } else {
                            Toast.makeText(
                                context,
                                "Nincs találat. Próbálkozz más kulcsszóval!",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                    KeresesStatusz.OFF -> Row(){}
                }


            }
        }
    }
}