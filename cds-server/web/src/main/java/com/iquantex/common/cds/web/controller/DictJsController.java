package com.iquantex.common.cds.web.controller;

import com.iquantex.common.cds.web.dto.DictDownloadInDTO;
import com.iquantex.common.cds.web.service.DictJsService;
import java.io.IOException;
import java.util.Arrays;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/** Created by leo on 2017/6/8. */
@Controller
@RequestMapping("/sys_dict_data")
public class DictJsController {
  @Autowired private DictJsService service;

  /** 前端导出文件名 */
  public static final String FRONT_FILE_NAME = "index.js";

  /** 后端带出文件名 */
  public static final String BACK_FILE_NAME = "DictConstants.java";

  @RequestMapping("/front/download")
  public ResponseEntity<byte[]> frontDownload(@RequestBody @Valid DictDownloadInDTO param)
      throws IOException {
    boolean isBlack = false;
    String charsetName = "UTF-8";
    String fileName = new String(FRONT_FILE_NAME.getBytes(charsetName), charsetName);
    String content = service.getContent(param.getAppId(), isBlack);

    HttpHeaders headers = new HttpHeaders();
    headers.setContentDispositionFormData("attachment", fileName);
    headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
    String[] exposeHeaders = {"Content-Disposition"};
    headers.setAccessControlExposeHeaders(Arrays.asList(exposeHeaders));

    return new ResponseEntity<>(content.getBytes(charsetName), headers, HttpStatus.CREATED);
  }

  @RequestMapping("/back/download")
  public ResponseEntity<byte[]> backDownload(@RequestBody @Valid DictDownloadInDTO param)
      throws IOException {
    boolean isBlack = true;
    String charsetName = "UTF-8";
    String fileName = new String(BACK_FILE_NAME.getBytes(charsetName), charsetName);
    String content = service.getContent(param.getAppId(), isBlack);

    HttpHeaders headers = new HttpHeaders();
    headers.setContentDispositionFormData("attachment", fileName);
    headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
    String[] exposeHeaders = {"Content-Disposition"};
    headers.setAccessControlExposeHeaders(Arrays.asList(exposeHeaders));

    return new ResponseEntity<>(content.getBytes(charsetName), headers, HttpStatus.CREATED);
  }
}
