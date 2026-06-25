package com.aespa.musicdec.decrypt.base;

import com.aespa.musicdec.decrypt.derive.KugouKgmaFile;

/**
 * EncMusicFileFactory: 加密文件类的工厂，自己判断加密文件类型，并返回对应的文件对象。
 */
public abstract class EncMusicFileFactory {
    public static BaseEncMusicFile create(
            String fileFullpath,
            String saveDecFileFullPath
    ) throws Exception {
        MUSIC_FILE_TYPE fileType = MusicFileTypeDetector.detect(fileFullpath);
        switch (fileType) {
//            case TYPE_KUGOU_KGM:
//                return new KugouKgmFile(fileFullpath, saveDecFileFullPath);
            case TYPE_KUGOU_KGMA:
                return new KugouKgmaFile(fileFullpath, saveDecFileFullPath);
//            case TYPE_KUWO_KWM:
//                return new KuwoKwmFile(fileFullpath, saveDecFileFullPath);
//
//            case TYPE_QQMUSIC_QMC:
//                return new QQMusicQmcFile(fileFullpath, saveDecFileFullPath);
//
//            case TYPE_QQMUSIC_MFLAC:
//                return new QQMusicMflacFile(fileFullpath, saveDecFileFullPath);
//
//            case TYPE_QQMUSIC_MGG:
//                return new QQMusicMggFile(fileFullpath, saveDecFileFullPath);
//
//            case TYPE_XIAMI_XM:
//                return new XiamiXmFile(fileFullpath, saveDecFileFullPath);

            case TYPE_UNKNOWN_OR_OTHER:
            default:
                throw new IllegalArgumentException("不支持的加密音乐文件类型：" + fileFullpath);
        }

    }
}
