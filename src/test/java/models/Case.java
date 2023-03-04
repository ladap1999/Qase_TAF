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
public class Case {
    @Expose
    @SerializedName("title")
    private String caseName;
    @Expose
    @SerializedName("id")
    private int caseID;
    @Expose
    private String description;
    @Expose
    private int severity;
}
