package com.example.parami

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
 * Use the [FragmentEmociones.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentEmociones : Fragment() {
    // TODO: Rename and change types of parameters

    private lateinit var recycler_emociones : RecyclerView
    private lateinit var adaptador_emociones : AdaptadorEmocion

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
        return inflater.inflate(R.layout.fragment_emociones, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler_emociones = view.findViewById(R.id.recyclerviewlistaEmociones)
        llenar_data()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentEmociones.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentEmociones().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun llenar_data() {
        val listarEmociones = listOf(
            EntidadEmocion(R.drawable.img_feliz, "Hoy me siento:", "Feliz"),
            EntidadEmocion(R.drawable.img_ansiosa, "Hoy me siento:", "Ansiosa"),
            EntidadEmocion(R.drawable.img_enojo, "Hoy me siento:", "Enojada"),
            EntidadEmocion(R.drawable.img_triste, "Hoy me siento:", "Triste"),
            EntidadEmocion(R.drawable.img_aburrida, "Hoy me siento:", "Aburrida"),
            EntidadEmocion(R.drawable.img_miedo2, "Hoy me siento con:", "Miedo")
        )

        adaptador_emociones = AdaptadorEmocion(listarEmociones)
        recycler_emociones.adapter = adaptador_emociones
        recycler_emociones.layoutManager = LinearLayoutManager(requireContext())
    }

}