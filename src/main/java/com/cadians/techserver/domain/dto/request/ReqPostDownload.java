package com.cadians.techserver.domain.dto.request;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReqPostDownload {

    @NotNull
    private String id;
    @NotNull
    private String pwd;

}
