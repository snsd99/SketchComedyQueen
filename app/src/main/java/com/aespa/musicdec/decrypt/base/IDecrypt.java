package com.aespa.musicdec.decrypt.base;
/**
 * IDecrypt: 接口，被类BaseEncMusicFile使用。
 */
public interface IDecrypt {
    /**
     * 音乐文件解密的方法，需要具体实现，便于统一调用。
     * @return int: 错误代码。
     */
    int decryptFromFile();
}
