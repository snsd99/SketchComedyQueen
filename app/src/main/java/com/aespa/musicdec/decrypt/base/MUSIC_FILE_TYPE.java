package com.aespa.musicdec.decrypt.base;


/**
 * 加密的音乐文件类型
 */
public enum MUSIC_FILE_TYPE{
    /** 酷狗KGMA格式 */
    TYPE_KUGOU_KGMA,
    /** 酷狗KGM格式 */
    TYPE_KUGOU_KGM,
    /** 酷我kwm格式 */
    TYPE_KUWO_KWM,
    /** QQ音乐qmc格式 */
    TYPE_QQMUSIC_QMC,
    /** QQ音乐mflac格式 */
    TYPE_QQMUSIC_MFLAC,
    /** QQ音乐mgg格式 */
    TYPE_QQMUSIC_MGG,
    /** 虾米xm格式 */
    TYPE_XIAMI_XM,
    /** 未知或其它类型，这种类型的一概无法解密。 */
    TYPE_UNKNOWN_OR_OTHER
}