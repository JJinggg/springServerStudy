package com.cadians.techserver.domain.controller;

import com.cadians.techserver.domain.dto.request.ReqPostDownload;
import com.cadians.techserver.domain.dto.response.ResDownload;
import com.cadians.techserver.domain.service.DownloadService;

import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;


@RestController
@RequestMapping("/download")
public class DownloadController {
    private final DownloadService downloadService;
    public DownloadController(DownloadService _downloadService)
    {
        this.downloadService = _downloadService;
    }

    @PostMapping(produces = "application/octet-stream")
    public ResDownload downloadfile (HttpServletResponse _response, @RequestBody @Valid ReqPostDownload _reqPostDownload)throws IOException
    {
        return downloadService.download(_response,_reqPostDownload);
    }

}
