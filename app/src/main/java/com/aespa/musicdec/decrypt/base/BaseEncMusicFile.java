package com.aespa.musicdec.decrypt.base;

/**
 * BaseEncMusicFile: 所有音乐文件的基类（统一管理），不能直接new实例。
 */
public abstract class BaseEncMusicFile implements IDecrypt{
    // 构造函数
    public BaseEncMusicFile(String fileFullpath, String saveDecFileFullPath,MUSIC_FILE_TYPE fileType){
        this.fileFullpath = fileFullpath;
        this.saveDecFileFullPath = saveDecFileFullPath;
        this.fileType = fileType;
    }
    /**
     * String: 完整的加密音乐文件路径。
     */
    protected String fileFullpath;
    /**
     * MUSIC_FILE_TYPE(enum)：加密的音乐文件类型，例如酷狗、酷我、QQ音乐等。
     */
    protected MUSIC_FILE_TYPE fileType;
    /**
     * String: 解密后的音乐文件完整保存路径。
     */
    protected String saveDecFileFullPath;

    /**
     * 获取加密的音乐文件类型，需要实现。
     * @return MUSIC_FILE_TYPE(enum)：文件类型。
     */
    public MUSIC_FILE_TYPE getFileType(){
        return this.fileType;
    }
}
