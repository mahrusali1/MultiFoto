package com.mahrusali.multifoto;

import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.*;

@DesignerComponent(version = 1,
    description = "Ekstensi MultiFoto untuk pengambilan gambar - Developed by Mahrus Ali",
    category = ComponentCategory.EXTENSION,
    nonVisible = true,
    iconName = "images/extension.png")
@SimpleObject(external = true)
public class MultiFoto extends AndroidNonvisibleComponent {

    public MultiFoto(ComponentContainer container) {
        super(container.$form());
    }

    @SimpleFunction(description = "Fungsi untuk tes ambil foto")
    public void AmbilFoto() {
        // Logika akan kita isi setelah build pertama berhasil
    }
}
