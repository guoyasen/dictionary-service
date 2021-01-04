package com.iquantex.common.cds.web.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author gys
 * @date 2020/12/30
 */
public class FileUtil {


    private static final Logger LOG = LoggerFactory.getLogger(FileUtil.class);

    public FileUtil() {
    }

    public static void writeFile(String fileName, String content, boolean overWrite) throws IOException {
        writeFile(fileName, content, overWrite, "UTF-8");
    }

    public static void writeFile(String fileName, String content, String encoding, boolean overWrite) throws IOException {
        writeFile(fileName, content, overWrite, encoding);
    }

    public static void writeFile(String fileName, String content, boolean overWrite, String encoding) throws IOException {
        File file = new File(fileName);
        boolean isExists = file.exists();
        if (isExists && !overWrite) {
            LOG.debug("file : {} already exists, passed", file.getAbsolutePath());
        } else {
            if (!isExists) {
                File fileParent = file.getParentFile();
                if (!fileParent.exists()) {
                    fileParent.mkdirs();
                }
            }

            BufferedWriter bw = null;

            try {
                FileOutputStream fos = new FileOutputStream(file, false);
                OutputStreamWriter osw;
                if (encoding == null) {
                    osw = new OutputStreamWriter(fos);
                } else {
                    osw = new OutputStreamWriter(fos, encoding);
                }

                bw = new BufferedWriter(osw);
                bw.write(content);
            } finally {
                bw.close();
            }

            if (isExists) {
                LOG.debug("file {} was overwrite", file.getAbsolutePath());
            } else {
                LOG.debug("generate file {}", file.getAbsolutePath());
            }

        }
    }

    public static void writeFile(String basePath, String fileName, byte[] fileContent) throws IOException {
        writeFile(getFilePath(basePath) + File.separator + fileName, fileContent);
    }

    public static void writeFile(String filePath, byte[] fileContent) throws IOException {
        File file = new File(filePath);
        boolean isExists = file.exists();
        if (!isExists) {
            File fileParent = file.getParentFile();
            if (!fileParent.exists()) {
                fileParent.mkdirs();
            }
        }

        BufferedOutputStream outputStream = null;

        try {
            outputStream = new BufferedOutputStream(new FileOutputStream(file));
            outputStream.write(fileContent);
        } finally {
            try {
                if (null != outputStream) {
                    outputStream.close();
                }
            } catch (Exception var11) {
                ;
            }

        }

        if (isExists) {
            LOG.debug("file {} was overwrite", file.getAbsolutePath());
        } else {
            LOG.debug("generate file {}", file.getAbsolutePath());
        }

    }

    public static String getFilePath(String basePath) {
        return getFilePath(basePath, (String)null);
    }

    public static String getFilePath(String basePath, String targetPackage) {
        if (!basePath.startsWith("/") && !basePath.contains(":") && StringUtils.isNotBlank(basePath)) {
            basePath = System.getProperty("user.dir") + File.separatorChar + basePath;
        }

        if (StringUtils.isNotBlank(targetPackage)) {
            StringBuilder sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(targetPackage, ".");

            while(st.hasMoreTokens()) {
                sb.append(st.nextToken());
                sb.append(File.separatorChar);
            }

            basePath = basePath + File.separatorChar + sb.toString();
        }

        return basePath;
    }
}
