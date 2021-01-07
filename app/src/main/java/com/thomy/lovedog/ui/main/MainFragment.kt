package com.thomy.lovedog.ui.main


import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.thomy.lovedog.R
import com.thomy.lovedog.databinding.FragmentMainBinding
import com.thomy.lovedog.ui.common.EventObserver
import com.thomy.lovedog.ui.common.app
import com.thomy.lovedog.ui.common.getViewModelF
import com.thomy.lovedog.ui.dogCard.DogCardActivity

class MainFragment : Fragment() {

    private lateinit var adapter: FilterDogAdapter
    private lateinit var navController: NavController
    private lateinit var component: MainFragmentComponent

    private lateinit var binding: FragmentMainBinding

    private val viewModel: MainViewModel by lazy { getViewModelF { component.mainViewModel } }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreate(savedInstanceState)
        binding = FragmentMainBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = view.findNavController()

        val list = resources.getStringArray(R.array.countries)
        val adapterSpinner: ArrayAdapter<String> = object : ArrayAdapter<String>(
            app,
            R.layout.support_simple_spinner_dropdown_item,
            list
        ) {
            override fun getDropDownView(
                position: Int,
                convertView: View?,
                parent: ViewGroup
            ): View {
                val view: TextView = super.getDropDownView(
                    position,
                    convertView,
                    parent
                ) as TextView
                with(binding) {


                    view.setTypeface(view.typeface, Typeface.BOLD)

                    if (position == spinnerNav.selectedItemPosition && position != 0) {
                        view.background = ColorDrawable(Color.parseColor("#F7E7CE"))
                        view.setTextColor(Color.parseColor("#333399"))
                    }
                    if (position == 0) {
                        view.setTextColor(Color.LTGRAY)
                    }
                }

                return view
            }

            override fun isEnabled(position: Int): Boolean {
                return position != 0
            }
        }
        with(binding) {
            spinnerNav.adapter = adapterSpinner
            spinnerNav.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    if (position != 0) {
                        tvSpinner.text = "Selected: "
                        val intent = Intent(activity, DogCardActivity::class.java)
                        intent.putExtra("key", parent!!.getItemAtPosition(position).toString())
                        startActivity(intent)
                        tvSpinner.append(parent.getItemAtPosition(position).toString())
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {

                }
            }

            component = app.component.plus(MainFragmentModule())


            viewModel.model.observe(viewLifecycleOwner, EventObserver {
                viewModel.getAllDogs()
            })

            setHasOptionsMenu(true)
            adapter = FilterDogAdapter()
            recycler.adapter = adapter
                .apply {
                    modelDog = viewModel
                    lifecycleOwner = this@MainFragment
                }

        }//end with

    }

}