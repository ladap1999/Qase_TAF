package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
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
