package com.leavitt.api;

import com.leavitt.model.Directory;
import com.leavitt.model.File;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.leavitt.service.FileSystemService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-05-22T21:17:31.018Z")

@Controller
public class FileSystemApiController implements FileSystemApi {

    @Autowired
    private FileSystemService fileSystemService;

    private static final Logger log = LoggerFactory.getLogger(FileSystemApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;


    @org.springframework.beans.factory.annotation.Autowired
    public FileSystemApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> deleteFile(@ApiParam(value = "The MIME type" ,required=true, defaultValue = "application/json") @RequestHeader(value="Content-Type", required=true) String contentType,
                                           @ApiParam(value = "pathway of the directory" ,required=true) @RequestHeader(value="pathway", required=true) String pathway) {
        if (pathway != null) {
            boolean status = fileSystemService.deleteFile(pathway);
            if (status) {
                return new ResponseEntity<Void>(HttpStatus.OK);
            } else {
                return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<File> getFile(@ApiParam(value = "The MIME type" ,required=true, defaultValue = "application/json") @RequestHeader(value="Content-Type", required=true) String contentType,
                                        @ApiParam(value = "pathway of file to retrieve" ,required=true) @RequestHeader(value="pathway", required=true) String pathway) {
        if (pathway != null) {
            File file = fileSystemService.getFile(pathway);
            if (file != null) {
                return new ResponseEntity<File>(file, HttpStatus.OK);
            } else {
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Void> updateFile(@ApiParam(value = "The MIME type" ,required=true, defaultValue = "application/json") @RequestHeader(value="Content-Type", required=true) String contentType,
                                           @ApiParam(value = "destination of moving directory" ,required=true) @RequestHeader(value="originPath", required=true) String originPath,@ApiParam(value = "destination of moving directory" ,required=true) @RequestHeader(value="destination", required=true) String destination,@ApiParam(value = "whether to delete original" ,required=true) @RequestHeader(value="keepOriginal", required=true) Boolean keepOriginal) {
        if (originPath !=  null && destination != null && keepOriginal != null) {
            boolean status = fileSystemService.updateFile(originPath, destination, keepOriginal);
            if (status) {
                return new ResponseEntity<Void>(HttpStatus.OK);
            } else {
                return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Void> createFile(@ApiParam(value = "The MIME type" ,required=true, defaultValue = "application/json") @RequestHeader(value="Content-Type", required=true) String contentType,
                                           @ApiParam(value = "destination of moving directory" ,required=true) @RequestHeader(value="destination", required=true) String destination,@ApiParam(value = "File that is being created" ,required=true )  @Valid @RequestBody File file) {
        if (destination !=  null && file != null) {
            boolean status = fileSystemService.createFile(destination, file);
            if (status) {
                return new ResponseEntity<Void>(HttpStatus.OK);
            } else {
                return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Void> deleteDirectory(@ApiParam(value = "The MIME type" ,required=true, defaultValue = "application/json") @RequestHeader(value="Content-Type", required=true) String contentType,
                                                @ApiParam(value = "pathway of the directory" ,required=true) @RequestHeader(value="pathway", required=true) String pathway) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> getDirectory(@ApiParam(value = "The MIME type" ,required=true, defaultValue = "application/json") @RequestHeader(value="Content-Type", required=true) String contentType,
                                             @ApiParam(value = "pathway of directory to retrieve" ,required=true) @RequestHeader(value="pathway", required=true) String pathway) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> updateDirectory(@ApiParam(value = "The MIME type" ,required=true, defaultValue = "application/json") @RequestHeader(value="Content-Type", required=true) String contentType,
                                                @ApiParam(value = "destination of moving directory" ,required=true) @RequestHeader(value="destination", required=true) String destination,@ApiParam(value = "whether to delete original" ,required=true) @RequestHeader(value="keepOriginal", required=true) Boolean keepOriginal,@ApiParam(value = "Directory to update" ,required=true )  @Valid @RequestBody Directory body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> createDirectory(@ApiParam(value = "The MIME type" ,required=true, defaultValue = "application/json") @RequestHeader(value="Content-Type", required=true) String contentType,
                                                @ApiParam(value = "destination of the new directory, including new directory name" ,required=true) @RequestHeader(value="destination", required=true) String destination) {
        if (destination !=  null) {
            boolean status = fileSystemService.createDirectory(destination);
            if (status) {
                return new ResponseEntity<Void>(HttpStatus.OK);
            } else {
                return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
    }



}
