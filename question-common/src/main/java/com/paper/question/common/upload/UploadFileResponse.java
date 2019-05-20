package com.paper.question.common.upload;


import com.paper.question.common.exception.FileMissingExtNameException;
import org.apache.commons.lang3.StringUtils;

public class UploadFileResponse {

    private String fileOriginalName;
    private String fileName;
    private String fileDownloadUri;
    private String fileType;
    private long size;
    // 若为图片，获取图片的宽度和高度
    private int width;
    private int height;

    public UploadFileResponse() {
    }

    public UploadFileResponse(String fileOriginalName, String fileName, String fileDownloadUri, String fileType, long size) {
        this.fileOriginalName = fileOriginalName;
        this.fileName = fileName;
        this.fileDownloadUri = fileDownloadUri;
        this.fileType = fileType;
        this.size = size;
    }

    @Override
    public String toString() {
        return "UploadFileResponse{" +
                "fileOriginalName='" + fileOriginalName + '\'' +
                ", fileName='" + fileName + '\'' +
                ", fileDownloadUri='" + fileDownloadUri + '\'' +
                ", fileType='" + fileType + '\'' +
                ", size=" + size +
                ", width=" + width +
                ", height=" + height +
                '}';
    }

    /**
     * 获取文件扩展名，包含"."分隔符
     */
    public String getExtName() {
        String fileOriginalName = this.fileOriginalName;
        int dotIndex = fileOriginalName.lastIndexOf(".");
        if (StringUtils.isBlank(fileOriginalName) || dotIndex == -1) {
            throw new FileMissingExtNameException("源文件名为空");
        }

        String extName = fileOriginalName.substring(dotIndex);
        if (!extName.startsWith(".")) {
            throw new FileMissingExtNameException("源文件缺少扩展名");
        }
        return extName;
    }

    public String getFileOriginalName() {
        return fileOriginalName;
    }

    public void setFileOriginalName(String fileOriginalName) {
        this.fileOriginalName = fileOriginalName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileDownloadUri() {
        return fileDownloadUri;
    }

    public void setFileDownloadUri(String fileDownloadUri) {
        this.fileDownloadUri = fileDownloadUri;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
