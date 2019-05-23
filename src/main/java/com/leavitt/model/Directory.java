package com.leavitt.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Directory
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-05-22T21:17:31.018Z")

public class Directory   {
  @JsonProperty("pathway")
  private String pathway = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("zipped")
  private Boolean zipped = null;

  @JsonProperty("size")
  private Integer size = null;

  @JsonProperty("subDirectories")
  private List<Directory> subDirectories;

  @JsonProperty("files")
  private List<File> files;

  public Directory(){
    subDirectories = new ArrayList<Directory>();
    files = new ArrayList<File>();
  }

  public Directory pathway(String pathway) {
    this.pathway = pathway;
    return this;
  }

  /**
   * Get pathway
   * @return pathway
  **/
  @ApiModelProperty(value = "")


  public String getPathway() {
    return pathway;
  }

  public void setPathway(String pathway) {
    this.pathway = pathway;
  }

  public Directory name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(value = "")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Directory zipped(Boolean zipped) {
    this.zipped = zipped;
    return this;
  }

  public Boolean getZipped() {
    return zipped;
  }

  public List<Directory> getSubDirectories() {
    return subDirectories;
  }

  public void setSubDirectories(List<Directory> subDirectories) {
    this.subDirectories = subDirectories;
  }

  public List<File> getFiles() {
    return files;
  }

  public void setFiles(List<File> files) {
    this.files = files;
  }

  /**
   * Get zipped
   * @return zipped
  **/
  @ApiModelProperty(value = "")


  public Boolean isZipped() {
    return zipped;
  }

  public void setZipped(Boolean zipped) {
    this.zipped = zipped;
  }

  public Directory size(Integer size) {
    this.size = size;
    return this;
  }

  /**
   * Get size
   * @return size
  **/
  @ApiModelProperty(value = "")


  public Integer getSize() {
    return size;
  }

  public void setSize(Integer size) {
    this.size = size;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Directory directory = (Directory) o;
    return Objects.equals(this.pathway, directory.pathway) &&
        Objects.equals(this.name, directory.name) &&
        Objects.equals(this.zipped, directory.zipped) &&
        Objects.equals(this.size, directory.size);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pathway, name, zipped, size);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Directory {\n");
    
    sb.append("    pathway: ").append(toIndentedString(pathway)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    zipped: ").append(toIndentedString(zipped)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

