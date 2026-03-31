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
    private int requestCode;

    public MultiFoto(ComponentContainer container) {
        super(container.$form());
        this.activity = container.$context();
    }

    @SimpleFunction(description = "Buka galeri untuk memilih banyak foto sekaligus")
    public void PilihBanyakFoto() {
        if (requestCode == 0) {
            requestCode = form.registerForActivityResult(this);
        }
        
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true); // Ini kuncinya!
        activity.startActivityForResult(Intent.createChooser(intent, "Pilih Foto"), requestCode);
    }

    @Override
    public void resultReturned(int requestCode, int resultCode, Intent data) {
        if (requestCode == this.requestCode && resultCode == Activity.RESULT_OK) {
            List<String> imagePaths = new ArrayList<>();
            
            if (data.getClipData() != null) {
                // Jika user pilih lebih dari satu
                ClipData clipData = data.getClipData();
                for (int i = 0; i < clipData.getItemCount(); i++) {
                    Uri uri = clipData.getItemAt(i).getUri();
                    imagePaths.add(uri.toString());
                }
            } else if (data.getData() != null) {
                // Jika user cuma pilih satu
                Uri uri = data.getData();
                imagePaths.add(uri.toString());
            }
            
            // Kirim daftar path foto kembali ke MIT App Inventor
            SetelahFotoDipilih(imagePaths);
        }
    }

    @SimpleEvent(description = "Event yang muncul setelah foto dipilih. Mengembalikan list berisi path foto.")
    public void SetelahFotoDipilih(List<String> daftarFoto) {
        EventDispatcher.dispatchEvent(this, "SetelahFotoDipilih", daftarFoto);
    }
}
