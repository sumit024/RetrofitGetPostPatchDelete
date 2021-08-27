package com.app_devs.retrofit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_create_new_user.*
import kotlinx.android.synthetic.main.activity_main.*

class CreateNewUser : AppCompatActivity() {
    lateinit var viewModel: CreateNewUserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_new_user)

        val user_id = intent.getStringExtra("user_id")
        initViewModel()
        createUserObservable()

        if(user_id != null) {
            loadUserData(user_id)
        }
        create_btn.setOnClickListener {
            createUser(user_id)
        }
        delete_btn.setOnClickListener {
            deleteUser(user_id)
        }
    }

    private fun deleteUser(user_id: String?) {
        viewModel.getDeleteUserObservable().observe(this, Observer <UserResponse?>{
            if(it != null) {
                Toast.makeText(this@CreateNewUser, "Failed to delete user...", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this@CreateNewUser, "Successfully deleted user...", Toast.LENGTH_LONG).show()
                finish()
            }
        })
        viewModel.deleteUser(user_id)
    }
    private fun loadUserData(user_id: String?) {
        viewModel.getLoadUserObservable().observe(this, Observer <UserResponse?>{
            if(it != null) {
                et_name.setText(it.data?.name)
                et_email.setText(it.data?.email)
                create_btn.setText("Update")
                delete_btn.visibility =  View.VISIBLE
            }
        })
        viewModel.getUserData(user_id)
    }
    private fun createUser(user_id: String?){
        val user = User("", et_name.text.toString(), et_email.text.toString(), "Active", "Male")

        if(user_id == null)
            viewModel.createUser(user)
        else
            viewModel.updateUser(user_id, user)

    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(CreateNewUserViewModel::class.java)

    }

    private fun createUserObservable() {
        viewModel.getCreateNewUserObservable().observe(this, Observer <UserResponse?>{
            if(it == null) {
                Toast.makeText(this@CreateNewUser, "Failed to create/update new user...", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this@CreateNewUser, "Successfully created/updated user...", Toast.LENGTH_LONG).show()
                finish()
            }
        })
    }
}