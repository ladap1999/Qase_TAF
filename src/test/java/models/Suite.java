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
public class Suite {
    @Expose
    @SerializedName("title")
    private String suiteName;
    @Expose
    @SerializedName("id")
    private int suiteID;
    @Expose
    private String description;
}
