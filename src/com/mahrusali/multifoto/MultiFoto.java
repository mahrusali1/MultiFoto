    [javac] /home/runner/work/MultiFoto/MultiFoto/src/com/mahrusali/multifoto/MultiFoto.java:21: error: cannot find symbol
    [javac]     private final Activity activity;
    [javac]                   ^
    [javac]   symbol:   class Activity
    [javac]   location: class MultiFoto
    [javac] /home/runner/work/MultiFoto/MultiFoto/src/com/mahrusali/multifoto/MultiFoto.java:24: error: cannot find symbol
    [javac]     public MultiFoto(ComponentContainer container) {
    [javac]                      ^
    [javac]   symbol:   class ComponentContainer
    [javac]   location: class MultiFoto
    [javac] /home/runner/work/MultiFoto/MultiFoto/src/com/mahrusali/multifoto/MultiFoto.java:42: error: cannot find symbol
    [javac]     public void resultReturned(int requestCode, int resultCode, Intent data) {
    [javac]                                                                 ^
    [javac]   symbol:   class Intent
    [javac]   location: class MultiFoto
    [javac] /home/runner/work/MultiFoto/MultiFoto/src/com/mahrusali/multifoto/MultiFoto.java:29: error: cannot find symbol
    [javac]     @SimpleFunction(description = "Buka galeri untuk memilih banyak foto sekaligus")
    [javac]      ^
    [javac]   symbol:   class SimpleFunction
    [javac]   location: class MultiFoto
    [javac] /home/runner/work/MultiFoto/MultiFoto/src/com/mahrusali/multifoto/MultiFoto.java:64: error: cannot find symbol
    [javac]     @SimpleEvent(description = "Event yang muncul setelah foto dipilih. Mengembalikan list berisi path foto.")
    [javac]      ^
    [javac]   symbol:   class SimpleEvent
    [javac]   location: class MultiFoto
    [javac] /home/runner/work/MultiFoto/MultiFoto/src/com/mahrusali/multifoto/MultiFoto.java:32: error: cannot find symbol
    [javac]             requestCode = form.registerForActivityResult(this);
    [javac]                           ^
    [javac]   symbol:   variable form
    [javac]   location: class MultiFoto
    [javac] /home/runner/work/MultiFoto/MultiFoto/src/com/mahrusali/multifoto/MultiFoto.java:35: error: cannot find symbol
    [javac]         Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
    [javac]         ^
    [javac]   symbol:   class Intent
    [javac]   location: class MultiFoto
    [javac] /home/runner/work/MultiFoto/MultiFoto/src/com/mahrusali/multifoto/MultiFoto.java:35: error: cannot find symbol
    [javac]         Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
    [javac]                             ^
    [javac]   symbol:   class Intent
    [javac]   location: class MultiFoto
    [javac] /home/runner/work/MultiFoto/MultiFoto/src/com/mahrusali/multifoto/MultiFoto.java:35: error: cannot find symbol
    [javac]         Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
    [javac]                                    ^
    [javac]   symbol:   variable Intent
    [javac]   location: class MultiFoto
    [javac] /home/runner/work/MultiFoto/MultiFoto/src/com/mahrusali/multifoto/MultiFoto.java:37: error: cannot find symbol
    [javac]         intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true); // Ini kuncinya!
    [javac]                         ^
    [javac]   symbol:   variable Intent
    [javac]   location: class MultiFoto
    [javac] /home/runner/work/MultiFoto/MultiFoto/src/com/mahrusali/multifoto/MultiFoto.java:38: error: cannot find symbol
    [javac]         activity.startActivityForResult(Intent.createChooser(intent, "Pilih Foto"), requestCode);
    [javac]                                         ^
    [javac]   symbol:   variable Intent
    [javac]   location: class MultiFoto
    [javac] /home/runner/work/MultiFoto/MultiFoto/src/com/mahrusali/multifoto/MultiFoto.java:41: error: method does not override or implement a method from a supertype
    [javac]     @Override
    [javac]     ^
    [javac] /home/runner/work/MultiFoto/MultiFoto/src/com/mahrusali/multifoto/MultiFoto.java:43: error: cannot find symbol
    [javac]         if (requestCode == this.requestCode && resultCode == Activity.RESULT_OK) {
    [javac]                                                              ^
    [javac]   symbol:   variable Activity
    [javac]   location: class MultiFoto
    [javac] /home/runner/work/MultiFoto/MultiFoto/src/com/mahrusali/multifoto/MultiFoto.java:48: error: cannot find symbol
    [javac]                 ClipData clipData = data.getClipData();
    [javac]                 ^
    [javac]   symbol:   class ClipData
    [javac]   location: class MultiFoto
    [javac] /home/runner/work/MultiFoto/MultiFoto/src/com/mahrusali/multifoto/MultiFoto.java:50: error: cannot find symbol
    [javac]                     Uri uri = clipData.getItemAt(i).getUri();
    [javac]                     ^
    [javac]   symbol:   class Uri
    [javac]   location: class MultiFoto
    [javac] /home/runner/work/MultiFoto/MultiFoto/src/com/mahrusali/multifoto/MultiFoto.java:55: error: cannot find symbol
    [javac]                 Uri uri = data.getData();
    [javac]                 ^
    [javac]   symbol:   class Uri
    [javac]   location: class MultiFoto
    [javac] /home/runner/work/MultiFoto/MultiFoto/src/com/mahrusali/multifoto/MultiFoto.java:66: error: cannot find symbol
    [javac]         EventDispatcher.dispatchEvent(this, "SetelahFotoDipilih", daftarFoto);
    [javac]         ^
    [javac]   symbol:   variable EventDispatcher
    [javac]   location: class MultiFoto
    [javac] 28 errors
    [javac] 1 warning

BUILD FAILED
/home/runner/work/MultiFoto/MultiFoto/build.xml:49: Compile failed; see the compiler error output for details.

Total time: 1 second
Error: Process completed with exit code 1.
