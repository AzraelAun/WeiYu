package com.example.menu


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.menu.databinding.FragmentChangePasswordBinding
import kotlinx.android.synthetic.main.fragment_change_password.*
import kotlinx.android.synthetic.main.fragment_login.*

/**
 * A simple [Fragment] subclass.
 */
class ChangePassword : Fragment() {

    lateinit var handler: AccDatabase

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentChangePasswordBinding>(inflater,
            R.layout.fragment_change_password,container,false)

        handler = AccDatabase(binding.root.context)

        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        editpass_button.setOnClickListener {
            if (login_pass.text.toString() == editcurrentpass.text.toString()) {
                if (editpass.text.toString() == editpassword.text.toString()) {
                    handler.changePass(login_username.text.toString(), editpass.text.toString())
                    Toast.makeText(activity, "Change Password Successful", Toast.LENGTH_SHORT).show()

                } else {
                    Toast.makeText(activity, "Retype Password Incorrect", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(activity, "Old Password Incorrect", Toast.LENGTH_SHORT).show()
            }
        }
    }


}
