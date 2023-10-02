package com.chandan.carser

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"





/**
 * A simple [Fragment] subclass.
 * Use the [HmeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HmeFragment : Fragment() {
    private lateinit var adapter: TypeAdap
    private lateinit var recyclerView: RecyclerView
    private lateinit var typeArrayList : ArrayList<Model>

    lateinit var ImageId : Array<Int>
    lateinit var heading : Array<String>
    lateinit var title : Array<String>
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hme, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HmeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HmeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            dataInt()
            val layoutManager = LinearLayoutManager(requireActivity())
            recyclerView=view.findViewById(R.id.car_types)
            recyclerView.layoutManager = layoutManager
            recyclerView.setHasFixedSize(true)




    }


    private fun dataInt(){

        typeArrayList = arrayListOf<Model>()

        ImageId = arrayOf(
            R.drawable.hatchback,
            R.drawable.cross_mini,
            R.drawable.sedan_coupe,
            R.drawable.suv_muv,
            R.drawable.img_3,
            R.drawable.lrs,
        )

        heading = arrayOf(
            getString(R.string.c1),
            getString(R.string.c2),
            getString(R.string.c3),
            getString(R.string.c4),
            getString(R.string.c5),
            getString(R.string.c6),
        )



    }

}