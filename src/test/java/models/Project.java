package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Project {
    @Expose
    @SerializedName("title")
    private String projectName;
    @Expose
    @SerializedName("code")
    private String projectCode;
    @Expose
    private String description;
}
