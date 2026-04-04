package com.mahrusali.multifoto;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.content.ClipData;

import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.*;

import java.util.ArrayList;
import java.util.List;

@DesignerComponent(version = 1,
    description = "Ekstensi MultiFoto untuk mengambil banyak foto sekaligus - Developed by Mahrus Ali",
    category = ComponentCategory.EXTENSION,
    nonVisible = true,
    iconName = "images/extension.png")
@SimpleObject(external = true)
public class MultiFoto extends AndroidNonvisibleComponent implements ActivityResultListener {

    private final Activity activity;
    private int requestCode = 0;

    public MultiFoto(ComponentContainer container) {
        super(container.$form());
        this.activity = container.$context();
    }

  @SimpleFunction(description = "Buka galeri untuk memilih banyak foto sekaligus dengan kompatibilitas tinggi")
    public void PilihBanyakFoto() {
        if (requestCode == 0) {
            requestCode = form.registerForActivityResult(this);
        }
        
        // Menggunakan ACTION_OPEN_DOCUMENT lebih stabil untuk memilih banyak file di Android baru
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("image/*");
        
        // Wajib untuk pemilihan banyak foto
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true); 
        
        // Memberikan akses baca permanen (opsional, tapi bagus untuk stabilitas)
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

        try {
            activity.startActivityForResult(intent, requestCode);
        } catch (Exception e) {
            // Jika perangkat lama tidak mendukung OPEN_DOCUMENT, gunakan fallback ke GET_CONTENT
            Intent fallback = new Intent(Intent.ACTION_GET_CONTENT);
            fallback.setType("image/*");
            fallback.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
            activity.startActivityForResult(Intent.createChooser(fallback, "Pilih Foto"), requestCode);
        }
    }

    @Override
    public void resultReturned(int requestCode, int resultCode, Intent data) {
        if (requestCode == this.requestCode && resultCode == Activity.RESULT_OK) {
            List<String> imagePaths = new ArrayList<>();
            
            if (data != null) {
                if (data.getClipData() != null) {
                    ClipData clipData = data.getClipData();
                    for (int i = 0; i < clipData.getItemCount(); i++) {
                        Uri uri = clipData.getItemAt(i).getUri();
                        imagePaths.add(uri.toString());
                    }
                } else if (data.getData() != null) {
                    Uri uri = data.getData();
                    imagePaths.add(uri.toString());
                }
            }
            SetelahFotoDipilih(imagePaths);
        }
    }

    @SimpleEvent(description = "Event yang muncul setelah foto dipilih. Mengembalikan list berisi path foto.")
    public void SetelahFotoDipilih(List<String> daftarFoto) {
        EventDispatcher.dispatchEvent(this, "SetelahFotoDipilih", daftarFoto);
    }
}
