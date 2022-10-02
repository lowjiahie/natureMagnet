package com.example.naturemagnet

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.Nullable
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.example.naturemagnet.database.NatureMagnetDB
import com.example.naturemagnet.databinding.FragmentAdminManagementBinding
import com.example.naturemagnet.databinding.FragmentEditProductBinding

class EditProduct : Fragment() {

    private lateinit var binding: FragmentEditProductBinding
    lateinit var bitmap : Bitmap

    companion object{
        val IMAGE_REQUEST_CODE = 100
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit_product, container, false)

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_edit_product,
            container,
            false
        )

        val application = requireNotNull(this.activity).application
        val db = NatureMagnetDB.getInstance(application)!!.productDao()

        val selectedProdID = binding.selectedProdID.toString()
        val selectedProdName = binding.selectedProdName.toString()
        val selectedProdPrice = binding.selectedProdPrice.toString()
        val selectedProdStock = binding.selectedProdStock.toString()
        val selectedProdDesc = binding.selectedProdDesc.toString()

        val editName = binding.inputProdName.text.toString().trim()
        val editPrice = binding.inputProdPrice.text.toString().trim()
        val editStock = binding.inputProdStock.text.toString().trim()
        val editDescription = binding.inputProdDesc.text.toString().trim()
        var imgUploaded = bitmap

        val editImage = binding.loadNewProdImg.setOnClickListener {
            pickImageGallery()
        }

        binding.btnUpdProdName.setOnClickListener{
            var product = db.loadProductDetail(editName)
            if(editName.isEmpty() || product != null)
            {
                Toast.makeText(application, "Please Enter a New Name", Toast.LENGTH_SHORT).show();
            }
            else{
                db.replaceNewProdName(editName, selectedProdName)
                Toast.makeText(application, "Name has Updated Successfully", Toast.LENGTH_SHORT).show();
            }
        }
        binding.btnUpdProdPrice.setOnClickListener{
            if(editPrice.isEmpty())
            {
                Toast.makeText(application, "Please Enter a New Price", Toast.LENGTH_SHORT).show();
            }
            else{
                db.replaceNewProdPrice(editPrice, selectedProdPrice)
                Toast.makeText(application, "Price has Updated Successfully", Toast.LENGTH_SHORT).show();
            }
        }
        binding.btnUpdProdStock.setOnClickListener{
            if(editStock.isEmpty())
            {
                Toast.makeText(application, "Please Enter a New Stock Quantity", Toast.LENGTH_SHORT).show();
            }
            else{
                db.replaceNewProdStock((editStock.toInt()), selectedProdStock.toInt())
                Toast.makeText(application, "Stock Quantity has Updated Successfully", Toast.LENGTH_SHORT).show();
            }
        }
        binding.btnUpdProdDesc.setOnClickListener{
            if(editStock.isEmpty())
            {
                Toast.makeText(application, "Please Enter a New Description", Toast.LENGTH_SHORT).show();
            }
            else{
                db.replaceNewProdDesc(editDescription, selectedProdDesc)
                Toast.makeText(application, "Description has Updated Successfully", Toast.LENGTH_SHORT).show();
            }
        }
        binding.loadNewProdImg.setOnClickListener{
        }
    }

    fun pickImageGallery(){
        val intent = Intent(Intent.ACTION_PICK)
        intent.type ="image/*"
        startActivityForResult(intent, AddProduct.IMAGE_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == AddProduct.IMAGE_REQUEST_CODE && resultCode == Activity.RESULT_OK){
            Glide.with(this)
                .asBitmap()
                .load(data?.data)
                .into(object : CustomTarget<Bitmap?>() {
                    override fun onResourceReady(
                        resource: Bitmap,
                        @Nullable transition: Transition<in Bitmap?>?
                    ) {
                        binding.loadNewProdImg.setImageBitmap(resource)
                        bitmap = resource
                    }
                    override fun onLoadCleared(@Nullable placeholder: Drawable?) {}
                })

        }
    }

}