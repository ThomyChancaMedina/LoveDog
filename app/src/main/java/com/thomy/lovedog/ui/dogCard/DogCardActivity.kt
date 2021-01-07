package com.thomy.lovedog.ui.dogCard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.view.Window
import androidx.core.view.isGone
import androidx.interpolator.view.animation.FastOutSlowInInterpolator
import androidx.lifecycle.Observer
import com.google.android.material.transition.platform.MaterialContainerTransform
import com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback
import com.thomy.domain.CardDogView
import com.thomy.domain.Dog
import com.thomy.lovedog.R
import com.thomy.lovedog.databinding.ActivityDogCardBinding
import com.thomy.lovedog.ui.common.appA
import com.thomy.lovedog.ui.common.getViewModel
import com.thomy.lovedog.ui.common.setSwipeCardsAnimation


class DogCardActivity : AppCompatActivity() {
    val data: ArrayList<Dog> = ArrayList()

    var currentIndex: Int = 0

    private lateinit var component: CardActivityComponent
    private val viewModel by lazy { getViewModel { component.dogCardViewModel } }

    lateinit var binding: ActivityDogCardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
        super.onCreate(savedInstanceState)
        binding = ActivityDogCardBinding.inflate(layoutInflater)
        with(binding) {
            setContentView(root)
            val intent = intent
            val country = intent.getStringExtra("key")

            component = appA.component.plus(CardActivityModule(country!!))

            setEnterSharedElementCallback(MaterialContainerTransformSharedElementCallback())
            window.sharedElementEnterTransition = buildContainerTransform()
            window.sharedElementReturnTransition = buildContainerTransform()
            setSupportActionBar(toolbar)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setDisplayShowTitleEnabled(false)

            viewModel.dog.observe(this@DogCardActivity, Observer(::updateUi))
            viewModel.modelStream.observe(this@DogCardActivity, Observer {
                bindCard(it)
            })
            motionLayout.setSwipeCardsAnimation {
                viewModel.swipe()
            }
            likeB.setOnClickListener {
                motionLayout.transitionToState(R.id.likeB)
            }
            dislike.setOnClickListener {
                motionLayout.transitionToState(R.id.dislike)
            }

        }


    }


    private fun updateUi(uiModelCard: DogCardViewModel.UiModelCard) {
        when (uiModelCard) {
            is DogCardViewModel.UiModelCard.GetAllDogs -> {
                with(binding) {
                    viewModel.setDogs(uiModelCard.dogs)
                    data.addAll(uiModelCard.dogs)
                    currentIndex += 1
                    photo.setImageResource(uiModelCard.dogs[0].image)
                    description.text = uiModelCard.dogs[0].description
                    name.text =
                        String.format("%s, %s", uiModelCard.dogs[0].name, uiModelCard.dogs[0].id)

                    photo2.setImageResource(uiModelCard.dogs[1].image)
                    description2.text = uiModelCard.dogs[1].description
                    name2.text =
                        String.format("%s, %s", uiModelCard.dogs[1].name, uiModelCard.dogs[1].id)
                }


            }
        }

    }

    private fun buildContainerTransform() =
        MaterialContainerTransform().apply {
            addTarget(binding.motionLayout)
            duration = 300
            interpolator = FastOutSlowInInterpolator()
            fadeMode = MaterialContainerTransform.FADE_MODE_IN
        }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> {
                true
            }
        }
    }

    private fun bindCard(dog: CardDogView) {

        if (data.size > currentIndex) {
            with(binding) {
                photo.setImageResource(dog.top.image)
                description.text = dog.top.description
                name.text = String.format("%s, %s", dog.top.name, dog.top.id)

                photo2.setImageResource(dog.bottom.image)
                description2.text = dog.bottom.description
                name2.text = String.format("%s, %s", dog.bottom.name, dog.bottom.id)
            }
        }


    }
}