package com.leavitt.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * File
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-05-22T21:17:31.018Z")

public class File   {
  @JsonProperty("pathway")
  private String pathway = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("zipped")
  private Boolean zipped = null;

  @JsonProperty("contents")
  private String contents = null;

  @JsonProperty("size")
  private Integer size = null;

  public File pathway(String pathway) {
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

  public File name(String name) {
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

  public File zipped(Boolean zipped) {
    this.zipped = zipped;
    return this;
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

  public File contents(String contents) {
    this.contents = contents;
    return this;
  }

  /**
   * Get contents
   * @return contents
  **/
  @ApiModelProperty(value = "")


  public String getContents() {
    return contents;
  }

  public void setContents(String contents) {
    this.contents = contents;
  }

  public File size(Integer size) {
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
    File file = (File) o;
    return Objects.equals(this.pathway, file.pathway) &&
        Objects.equals(this.name, file.name) &&
        Objects.equals(this.zipped, file.zipped) &&
        Objects.equals(this.contents, file.contents) &&
        Objects.equals(this.size, file.size);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pathway, name, zipped, contents, size);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class File {\n");
    
    sb.append("    pathway: ").append(toIndentedString(pathway)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    zipped: ").append(toIndentedString(zipped)).append("\n");
    sb.append("    contents: ").append(toIndentedString(contents)).append("\n");
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

