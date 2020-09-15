package ir.psdf.pdfreader;

import android.content.res.AssetManager;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileProvider extends AbstractFileProvider {
    public static final Uri CONTENT_URI =
            Uri.parse("content://ir.psdf.pdfreader/");

    public boolean getFromAsset(String fileName) {
        File f = new File(getContext().getFilesDir(), fileName);
        if (!f.exists()) {
            AssetManager assets = getContext().getAssets();

            try {
                copy(assets.open(fileName), f);
            } catch (IOException e) {
                Log.e("FileProvider", "Exception copying from assets", e);

                return (false);
            }
        }

        return (true);

    }

    @Override
    public boolean onCreate() {
        AssetManager assetManager = getContext().getAssets();
        try {
            String[] assetFilesName = assetManager.list("");
            assert assetFilesName != null;
            int num = assetFilesName.length;
            int index = 0;
            for(String filename:assetFilesName){
                boolean partialResult = this.getFromAsset(filename);
                if (partialResult) {
                    index++;
                }
            }
            if (index == num) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

    @Override
    public ParcelFileDescriptor openFile(Uri uri, String mode)
            throws FileNotFoundException {
        File root = getContext().getFilesDir();
        File f = new File(root, uri.getPath()).getAbsoluteFile();

        if (!f.getPath().startsWith(root.getPath())) {
            throw new
                    SecurityException("Resolved path jumped beyond root");
        }

        if (f.exists()) {
            return (ParcelFileDescriptor.open(f, parseMode(mode)));
        }

        throw new FileNotFoundException(uri.getPath());
    }

    @Override
    protected long getDataLength(Uri uri) {
        File f = new File(getContext().getFilesDir(), uri.getPath());

        return (f.length());
    }

    // following is from ParcelFileDescriptor source code
    // Copyright (C) 2006 The Android Open Source Project
    // (even though this method was added much after 2006...)

    private static int parseMode(String mode) {
        final int modeBits;
        if ("r".equals(mode)) {
            modeBits = ParcelFileDescriptor.MODE_READ_ONLY;
        } else if ("w".equals(mode) || "wt".equals(mode)) {
            modeBits =
                    ParcelFileDescriptor.MODE_WRITE_ONLY
                            | ParcelFileDescriptor.MODE_CREATE
                            | ParcelFileDescriptor.MODE_TRUNCATE;
        } else if ("wa".equals(mode)) {
            modeBits =
                    ParcelFileDescriptor.MODE_WRITE_ONLY
                            | ParcelFileDescriptor.MODE_CREATE
                            | ParcelFileDescriptor.MODE_APPEND;
        } else if ("rw".equals(mode)) {
            modeBits =
                    ParcelFileDescriptor.MODE_READ_WRITE
                            | ParcelFileDescriptor.MODE_CREATE;
        } else if ("rwt".equals(mode)) {
            modeBits =
                    ParcelFileDescriptor.MODE_READ_WRITE
                            | ParcelFileDescriptor.MODE_CREATE
                            | ParcelFileDescriptor.MODE_TRUNCATE;
        } else {
            throw new IllegalArgumentException("Bad mode '" + mode + "'");
        }
        return modeBits;
    }
}
