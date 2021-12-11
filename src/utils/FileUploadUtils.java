package utils;

public class FileUploadUtils {
    //获取文件真实名称
    public static String subFileName(String fileName) {
        // 查找最后一个 \出现位置
        int index = fileName.lastIndexOf("\\");
        if (index == -1) {
            return fileName;
        }
        return fileName.substring(index + 1);
    }
    //获得hashcode生成二级目录
    public static String generateRandomDir(String uuidFileName) {
        int hashCode = uuidFileName.hashCode();
        // 一级目录
        int d1 = hashCode & 0xf;
        // 二级目录
        int d2 = (hashCode >> 4) & 0xf;
        return "/" + d1 + "/" + d2;
    }
}
