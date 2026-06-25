package com.aespa.musicdec.decrypt.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;

/**
 * MusicFileTypeDetector：用于判断音乐文件类型的模块，不用new实例直接调用它的方法即可。
 */
public abstract class MusicFileTypeDetector {
    /**
     * int: 读取头部字节数，1024个字节。
     */
    private static final int READ_HEAD_SIZE = 1024;

    /**
     * 酷狗 KGM / KGMA 常见文件头
     */
    private static final byte[] KUGOU_KGM_HEADER = new byte[]{
            (byte) 0x7C, (byte) 0xD5, (byte) 0x32, (byte) 0xEB,
            (byte) 0x86, (byte) 0x02, (byte) 0x7F, (byte) 0x4B,
            (byte) 0xA8, (byte) 0xAF, (byte) 0xA6, (byte) 0x8E,
            (byte) 0x0F, (byte) 0xFF, (byte) 0x99, (byte) 0x14
    };

    /**
     * 酷我 KWM 文件头：yeelion-kuwo-tme
     */
    private static final byte[] KUWO_KWM_HEADER = new byte[]{
            0x79, 0x65, 0x65, 0x6C,
            0x69, 0x6F, 0x6E, 0x2D,
            0x6B, 0x75, 0x77, 0x6F,
            0x2D, 0x74, 0x6D, 0x65
    };

    /**
     * 虾米 XM：
     * offset 0: 69 66 6D 74，即 "ifmt"
     */
    private static final byte[] XIAMI_XM_HEADER_1 = new byte[]{
            0x69, 0x66, 0x6D, 0x74
    };

    /**
     * 虾米 XM：
     * offset 8: FE FE FE FE
     */
    private static final byte[] XIAMI_XM_HEADER_2 = new byte[]{
            (byte) 0xFE, (byte) 0xFE, (byte) 0xFE, (byte) 0xFE
    };

    public static MUSIC_FILE_TYPE detect(String fileFullPath) throws IOException {
        if (fileFullPath == null || fileFullPath.length() == 0) {
            return MUSIC_FILE_TYPE.TYPE_UNKNOWN_OR_OTHER;
        }

        File file = new File(fileFullPath);
        if (!file.isFile() || file.length() <= 0) {
            return MUSIC_FILE_TYPE.TYPE_UNKNOWN_OR_OTHER;
        }

        byte[] head = readHead(file, READ_HEAD_SIZE);
        String ext = getExt(file.getName());

        // 1. 酷狗 KGM / KGMA
        // 这俩头部可能一样，所以用后缀辅助区分
        if (startsWith(head, KUGOU_KGM_HEADER)) {
            if ("kgma".equals(ext)) {
                return MUSIC_FILE_TYPE.TYPE_KUGOU_KGMA;
            }
            return MUSIC_FILE_TYPE.TYPE_KUGOU_KGM;
        }

        // 2. 酷我 KWM
        if (startsWith(head, KUWO_KWM_HEADER)) {
            return MUSIC_FILE_TYPE.TYPE_KUWO_KWM;
        }

        // 3. 虾米 XM
        if (isXiamiXm(head)) {
            return MUSIC_FILE_TYPE.TYPE_XIAMI_XM;
        }

        // 4. QQ 音乐相关
        // 注意：qmc / mflac / mgg 很多时候不能只靠头部判断，
        // 所以这里先根据后缀分类。
        if ("mflac".equals(ext) || "mflac0".equals(ext) || "mflac1".equals(ext)) {
            return MUSIC_FILE_TYPE.TYPE_QQMUSIC_MFLAC;
        }

        if ("mgg".equals(ext) || "mgg0".equals(ext) || "mgg1".equals(ext) || "mggl".equals(ext)) {
            return MUSIC_FILE_TYPE.TYPE_QQMUSIC_MGG;
        }

        if (isQmcExt(ext)) {
            return MUSIC_FILE_TYPE.TYPE_QQMUSIC_QMC;
        }
        return MUSIC_FILE_TYPE.TYPE_UNKNOWN_OR_OTHER;
    }

    private static byte[] readHead(File file, int maxSize) throws IOException {
        int readSize = (int) Math.min(file.length(), maxSize);
        byte[] buffer = new byte[readSize];

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            int offset = 0;

            while (offset < readSize) {
                int read = fis.read(buffer, offset, readSize - offset);
                if (read == -1) {
                    break;
                }
                offset += read;
            }

            return buffer;
        } finally {
            if (fis != null) {
                fis.close();
            }
        }
    }

    private static boolean startsWith(byte[] data, byte[] magic) {
        return bytesEquals(data, 0, magic);
    }

    private static boolean bytesEquals(byte[] data, int offset, byte[] magic) {
        if (data == null || magic == null) {
            return false;
        }

        if (offset < 0 || data.length < offset + magic.length) {
            return false;
        }

        for (int i = 0; i < magic.length; i++) {
            if (data[offset + i] != magic[i]) {
                return false;
            }
        }

        return true;
    }

    private static boolean isXiamiXm(byte[] head) {
        return bytesEquals(head, 0, XIAMI_XM_HEADER_1)
                && bytesEquals(head, 8, XIAMI_XM_HEADER_2);
    }

    private static boolean isQmcExt(String ext) {
        return "qmc".equals(ext)
                || "qmc0".equals(ext)
                || "qmc2".equals(ext)
                || "qmc3".equals(ext)
                || "qmcflac".equals(ext)
                || "qmcogg".equals(ext)
                || "tkm".equals(ext)
                || "tm0".equals(ext)
                || "tm2".equals(ext)
                || "tm3".equals(ext)
                || "tm6".equals(ext);
    }

    private static String getExt(String fileName) {
        if (fileName == null) {
            return "";
        }

        int index = fileName.lastIndexOf('.');
        if (index < 0 || index == fileName.length() - 1) {
            return "";
        }

        return fileName.substring(index + 1).toLowerCase(Locale.US);
    }
}