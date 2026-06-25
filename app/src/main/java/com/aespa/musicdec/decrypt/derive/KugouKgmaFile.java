package com.aespa.musicdec.decrypt.derive;

import com.aespa.musicdec.decrypt.base.BaseEncMusicFile;
import com.aespa.musicdec.decrypt.base.MUSIC_FILE_TYPE;

public class KugouKgmaFile extends BaseEncMusicFile {

    public KugouKgmaFile(String fileFullpath, String saveDecFileFullPath) {
        super(fileFullpath, saveDecFileFullPath, MUSIC_FILE_TYPE.TYPE_KUGOU_KGMA);
    }

    @Override
    public int decryptFromFile() {

        return 0;
    }
}
