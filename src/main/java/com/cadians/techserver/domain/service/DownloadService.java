package com.cadians.techserver.domain.service;

import com.cadians.techserver.domain.util.SCPUtil;
import jcifs.smb1.smb1.NtlmPasswordAuthentication;
import jcifs.smb1.smb1.SmbFile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cadians.techserver.domain.dto.request.ReqPostDownload;
import com.cadians.techserver.domain.dto.response.ResDownload;
import com.cadians.techserver.domain.dto.response.ResUser;
import com.cadians.techserver.domain.entity.User;
import com.cadians.techserver.domain.repository.UserRepository;
import org.apache.commons.io.FileUtils;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.List;
import java.util.stream.Collectors;



@Service
public class DownloadService {
    private final UserRepository userRepository;

    public DownloadService(UserRepository _userRepository) {
        this.userRepository = _userRepository;
    }

    @Transactional(readOnly = true)
    private User getUser(String _id) {
        return userRepository.findById(_id).orElse(null);
    }

    private HttpServletResponse downloadFile(HttpServletResponse response, String _id) throws IOException {
        User user = getUser(_id);

        if (user == null) return response;


        NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(null,"server_user","Cad780578");
        SmbFile smbfile = new SmbFile("smb://DEV2/AutoUpdate_Test/튜토리얼.tsim",auth);

        InputStream iStream = smbfile.getInputStream();
        File fileStorage = File.createTempFile(String.valueOf(iStream.hashCode()),".tmp");
        fileStorage.deleteOnExit();
        FileUtils.copyInputStreamToFile(iStream,fileStorage);


        byte[] fileByte = FileUtils.readFileToByteArray(fileStorage);
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode("TIMSIM.exe", "UTF-8") + "\";");
        response.setHeader("Content-Transfer-Encoding", "binary");
        response.getOutputStream().write(fileByte);
        response.getOutputStream().flush();
        response.getOutputStream().close();
        return response;
    }

    public ResDownload download(HttpServletResponse response, ReqPostDownload reqPostDownload) throws IOException {
        ResDownload resDownload = new ResDownload(downloadFile(response, reqPostDownload.getId()));
        return resDownload;
    }
}
