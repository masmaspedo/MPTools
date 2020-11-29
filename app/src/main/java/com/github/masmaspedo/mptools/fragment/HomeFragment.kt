package com.github.masmaspedo.mptools.fragment

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.github.masmaspedo.mptools.R
import android.os.Build
import androidx.annotation.RequiresApi
import com.topjohnwu.superuser.Shell

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
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
        val v : View =  inflater.inflate(R.layout.fragment_home, container, false)
        getDeviceInfo(v)
        return v
    }

    fun getDeviceInfo(view : View){
        val devices : TextView = view.findViewById(R.id.fhome_device_name)
        val osver : TextView = view.findViewById(R.id.fhome_device_os_version)
        val roms : TextView = view.findViewById(R.id.fhome_device_rom)
        val kernel : TextView = view.findViewById(R.id.fhome_device_kernel)
        val rooted : TextView = view.findViewById(R.id.fhome_device_rooted)
        val version : TextView = view.findViewById(R.id.fhome_device_app_version)
        val infos = context?.let { activity?.packageManager?.getPackageInfo(it.packageName,0)}
        devices.setText(Build.MANUFACTURER.toString()+" "+Build.MODEL.toString())
        osver.setText(Build.VERSION.RELEASE)
        roms.setText(Build.DISPLAY.toString())
        kernel.setText(System.getProperty("os.version"))
        if(Shell.rootAccess()){
            rooted.setText("True")
            rooted.setTextColor(Color.parseColor("#17E64E"))
        }else {
            rooted.setText("False")
            rooted.setTextColor(Color.parseColor("#E61717"))
        }
        version.setText(infos?.versionName.toString())

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}